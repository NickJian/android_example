package com.example.testapplication.api.di

import com.example.testapplication.api.pokemon.PokemonDataSource
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
	fun getRetrofit(): PokemonDataSource {
		return Retrofit.Builder()
			.baseUrl("https://pokeapi.co/api/v2/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(PokemonDataSource::class.java)
	}
}