package com.example.amphibiansapp.ui.screens.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
                title = amphibians[it].titleId,
                description = amphibians[it].descriptionId,
                img = amphibians[it].imgId,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}
@Composable
fun AmphibianCard(
    title: Int,
    description: Int,
    @DrawableRes img: Int,
    modifier: Modifier = Modifier
){
    val imgHeight = dimensionResource(R.dimen.image_height)
    val textPadding = dimensionResource(R.dimen.text_padding)

    Card(modifier = modifier){
        Column {
            Text(
                text = stringResource(title),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(textPadding)
                    .fillMaxWidth()
            )

            Image (
                painter = painterResource(img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .heightIn(imgHeight)
                    .fillMaxWidth()
            )

            Text(
                text = stringResource(description),
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
            title = R.string.test_title,
            description = R.string.test_description,
            img = R.drawable.testimg,
            modifier = Modifier.padding(dimensionResource(R.dimen.text_padding)*2)
        )
    }
}
