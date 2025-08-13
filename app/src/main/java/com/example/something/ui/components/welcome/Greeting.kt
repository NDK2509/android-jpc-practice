package com.example.something.ui.components.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.something.ui.theme.SomethingTheme


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            title = {
                Text(text = "Title")
            },
            text = {
                Text("This is a simple dialog in Jetpack Compose.")
            },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            fontSize = 24.sp
        )
        Text(
            text = "Welcome to Something!",
            modifier = modifier,
            fontSize = 12.sp
        )

        Button(
            onClick = {
                showDialog = true
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Click me!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SomethingTheme {
        Greeting("Android")
    }
}