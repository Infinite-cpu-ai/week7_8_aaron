package com.hanzelius.week7_8_aaron.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hanzelius.week7_8_aaron.R

@Composable
fun SunCard(
    modifier: Modifier = Modifier,
    sunCondition: String,
    time: String,
    image: Int
) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp),
        colors  = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = sunCondition,
                modifier = Modifier
                    .size(30.dp)
            )
            Text(
                text = sunCondition,
                fontSize = 16.sp,
                color = Color.White.copy(0.7f),
                modifier = modifier.padding(vertical = 2.dp)
            )
            Text(
                text = time,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun SunCardPreview(){
    SunCard(Modifier, "SUNRISE", "5:22 AM", R.drawable.vector)
}