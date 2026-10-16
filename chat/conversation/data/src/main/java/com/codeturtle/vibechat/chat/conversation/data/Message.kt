package com.codeturtle.vibechat.chat.conversation.data

data class Message(
    val id: Long,
    val text: String,
    val timestamp: String,
    val isSentByMe: Boolean,
    val isRead: Boolean = false
)