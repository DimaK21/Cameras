package ru.kryu.camera.data.network

object NetworkParams {
    const val BASE_URL = "http://demo.macroscop.com"
    const val LOGIN = "root"
    const val ONE_FRAME_URL_FORMAT = "$BASE_URL/mobile?channelid=%s&oneframeonly=true&login=$LOGIN&withcontenttype=true"
}