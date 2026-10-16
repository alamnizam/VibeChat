package com.codeturtle.vibechat.chat.dashboard.data

data class DashboardChat(
    val id: String,
    val name: String,
    val message: String,
    val time: String,
    val avatar: String,
    val unreadCount: Int = 0
)