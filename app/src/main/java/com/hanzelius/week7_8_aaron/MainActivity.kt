package com.hanzelius.week7_8_aaron

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

        val container = WeatherContainer()

        setContent {
            Week7_8_AaronTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val weatherViewModel: WeatherViewModel = viewModel(
                        factory = object : ViewModelProvider.Factory {
                            @Suppress("UNCHECKED_CAST")
                            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                return WeatherViewModel(container.weatherRepository) as T
                            }
                        }
                    )
                    MainView(viewModel = weatherViewModel)
                }
            }
        }
    }
}
