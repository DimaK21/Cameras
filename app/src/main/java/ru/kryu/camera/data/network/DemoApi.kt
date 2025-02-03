package ru.kryu.camera.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.kryu.camera.data.network.dto.ServerInfoDto

interface DemoApi {
    @GET("configex")
    suspend fun getServerInfo(
        @Query("login") login: String,
        @Query("responsetype") responseType: String,
    ): Response<ServerInfoDto>
}