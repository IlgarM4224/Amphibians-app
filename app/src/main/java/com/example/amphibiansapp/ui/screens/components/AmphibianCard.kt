package com.example.amphibiansapp.ui.screens.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.amphibiansapp.R
import com.example.amphibiansapp.model.Amphibian
import com.example.amphibiansapp.ui.theme.AmphibiansAppTheme


@Composable
fun AmphibianCardList(
    amphibians: List<Amphibian>,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier) {
        items (amphibians.size){
            AmphibianCard(
                name = amphibians[it].name,
                type = amphibians[it].type,
                description = amphibians[it].description,
                img = amphibians[it].imgSrc,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}
@Composable
fun AmphibianCard(
    name: String,
    type: String,
    description: String,
    img: String,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
){
    val imgHeight = dimensionResource(R.dimen.image_height)
    val textPadding = dimensionResource(R.dimen.text_padding)

    Card(modifier = modifier){
        Column {
            Text(
                text = "$name ($type)",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(textPadding)
                    .fillMaxWidth()
            )

            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(img)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .heightIn(imgHeight)
                    .fillMaxWidth()
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(textPadding)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun AmphibianCardPreview(){
    AmphibiansAppTheme {
        AmphibianCard(
            name = stringResource(R.string.test_title),
            type = "Frog",
            description = stringResource(R.string.test_description),
            img = "",
            modifier = Modifier.padding(dimensionResource(R.dimen.text_padding)*2)
        )
    }
}
