package com.onestopcoding.data

import com.onestopcoding.data.model.Message

interface MessageDataSource {
    suspend fun getAllMessages(): List<Message>

    suspend fun insertMessage(message: Message)
}