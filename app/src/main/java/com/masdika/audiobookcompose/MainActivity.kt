package com.masdika.audiobookcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.masdika.audiobookcompose.ui.screens.home.HomeScreen
import com.masdika.audiobookcompose.ui.theme.AudioBookComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AudioBookComposeTheme {
                HomeScreen({})
            }
        }
    }
}