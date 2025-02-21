package com.example.testapplication.main.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testapplication.api.mars.MarsPhotoRemoteSource
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(val  marsPhotoRemoteSource: MarsPhotoRemoteSource)  : ViewModel() {


}