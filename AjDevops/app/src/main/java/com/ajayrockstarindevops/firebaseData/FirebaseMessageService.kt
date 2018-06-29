package com.ajayrockstarindevops.firebaseData

import android.util.Log;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.app.Notification;
import com.ajayrockstarindevops.ajdevops.R

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import android.app.PendingIntent


/**
 * Created by Ajay on 5/29/2018.
 */
class FirebaseMessageService : FirebaseMessagingService() {
    private val TAG = "FirebaseMessageService"


    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)
        // Check whether the remoteMessage contains a notification payload.
        if (remoteMessage!!.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification()?.getBody()!!)
            sendNotification(remoteMessage.getNotification()?.getBody())
        }
        //Check whether the remoteMessage contains a data payload.
        if (remoteMessage.getData().size > 0) {
            Log.e(TAG, "Data Payload: " + remoteMessage.getData().toString())
            try {
                val map = remoteMessage.getData()
                handleDataMessage(map)
            } catch (e: Exception) {
                Log.e(TAG, "Exception: " + e.message)
            }
        }
    }

    private fun handleDataMessage(map: Map<String, String>) {
        Log.e(TAG, "push json: " + map.toString())
        try {
            val type = map["type"]
            val id = map["id"]
            val message = map["message"]
            val title = map["title"]
            Log.e(TAG, "type: " + type)
            Log.e(TAG, "message: " + message)
            Log.e(TAG, "id: " + id)
            /** Do the things you would like to do with the data, here **/
        } catch (e: Exception) {
            Log.e(TAG, "Exception: " + e.message)
        }
    }

    private fun sendNotification(messageBody: String?) {
        val channelId: String = getString(R.string.app_name);
        val notificationBuilder: NotificationCompat.Builder =
                NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.drawable.devops)
                        .setContentTitle(getString(R.string.app_name))
                        .setStyle(NotificationCompat.BigTextStyle().bigText(messageBody))
                        .setContentText(messageBody)
                        .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.devops))
                        .setAutoCancel(true)

        val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager;
        notificationManager.notify(2, notificationBuilder.build());

    }
}

