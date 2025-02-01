package ru.kryu.camera

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.kryu.camera.presentation.details.DetailScreen
import ru.kryu.camera.presentation.details.DetailViewModel
import ru.kryu.camera.presentation.mainscreen.MainScreen
import ru.kryu.camera.presentation.mainscreen.MainViewModel
import ru.kryu.camera.presentation.ui.theme.CameraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            CameraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController, startDestination = "main") {
                        composable("main") {
                            val viewModel = remember { MainViewModel() }
                            val state by remember { derivedStateOf { viewModel.uiState } }
                            MainScreen(
                                state,
                                viewModel::processIntent,
                                navController,
                                Modifier.padding(innerPadding)
                            )
                        }
                        composable("detail/{title}") { backStackEntry ->
                            val title = backStackEntry.arguments?.getString("title") ?: ""
                            val detailViewModel = remember { DetailViewModel() }
                            DetailScreen(
                                title,
                                detailViewModel,
                                Modifier.padding(innerPadding)
                            )
                        }
                    }
                }
            }
        }
    }
}
