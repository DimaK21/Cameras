package ru.kryu.camera.data.converter

import ru.kryu.camera.data.network.NetworkParams.ONE_FRAME_URL_FORMAT
import ru.kryu.camera.data.network.dto.ServerInfoDto
import ru.kryu.camera.domain.model.CameraItem

fun ServerInfoDto.toCameraItemList() = channels?.map {
    CameraItem(
        id = it?.id ?: "",
        name = it?.name ?: "",
        image = null //String.format(ONE_FRAME_URL_FORMAT, it?.id ?: "")
    )
} ?: emptyList()
