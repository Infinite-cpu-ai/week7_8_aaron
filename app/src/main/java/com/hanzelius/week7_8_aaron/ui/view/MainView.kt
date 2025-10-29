package com.hanzelius.week7_8_aaron.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.grid.items
import coil.compose.AsyncImage
import com.hanzelius.week7_8_aaron.R
import com.hanzelius.week7_8_aaron.ui.viewmodel.WeatherViewModel

@Composable
fun MainView(
    modifier: Modifier = Modifier,
    viewModel: WeatherViewModel
) {
    val weather by viewModel.weather.collectAsState()
    val iconUrl by viewModel.weatherIconUrl.collectAsState()
    val query by viewModel.query.collectAsState()
    val currentDate by viewModel.currentDate.collectAsState()
    val updateTime by viewModel.updateTime.collectAsState()
    val sunriseSunset by viewModel.setrise.collectAsState()
    val detailItems = viewModel.getWeatherTriples(weather)

    Column(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.weather___home_2),
                contentScale = ContentScale.Crop
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(100.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = query,
                onValueChange = { viewModel.onQueryChange(it) },
                placeholder = {
                    Text(
                        text = "Enter city name...",
                        color = Color.LightGray
                    )
                },
                shape = RoundedCornerShape(15.dp),
                modifier = modifier.weight(0.7f),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.LightGray
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White.copy(0.2f),
                    unfocusedBorderColor = Color.White.copy(0.2f),
                    focusedContainerColor = Color.White.copy(0.05f),
                    unfocusedContainerColor = Color.White.copy(0.05f),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )
            Spacer(modifier = modifier.width(8.dp))
            Button(
                onClick = { viewModel.search() },
                modifier = modifier.height(50.dp),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 1.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White.copy(0.15f)
                ),
                shape = RoundedCornerShape(18.dp),
                border = BorderStroke(1.dp, Color.LightGray.copy(0.5f))
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Button Icon",
                    tint = Color.White
                )
                Text(
                    text = "Search",
                    color = Color.White,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
        }

        Spacer(modifier = modifier.height(16.dp))

        when {
            weather.isError -> {
                ErrorView(
                    errorMessage = weather.errorMessage ?: "Unknown error",
                    modifier = modifier.fillMaxSize()
                )
            }

            iconUrl.isEmpty() -> {
                StarterView()
            }

            else -> {
                LazyColumn(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier.padding(top = 8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = "Location",
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier.width(4.dp))
                            Text(
                                text = weather.cityName ?: "Unknown",
                                color = Color.White,
                                fontSize = 16.sp
                            )
                        }

                        Text(
                            text = currentDate,
                            color = Color.White,
                            fontSize = 38.sp,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                        )

                        Text(
                            text = "Updated as of $updateTime",
                            color = Color.White.copy(0.8f),
                            fontSize = 14.sp,
                            modifier = modifier.padding(top = 2.dp, bottom = 16.dp)
                        )
                        Spacer(modifier = modifier.height(50.dp))
                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column (
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                AsyncImage(
                                    model = iconUrl,
                                    contentDescription = "Weather Icon",
                                    modifier = Modifier.size(100.dp)
                                )
                                Text(
                                    text = weather.condition ?: "Clouds",
                                    color = Color.White,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "${weather.temperature.toInt()}°C",
                                    color = Color.White,
                                    fontSize = 60.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Image(
                                painter = painterResource(
                                    id = when (weather.condition?.lowercase()) {
                                        "clear" -> R.drawable.blue_and_black_bold_typography_quote_poster_3
                                        "rain" -> R.drawable.blue_and_black_bold_typography_quote_poster_2
                                        else -> R.drawable.blue_and_black_bold_typography_quote_poster
                                    }
                                ),
                                contentDescription = "Weather Icon",
                                modifier = modifier.size(240.dp)
                            )
                        }

                        Spacer(modifier.height(40.dp))
                    }

                    item {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(3),
                            modifier = modifier
                                .fillMaxWidth()
                                .height(265.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(detailItems) { (img, title, value) ->
                                DetailCard(
                                    title = title,
                                    value = value,
                                    image = img
                                )
                            }
                        }
                    }

                    item {
                        Spacer(modifier.height(8.dp))
                        Row(
                            modifier = modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            sunriseSunset.forEach { (img, label, time) ->
                                SunCard(
                                    sunCondition = label,
                                    time = time,
                                    image = img
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
