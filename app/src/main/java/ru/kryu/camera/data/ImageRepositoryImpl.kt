package ru.kryu.camera.data

import ru.kryu.camera.data.network.NetworkClient
import ru.kryu.camera.domain.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val networkClient: NetworkClient
) : ImageRepository {
    override suspend fun fetchImage(channelId: String): ByteArray? {
        return networkClient.fetchImage(channelId)
    }
}