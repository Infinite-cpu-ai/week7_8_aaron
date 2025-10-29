package com.hanzelius.week7_8_aaron.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hanzelius.week7_8_aaron.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun DetailCard(
    modifier: Modifier = Modifier,
    title: String, value: String, image: Int
) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray.copy(0.1f),
        )
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = title,
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .size(30.dp),
                colorFilter = ColorFilter.tint(Color.White)

            )
            Text(
                text = title,
                fontSize = 14.sp,
                color = Color.White.copy(0.7f),
                modifier = modifier.padding(bottom = 10.dp)
            )
            Text(
                text = value,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun DetailCardPreview() {
    DetailCard(Modifier, "HUMIDITY", "49%", R.drawable.icon_humidity)
}