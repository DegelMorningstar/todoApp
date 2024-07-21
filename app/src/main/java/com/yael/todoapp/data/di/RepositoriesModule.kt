package com.yael.todoapp.data.di

import com.yael.todoapp.data.repository.TaskRepositoryImpl
import com.yael.todoapp.data.repository.UserRepositoryImpl
import com.yael.todoapp.domain.repositories.TaskRepository
import com.yael.todoapp.domain.repositories.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

  @Binds
  fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl):UserRepository

  @Binds
  fun bindTaskRepository(taskRepositoryImpl: TaskRepositoryImpl):TaskRepository

}