package com.example.testapplication.main.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
	private val _state = MutableStateFlow(MainState.MainPage)
	val state: StateFlow<MainState> = _state.asStateFlow()

	fun updateState(newState: MainState) {
		_state.value = newState
	}
}

enum class MainState {
	MainPage,
	ListPage,
	BoxLayout,
}