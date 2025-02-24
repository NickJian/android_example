package com.example.testapplication.ui.navigation

sealed class NavigationScreen(val route: String){
	object MainPage: NavigationScreen("main_page")
	object PokemonListPage : NavigationScreen("PokemonListPage")
	object BoxLayout: NavigationScreen("box_layout")
	object PokemonDetail : NavigationScreen("PokemonDetail/{id}") {
		fun createRoute(id: String) = "PokemonDetail/$id"
	}

}