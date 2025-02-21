package com.example.testapplication.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.testapplication.ui.model.ListImage

@Composable
@Preview(showBackground = true)
fun ListScreen(@PreviewParameter(PreviewListDataProvider::class) imageList: List<ListImage>) {

//	Column(
//		Modifier.fillMaxSize()
//	) {


	LazyColumn(
		modifier = Modifier
			.fillMaxWidth()
	) {
		items(imageList.size, key = { index -> imageList[index].id }) { idx ->
			Card(modifier = Modifier.padding(3.dp)) {
				Column(modifier = Modifier.padding(10.dp)) {
					val imageData = imageList[idx]

					Text("item ${imageData.id}")

					AsyncImage(
						modifier = Modifier
							.padding(top =  10.dp)
							.background(Color.Red),
						model = imageData.imgSrc,
						contentDescription = imageData.id,
					)
				}
			}
		}
	}

//	}
}


class PreviewListDataProvider : PreviewParameterProvider<List<ListImage>> {
	override val values: Sequence<List<ListImage>>
		get() = sequenceOf(
			listOf(
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
				)
			)
		)

}