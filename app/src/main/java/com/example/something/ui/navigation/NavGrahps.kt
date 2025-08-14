package com.example.something.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.something.ui.layouts.MainLayout


@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.mainLayout(
    route: String,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    composable(route) {
        MainLayout(topBar = topBar, bottomBar = bottomBar) {
            content()
        }
    }
}
