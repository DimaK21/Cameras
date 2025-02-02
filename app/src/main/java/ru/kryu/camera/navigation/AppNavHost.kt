package ru.kryu.camera.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.kryu.camera.presentation.details.DetailScreen
import ru.kryu.camera.presentation.mainscreen.MainScreen

const val DETAIL_ARG_TITLE_KEY = "title"
const val DETAIL_ARG_ID_KEY = "id"

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Main.route) {
            MainScreen(
                onItemClick = { title, id ->
                    navController.navigate(Detail.detailRoute(title, id))
                }
            )
        }
        composable(
            route = Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARG_TITLE_KEY) { type = NavType.StringType },
                navArgument(DETAIL_ARG_ID_KEY) { type = NavType.StringType },
            ),
        ) { backStackEntry ->
            val title =
                backStackEntry.arguments?.getString(DETAIL_ARG_TITLE_KEY)?.let { Uri.decode(it) }
                    ?: ""
            val id =
                backStackEntry.arguments?.getString(DETAIL_ARG_ID_KEY)?.let { Uri.decode(it) }
                    ?: ""
            DetailScreen(
                title = title,
                id = id
            )
        }
    }
}