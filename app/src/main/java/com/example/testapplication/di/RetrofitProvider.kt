package com.example.testapplication.di

import com.example.testapplication.api.mars.MarsPhotoRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule @Inject constructor() {

	@Provides
	fun getRetrofit(): MarsPhotoRemoteSource {
		return Retrofit.Builder()
			.baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(MarsPhotoRemoteSource::class.java)
	}
}