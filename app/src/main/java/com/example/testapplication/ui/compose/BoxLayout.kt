package com.example.testapplication.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.testapplication.R

@Composable
@Preview(showBackground = true)
fun BoxLayout() {

	var image = remember { mutableStateOf<Any>(R.drawable.ic_launcher_background) }

	Column(
		Modifier
			.verticalScroll(rememberScrollState())
			.padding(10.dp)
			.fillMaxWidth()

	) {
		Box(
			modifier = Modifier
				.background(Color.Yellow)
				.height(500.dp)
		) {
			Spacer(
				Modifier
					.height(300.dp)
					.background(Color.LightGray)
					.align(Alignment.TopCenter)
					.fillMaxWidth()
			)

			AsyncImage(
				model = "https://letsenhance.io/static/73136da51c245e80edc6ccfe44888a99/1015f/MainBefore.jpg",
				contentDescription = "test content description",
				modifier = Modifier
					.width(300.dp)
					.height(300.dp)
					.align(Alignment.BottomCenter)
					.clip(
						CircleShape
					),
				alignment = Alignment.BottomCenter,
				contentScale = ContentScale.Crop
			)


		}

	}
}

@Composable
fun ConstraintLayout(modifier: Modifier, content: () -> Unit) {

}

