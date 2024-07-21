package com.yael.todoapp.data.remote

import com.yael.todoapp.data.Constants.PRIVATE_ROUTE
import com.yael.todoapp.data.remote.request.LoginRequest
import com.yael.todoapp.data.remote.request.SignUpRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface TodoApi {

  /** User endpoints */

  @POST("api/v1/usuario/login")
  fun login(@Body loginRequest: LoginRequest):Call<ResponseBody>

  @POST("api/v1/usuario/registro")
  fun signUp(@Body signUpRequest: SignUpRequest):Call<ResponseBody>

  @GET("api/v1/usuario/validate")
  fun validateToken(@Query("jwt") jwt:String):Call<ResponseBody>

  @GET("api/v1/usuario/profile")
  fun profile():Call<ResponseBody>

  /** task endpoints */

  @GET("api/v1/task/all")
  fun getAllTasks():Call<ResponseBody>

}