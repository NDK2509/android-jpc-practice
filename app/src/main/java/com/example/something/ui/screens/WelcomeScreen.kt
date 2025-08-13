package com.example.something.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.something.R
import com.example.something.ui.components.core.SButton
import com.example.something.ui.viewmodels.WelcomeViewModel
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(
    navigatorController: NavController,
    viewModel: WelcomeViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.onFocus()
    }

    // Animation states
    var showLogo by remember { mutableStateOf(false) }
    var showGreeting by remember { mutableStateOf(false) }
    var showButton by remember { mutableStateOf(false) }

    // Run animation sequence
    LaunchedEffect(Unit) {
        delay(300) // Small delay before starting
        showLogo = true
        delay(500)
        showGreeting = true
        delay(400)
        showButton = true
    }

    // Scale animation for logo
    val logoScale by animateFloatAsState(
        targetValue = if (showLogo) 1f else 0.6f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        AnimatedVisibility(
            visible = showLogo,
            enter = fadeIn(animationSpec = tween(800))
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(120.dp)
                    .scale(logoScale)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Greeting
        AnimatedVisibility(
            visible = showGreeting,
            enter = slideInVertically(
                initialOffsetY = { 50 },
                animationSpec = tween(1000)
            ) + fadeIn(animationSpec = tween(1000))
        ) {
            Text(
                text = "Welcome to Something App!",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Button
        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn(animationSpec = tween(500))
        ) {
            SButton(
                text = "Get started!",
                onClick = {}
            )
        }
    }
}
