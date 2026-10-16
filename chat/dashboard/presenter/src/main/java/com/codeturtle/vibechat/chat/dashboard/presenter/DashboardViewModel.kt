package com.codeturtle.vibechat.chat.dashboard.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeturtle.vibechat.chat.dashboard.domain.GetDashboardChatsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val getDashboardChats: GetDashboardChatsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DashboardState())
    val uiState = _uiState.asStateFlow()

    init {
        observeChats()
    }

    private fun observeChats() {
        viewModelScope.launch {
            getDashboardChats()
                .onStart {
                    _uiState.value = DashboardState(isLoading = true)
                }
                .catch { error ->
                    _uiState.value = DashboardState(
                        isLoading = false,
                        errorMessage = error.message
                            ?: "Unable to load chats"
                    )
                }
                .collect { chats ->
                    _uiState.value = DashboardState(
                        isLoading = false,
                        chats = chats
                    )
                }
        }
    }

    fun onChatClicked(chatId: String) {
        // Send a navigation event to the conversation feature.
    }

    fun onNewChatClicked() {
        // Send a navigation event to the new-chat feature.
    }
}