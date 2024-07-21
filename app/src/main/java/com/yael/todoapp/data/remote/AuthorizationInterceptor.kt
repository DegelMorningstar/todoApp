package com.yael.todoapp.data.remote

import android.util.Log
import com.yael.todoapp.data.local.PreferencesManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor(
    private val preferencesManager: PreferencesManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()

        val jwt = preferencesManager.getData(PreferencesManager.keySession,"")
        val isPrivate = !jwt.isNullOrEmpty()

        if(isPrivate){
            Log.d("AuthorizationInterceptor","Ruta privada")
            requestBuilder.addHeader("User-Agent","com.todoapp.mx.v1")
            requestBuilder.addHeader("Authorization","Bearer $jwt")
        }

        return  chain.proceed(requestBuilder.build())

    }

}