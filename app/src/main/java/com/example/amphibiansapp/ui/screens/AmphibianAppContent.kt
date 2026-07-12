package com.example.amphibiansapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.amphibiansapp.R
import com.example.amphibiansapp.model.Amphibian
import com.example.amphibiansapp.ui.screens.components.AmphibianCardList
import com.example.amphibiansapp.ui.theme.AmphibiansAppTheme

@Composable
fun AmphibianAppContent(
    amphibians: List<Amphibian>,
    modifier: Modifier
){
    Scaffold(
        topBar = {
            Text (
                text = stringResource(R.string.top_bar_title),
                style = MaterialTheme.typography.titleLarge,
                fontSize = 36.sp,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        },
        modifier = modifier
    ) { innerPadding ->
        AmphibianCardList(
            modifier = Modifier.padding(innerPadding),
            amphibians = amphibians
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AmphibianAppContentPreview(){
    AmphibiansAppTheme {
        AmphibianAppContent(
            amphibians = test,
            Modifier.fillMaxSize())
    }
}

val test = listOf(
    Amphibian(
        titleId = R.string.test_title,
        descriptionId = R.string.test_description,
        imgId = R.drawable.testimg,
    ),
    Amphibian(
        titleId = R.string.test_title,
        descriptionId = R.string.test_description,
        imgId = R.drawable.testimg,
    ),
    Amphibian(
        titleId = R.string.test_title,
        descriptionId = R.string.test_description,
        imgId = R.drawable.testimg,
    )
)