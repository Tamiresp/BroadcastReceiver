package com.example.broadcast

import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mSimStateChanged = WiffiStateChange()
    private val mAirPlaneModeChanged = AirPlaneModeChanged()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = button
        btn.setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            }

        }
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter()
        val filter2 = IntentFilter()
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
        // filter.addAction("android.telephony.action.SIM_CARD_STATE_CHANGED")
        filter2.addAction( Intent.ACTION_AIRPLANE_MODE_CHANGED)
        //registerReceiver(mSimStateChanged, filter)
        registerReceiver(mAirPlaneModeChanged, filter2)
    }

    override fun onPause() {
        super.onPause()
        //unregisterReceiver(mAirPlaneModeChanged)
        unregisterReceiver(mSimStateChanged)
    }
}
