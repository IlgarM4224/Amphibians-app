package com.example.amphibiansapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.amphibiansapp.ContentType
import com.example.amphibiansapp.R
import com.example.amphibiansapp.model.Amphibian
import com.example.amphibiansapp.ui.screens.components.AmphibianCardList
import com.example.amphibiansapp.ui.screens.components.AmphibiansGridList

@Composable
fun AmphibianAppContent(
    amphibians: List<Amphibian>,
    contentType: ContentType,
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

        if (contentType == ContentType.GridList){
            AmphibiansGridList(
                modifier = Modifier.padding(innerPadding),
                amphibians = amphibians
            )
        } else {
            AmphibianCardList(
                modifier = Modifier.padding(innerPadding),
                amphibians = amphibians
            )
        }
    }
}