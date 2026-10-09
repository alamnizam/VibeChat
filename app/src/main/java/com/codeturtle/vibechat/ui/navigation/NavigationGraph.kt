package com.codeturtle.vibechat.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Register
    ) {
        composable<Screen.Register> {
            //TODO
        }
        composable<Screen.Login> {
            //TODO
        }

    }
}