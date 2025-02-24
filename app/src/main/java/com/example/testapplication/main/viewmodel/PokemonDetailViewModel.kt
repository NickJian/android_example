package com.example.testapplication.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapplication.repository.PokemonDetailManager
import com.example.testapplication.ui.model.PokemonUiDetailData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(val pokemonDetailManager: PokemonDetailManager) :
	ViewModel() {

	private val _loadingState = MutableStateFlow<Boolean>(false)
	val loadingState = _loadingState.asStateFlow<Boolean>()

	private val _detailState = MutableStateFlow(PokemonUiDetailData("", "", "", "", "", "loading"))
	val detailState = _detailState.asStateFlow()

//	init {
	// todo why crash?
//		Log.d("TestViewModel", "init")
//	}

	fun getPokemonDetail(id: String) {
		_loadingState.value = true
		viewModelScope.launch(Dispatchers.IO) {
			val detail = pokemonDetailManager.getPokemonDetail(id)
			_detailState.value = detail
			_loadingState.value = false
			// todo error handling
		}
	}

	override fun onCleared() {
		super.onCleared()
		Log.d("TestViewModel", "onclear")
	}
}
