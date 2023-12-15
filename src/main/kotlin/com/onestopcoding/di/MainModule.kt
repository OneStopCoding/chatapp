package com.onestopcoding.di

import com.onestopcoding.data.MessageDataSource
import com.onestopcoding.data.MessageSourceImpl
import com.onestopcoding.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module{
    single{
        KMongo.createClient()
            .coroutine
            .getDatabase("message_db_yt")
    }

    single<MessageDataSource> {
        MessageSourceImpl(get())
    }

    single<RoomController>{
        RoomController(get())
    }
}