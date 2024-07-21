package com.yael.todoapp.data.repository

import android.util.Log
import com.google.gson.Gson
import com.yael.todoapp.data.local.PreferencesManager
import com.yael.todoapp.data.remote.TodoApi
import com.yael.todoapp.data.remote.request.LoginRequest
import com.yael.todoapp.data.remote.response.user.LoginResponse
import com.yael.todoapp.domain.listeners.LoginListener
import com.yael.todoapp.domain.listeners.SessionListener
import com.yael.todoapp.domain.repositories.UserRepository
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
  private val api: TodoApi,
  private val gson: Gson,
  private val preferencesManager: PreferencesManager
) : UserRepository {

  private val tag = UserRepositoryImpl::class.java.simpleName

  override fun login(email:String,password:String,listener: LoginListener){
    val loginRequest = LoginRequest(email = email, password = password)
    val response = api.login(loginRequest = loginRequest)
    response.enqueue(object : Callback<ResponseBody>{
      override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
        if(response.isSuccessful){
          val body = response.body()?.string()
          if(!body.isNullOrEmpty()){
            val loginResponse = gson.fromJson(body, LoginResponse::class.java)
            listener.onLoginSuccess(token = loginResponse.resultado?.jwt)
          }else{
            Log.d(tag,"No pos no hay un body")
            listener.onLoginError()
          }

        }else{
          Log.d(tag,"No pos hay un error")
          listener.onLoginError()
        }
      }

      override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
        Log.d(tag,t.message.toString())
        listener.onLoginError()
      }
    })
  }

  override fun signUp() {
    TODO("Not yet implemented")
  }

  override fun validate(listener:SessionListener) {
    //1.- recuperar jwt
    val jwt = preferencesManager.getData(PreferencesManager.keySession,"")
    //val jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlIjpbeyJpZCI6MSwibm9tYnJlIjoiVVNVQVJJTyJ9XSwibmFtZSI6IllhZWwiLCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9VU1VBUklPIn1dLCJzdWIiOiJ4eWFlbDkxMXhAaG90bWFpbC5jb20iLCJpYXQiOjE3MjE0OTA5MzUsImV4cCI6MTcyMTQ5MTIzNX0.xBJ9gCh7JFDZl9-Vv1lt1sZqVRte8WENP4SC1pgsKRc"
    //2.- realizar consulta
    val response = api.validateToken(jwt = jwt ?: "")
    //3.- manejar logica
    response.enqueue(object : Callback<ResponseBody>{
      override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
        if(response.isSuccessful){
          val body = response.body()?.string()
          if(!body.isNullOrEmpty()){
            Log.d(tag,"Respuesta ok ====> $body")
            listener.onValidSession()
          }else{
            Log.d(tag,"No pos no hay un body")
            listener.onSessionExpired()
          }

        }else{
          Log.d(tag,"No pos hay un error")
          listener.onSessionExpired()
        }
      }

      override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
        Log.d(tag,t.message.toString())
        listener.onSessionExpired()
      }

    })
  }

  override fun profile() {
    TODO("Not yet implemented")
  }

}