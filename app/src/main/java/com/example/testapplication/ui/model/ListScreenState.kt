package com.example.testapplication.ui.model

sealed class ListScreenState {

	class Success(val imageList: List<PokemonListItemData> = listOf()) : ListScreenState()
	class Failed(val message: String) : ListScreenState()
	object Loading : ListScreenState()
}

