package ru.kryu.camera.presentation.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.kryu.camera.domain.CamerasRepository
import ru.kryu.camera.domain.ImageRepository
import ru.kryu.camera.util.Resource
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val camerasRepository: CamerasRepository,
    private val imageRepository: ImageRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenState())
    val uiState: StateFlow<MainScreenState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    fun processIntent(intent: UiIntent) {
        when (intent) {
            is UiIntent.LoadData -> loadData()
        }
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(isLoading = true, errorMessage = "", isError = false) }
            camerasRepository.getCameras().collect { resource ->
                if (resource is Resource.Success) {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = "",
                            isError = false,
                            items = resource.data ?: emptyList()
                        )
                    }
                    _uiState.value.items.forEachIndexed() { index, item ->
                        viewModelScope.launch {
                            val byteArray = imageRepository.fetchImage(item.id)
                            _uiState.update { state ->
                                state.items[index].image = byteArray
                                state
                            }
                        }
                    }
                } else {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = resource.message ?: "",
                            isError = true
                        )
                    }
                    delay(100L)
                    _uiState.update { it.copy(errorMessage = "") }
                }
            }
        }
    }
}
