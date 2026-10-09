package com.codeturtle.vibechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.codeturtle.theme.VibeChatTheme
import com.codeturtle.vibechat.ui.navigation.NavigationGraph
import com.codeturtle.vibechat.ui.splashScreen.SplashScreen
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VibeChatTheme {

                var showSplash by remember { mutableStateOf(true) }

                LaunchedEffect(Unit) {
                    delay(10000.milliseconds)
                    showSplash = false
                }
                if (showSplash) {
                    SplashScreen()
                } else {
                    NavigationGraph()
                }
            }
        }
    }
}