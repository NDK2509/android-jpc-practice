package com.example.something.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.something.ui.layouts.STopBar
import com.example.something.ui.screens.HomeScreen
import com.example.something.ui.screens.WelcomeScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Welcome.route
    ) {
        composable(Routes.Welcome.route) {
            WelcomeScreen(navController)
        }
        mainLayout(
            route = Routes.Home.route,
            topBar = {
                STopBar(title = "Home", navController = navController)
            }
        ) {
            HomeScreen(navController)
        }
    }
}