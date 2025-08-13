package com.example.something.ui.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.something.ui.theme.DEFAULT_PADDING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(
    content: @Composable () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My App") }
            )
        }
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