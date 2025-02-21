package com.example.testapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testapplication.main.viewmodel.ListViewModel
import com.example.testapplication.ui.compose.BoxLayout
import com.example.testapplication.ui.compose.ListScreen
import com.example.testapplication.ui.compose.MainScreen

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
		composable(NavigationScreen.ListPage.route) {
			val viewModel = hiltViewModel<ListViewModel>()
			ListScreen(viewModel.listScreenState.collectAsState())
		}
		composable(NavigationScreen.BoxLayout.route) {
			BoxLayout() // todo add NavController
		}

	}
}


