package ru.kryu.camera.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.kryu.camera.data.CamerasRepositoryImpl
import ru.kryu.camera.data.ImageRepositoryImpl
import ru.kryu.camera.data.network.DemoApi
import ru.kryu.camera.data.network.NetworkClient
import ru.kryu.camera.data.network.NetworkParams.BASE_URL
import ru.kryu.camera.data.network.RetrofitNetworkClient
import ru.kryu.camera.domain.CamerasRepository
import ru.kryu.camera.domain.ImageRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DiModule {

    @Provides
    @Singleton
    fun provideNetworkClient(
        demoApi: DemoApi,
    ): NetworkClient = RetrofitNetworkClient(
        demoApi = demoApi,
    )

    @Provides
    @Singleton
    fun provideDemoApi(): DemoApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DemoApi::class.java)

    @Provides
    @Singleton
    fun provideCamerasRepository(networkClient: NetworkClient): CamerasRepository =
        CamerasRepositoryImpl(networkClient)

    @Provides
    @Singleton
    fun provideImageRepository(networkClient: NetworkClient): ImageRepository =
        ImageRepositoryImpl(networkClient)
}