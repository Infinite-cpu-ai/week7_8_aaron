package com.hanzelius.week7_8_aaron.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ErrorView(
    errorMessage: String,
    modifier: Modifier = Modifier,
) {
    LazyColumn (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = "Error Icon",
                modifier = Modifier
                    .size(64.dp)
                    .padding(bottom = 10.dp),
                tint = Color.Red
            )
        }
        item {
            Text(
                text = "Oops something went wrong",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
        }
        item {
            Text(
                text = errorMessage,
                color = Color.LightGray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = modifier.padding(top = 10.dp)
            )
        }
    }
}


@Preview
@Composable
fun ErrorViewPreview() {
    ErrorView("HTTP 404 Not Found")
}