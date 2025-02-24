package com.example.testapplication.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class TestViewModel @Inject constructor() : ViewModel() {
	init {
		Log.d("TestViewModel", "init")
	}

	override fun onCleared() {
		super.onCleared()
		Log.d("TestViewModel", "onclear")
	}
}
