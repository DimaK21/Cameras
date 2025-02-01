package ru.kryu.camera.presentation.mainscreen

import ru.kryu.camera.domain.model.CardItem

sealed class UiState {
    object Loading : UiState()
    data class Success(val items: List<CardItem>) : UiState()
    object Error : UiState()
}