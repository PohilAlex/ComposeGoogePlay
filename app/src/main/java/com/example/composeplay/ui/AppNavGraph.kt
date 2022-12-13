package com.example.composeplay.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeplay.model.AppDetailsViewModel
import com.example.composeplay.ui.Destinations.APP_DETAILS
import com.example.composeplay.ui.Destinations.APP_FULL_INFO
import com.example.composeplay.ui.Destinations.IMAGES
import com.example.composeplay.ui.Destinations.IMAGE_POSITION_PARAM

object Destinations {
    const val APP_FULL_INFO = "APP_FULL_INFO"
    const val APP_DETAILS = "APP_DETAILS"
    const val IMAGES = "IMAGES"

    const val IMAGE_POSITION_PARAM = "IMAGE_POSITION_PARAM"
}

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(), viewModel: AppDetailsViewModel
) {
    NavHost(navController = navController, startDestination = APP_FULL_INFO) {
        composable(APP_FULL_INFO) {
            ApplicationFullInfoScreen(viewModel = viewModel,
                openAboutScreen = { navController.navigate(APP_DETAILS) },
                openImages = { page ->  navController.navigate("IMAGES/$page") })
        }
        composable(APP_DETAILS) {
            AboutAppScreen(viewModel = viewModel, navigateBack = { navController.popBackStack() })
        }
        composable(
            route = "$IMAGES/{$IMAGE_POSITION_PARAM}",
            arguments = listOf(navArgument(IMAGE_POSITION_PARAM) { type = NavType.IntType })
        ) {
            ScreenshotScreen(
                viewModel = viewModel,
                screenShotPosition = it.arguments?.getInt(IMAGE_POSITION_PARAM) ?: 0,
                navigateBack = { navController.popBackStack() })
        }
    }
}