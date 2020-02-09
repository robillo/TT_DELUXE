package com.firstapp.robinpc.tongue_twisters_deluxe.utils.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import com.firstapp.robinpc.tongue_twisters_deluxe.TwisterApp
import com.firstapp.robinpc.tongue_twisters_deluxe.data.database.TwisterDatabase
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import com.firstapp.robinpc.tongue_twisters_deluxe.data.repository.TwisterRepository
import com.firstapp.robinpc.tongue_twisters_deluxe.di.component.service.DaggerRecurringNotificationServiceComponent
import com.firstapp.robinpc.tongue_twisters_deluxe.ui.splash.SplashActivity
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TWISTER_COUNT
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.background.AlarmSchedulerUtil
import java.util.*
import javax.inject.Inject

class RecurringNotificationService : LifecycleService() {

    @Inject
    lateinit var database: TwisterDatabase

    private lateinit var twisterRepo: TwisterRepository

    companion object {
        const val WAIT_DURATION_MILLIS = 6 * 60 * 60 * 1000
        private const val INTRO_STRING_SMALL = "Hey buddy. Here is a new twister for you - "
        private const val INTRO_STRING_BIG = "Hey buddy. Here is a new twister for you named "
        private const val OUTRO_STRING = "Open the app to read out loud."
        private const val ACTION_NAME_STRING = "OPEN IN APP"
        private const val LINE_BREAKER_STRING = "."
        private const val LINE_SPACER_STRING = " "
        private const val MIN_BOUND = 0
        private const val MAX_BOUND = TWISTER_COUNT
        private const val CHANNEL_ID = "tongue_twisters_default"
        private const val CHANNEL_NAME = "Tongue Twisters Deluxe"
        private const val CHANNEL_DESCRIPTION = "Pronunciation Improvement"
        const val NOTIFICATION_ID = 1234
        fun newIntent(context: Context): Intent {
            return Intent(context, RecurringNotificationService::class.java)
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        super.onBind(intent)
        return null
    }

    override fun onCreate() {
        setup()
        super.onCreate()
    }

    private fun setup() {
        setComponent()
        createNotificationChannel()
        configureNotification()
    }

    private fun configureNotification() {
        twisterRepo = TwisterRepository(database.twisterDao())

        getTwisterForIndex(generateRandomIndex()).observe(this, Observer {
            it?.let {
                buildNotification(it)
            }
            rescheduleAlarmForRecurringTrigger()
            stopSelf()
        })
    }

    private fun generateRandomIndex(): Int {
        return Random().nextInt(MAX_BOUND - MIN_BOUND + 1) + MIN_BOUND
    }

    private fun setComponent() {
        val component = DaggerRecurringNotificationServiceComponent.builder()
                .appComponent(TwisterApp.get(this).appComponent())
                .build()

        component.injectRecurringNotificationService(this)
    }

    private fun buildNotification(twister: Twister) {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(twister.name)
                .setContentIntent(getTwisterIntent(twister.id))
                .setContentText(INTRO_STRING_SMALL.plus(twister.twister))
                .setAutoCancel(true)
                .setStyle(
                        NotificationCompat
                                .BigTextStyle()
                                .bigText(
                                        INTRO_STRING_BIG
                                                .plus(twister.name)
                                                .plus(LINE_BREAKER_STRING)
                                                .plus(LINE_SPACER_STRING)
                                                .plus(OUTRO_STRING)
                                )
                )
                .addAction(R.drawable.ic_next_filled, ACTION_NAME_STRING, getTwisterIntent(twister.id))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        sendNotification(builder)
    }

    private fun getTwisterIntent(twisterIndex: Int): PendingIntent {
        val splashIntent = SplashActivity.newIntent(this, twisterIndex)
        val taskStackBuilder = TaskStackBuilder.create(this)
        taskStackBuilder.addNextIntent(splashIntent)
        return taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
    }

    private fun sendNotification(builder: NotificationCompat.Builder) {
        with(NotificationManagerCompat.from(this)) {
            notify(NOTIFICATION_ID, builder.build())
        }
    }

    private fun rescheduleAlarmForRecurringTrigger() {
        AlarmSchedulerUtil.setAlarm(this, System.currentTimeMillis() + WAIT_DURATION_MILLIS)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            getNotificationChannel()?.let {
                getNotificationManager(this).createNotificationChannel(it)
            }
        }
    }

    private fun getNotificationChannel(): NotificationChannel? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = CHANNEL_DESCRIPTION
            }
        }
        return null
    }

    private fun getNotificationManager(context: Context): NotificationManager {
        return context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    private fun getTwisterForIndex(index: Int): LiveData<Twister> {
        return twisterRepo.getTwisterForIndex(index)
    }
}
