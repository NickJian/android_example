package com.example.testapplication.api.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailData(
	@SerializedName("id") val id: String?,
	@SerializedName("name") val name: String?,
	@SerializedName("height") val height: String?,
	@SerializedName("weight") val weight: String?,
	@SerializedName("sprites") val sprites: PokemonDetailSprites,
)

data class PokemonDetailSprites(
	@SerializedName("front_shiny") val front: String?,
	@SerializedName("back_shiny") val back: String?,
)