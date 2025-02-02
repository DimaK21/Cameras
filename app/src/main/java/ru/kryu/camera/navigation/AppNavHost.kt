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
                onItemClick = { title ->
                    navController.navigate(Detail.detailRoute(title))
                }
            )
        }
        composable(
            route = Detail.route,
            arguments = listOf(navArgument("text") { type = NavType.StringType }),
        ) { backStackEntry ->
            val text = backStackEntry.arguments?.getString("text")?.let { Uri.decode(it) } ?: ""
            DetailScreen(
                title = text
            )
        }
    }
}