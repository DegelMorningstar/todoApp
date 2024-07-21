package com.yael.todoapp.data.repository

import android.util.Log
import com.google.gson.Gson
import com.yael.todoapp.data.remote.TodoApi
import com.yael.todoapp.data.remote.response.task.TaskResponse
import com.yael.todoapp.domain.listeners.GetAllTaskListener
import com.yael.todoapp.domain.repositories.TaskRepository
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class TaskRepositoryImpl @Inject constructor(
    private val api: TodoApi,
    private val gson: Gson,
):TaskRepository {

    private val tag = TaskRepositoryImpl::class.java.simpleName

    override fun getAllTasks(listener:GetAllTaskListener) {
        val response = api.getAllTasks()
        response.enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
                    val responseBody = response.body()!!.string()
                    val taskResponse = gson.fromJson(responseBody,TaskResponse::class.java)
                    val taskList = taskResponse.resultado
                    listener.onGetAllTaskSuccess(taskList)
                }else{
                    listener.onError("Ocurrio un error")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d(tag,t.message.toString())
                listener.onError(t.message.toString())
            }

        })
    }

}