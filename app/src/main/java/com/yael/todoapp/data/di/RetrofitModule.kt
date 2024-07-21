package com.yael.todoapp.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.yael.todoapp.data.Constants.BASE_URL
import com.yael.todoapp.data.local.PreferencesManager
import com.yael.todoapp.data.remote.AuthorizationInterceptor
import com.yael.todoapp.data.remote.TodoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

  @Singleton
  @Provides
  fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
    return Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  @Singleton
  @Provides
  fun provideTodoApi(retrofit: Retrofit):TodoApi{
    return retrofit.create(TodoApi::class.java)
  }

  @Singleton
  @Provides
  fun provideHttpClient(
    authorizationInterceptor: AuthorizationInterceptor,
    httpLoggingInterceptor: HttpLoggingInterceptor
  ): OkHttpClient {
    return OkHttpClient
      .Builder()
      .addInterceptor(httpLoggingInterceptor)
      .addInterceptor(authorizationInterceptor)
      .build()
  }

  @Singleton
  @Provides
  fun provideAuthorizationInterceptor(preferencesManager: PreferencesManager):AuthorizationInterceptor{
    return AuthorizationInterceptor(preferencesManager)
  }

  @Singleton
  @Provides
  fun provideHttpInterceptor():HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
  }

  @Singleton
  @Provides
  fun provideGson():Gson{
    return GsonBuilder().create()
  }

}