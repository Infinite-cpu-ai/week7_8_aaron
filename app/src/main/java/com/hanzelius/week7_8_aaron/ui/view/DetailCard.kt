package com.hanzelius.week7_8_aaron.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hanzelius.week7_8_aaron.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailCard(
    modifier: Modifier = Modifier
) {
    Card (
        modifier = modifier
            .width(160.dp)
            .height(180.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray.copy(0.25f)
        )
    ){
        Column (
            modifier = modifier
                .fillMaxSize()
                .padding(vertical = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.icon_humidity),
                contentDescription = "Icon",
                modifier = modifier.size(45.dp)
            )
            Text(
                text = "Humidity",
                modifier = modifier.padding(top = 10.dp),
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun DetailCardPreview() {
    DetailCard()
}