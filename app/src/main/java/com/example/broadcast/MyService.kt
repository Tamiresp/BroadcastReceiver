package com.example.broadcast

import android.app.IntentService
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class MyService : IntentService("MyService") {
    override fun onHandleIntent(intent: Intent?) {

        stopSelf()
    }

    private fun callAirPlaneNotification(context: Context, state: Boolean) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(context, SecondScreem::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        intent.putExtra("state", state)

        val pedingIntent = PendingIntent.getActivity(context, 1234,
            intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(context, "MYAPP")
        builder.setSmallIcon(R.drawable.ic_launcher_foreground)
        builder.setContentTitle("My app notification")
        builder.setContentText("O estado do airplane mode é: $state")
        builder.priority = NotificationCompat.PRIORITY_HIGH
        builder.setAutoCancel(true)
        builder.setContentIntent(pedingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel("MYAPP",
                "My Application", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val notification = builder.build()
        notificationManager.notify(1234, notification)

    }
}