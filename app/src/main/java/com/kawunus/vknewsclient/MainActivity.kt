package com.kawunus.vknewsclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kawunus.vknewsclient.ui.MainScreen
import com.kawunus.vknewsclient.ui.theme.VkNewsClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkNewsClientTheme {
                MainScreen()
            }
        }
    }
}