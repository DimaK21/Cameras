package ru.kryu.camera.domain.model

data class CameraItem(
    val id: String,
    val name: String,
    val image : ByteArray?,
)
