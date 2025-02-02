package ru.kryu.camera.navigation

import android.net.Uri

interface Destinations {
    val route: String
}

object Main : Destinations {
    override val route = "mainScreen"
}

object Detail : Destinations {
    override val route = "detail/{$DETAIL_ARG_TITLE_KEY}/{$DETAIL_ARG_ID_KEY}"
    fun detailRoute(title: String, id: String) = "detail/${Uri.encode(title)}/${Uri.encode(id)}"
}
