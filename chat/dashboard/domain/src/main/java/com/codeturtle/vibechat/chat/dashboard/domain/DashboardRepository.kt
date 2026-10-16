package com.codeturtle.vibechat.chat.dashboard.domain

import com.codeturtle.vibechat.chat.dashboard.data.DashboardChat
import kotlinx.coroutines.flow.Flow

interface DashboardRepository {
    fun observeChats(): Flow<List<DashboardChat>>
}