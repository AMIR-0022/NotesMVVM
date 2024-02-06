package com.amar.notesmvvm.MyDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amar.notesmvvm.Models.DataEntity
import com.amar.notesmvvm.Utils.DATABASE_NAME
import com.amar.notesmvvm.Utils.DateConverter

@Database(entities = [DataEntity::class], version = 2)
@TypeConverters(DateConverter::class)
abstract class PoetDb : RoomDatabase(){

    abstract fun getPoetDao(): PoetDAO;

    companion object {
        @Volatile
        private var instance: PoetDb? = null;

        fun getInstance (context: Context): PoetDb{
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(context.applicationContext, PoetDb::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build().also { instance = it }
            }
        }

//        fun getInstance (context: Context): PoetDb {
//            if (instance == null){
//                synchronized(this) {
//                    instance ?: Room.databaseBuilder(context.applicationContext, PoetDb::class.java, DATABASE_NAME)
//                        .fallbackToDestructiveMigration()
//                        .build().also { instance = it }
//                }
//            }
//            return instance!!;
//        }


    }

}