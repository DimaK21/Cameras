package ru.kryu.camera.data.converter

import ru.kryu.camera.data.network.dto.ServerInfoDto
import ru.kryu.camera.domain.model.CameraItem

fun ServerInfoDto.toCameraItemList() = channels?.map {
    CameraItem(
        id = it?.id ?: "",
        name = it?.name ?: "",
        image = null
    )
} ?: emptyList()
