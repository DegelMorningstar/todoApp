package com.yael.todoapp.data.local

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferencesManager @Inject constructor(@ApplicationContext context: Context) {

  companion object {
    private const val sharedPreferencesName:String = "TodoAppSharedPreferences"
    const val keyFirstTime = "FirstTimeApp"
    const val keySession = "JwtValue"
  }

  private val sharedPreferences:SharedPreferences = context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)

  fun saveData(key:String,value:String){
    val editor = sharedPreferences.edit()
    editor.putString(key,value)
    editor.apply()
  }
  fun getData(key: String,default:String):String?{
    return sharedPreferences.getString(key,default)
  }

  fun saveData(key:String,value:Boolean){
    val editor = sharedPreferences.edit()
    editor.putBoolean(key,value)
    editor.apply()
  }
  fun getData(key: String,default:Boolean):Boolean{
    return sharedPreferences.getBoolean(key,default)
  }


}