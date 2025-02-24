package com.example.testapplication.ui.compose

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.testapplication.ui.model.ListScreenState
import com.example.testapplication.ui.model.PokemonListItemData
import com.example.testapplication.ui.navigation.NavigationScreen

@Composable
fun PokemonListScreen(state: State<ListScreenState>, navController: NavController) {
	Box(Modifier.statusBarsPadding()) {
		Log.d("listScreen", "recompose ${state.value}")
		when (val screenState = state.value) {
			is ListScreenState.Failed -> Text("Error" + screenState.message)
			is ListScreenState.Loading -> Text("loading")
			is ListScreenState.Success -> ItemListScreen(navController, screenState.imageList)
		}
	}
}

@Composable
fun ItemListScreen(navController: NavController, imageList: List<PokemonListItemData>) {
	LazyColumn(
		modifier = Modifier
			.fillMaxWidth()
	) {
		items(imageList.size, key = { index -> imageList[index].id }) { idx ->
			ListItemCard(navController, imageList, idx)
		}
	}
}

@Composable
private fun ListItemCard(
	navController: NavController,
	imageList: List<PokemonListItemData>,
	idx: Int
) {
	Card(modifier = Modifier
		.padding(3.dp)
		.clickable { navController.navigate(NavigationScreen.PokemonDetail.createRoute(imageList[idx].id)) }) {
		Column(modifier = Modifier.padding(10.dp)) {
			val imageData = imageList[idx]

			Text("${imageData.id} ${imageData.name}")
			AsyncImage(
				modifier = Modifier
					.padding(top = 10.dp)
					.height(100.dp),
				model = imageData.image,
				contentDescription = imageData.id,
			)
		}
	}
}

@Composable
@Preview(showBackground = true)
fun PeviewListScreen() {
	val mutableState = remember { mutableStateOf(ListScreenState.Success(preivewItemList)) }
	PokemonListScreen(mutableState, rememberNavController())
}

@Composable
@Preview(showBackground = true)
fun PreviewListScreenLoading() {
	val mutableState = remember { mutableStateOf(ListScreenState.Loading) }
	PokemonListScreen(mutableState, rememberNavController())
}

private val preivewItemList = listOf(
	PokemonListItemData(
		id = "id1",
		name = "name1",
		image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
	),
	PokemonListItemData(
		id = "id2",
		name = "name2",
		image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png"
	),
	PokemonListItemData(
		id = "id3",
		name = "name3",
		image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png"
	)
)


