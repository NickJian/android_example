package com.example.testapplication.api.mars

import com.example.testapplication.model.MarsPhoto
import retrofit2.Call
import retrofit2.http.GET

interface MarsPhotoRemoteSource {
	@GET("photos")
	fun getPhotos(): Call<List<MarsPhoto>>
}