package com.example.testapplication.api.model

import com.google.gson.annotations.SerializedName

data class PokemonListResult(
	@SerializedName("count") val count: Int,
	@SerializedName("next") val next: String?,
	@SerializedName("previous") val previous: String?,
	@SerializedName("results") val results: List<PokemonItemData>
)

data class PokemonItemData(
	@SerializedName("name") val name: String,
	@SerializedName("url") val url: String,
)