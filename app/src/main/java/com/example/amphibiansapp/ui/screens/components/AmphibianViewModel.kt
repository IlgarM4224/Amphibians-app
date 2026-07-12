package com.example.amphibiansapp.ui.screens.components

import androidx.lifecycle.ViewModel
import com.example.amphibiansapp.data.AmphibianData
import com.example.amphibiansapp.model.Amphibian
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AmphibianViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(
        AmphibianState(
            amphibians = AmphibianData.getTest()
        )
    )

    val uiState: StateFlow<AmphibianState> = _uiState.asStateFlow()
}

data class AmphibianState(
   val amphibians: List<Amphibian>
)