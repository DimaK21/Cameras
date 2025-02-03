package ru.kryu.camera.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.kryu.camera.data.converter.toCameraItemList
import ru.kryu.camera.data.network.NetworkClient
import ru.kryu.camera.data.network.NetworkParams.CODE_SUCCESS
import ru.kryu.camera.data.network.dto.ServerInfoDto
import ru.kryu.camera.domain.CamerasRepository
import ru.kryu.camera.domain.model.CameraItem
import ru.kryu.camera.util.Resource
import javax.inject.Inject

class CamerasRepositoryImpl @Inject constructor(
    private val networkClient: NetworkClient
) : CamerasRepository {
    override suspend fun getCameras(): Flow<Resource<List<CameraItem>>> = flow {
        val response = networkClient.getServerInfo()
        when {
            response is ServerInfoDto -> {
                emit(Resource.Success(response.toCameraItemList()))
            }

            response.resultCode == CODE_SUCCESS -> {
                emit(Resource.Success(emptyList()))
            }

            else -> {
                emit(Resource.Error(message = "${response.resultCode} ${response.text}"))
            }
        }
    }
}