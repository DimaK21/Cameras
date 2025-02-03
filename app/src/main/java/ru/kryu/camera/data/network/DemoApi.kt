package ru.kryu.camera.data.network

import retrofit2.Response
import retrofit2.http.GET
import ru.kryu.camera.data.network.dto.ServerInfoDto

interface DemoApi {
    @GET("configex?login=root&responsetype=json")
    suspend fun getServerInfo(): Response<ServerInfoDto>
}