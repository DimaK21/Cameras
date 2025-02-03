package ru.kryu.camera.domain

import kotlinx.coroutines.flow.Flow
import ru.kryu.camera.domain.model.CameraItem
import ru.kryu.camera.util.Resource

interface CamerasRepository {
    suspend fun getCameras(): Flow<Resource<List<CameraItem>>>
}