package com.example.amphibiansapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibiansapp.ui.screens.AmphibianAppContent
import com.example.amphibiansapp.ui.screens.components.AmphibianViewModel

@Composable
fun AmphibianApp(){
    val viewModel: AmphibianViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    AmphibianAppContent(
        modifier = Modifier
            .statusBarsPadding()
            .padding(dimensionResource(R.dimen.padding_small))
            .fillMaxSize(),
        amphibians = uiState.amphibians
    )
}
