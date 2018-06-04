package com.ajayrockstarindevops.firebaseData

import android.util.Log;
import com.ajayrockstarindevops.ajdevops.R

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
/**
 * Created by Ajay on 5/29/2018.
 */
class FirebaseIDService : FirebaseInstanceIdService() {
  internal var dataStorage: DataStorage = DataStorage()


  override fun onTokenRefresh() {
    super.onTokenRefresh()
    // Get updated InstanceID token.
    val refreshedToken = FirebaseInstanceId.getInstance().token
    Log.d("FirebaseIDService", "Refreshed token: " + refreshedToken!!)
    dataStorage.saveFcmToken(applicationContext, refreshedToken)
    // If you want to send messages to this application instance or
    // manage this apps subscriptions on the server side, send the
    // Instance ID token to your app server.
    sendRegistrationToServer(refreshedToken)
  }
  private fun sendRegistrationToServer(refreshedToken: String?) {
    Log.v("Sending to server!!", "Sending==" + refreshedToken!!)
  }
}

