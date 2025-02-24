package com.example.testapplication.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapplication.repository.LoadPhotoResult
import com.example.testapplication.repository.PhotoListRepository
import com.example.testapplication.ui.model.ListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ListViewModel @Inject constructor(val photoListRepository: PhotoListRepository) :
	ViewModel() {

	private val _listScreenState = MutableStateFlow<ListScreenState>(ListScreenState.Loading)
	val listScreenState = _listScreenState.asStateFlow()

	init {
		Log.d("ListViewModel", "init")
		viewModelScope.launch {
			getListViewDetail()
		}
	}

	override fun onCleared() {
		super.onCleared()
		Log.d("ListViewModel", "onCleared")
	}

	private suspend fun getListViewDetail() {
		_listScreenState.value = ListScreenState.Loading
		val result = withContext(Dispatchers.IO) { photoListRepository.getPhotoList() }
		_listScreenState.value = when (result) {
			is LoadPhotoResult.Success ->
				ListScreenState.Success(result.photos)
			is LoadPhotoResult.Error -> ListScreenState.Failed(result.message)
		}
	}

}