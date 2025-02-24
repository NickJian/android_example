package com.example.testapplication.api.pokemon

import com.example.testapplication.api.model.PokemonDetailData
import com.example.testapplication.api.model.PokemonListResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonDataSource {
	@GET("pokemon")
	suspend fun getPokemon(
		@Query("limit") limit: String,
		@Query("offset") offset: String,
	): PokemonListResult

	@GET("pokemon/{id}")
	suspend fun getPokemonDetails(
		@Path("id") id: String,
	): PokemonDetailData
}