package com.example.something

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.something.ui.layouts.MainLayout
import com.example.something.ui.navigation.MainNavigation
import com.example.something.ui.theme.SomethingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SomethingTheme {
                MainLayout {
                    MainNavigation()
                }
            }
        }
    }
}
