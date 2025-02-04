package ru.kryu.camera.data.network

interface NetworkClient {
    suspend fun getServerInfo(): Response
    suspend fun fetchImage(channelId: String): ByteArray?
}