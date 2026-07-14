package com.example.amphibiansapp.ui.screens.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.amphibiansapp.R
import com.example.amphibiansapp.model.Amphibian

@Composable
fun AmphibiansGridList(
    amphibians: List<Amphibian>,
    modifier: Modifier = Modifier
){
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_small))
    ) {
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
