package ru.kryu.camera.domain

interface ImageRepository {
    suspend fun fetchImage(channelId: String): ByteArray?
}