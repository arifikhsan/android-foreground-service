package com.example.android.foregroundserviceexample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.support.v4.app.NotificationCompat
import android.app.PendingIntent
import com.example.android.foregroundserviceexample.App.Companion.CHANNEL_ID


/**
 * Created by Arif Ikhsanudin on Sunday, 02 December 2018.
 */

class ExampleService : Service() {

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val input = intent.getStringExtra("inputExtra")

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0, notificationIntent, 0
        )

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Example Service")
            .setContentText(input)
            .setSmallIcon(R.drawable.ic_android)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

        //do heavy work on a background thread
        //stopSelf();

        return Service.START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}
