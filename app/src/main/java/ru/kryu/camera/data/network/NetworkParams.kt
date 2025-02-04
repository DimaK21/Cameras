package ru.kryu.camera.data.network

object NetworkParams {
    const val BASE_URL = "http://demo.macroscop.com"
    const val LOGIN = "root"
    const val RESPONSE_TYPE = "json"
    const val ONE_FRAME_URL_FORMAT = "$BASE_URL/mobile?channelid=%s&oneframeonly=true&login=$LOGIN&withcontenttype=true"
    const val CODE_SUCCESS = 200
    const val ONE_FRAME_ONLY = true
    const val WITH_CONTENT_TYPE = true
}