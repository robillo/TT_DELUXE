package com.firstapp.robinpc.tongue_twisters_deluxe.background

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.service.RecurringNotificationService

class AlarmTriggerReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let {
            it.startService(RecurringNotificationService.newIntent(it))
        }
    }
}