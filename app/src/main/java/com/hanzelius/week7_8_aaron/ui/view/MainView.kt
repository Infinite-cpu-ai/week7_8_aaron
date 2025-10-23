package com.hanzelius.week7_8_aaron.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hanzelius.week7_8_aaron.R

@Composable
fun MainView(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.weather___home_2),
                contentScale = ContentScale.Crop
            )
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(110.dp)
                .padding(
                    vertical = 25.dp,
                    horizontal = 30.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = modifier
                    .width(230.dp)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(15.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        modifier = modifier.size(20.dp),
                        tint = Color.White
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White.copy(0.1f),
                    unfocusedContainerColor = Color.White.copy(0.1f),
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray,
                ),
                placeholder = {
                    Text(
                        text = "Enter city name....",
                        color = Color.White.copy(0.7f),
                        fontSize = 18.sp,
                        modifier = modifier.fillMaxSize()
                    )
                }
            )
            Row(
                modifier = modifier
                    .fillMaxSize()
                    .padding(vertical = 3.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White.copy(0.15f))
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(20.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    modifier = modifier.size(20.dp),
                    tint = Color.White
                )
                Text(
                    text = "Search",
                    modifier = modifier.padding(start = 5.dp),
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainViewPreview() {
    MainView()
}