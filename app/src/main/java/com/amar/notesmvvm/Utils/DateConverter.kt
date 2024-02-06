package com.amar.notesmvvm.Utils

import androidx.room.TypeConverter
import java.util.Date

object DateConverter {

    @TypeConverter
    @JvmStatic
    fun toTimeStamp(date: Date): Long{
        return date.time;
    }

    @TypeConverter
    @JvmStatic
    fun toDateStamp(time: Long): Date{
        return Date(time);
    }

}