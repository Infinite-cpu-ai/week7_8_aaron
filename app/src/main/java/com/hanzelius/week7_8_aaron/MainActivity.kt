package com.hanzelius.week7_8_aaron

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hanzelius.week7_8_aaron.data.container.WeatherContainer
import com.hanzelius.week7_8_aaron.ui.theme.Week7_8_AaronTheme
import com.hanzelius.week7_8_aaron.ui.view.MainView
import com.hanzelius.week7_8_aaron.ui.viewmodel.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week7_8_AaronTheme {
                MainView()
            }
        }
    }
}
