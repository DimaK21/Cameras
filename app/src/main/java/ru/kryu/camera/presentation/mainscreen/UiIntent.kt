package ru.kryu.camera.presentation.mainscreen

sealed class UiIntent {
    object LoadData : UiIntent()
    object Retry : UiIntent()
}