package com.codeturtle.vibechat.ui.navigation

import kotlinx.serialization.Serializable


@Serializable
sealed class Screen() {
    @Serializable
    object Register : Screen()
    @Serializable
    object Login : Screen()
}