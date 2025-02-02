package ru.kryu.camera.presentation.mainscreen

import android.R
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
import ru.kryu.camera.domain.model.CardItem
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
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
        _uiState.update { it.copy(isLoading = true, errorMessage = "", isError = false) }
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000) // Simulate network delay
            val success = (0..1).random() > 0 // Simulate random error
            if (success) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isError = false,
                        items = listOf(
                            CardItem("1", "Title 1", R.drawable.ic_menu_gallery),
                            CardItem("2", "Title 2", android.R.drawable.ic_menu_camera),
                            CardItem("3", "Title 1", R.drawable.ic_menu_gallery),
                            CardItem("4", "Title 2", android.R.drawable.ic_menu_camera),
                            CardItem("5", "Title 1", R.drawable.ic_menu_gallery),
                            CardItem("6", "Title 2", android.R.drawable.ic_menu_camera),
                            CardItem("7", "Title 1", R.drawable.ic_menu_gallery),
                            CardItem("8", "Title 2", android.R.drawable.ic_menu_camera),
                            CardItem("9", "Title 1", R.drawable.ic_menu_gallery),
                            CardItem("10", "Title 2", android.R.drawable.ic_menu_camera),
                            CardItem("11", "Title 1", R.drawable.ic_menu_gallery),
                            CardItem("12", "Title 2", android.R.drawable.ic_menu_camera),
                            CardItem("13", "Title 1", R.drawable.ic_menu_gallery),
                            CardItem("14", "Title 2", android.R.drawable.ic_menu_camera),
                            CardItem("15", "Title 1", R.drawable.ic_menu_gallery),
                            CardItem("16", "Title 2", android.R.drawable.ic_menu_camera),
                            CardItem("17", "Title 1", R.drawable.ic_menu_gallery),
                            CardItem("18", "Title 2", android.R.drawable.ic_menu_camera),
                            CardItem("19", "Title 1", R.drawable.ic_menu_gallery),
                            CardItem("20", "Title 2", android.R.drawable.ic_menu_camera),
                            CardItem("21", "Title 1", R.drawable.ic_menu_gallery),
                            CardItem("22", "Title 2", android.R.drawable.ic_menu_camera),
                            CardItem("23", "Title 1", R.drawable.ic_menu_gallery),
                            CardItem("24", "Title 2", android.R.drawable.ic_menu_camera),
                        )
                    )
                }
            } else {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isError = true,
                        errorMessage = "Error"
                    )
                }
                delay(50L)
                _uiState.update { it.copy(errorMessage = "") }
            }
        }
    }
}
