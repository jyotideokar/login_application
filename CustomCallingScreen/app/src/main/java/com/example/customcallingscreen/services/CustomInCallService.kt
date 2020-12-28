package com.example.customcallingscreen.services

import android.os.Build
import android.telecom.Call
import android.telecom.InCallService
import androidx.annotation.RequiresApi
import com.example.customcallingscreen.activity.OutgoingCallActivity
import com.example.customcallingscreen.utils.OngoingCall

@RequiresApi(Build.VERSION_CODES.M)
class CustomInCallService : InCallService() {
    override fun onCallAdded(call: Call) {
        super.onCallAdded(call)
        OngoingCall.call = call
        OutgoingCallActivity.start(this, call)
    }

    override fun onCallRemoved(call: Call?) {
        super.onCallRemoved(call)
        OngoingCall.call = null
    }
}
