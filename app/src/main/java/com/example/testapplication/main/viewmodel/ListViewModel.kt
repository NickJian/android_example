package com.example.testapplication.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapplication.api.mars.MarsPhotoRemoteSource
import com.example.testapplication.ui.model.ListImage
import com.example.testapplication.ui.model.ListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListViewModel @Inject constructor(val marsPhotoRemoteSource: MarsPhotoRemoteSource) :
	ViewModel() {


	private val _listScreenState = MutableStateFlow<ListScreenState>(ListScreenState.Loading)
	val listScreenState = _listScreenState.asStateFlow()

	init {
		viewModelScope.launch {
			getMarsPhotos()
		}
	}

	private suspend fun getMarsPhotos() {
		_listScreenState.value = ListScreenState.Loading
		delay(1000L)
		_listScreenState.value = ListScreenState.Success(sampleData)
	}

	companion object {
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

	}

}