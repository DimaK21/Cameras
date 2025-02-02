package ru.kryu.camera.presentation.mainscreen

import ru.kryu.camera.domain.model.CardItem

data class MainScreenState(
    val isLoading: Boolean = false,
    val items: List<CardItem> = emptyList(),
    val isError: Boolean = false,
    val errorMessage: String = "",
)