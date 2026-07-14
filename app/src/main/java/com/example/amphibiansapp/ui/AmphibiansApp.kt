package com.example.amphibiansapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibiansapp.ContentType
import com.example.amphibiansapp.R
import com.example.amphibiansapp.ui.screens.AmphibianAppContent
import com.example.amphibiansapp.ui.screens.AmphibianUiState
import com.example.amphibiansapp.ui.screens.AmphibianViewModel
import com.example.amphibiansapp.ui.screens.ErrorScreen
import com.example.amphibiansapp.ui.screens.LoadingScreen

@Composable
fun AmphibianApp(windowSize: WindowWidthSizeClass){
    val viewModel: AmphibianViewModel = viewModel(factory = AmphibianViewModel.Factory)
    val uiState by viewModel.uiState.collectAsState()

    val contentType = when (windowSize) {
        WindowWidthSizeClass.Compact -> ContentType.CardList
        WindowWidthSizeClass.Medium -> ContentType.CardList
        WindowWidthSizeClass.Expanded -> ContentType.GridList
        else -> ContentType.CardList
    }

    when (val state = uiState) {
        is AmphibianUiState.Success ->
            AmphibianAppContent(
                contentType = contentType,
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(dimensionResource(R.dimen.padding_small))
                    .fillMaxSize(),
                amphibians = state.amphibians
            )
        is AmphibianUiState.Loading ->
            LoadingScreen()
        is AmphibianUiState.Error ->
            ErrorScreen(
                retryAction = { viewModel .retry() },
                errorText = stringResource(R.string.no_internet)
            )
    }
}
