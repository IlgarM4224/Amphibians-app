package com.example.amphibiansapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibiansapp.AmphibiansApplication
import com.example.amphibiansapp.data.AmphibiansRepository
import com.example.amphibiansapp.model.Amphibian
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okio.IOException

sealed interface AmphibianUiState {
    data class Success(val amphibians: List<Amphibian> ) : AmphibianUiState
    object Error : AmphibianUiState
    object Loading : AmphibianUiState
}

class AmphibianViewModel(private val amphibiansRepository: AmphibiansRepository): ViewModel(){
    private val _uiState = MutableStateFlow<AmphibianUiState>(AmphibianUiState.Loading)

    init {
        getAmphibians()
    }

    val uiState: StateFlow<AmphibianUiState> = _uiState.asStateFlow()

    private fun getAmphibians() {
        viewModelScope.launch {
            _uiState.update { AmphibianUiState.Loading }
            _uiState.update{
                try {
                    AmphibianUiState.Success(amphibiansRepository.getAmphibians())
                } catch (_ : IOException){
                    AmphibianUiState.Error
                } catch (_: Exception){
                    AmphibianUiState.Error
                }
            }
        }
    }

    fun retry(){
        getAmphibians()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibianViewModel(amphibiansRepository)
            }
        }
    }
}