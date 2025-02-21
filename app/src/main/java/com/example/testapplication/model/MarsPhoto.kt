package com.example.testapplication.model

import com.google.gson.annotations.SerializedName

data class MarsPhoto(
	@SerializedName("id") val id: String,
	@SerializedName("img_src") val image: String,
)