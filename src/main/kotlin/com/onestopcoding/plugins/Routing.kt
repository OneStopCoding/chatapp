package com.onestopcoding.plugins

import com.onestopcoding.room.RoomController
import com.onestopcoding.routes.chatSocket
import com.onestopcoding.routes.getAllMessages
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing) {
        chatSocket(roomController)
        getAllMessages(roomController)
    }
}
