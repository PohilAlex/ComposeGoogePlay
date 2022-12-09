package com.example.composeplay.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplay.model.AppDetailsViewModel
import com.example.composeplay.ui.Destinations.APP_DETAILS
import com.example.composeplay.ui.Destinations.APP_FULL_INFO

object Destinations {
    const val APP_FULL_INFO = "APP_FULL_INFO"
    const val APP_DETAILS = "APP_DETAILS"
}

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    viewModel: AppDetailsViewModel
) {
    NavHost(navController = navController, startDestination = APP_FULL_INFO) {
        composable(APP_FULL_INFO) { ApplicationFullInfoScreen(viewModel, openAboutScreen = {
            navController.navigate(APP_DETAILS)
        }) }
        composable(APP_DETAILS) { AboutAppScreen(viewModel, navigateBack = { navController.popBackStack() } ) }
    }
}