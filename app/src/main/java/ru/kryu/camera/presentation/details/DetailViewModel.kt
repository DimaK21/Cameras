package ru.kryu.camera.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.kryu.camera.navigation.DETAIL_ARG_ID_KEY
import ru.kryu.camera.navigation.DETAIL_ARG_TITLE_KEY
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow(DetailScreenState())
    val uiState: StateFlow<DetailScreenState> = _uiState.asStateFlow()

    init {
        val title: String = savedStateHandle[DETAIL_ARG_TITLE_KEY] ?: ""
        val id: String = savedStateHandle[DETAIL_ARG_ID_KEY] ?: ""
        _uiState.update { it.copy(title = title, videoId = id) }
    }
}