package com.example.testapplication.repository

import com.example.testapplication.api.model.PokemonItemData
import com.example.testapplication.api.pokemon.PokemonDataSource
import com.example.testapplication.ui.model.PokemonListItemData
import javax.inject.Inject

class PhotoListRepositoryImpl @Inject constructor(val remoteSource: PokemonDataSource) :
	PhotoListRepository {

	override suspend fun getPhotoList(): LoadPhotoResult {
		try {
			val result = remoteSource.getPokemon("100", "0")
			return LoadPhotoResult.Success(result.results.toPokemonListItem())
		} catch (e: Exception) {
			return LoadPhotoResult.Error(e.message.toString())
		}

	}
}

interface PhotoListRepository {
	suspend fun getPhotoList(): LoadPhotoResult
}

sealed class LoadPhotoResult {
	class Success(val photos: List<PokemonListItemData>) : LoadPhotoResult()
	class Error(val message: String) : LoadPhotoResult()
}

fun List<PokemonItemData>?.toPokemonListItem(): List<PokemonListItemData> {
	if (this == null) return emptyList()
	return map {
		val id = it.url.removeSuffix("/").split("/").last()
		val imageUrl =
			"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id.toInt()}.png"
		PokemonListItemData(
			id = id,
			name = it.name,
			image = imageUrl
		)
	}
}





