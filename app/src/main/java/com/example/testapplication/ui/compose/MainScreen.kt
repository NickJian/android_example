package com.example.testapplication.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testapplication.ui.navigation.NavigationScreen
import com.example.testapplication.ui.navigation.NavigationStack

@Composable
@Preview(showBackground = true)
private fun PreviewCompose() {
	MainScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
	val navController = rememberNavController()
	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text("My App") }
			)
		},
		bottomBar = {
			BottomNavigationBar(navController)
		},
		floatingActionButton = {
			FloatingActionButton(onClick = { /* Handle action */ }) {
				Icon(Icons.Default.Add, contentDescription = "Add")
			}
		},
	) { innerPadding ->
		Box(
			modifier = Modifier
				.padding(innerPadding)
				.fillMaxSize()
		) {
			NavigationStack(navController)
		}

	}
}

@Composable
fun BottomNavigationBar(navController: NavController) {
	val list = listOf(
		NavigationScreen.MainPage to Icons.Default.Home,
		NavigationScreen.PokemonListPage to Icons.Default.ShoppingCart,
		NavigationScreen.BoxLayout to Icons.Default.PlayArrow,
	)

	BottomNavigation {
		val navBackStackEntry = navController.currentBackStackEntryAsState()
		val currentRoute = navBackStackEntry.value?.destination?.route

		list.forEach { item ->
//			val isSelected = derivedStateOf { currentRoute == item.first.route }
			val isSelected = currentRoute == item.first.route

			BottomNavigationItem(
				selected = isSelected,
				onClick = {
					navController.navigate(item.first.route) {
						navController.graph.startDestinationRoute?.let { screen_route ->
							popUpTo(screen_route) {
								saveState = true
							}
						}
						launchSingleTop = true
						restoreState = true
					}
				},
				icon = {
					Icon(item.second, contentDescription = item.first.route)
				})
		}
	}
}





