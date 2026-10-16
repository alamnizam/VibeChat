package com.codeturtle.vibechat.chat.dashboard.presenter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.codeturtle.vibechat.chat.dashboard.data.DashboardChat

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel,
    onChatClicked: (String) -> Unit = {},
    onNewChatClicked: () -> Unit = {},
    currentRoute: String? = "chats",
    onNavigationItemClick: (BottomNavItem) -> Unit = {}
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    val bottomNavItems = listOf(
        BottomNavItem(
            label = "Chats",
            icon = R.drawable.chats_active,
            route = "chats"
        ),
        BottomNavItem(
            label = "Contacts",
            icon = R.drawable.contacts,
            route = "contacts"
        ),
        BottomNavItem(
            label = "Settings",
            icon = R.drawable.settings,
            route = "settings"
        )
    )

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            BottomNavigationBar(
                items = bottomNavItems,
                currentRoute = currentRoute,
                onItemClick = onNavigationItemClick
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNewChatClicked,
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = Color.White,
                shape = CircleShape
            ) {
                Image(painter = painterResource(id = R.drawable.newchat), contentDescription = "New Chat")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(
                text = "Chats",
                modifier = Modifier.padding(
                    start = 24.dp,
                    top = 24.dp,
                    bottom = 16.dp
                ),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.background
            )

            when {
                state.isLoading -> {
                    Box(
                        Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                state.errorMessage != null -> {
                    Box(
                        Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(state.errorMessage.orEmpty())
                    }
                }

                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(
                            start = 20.dp,
                            end = 20.dp,
                            bottom = 16.dp
                        )
                    ) {
                        items(
                            items = state.chats,
                            key = { it.id }
                        ) { chat ->
                            DashboardChatRow(
                                chat = chat,
                                onClick = {
                                    onChatClicked(chat.id)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DashboardChatRow(
    chat: DashboardChat,
    onClick: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 112.dp)
                .clickable(onClick = onClick)
                .padding(vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(66.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFDAD2FF)),
                contentAlignment = Alignment.Center
            ) {
                Text(chat.avatar, fontSize = 30.sp)
            }

            Spacer(Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = chat.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 1
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = chat.message,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 1
                )
            }

            Spacer(Modifier.width(8.dp))

            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = chat.time,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )

                if (chat.unreadCount > 0) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(14.dp))
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(
                                horizontal = 10.dp,
                                vertical = 5.dp
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = chat.unreadCount.toString(),
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }

        HorizontalDivider(
            color = MaterialTheme.colorScheme.inverseSurface,
            thickness = 1.dp
        )
    }
}

@Composable
@Preview
fun ShowDashboardScreen() {
 /*   DashboardScreen(
        viewModel = DashboardViewModel(getDashboardChats = ),
        onChatClicked = {},
        onNewChatClicked = {},
        currentRoute = "chats",
        onNavigationItemClick = {}
    )*/
}