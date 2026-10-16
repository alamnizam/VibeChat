package com.codeturtle.vibechat.chat.dashboard.presenter

import com.codeturtle.vibechat.chat.dashboard.data.DashboardChat

data class DashboardState(
    val isLoading: Boolean = true,
    val chats: List<DashboardChat> = emptyList(),
    val errorMessage: String? = null
)