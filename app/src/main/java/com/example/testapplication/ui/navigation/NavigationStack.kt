package com.example.testapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testapplication.ui.compose.BoxLayout
import com.example.testapplication.ui.compose.ListScreen
import com.example.testapplication.ui.compose.MainScreen
import com.example.testapplication.ui.model.ListImage

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
			ListScreen(sampleData)
		}
		composable(NavigationScreen.BoxLayout.route) {
			BoxLayout() // todo add NavController
		}
	}
}


val sampleData = listOf(
	ListImage(
		id = "id1",
		imgSrc = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044630840405181E02_DXXX.jpg"
	),
	ListImage(
		id = "id2",
		imgSrc = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044630840503644E01_DXXX.jpg"
	),
	ListImage(
		id = "id3",
		imgSrc = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044630830503643E02_DXXX.jpg"
	),
	ListImage(
		id = "id4",
		imgSrc = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044630840405181E02_DXXX.jpg"
	),
	ListImage(
		id = "id5",
		imgSrc = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044630840503644E01_DXXX.jpg"
	),
	ListImage(
		id = "id6",
		imgSrc = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044630830503643E02_DXXX.jpg"
	)
)
