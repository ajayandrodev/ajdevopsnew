package com.ajayrockstarindevops.firebaseData


import android.content.SharedPreferences
import android.content.Context
import android.app.Activity;

/**
 * Created by Ajay on 5/29/2018.
 */
class DataStorage {

  internal lateinit var savedSession: SharedPreferences
  private val KEY: String = ""

  fun saveFcmToken(context: Context, tokenId: String) {
    // TODO Auto-generated method stub
    val editor = context.getSharedPreferences(KEY, Activity.MODE_PRIVATE).edit()
    editor.putString("FCM_TOKEN_ID", tokenId)
    editor.commit()
  }
  fun getFcmToken(context: Context): String {
    savedSession = context.getSharedPreferences(KEY, Activity.MODE_PRIVATE)
    return savedSession.getString("FCM_TOKEN_ID", "")
  }
}
