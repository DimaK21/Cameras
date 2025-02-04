package ru.kryu.camera.data.network

import android.util.Log
import ru.kryu.camera.data.network.NetworkParams.LOGIN
import ru.kryu.camera.data.network.NetworkParams.ONE_FRAME_ONLY
import ru.kryu.camera.data.network.NetworkParams.RESPONSE_TYPE
import ru.kryu.camera.data.network.NetworkParams.WITH_CONTENT_TYPE
import javax.inject.Inject

class RetrofitNetworkClient @Inject constructor(
    private val demoApi: DemoApi
) : NetworkClient {

    override suspend fun getServerInfo(): Response {
        return try {
            val retrofitResponse = demoApi.getServerInfo(
                login = LOGIN,
                responseType = RESPONSE_TYPE,
            )
            if (retrofitResponse.isSuccessful) {
                retrofitResponse.body().let {
                    Log.e(this.javaClass.simpleName, it.toString())
                    it
                } ?: Response().apply {
                    resultCode = retrofitResponse.code()
                }
            } else {
                Log.e(this.javaClass.simpleName, retrofitResponse.errorBody().toString())
                Response().apply {
                    resultCode = retrofitResponse.code()
                    text = retrofitResponse.errorBody().toString()
                }
            }
        } catch (e: Exception) {
            Log.e(this.javaClass.simpleName, e.message.toString())
            Log.e(this.javaClass.simpleName, e.stackTraceToString())
            Response().apply {
                text = e.message
            }
        }
    }

    override suspend fun fetchImage(channelId: String): ByteArray? {
        return try {
            val response = demoApi.getOneshot(
                channelId = channelId,
                oneFrameOnly = ONE_FRAME_ONLY,
                login = LOGIN,
                withContentType = WITH_CONTENT_TYPE,
            )
            val body = response.byteStream()

            val boundary = "--myboundary".toByteArray()
            var imageBytes: ByteArray? = null
            val buffer = body.readBytes()

            val boundaryIndex = buffer.indexOf(boundary)
            if (boundaryIndex != -1) {
                val contentStart = buffer.indexOf("\r\n\r\n".toByteArray(), boundaryIndex) + 4
                if (contentStart != -1) {
                    imageBytes = buffer.copyOfRange(contentStart, buffer.size)
                }
            } else {
                imageBytes = buffer
            }
            imageBytes
        } catch (e: Exception) {
            Log.e(this.javaClass.simpleName, e.message.toString())
            Log.e(this.javaClass.simpleName, e.stackTraceToString())
            null
        }
    }
}

fun ByteArray.indexOf(subArray: ByteArray, startIndex: Int = 0): Int {
    outer@ for (i in startIndex..this.size - subArray.size) {
        for (j in subArray.indices) {
            if (this[i + j] != subArray[j]) continue@outer
        }
        return i
    }
    return -1
}
