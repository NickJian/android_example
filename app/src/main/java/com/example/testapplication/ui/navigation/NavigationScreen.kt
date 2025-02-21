package com.example.testapplication.ui.navigation

sealed class NavigationScreen(val route: String){
	object MainPage: NavigationScreen("main_page")
	object ListPage: NavigationScreen("list_page")
	object BoxLayout: NavigationScreen("box_layout")

}