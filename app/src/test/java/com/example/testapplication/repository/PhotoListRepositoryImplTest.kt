package com.example.testapplication.repository

import com.example.testapplication.api.model.PokemonDetailData
import com.example.testapplication.api.model.PokemonDetailSprites
import com.example.testapplication.api.model.PokemonItemData
import com.example.testapplication.api.model.PokemonListResult
import com.example.testapplication.api.pokemon.PokemonDataSource
import org.junit.Before
import org.junit.Test

class PhotoListRepositoryImplTest {

	private lateinit var remoteSource: FakePokemonDataSource
	private lateinit var repository: PhotoListRepositoryImpl

	@Before
	fun setUp() {
		remoteSource = FakePokemonDataSource()
		repository = PhotoListRepositoryImpl(remoteSource)
	}

	@Test
	fun `return correct photo list when api successed`() =
		runTest {
			val result = repository.getPhotoList()
			assert(result is LoadPhotoResult.Success)

			result as LoadPhotoResult.Success
			assert(result.photos.size == 2)
			assertEquals("item1", { "incorrect photo name" }, result.photos[0].name)
			assertEquals("item2", { "incorrect photo name" }, result.photos[1].name)

		}

	@Test
	fun `return error when api failed`() =
		runTest {
			remoteSource.shouldFail = true
			val result = repository.getPhotoList()
			assert(result is LoadPhotoResult.Error)
		}
}

class FakePokemonDataSource : PokemonDataSource {

	val successList = PokemonListResult(
		count = 200,
		next = "next",
		previous = "prev",
		results = listOf(PokemonItemData("item1", "url"), PokemonItemData("item2", "url"))
	)

	var shouldFail = false

	var pokemonListResult = successList
	override suspend fun getPokemon(limit: String, offset: String): PokemonListResult {
		if (shouldFail) throw IllegalStateException("failed to load")
		else return pokemonListResult
	}

	override suspend fun getPokemonDetails(id: String): PokemonDetailData {
		return PokemonDetailData(
			id = "id",
			name = "name",
			height = "height",
			weight = "weight",
			sprites = PokemonDetailSprites(
				front = "front",
				back = "back"
			)
		)
	}
}