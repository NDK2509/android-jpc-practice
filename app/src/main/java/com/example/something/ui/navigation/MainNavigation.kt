package com.example.something.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.something.R
import com.example.something.ui.layouts.*
import com.example.something.ui.screens.ExampleScreen
import com.example.something.ui.screens.WelcomeScreen

@Composable
fun MainNavigation() {
    val bottomBarItems = listOf(
        BottomBarItemProps(
            icon = painterResource(R.drawable.ic_notes), route = Routes.Notes.route
        ),
        BottomBarItemProps(
            icon = painterResource(R.drawable.ic_home), route = Routes.Home.route
        ),
        BottomBarItemProps(
            icon = painterResource(R.drawable.ic_arrow_back), route = "home"
        ),
    )
    val navController = rememberNavController()
    val topBar: @Composable () -> Unit = {
        STopBar(title = "Something", navController = navController) {
            BottomBarItem(
                BottomBarItemProps(
                    icon = painterResource(R.drawable.ic_arrow_back), route = "home"
                ),
                onClick = {
                    navController.popBackStack()
                },
                isActive = false,
            )
        }
    }
    val bottomBar: @Composable () -> Unit = {
        SBottomBar(navController, bottomBarItems)
    }

    MainLayout(
        topBar = topBar,
        bottomBar = bottomBar,
    ) {
        NavHost(
            navController = navController,
            startDestination = Routes.Welcome.route
        ) {
            composable(Routes.Welcome.route) {
                WelcomeScreen(navController)
            }
            composable(Routes.Home.route) {
                ExampleScreen(navController)
            }
            composable(Routes.Notes.route) {
                ExampleScreen(navController)
            }
        }
    }
}