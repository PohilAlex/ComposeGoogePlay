package com.example.composeplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.composeplay.model.AppDetailsViewModel
import com.example.composeplay.ui.AppNavGraph
import com.example.composeplay.ui.theme.ComposePlayTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: AppDetailsViewModel by viewModels()
        setContent {
            ComposePlayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavGraph(viewModel = viewModel)
                }
            }
        }
    }
}
