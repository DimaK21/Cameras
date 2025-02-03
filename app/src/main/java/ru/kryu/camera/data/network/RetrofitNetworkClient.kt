package ru.kryu.camera.data.network

import android.util.Log
import ru.kryu.camera.data.network.NetworkParams.CODE_NO_CONTENT
import ru.kryu.camera.data.network.NetworkParams.LOGIN
import ru.kryu.camera.data.network.NetworkParams.RESPONSE_TYPE
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
}