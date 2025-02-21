package com.example.testapplication.ui.model

sealed class ListScreenState {

	class Success(val imageList: List<ListImage> = listOf()) : ListScreenState()
	class Failed(val message: String) : ListScreenState()
	object Loading : ListScreenState()
}

