package com.codeturtle.vibechat.ui.splashScreen

import androidx.compose.foundation.Image
import com.codeturtle.vibechat.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(
                id = R.mipmap.logo
            ),
            contentDescription = "Vibe Chat logo",
            modifier = Modifier.size(
                width = 280.dp,
                height = 120.dp
            ),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
@Preview
fun ShowSplashScreen(){
    SplashScreen()
}