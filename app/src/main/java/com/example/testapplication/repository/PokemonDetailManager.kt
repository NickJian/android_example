package com.example.testapplication.repository

import com.example.testapplication.api.model.PokemonDetailData
import com.example.testapplication.api.pokemon.PokemonDataSource
import com.example.testapplication.ui.model.PokemonUiDetailData
import javax.inject.Inject

interface PokemonDetailManager {
	suspend fun getPokemonDetail(id: String): PokemonUiDetailData
}

class PokemonDetailManagerImpl @Inject constructor(val dataSource: PokemonDataSource) :
	PokemonDetailManager {
	override suspend fun getPokemonDetail(id: String): PokemonUiDetailData {
		return dataSource.getPokemonDetails(id).toPokemonUiDetailData()
	}

	fun PokemonDetailData.toPokemonUiDetailData(): PokemonUiDetailData {
		return PokemonUiDetailData(
			id = id ?: "",
			height = height ?: "",
			weight = weight ?: "",
			front = sprites.front ?: "",
			back = sprites.back ?: "",
			name = name ?: "",
		)
	}
}

