package com.example.testapplication.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavigationItem(
	val screen: NavigationScreen,
	val label: String,
	val icon: ImageVector
) {
	MainPage(NavigationScreen.MainPage, "MainPage", Icons.Default.Home),
	PokemonListPage(
		NavigationScreen.PokemonListPage,
		"PokemonListPage",
		Icons.Default.Person
	),
	BoxLayout(NavigationScreen.BoxLayout, "BoxLayout", Icons.Default.Build)
}