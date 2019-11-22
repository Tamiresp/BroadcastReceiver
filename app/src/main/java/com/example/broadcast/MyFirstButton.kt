package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyFirstButton : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action.equals(Intent.ACTION_BOOT_COMPLETED)){

        } else {
            Log.e("MyFirstButton", "Erro no Boot receiver, Action: ${intent?.action}")
        }
    }
}