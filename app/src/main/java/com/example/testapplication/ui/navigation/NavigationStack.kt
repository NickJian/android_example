package com.example.testapplication.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testapplication.main.viewmodel.PokemonDetailViewModel
import com.example.testapplication.main.viewmodel.PokemonListViewModel
import com.example.testapplication.main.viewmodel.TestViewModel
import com.example.testapplication.ui.compose.BoxLayout
import com.example.testapplication.ui.compose.PokemonDetailScreen
import com.example.testapplication.ui.compose.PokemonListScreen
import com.example.testapplication.ui.compose.TestContentScreen

private const val tag = "NavigationStack"
@Composable
fun NavigationStack(navigationController: NavHostController) {

	NavHost(
		navController = navigationController,
		startDestination = NavigationScreen.MainPage.route
	) {
		composable(NavigationScreen.MainPage.route) {
			TestContentScreen()
		}
		composable(NavigationScreen.PokemonListPage.route) {
			Log.d(tag, "navigate to " + NavigationScreen.PokemonListPage.route)
			val viewModel = hiltViewModel<PokemonListViewModel>()
			LaunchedEffect(Unit) {
				viewModel.getListViewDetail()
			}
			PokemonListScreen(
				onItemClick = { id ->
					navigationController.navigate(
						NavigationScreen.PokemonDetail.createRoute(id)
					)
				},
				state = viewModel.listScreenState.collectAsState()
			)
		}
		composable(NavigationScreen.BoxLayout.route) {
			Log.d(tag, "navigate to " + NavigationScreen.BoxLayout.route)
			val viewModel = hiltViewModel<TestViewModel>()
			BoxLayout(navigationController)
		}

		composable(NavigationScreen.PokemonDetail.route) { backStackEntry ->
			Log.d(tag, "navigate to " + NavigationScreen.PokemonDetail.route)
			val id = backStackEntry.arguments?.getString(NavigationScreen.PokemonDetail.param_id)

			val viewModel = hiltViewModel<PokemonDetailViewModel>()
			LaunchedEffect(Unit) { viewModel.getPokemonDetail(id.orEmpty()) }

			PokemonDetailScreen(
				viewModel.detailState.collectAsState(),
				viewModel.loadingState.collectAsState()
			)
		}

	}
}


