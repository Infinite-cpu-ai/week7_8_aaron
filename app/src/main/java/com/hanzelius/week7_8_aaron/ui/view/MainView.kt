package com.hanzelius.week7_8_aaron.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hanzelius.week7_8_aaron.R

@Composable
fun MainView(modifier: Modifier = Modifier) {
    Column (
        modifier.fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.weather___home_2),
                contentScale = ContentScale.Crop
            )
    ){
        Row (
            modifier = modifier.fillMaxWidth()
                .padding(
                    vertical = 25.dp,
                    horizontal = 30.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = modifier.fillMaxWidth(0.8f),
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White.copy(0.1f),
                    unfocusedContainerColor = Color.White.copy(0.1f),
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray,
                )
            )
            Button(
                onClick = {},
                modifier = modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    Color.White.copy(0.2f)
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    modifier = modifier.size(120.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainViewPreview(){
    MainView()
}