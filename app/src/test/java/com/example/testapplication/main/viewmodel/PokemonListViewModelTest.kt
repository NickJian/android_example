package com.example.testapplication.main.viewmodel

import com.example.testapplication.repository.LoadPhotoResult
import com.example.testapplication.repository.PhotoListRepository
import com.example.testapplication.ui.model.ListScreenState
import com.example.testapplication.ui.model.PokemonListItemData
import org.junit.Before
import org.junit.Test

class PokemonListViewModelTest {

	lateinit var repo: FakePokemonRepository
	lateinit var viewModel: PokemonListViewModel

	@Before
	fun setUp() {
		repo = FakePokemonRepository()
		viewModel = PokemonListViewModel(repo)
	}

	@Test
	fun `getListScreenState successfully`() {
		viewModel.getListViewDetail()
		val result = viewModel.listScreenState.value
		assert(result is ListScreenState.Success)
		result as ListScreenState.Success

		assert(result.imageList.size == 2)
		assert(result.imageList[0].id == "1")
		assert(result.imageList[0].name == "name1")
		assert(result.imageList[0].image == "image1")
	}

	@Test
	fun `getListScreenState failed`() {
		repo.result = repo.failedResult
		viewModel.getListViewDetail()
		val result = viewModel.listScreenState.value
		assert(result is ListScreenState.Failed)
		result as ListScreenState.Failed
		assert(result.message == "failed")
	}
}

class FakePokemonRepository : PhotoListRepository {
	val successResult = LoadPhotoResult.Success(
		listOf(
			PokemonListItemData(
				id = "1",
				name = "name1",
				image = "image1",
			), PokemonListItemData(
				id = "2",
				name = "name2",
				image = "image2",
			)
		)
	)
	val failedResult = LoadPhotoResult.Error("failed")

	var result: LoadPhotoResult = successResult
	override suspend fun getPhotoList(): LoadPhotoResult {
		return result
	}
}