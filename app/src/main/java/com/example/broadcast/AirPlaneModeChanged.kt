package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AirPlaneModeChanged : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            Log.e("MyFirstButton", "mudou airplane, Action: ${intent?.getBooleanExtra(Intent.ACTION_AIRPLANE_MODE_CHANGED, true)}")
        } else {
            Log.e("MyFirstButton", "Erro no Boot receiver, Action: ${intent?.action}")
        }
    }
}