package com.practies.retrofitapplication.api.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.practies.retrofitapplication.Movie
import com.practies.retrofitapplication.helper.Constants
import com.practies.retrofitapplication.helper.Constants.MOVIES_TABLE
import com.practies.retrofitapplication.model.Result

@Database( entities = [Result::class], version = 1, exportSchema = true)
abstract  class MovieDbEntity :RoomDatabase(){

   abstract fun movieDao():MovieDao
    companion object{

         @Volatile
        private var INSTANCE:MovieDbEntity?=null


        fun getMovieDbEntity(context: Context):MovieDbEntity{
            val tempInstance= INSTANCE
            if (tempInstance != null){
                return  tempInstance
            }
            synchronized(this){
                val instance=Room.databaseBuilder(
                    context.applicationContext,
                    MovieDbEntity::class.java,MOVIES_TABLE)
                    .build()
                INSTANCE=instance
              return  instance
            }
        }


}}