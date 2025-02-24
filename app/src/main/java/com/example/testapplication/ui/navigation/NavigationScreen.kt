package com.example.testapplication.ui.navigation


sealed class NavigationScreen(val route: String){
	object MainPage: NavigationScreen("main_page")
	object PokemonListPage : NavigationScreen("PokemonListPage")
	object BoxLayout: NavigationScreen("box_layout")
	object PokemonDetail : NavigationScreen("PokemonDetail/{$param_id}") {
		fun createRoute(id: String) = "PokemonDetail/$id"

	}

	companion object {
		const val param_id = "id"
	}

}

