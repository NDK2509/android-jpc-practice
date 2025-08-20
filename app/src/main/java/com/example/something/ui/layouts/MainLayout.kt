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
        val bottomPadding = paddingValues.calculateBottomPadding()
        Surface(
            modifier = Modifier
                .padding(
                    start = DEFAULT_PADDING,
                    end = DEFAULT_PADDING,
                    bottom = bottomPadding
                )
                .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Top)),
            color = MaterialTheme.colorScheme.background
        ) {
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