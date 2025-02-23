package com.example.testapplication.repository.di

import com.example.testapplication.repository.PhotoListRepository
import com.example.testapplication.repository.PhotoListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PhotoListRepositoryModule {

	@Binds
	abstract fun bindPhotoListRepository(impl: PhotoListRepositoryImpl): PhotoListRepository
}
