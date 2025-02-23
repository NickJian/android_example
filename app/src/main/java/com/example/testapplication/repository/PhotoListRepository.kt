package com.example.testapplication.repository

import com.example.testapplication.api.mars.MarsPhotoRemoteSource
import com.example.testapplication.model.MarsPhoto
import javax.inject.Inject

class PhotoListRepositoryImpl @Inject constructor(val remoteSource: MarsPhotoRemoteSource) :
	PhotoListRepository {

	override suspend fun getPhotoList(): LoadPhotoResult {
		try {
			val result = remoteSource.getPhotos().execute()
			if (result.isSuccessful && result.body() != null) {
				return LoadPhotoResult.Success(result.body()!!)
			} else {
				return LoadPhotoResult.Error("Server error")
			}
		} catch (e: Exception) {
			return LoadPhotoResult.Error(e.message.toString())
		}

	}
}

interface PhotoListRepository {
	suspend fun getPhotoList(): LoadPhotoResult
}

sealed class LoadPhotoResult {
	class Success(val photos: List<MarsPhoto>) : LoadPhotoResult()
	class Error(val message: String) : LoadPhotoResult()
}



