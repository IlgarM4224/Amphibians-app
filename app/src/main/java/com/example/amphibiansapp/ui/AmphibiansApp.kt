package com.example.amphibiansapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibiansapp.R
import com.example.amphibiansapp.ui.screens.AmphibianAppContent
import com.example.amphibiansapp.ui.screens.AmphibianUiState
import com.example.amphibiansapp.ui.screens.AmphibianViewModel

@Composable
fun AmphibianApp(){
    val viewModel: AmphibianViewModel = viewModel(factory = AmphibianViewModel.Factory)
    val uiState by viewModel.uiState.collectAsState()

    when (val state = uiState) {
        is AmphibianUiState.Success ->
            AmphibianAppContent(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(dimensionResource(R.dimen.padding_small))
                    .fillMaxSize(),
                amphibians = state.amphibians
            )
        is AmphibianUiState.Loading -> Text(text = "Loading data")
        is AmphibianUiState.Error -> Text(text = "Error loading data")
    }
}
