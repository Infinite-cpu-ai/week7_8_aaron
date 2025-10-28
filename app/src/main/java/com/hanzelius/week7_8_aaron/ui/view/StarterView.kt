package com.hanzelius.week7_8_aaron.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StarterView() {
    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                modifier = Modifier.size(70.dp),
                tint = Color.White.copy(0.7f)
            )
        }
        item {
            Text(
                text = "Search for a city to get started!",
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                modifier = Modifier.padding(32.dp),
                color = Color.White.copy(0.7f)
            )
        }
    }
}

@Preview
@Composable
fun StarterViewPreview() {
    StarterView()
}

