package com.example.testapplication.repository

import com.example.testapplication.model.MarsPhoto
import javax.inject.Inject

class PhotoListRepositoryImpl @Inject constructor() : PhotoListRepository {
	override suspend fun getPhotoList(): LoadPhotoResult {
		return LoadPhotoResult.Success(sampleData)
	}

	companion object {
		val sampleData = listOf(
			MarsPhoto(
				id = "id1",
				image = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044630840405181E02_DXXX.jpg"
			),
			MarsPhoto(
				id = "id2",
				image = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044630840503644E01_DXXX.jpg"
			),
			MarsPhoto(
				id = "id3",
				image = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044630830503643E02_DXXX.jpg"
			),
			MarsPhoto(
				id = "id4",
				image = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044630840405181E02_DXXX.jpg"
			),
			MarsPhoto(
				id = "id5",
				image = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044630840503644E01_DXXX.jpg"
			),
			MarsPhoto(
				id = "id6",
				image = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044630830503643E02_DXXX.jpg"
			)
		)

	}
}

interface PhotoListRepository {
	suspend fun getPhotoList(): LoadPhotoResult
}

sealed class LoadPhotoResult {
	class Success(val photos: List<MarsPhoto>) : LoadPhotoResult()
	class Error(val message: String) : LoadPhotoResult()
}

