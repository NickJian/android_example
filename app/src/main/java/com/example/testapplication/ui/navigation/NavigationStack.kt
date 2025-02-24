package com.example.testapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testapplication.main.viewmodel.ListViewModel
import com.example.testapplication.main.viewmodel.PokemonDetailViewModel
import com.example.testapplication.main.viewmodel.TestViewModel
import com.example.testapplication.ui.compose.BoxLayout
import com.example.testapplication.ui.compose.MainScreen
import com.example.testapplication.ui.compose.PokemonDetailScreen
import com.example.testapplication.ui.compose.PokemonListScreen

@Composable
fun NavigationStack() {

	val navigationController = rememberNavController()

	NavHost(
		navController = navigationController,
		startDestination = NavigationScreen.MainPage.route
	) {
		composable(NavigationScreen.MainPage.route) {
			MainScreen(navigationController)
		}
		composable(NavigationScreen.PokemonListPage.route) {
			val viewModel = hiltViewModel<ListViewModel>()
			PokemonListScreen(
				navController = navigationController,
				state = viewModel.listScreenState.collectAsState()
			)
		}
		composable(NavigationScreen.BoxLayout.route) {
			val viewModel = hiltViewModel<TestViewModel>()
			BoxLayout(navigationController)
		}

		composable(NavigationScreen.PokemonDetail.route) { backStackEntry ->
			val id = backStackEntry.arguments?.getString("id")

			val viewModel = hiltViewModel<PokemonDetailViewModel>()
			viewModel.getPokemonDetail(id.orEmpty())
			PokemonDetailScreen(
				viewModel.detailState.collectAsState(),
				viewModel.loadingState.collectAsState()
			)
		}

	}
}


