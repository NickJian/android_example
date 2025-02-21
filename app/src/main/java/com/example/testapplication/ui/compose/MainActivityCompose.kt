package com.example.testapplication.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.testapplication.main.viewmodel.MainState
import com.example.testapplication.ui.model.ListImage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
@Preview(showBackground = true)
private fun PreviewCompose(@PreviewParameter(PreviewStateProvider::class) pair: PreviewObj) {
	MainActivityCompose(pair.callback, pair.state)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainActivityCompose(
	onNavClick: ((MainState) -> Unit),
	state: StateFlow<MainState>
) {
	Scaffold(
		topBar = {
			TopAppBar(
				title = { Text("My App") }
			)
		},
		bottomBar = {
			BottomAppBar {
				IconButton(onClick = { onNavClick.invoke(MainState.MainPage) }) {
					Icon(Icons.Default.Home, contentDescription = "Home")
				}
				IconButton(onClick = { onNavClick.invoke(MainState.ListPage) }) {
					Icon(Icons.Default.Favorite, contentDescription = "List")
				}
				IconButton(onClick = { onNavClick.invoke(MainState.BoxLayout) }) {
					Icon(
						Icons.Default.Lock,
						contentDescription = "boxlayout"
					)
				}
			}
		},
		floatingActionButton = {
			FloatingActionButton(onClick = { /* Handle action */ }) {
				Icon(Icons.Default.Add, contentDescription = "Add")
			}
		},
	) { innerPadding ->
		Box(modifier = Modifier
			.padding(innerPadding)
			.fillMaxSize()){
		when (state.collectAsState().value) {
			MainState.MainPage -> MainScreen()
			MainState.ListPage -> ListScreen(sampleData)
			MainState.BoxLayout -> BoxLayout()
		}
			}

	}

}

val sampleData = listOf(
	ListImage(
		id = "id1",
		imgSrc = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044630840405181E02_DXXX.jpg"
	),
	ListImage(
		id = "id2",
		imgSrc = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044630840503644E01_DXXX.jpg"
	),
	ListImage(
		id = "id3",
		imgSrc = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044630830503643E02_DXXX.jpg"
	),
	ListImage(
		id = "id4",
		imgSrc = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044630840405181E02_DXXX.jpg"
	),
	ListImage(
		id = "id5",
		imgSrc = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044630840503644E01_DXXX.jpg"
	),
	ListImage(
		id = "id6",
		imgSrc = "https://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044630830503643E02_DXXX.jpg"
	)
)

data class PreviewObj(val callback: (MainState) -> Unit, val state: StateFlow<MainState>)

class PreviewStateProvider :
	PreviewParameterProvider<PreviewObj> {
	override val values: Sequence<PreviewObj>
		get() = sequenceOf(PreviewObj({ _: MainState -> }, MutableStateFlow(MainState.MainPage)))

}




