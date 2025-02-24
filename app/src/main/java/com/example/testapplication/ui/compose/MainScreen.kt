package com.example.testapplication.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testapplication.main.viewmodel.MainState
import com.example.testapplication.ui.navigation.NavigationScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
@Preview(showBackground = true)
private fun PreviewCompose(@PreviewParameter(PreviewStateProvider::class) pair: PreviewObj) {
	MainScreen(rememberNavController())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
	navController: NavController
) {
	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text("My App") }
			)
		},
		bottomBar = {

			BottomAppBar {
				IconButton(onClick = { }) {
					Icon(Icons.Default.Home, contentDescription = "Home")
				}
				IconButton(onClick = { navController.navigate(NavigationScreen.PokemonListPage.route) }) {
					Icon(Icons.Default.Favorite, contentDescription = "List")
				}
				IconButton(onClick = { navController.navigate(NavigationScreen.BoxLayout.route) }) {
					Icon(
						Icons.Default.Lock,
						contentDescription = "boxlayout"
					)
				}
			}
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
			MainScreenContent()
		}

	}
}

@Composable
fun BottomNavigationBar(navController: NavController) {
	val list = listOf(
		NavigationScreen.MainPage to Icons.Default.Home,
		NavigationScreen.PokemonListPage to Icons.AutoMirrored.Filled.List,
		NavigationScreen.BoxLayout to Icons.Default.PlayArrow,
	)

	BottomNavigation {
		val navBackStackEntry = navController.currentBackStackEntryAsState()
		val currentRoute = navBackStackEntry.value?.destination?.route

		list.forEach { item ->
			val isSelected = currentRoute == item.first.route

			BottomNavigationItem(
				selected = isSelected,
				onClick = {
					navController.navigate(item.first.route)
//					navController.navigate(item.route) {
//						navController.graph.startDestinationRoute?.let { screen_route ->
//							popUpTo(screen_route) {
//								saveState = true
//							}
//						}
//						launchSingleTop = true
//						restoreState = true
				},
				icon = {
					Icon(item.second, contentDescription = item.first.route)
				})
		}
	}
}

data class PreviewObj(val callback: (MainState) -> Unit, val state: StateFlow<MainState>)

class PreviewStateProvider :
	PreviewParameterProvider<PreviewObj> {
	override val values: Sequence<PreviewObj>
		get() = sequenceOf(
			PreviewObj(
				{ _: MainState -> },
				MutableStateFlow(MainState.MainPage)
			)
		)
}




