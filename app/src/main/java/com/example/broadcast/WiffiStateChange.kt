package com.example.broadcast

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat

class WiffiStateChange : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action.equals(WifiManager.WIFI_STATE_CHANGED_ACTION)){
            Log.e("MyFirstButton", "mudou, Action: ${intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE, -1)}")
        } else {
            Log.e("MyFirstButton", "Erro no Boot receiver, Action: ${intent?.action}")
        }
    }

    private fun callNotification(context: Context, state: Boolean){
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intent = Intent(context, SecondScreem::class.java).apply{
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        intent.putExtra("state", state)

        val pendingIntent = PendingIntent.getActivity(context, 1234, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(context, "MY")
        //builder.setSmallIcon()
        builder.setContentTitle("ss")
        builder.setContentText("ssa")
        builder.priority = NotificationCompat.PRIORITY_HIGH
        builder.setAutoCancel(true)
        builder.setContentIntent(pendingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel("MY",
                "My", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }
        val notification = builder.build()
        notificationManager.notify(1234, notification)
    }
}