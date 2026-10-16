package com.codeturtle.vibechat.chat.dashboard.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MockedDataSource {

    fun observeChats(): Flow<List<DashboardChat>> = flowOf(
        listOf(
            DashboardChat(
                id = "1",
                name = "Ayumi Kato",
                message = "Omg, this is so cute",
                time = "11:32",
                avatar = "👩🏻",
                unreadCount = 1
            ),
            DashboardChat(
                id = "2",
                name = "Mika Ishikawa",
                message = "I'll be there in 2 mins",
                time = "10:18",
                avatar = "👩🏻",
                unreadCount = 1
            ),
            DashboardChat(
                id = "3",
                name = "Haruka Yamamoto",
                message = "Yes sir",
                time = "09:14",
                avatar = "👩🏻",
                unreadCount = 1
            ),
            DashboardChat(
                id = "4",
                name = "Hikari Tanaka",
                message = "Photo 📷 📷",
                time = "01:23",
                avatar = "👩🏽"
            ),
            DashboardChat(
                id = "5",
                name = "Aiko Nakamura",
                message = "How are you?",
                time = "Mon, 22:17",
                avatar = "👩🏻"
            ),
            DashboardChat(
                id = "6",
                name = "Sakura Miyazaki",
                message = "I'll share it",
                time = "Sun",
                avatar = "👩🏻"
            ),
            DashboardChat(
                id = "7",
                name = "Emi Sato",
                message = "See you soon",
                time = "Sun",
                avatar = "👩🏽"
            )
        )
    )
}