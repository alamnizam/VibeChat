package com.codeturtle.vibechat.chat.conversation.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ConversationScreen(
    contactName: String = "Alex Morgan",
    onBackClick: () -> Unit = {},
    viewModel: ConversationViewModel
) {
    val messages by viewModel.messages.collectAsStateWithLifecycle()

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    // Scroll to the latest message whenever the list changes.
    LaunchedEffect(messages.size) {
        if (messages.isNotEmpty()) {
            listState.animateScrollToItem(messages.lastIndex)
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            ConversationTopBar(
                contactName = contactName,
                onBackClick = onBackClick
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.12f))
            )

            LazyColumn(
                state = listState,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp),
                contentPadding = PaddingValues(
                    top = 16.dp,
                    bottom = 16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = messages,
                    key = { message -> message.id }
                ) { message ->
                    MessageBubble(message = message)
                }
            }

            MessageInput(
                onSendMessage = { text ->
                    viewModel.sendMessage(text)

                    // The new message triggers LaunchedEffect above.
                }
            )
        }
    }
}

@Composable
@Preview
fun ShowConversationScreen() {
    val viewModel = ConversationViewModel()

    ConversationScreen(
        contactName = "Alex Morgan",
        onBackClick = {},
        viewModel = viewModel
    )
}