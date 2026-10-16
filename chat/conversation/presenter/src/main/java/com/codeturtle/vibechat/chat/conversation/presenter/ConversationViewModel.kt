package com.codeturtle.vibechat.chat.conversation.presenter

import androidx.lifecycle.ViewModel
import com.codeturtle.vibechat.chat.conversation.data.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ConversationViewModel : ViewModel() {

    private val _messages = MutableStateFlow(
        listOf(
            Message(
                id = 1L,
                text = "Hey! Welcome to Vibe Chat 😊",
                timestamp = "10:30 AM",
                isSentByMe = false
            ),
            Message(
                id = 2L,
                text = "Hey! I love the new design.",
                timestamp = "10:31 AM",
                isSentByMe = true,
                isRead = true
            ),
            Message(
                id = 3L,
                text = "Thank you! The pastel blue looks great 💙",
                timestamp = "10:32 AM",
                isSentByMe = false
            ),
            Message(
                id = 4L,
                text = "Yes! It feels so clean and modern.",
                timestamp = "10:33 AM",
                isSentByMe = true,
                isRead = true
            ),
            Message(
                id = 5L,
                text = "Let's try the new chat screen!",
                timestamp = "10:34 AM",
                isSentByMe = false
            )
        )
    )

    val messages = _messages.asStateFlow()

    fun sendMessage(text: String) {
        val trimmedText = text.trim()

        if (trimmedText.isEmpty()) return

        val timestamp = SimpleDateFormat(
            "h:mm a",
            Locale.getDefault()
        ).format(Date())

        val newMessage = Message(
            id = System.nanoTime(),
            text = trimmedText,
            timestamp = timestamp,
            isSentByMe = true,
            isRead = false
        )

        _messages.value = _messages.value + newMessage
    }
}