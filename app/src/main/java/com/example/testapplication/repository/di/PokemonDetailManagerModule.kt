package com.example.testapplication.repository.di

import com.example.testapplication.repository.PokemonDetailManager
import com.example.testapplication.repository.PokemonDetailManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PokemonDetailManagerModule {
	@Binds
	abstract fun bindPokemonDetailManager(impl: PokemonDetailManagerImpl): PokemonDetailManager
}