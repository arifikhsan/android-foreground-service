package com.example.android.foregroundserviceexample

import android.app.Application
import android.app.NotificationManager
import android.app.NotificationChannel
import android.os.Build


/**
 * Created by Arif Ikhsanudin on Sunday, 02 December 2018.
 */

class App : Application() {


    companion object {
        const val CHANNEL_ID = "exampleServiceChannel"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Example Service Channel",
                NotificationManager.IMPORTANCE_LOW
            )

            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(serviceChannel)
        }
    }

}
