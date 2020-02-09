package com.firstapp.robinpc.tongue_twisters_deluxe.utils.background

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.firstapp.robinpc.tongue_twisters_deluxe.background.AlarmTriggerReceiver

object AlarmSchedulerUtil {

    private const val ALARM_REQUEST_CODE = 934

    fun setAlarm(context: Context, alarmTime: Long) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val broadcastIntent = Intent(context, AlarmTriggerReceiver::class.java)

        val pendingIntent = PendingIntent.getBroadcast(
                context,
                ALARM_REQUEST_CODE,
                broadcastIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )

        alarmManager.cancel(pendingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    alarmTime,
                    pendingIntent
            )
        }

        else {
            alarmManager.setExact(
                    AlarmManager.RTC_WAKEUP,
                    alarmTime,
                    pendingIntent
            )
        }
    }
}