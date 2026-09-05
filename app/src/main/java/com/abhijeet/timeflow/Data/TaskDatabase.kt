package com.abhijeet.timeflow.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abhijeet.timeflow.Data.Dao.TaskDao
import com.abhijeet.timeflow.Data.Model.Tasks

@Database(
    entities = [Tasks::class],
    version = 1,
    exportSchema = true
)
abstract class TaskDatabase : RoomDatabase(){
    abstract fun taskDao() : TaskDao
}
