package com.codeturtle.vibechat.chat.dashboard.domain

import com.codeturtle.vibechat.chat.dashboard.data.DashboardChat
import kotlinx.coroutines.flow.Flow

class GetDashboardChatsUseCase(
    private val repository: DashboardRepository
) {
    operator fun invoke(): Flow<List<DashboardChat>> {
        return repository.observeChats()
    }
}