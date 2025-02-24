package com.example.testapplication.ui.navigation

sealed class NavigationScreen(val route: String){
	object MainPage: NavigationScreen("main_page")
	object PokemonListPage : NavigationScreen("PokemonListPage")
	object BoxLayout: NavigationScreen("box_layout")
	object PokemonDetail : NavigationScreen("PokemonDetail/{$_param_id}") {
		fun createRoute(id: String) = "PokemonDetail/$id"
		const val param_id = _param_id
	}

	companion object {
		private const val _param_id = "id"
	}

}

