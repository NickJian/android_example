package com.example.testapplication.ui.compose

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.testapplication.R

@Composable
@Preview(showBackground = true)
fun MainScreenContent() {
	var text by remember { mutableStateOf("Sample text") }
	var visible by rememberSaveable { mutableStateOf(false) }

	Column(
		Modifier
			.verticalScroll(rememberScrollState())
//			.padding(innerPadding)
	) {


		Text(
			text = "click to show more text",
			modifier = Modifier
				.clickable { visible = !visible },
			fontSize = 20.sp,
		)


		Text(
			if (visible)
				"Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2"
			else "",
			Modifier
				.animateContentSize(),
		)


		Button(onClick = { text += "_" }, contentPadding = PaddingValues(20.dp)) {
			Text("Click me")
//                Toast.makeText(LocalContext.current, "Button clicked", Toast.LENGTH_SHORT).show()
		}
		Spacer(modifier = Modifier.height(10.dp))

		Text(
			"Button clicked $text times",
			fontStyle = FontStyle.Italic,
			fontSize = 20.sp,
			textAlign = TextAlign.Center,
			modifier = Modifier.fillMaxWidth()
		)

		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.SpaceEvenly
		) {
			Text("text 1")
			Text("text 2")
		}

		AsyncImage(
			model = R.drawable.ic_launcher_background,
			contentDescription = "test content description",
			modifier = Modifier.size(150.dp),
		)
		AsyncImage(
			model = "https://letsenhance.io/static/73136da51c245e80edc6ccfe44888a99/1015f/MainBefore.jpg",
			contentDescription = "test content description",
			modifier = Modifier.size(150.dp),
		)
		Card {
			Text(
				if (visible)
					"Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2 Hello Compose line 2"
				else "Hidden text",
				Modifier
					.animateContentSize()
					.padding(10.dp),
			)
		}


	}
}



