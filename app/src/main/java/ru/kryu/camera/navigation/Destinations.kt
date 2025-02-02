package ru.kryu.camera.navigation

import android.net.Uri

interface Destinations {
    val route: String
}

object Main : Destinations {
    override val route = "mainScreen"
}

object Detail : Destinations {
    override val route = "detail/{text}"
    fun detailRoute(text: String) = "detail/${Uri.encode(text)}"
}
