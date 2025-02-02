package ru.kryu.camera.presentation.mainscreen

import ru.kryu.camera.domain.model.CardItem

data class UiState(
    val isLoading: Boolean,
    val items: List<CardItem>,
    val isError: Boolean,
)