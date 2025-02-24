package com.example.testapplication.ui.compose

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.testapplication.ui.model.PokemonUiDetailData

@Composable
fun PokemonDetailScreen(data: State<PokemonUiDetailData>, isLoading: State<Boolean>) {
	Scaffold { innerPadding ->

		Log.d("PokemonDetailScreen", "recompose ${data.value}  ${isLoading.value}")
		Box(Modifier.padding(10.dp)) {
			Box(Modifier.padding(innerPadding)) {
				if (isLoading.value) {
					Text("Loading...")
				} else {
					DetailPokemonCard(data)
				}
			}
		}
	}
}

@Composable
private fun DetailPokemonCard(data: State<PokemonUiDetailData>) {
	Card {
		Column(Modifier.padding(20.dp)) {
			Row(
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier.padding(10.dp)
			) {
				Text(
					text = "NO ${data.value.id}",
					fontWeight = FontWeight.Bold
				)
				Spacer(Modifier.width(10.dp))
				Text(text = data.value.name, fontSize = 20.sp)
			}

			Row {
				AsyncImage(
					modifier = Modifier.height(100.dp),
					model = data.value.front,
					contentDescription = data.value.name
				)
				AsyncImage(
					modifier = Modifier.height(100.dp),
					model = data.value.back,
					contentDescription = data.value.name
				)
			}
			Text(text = "height : ${data.value.name}", fontSize = 20.sp)
			Text(text = "weight : ${data.value.weight}", fontSize = 20.sp)
			Text(text = "height : ${data.value.height}", fontSize = 20.sp)

		}
	}
}

@Composable
@Preview(showBackground = true)
fun PreviewPokemonDetailScreen() {
	PokemonDetailScreen(
		remember {
			mutableStateOf(
				PokemonUiDetailData(
					id = "123",
					height = "5566",
					weight = "7766",
					front = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
					back = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/1.png",
					name = "name",
				)
			)
		},
		isLoading = remember {
			mutableStateOf(false)
		}
	)
}



