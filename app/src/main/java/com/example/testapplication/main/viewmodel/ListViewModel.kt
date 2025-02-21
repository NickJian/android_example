package com.example.testapplication.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapplication.repository.LoadPhotoResult
import com.example.testapplication.repository.PhotoListRepository
import com.example.testapplication.ui.model.ListImage
import com.example.testapplication.ui.model.ListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListViewModel @Inject constructor(val photoListRepository: PhotoListRepository) :
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
		when (val result = photoListRepository.getPhotoList()) {
			is LoadPhotoResult.Success -> _listScreenState.value =
				ListScreenState.Success(result.photos.map {
					ListImage(
						id = it.id,
						imgSrc = it.image
					)
				})

			is LoadPhotoResult.Error -> LoadPhotoResult.Error(result.message)
		}


	}



}