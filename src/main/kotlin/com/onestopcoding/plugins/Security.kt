package com.onestopcoding.plugins

import com.onestopcoding.sessions.ChatSession
import io.ktor.server.application.*
import io.ktor.server.application.ApplicationCallPipeline.ApplicationPhase.Plugins
import io.ktor.server.sessions.*
import io.ktor.util.*
import kotlin.collections.set

fun Application.configureSecurity() {
    install(Sessions) {
        cookie<ChatSession>("SESSION") {
            cookie.extensions["SameSite"] = "lax"
        }
        this@configureSecurity.intercept(Plugins){
            if (call.sessions.get<ChatSession>() == null){
                val username = call.parameters["username"] ?: "Guest"
                call.sessions.set(ChatSession(username, generateNonce()))
            }
        }
    }
}
