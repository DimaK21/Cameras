package ru.kryu.camera.data.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Streaming
import ru.kryu.camera.data.network.dto.ServerInfoDto

interface DemoApi {
    @GET("configex")
    suspend fun getServerInfo(
        @Query("login") login: String,
        @Query("responsetype") responseType: String,
    ): Response<ServerInfoDto>

    @GET("mobile")
    @Streaming
    suspend fun getOneshot(
        @Query("channelid") channelId: String,
        @Query("oneframeonly") oneFrameOnly: Boolean,
        @Query("login") login: String,
        @Query("withcontenttype") withContentType: Boolean,
    ): ResponseBody
}