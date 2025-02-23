package com.example.testapplication.api.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailData(
	@SerializedName("name") val id: String,
	@SerializedName("height") val height: String,
	@SerializedName("weight") val weight: String,
	@SerializedName("front_shiny") val front: String,
	@SerializedName("back_shiny") val back: String,
)
