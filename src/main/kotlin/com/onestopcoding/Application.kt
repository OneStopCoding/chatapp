package com.onestopcoding

import com.onestopcoding.di.mainModule
import com.onestopcoding.plugins.*
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    install(Koin){
        modules(mainModule)
    }
    configureSecurity()
    configureMonitoring()
    configureSockets()
    configureSerialization()
    configureRouting()
}
