package com.hanzelius.week7_8_aaron.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.hanzelius.week7_8_aaron.R

@Composable
fun MainView(modifier: Modifier = Modifier) {
    Column (
        modifier.fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.ic_launcher_background)
            )
    ){

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainViewPreview(){
    MainView()
}