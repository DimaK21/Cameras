package ru.kryu.camera.presentation.mainscreen

import ru.kryu.camera.domain.model.CameraItem

data class MainScreenState(
    val isLoading: Boolean = false,
    val items: List<CameraItem> = emptyList(),
    val isError: Boolean = false,
    val errorMessage: String = "",
)