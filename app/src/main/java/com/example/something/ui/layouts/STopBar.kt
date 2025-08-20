package com.example.something.ui.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.something.R

@Composable
fun STopBar(
    title: String? = null,
    navController: NavController? = null,
    titleStyle: TextStyle? = null,
    leftItem: @Composable () -> Unit = {
        IconButton(
            onClick = {
                navController?.popBackStack()
            }
        ) {
            Icon(
                painterResource(R.drawable.ic_arrow_back),
                "Back",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
        }
    },
    rightItem: @Composable () -> Unit = {
        Box {}
    },
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Top))
    ) {
        // Left item
        Box(
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            leftItem()
        }
        Box(
            modifier = Modifier.align(Alignment.Center)
        ) {
            title?.let { Text(text = it, style = titleStyle ?: TextStyle.Default) }
        }
        Box(
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            rightItem()
        }
    }
}

@Preview
@Composable
fun PreviewSTopBar() {
    STopBar(title = "Example", navController = null)
}