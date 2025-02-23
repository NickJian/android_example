package com.example.testapplication.api.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailData(
	// todo placeholder, need to update
	@SerializedName("name") val id: String,
	@SerializedName("url") val url: String,
)