package com.example.something.ui.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.something.ui.theme.DEFAULT_PADDING

@Composable
fun MainLayout(
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = topBar,
        bottomBar = bottomBar,
        contentWindowInsets = WindowInsets.safeDrawing,
    ) { paddingValues ->
        Surface(
            modifier = Modifier.padding(paddingValues),
            color = MaterialTheme.colorScheme.background
        ) {
            val bottomPadding = paddingValues.calculateBottomPadding()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = DEFAULT_PADDING,
                        top = DEFAULT_PADDING,
                        end = DEFAULT_PADDING,
                        bottom = bottomPadding
                    ),
            ) {
                content()
            }
        }
    }
}