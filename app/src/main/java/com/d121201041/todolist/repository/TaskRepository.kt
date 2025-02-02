package com.d121201041.todolist.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.d121201041.todolist.database.TaskDao
import com.d121201041.todolist.database.TaskEntry

class TaskRepository(val taskDao: TaskDao) {

    suspend fun insert(taskEntry: TaskEntry) = taskDao.insert(taskEntry)

    suspend fun updateData(taskEntry: TaskEntry) = taskDao.update(taskEntry)

    suspend fun deleteItem(taskEntry: TaskEntry) = taskDao.delete(taskEntry)

    suspend fun deleteAll() {
        taskDao.deleteAll()
    }

    fun getAllTasks() : LiveData<List<TaskEntry>> = taskDao.getAllTask()

    fun getAllPriorityTasks() : LiveData<List<TaskEntry>> = taskDao.getAllPriorityTasks()

    fun searchDatabase(searchQuery: String) : LiveData<List<TaskEntry>> {
        return taskDao.searchDatabase(searchQuery)
    }
}