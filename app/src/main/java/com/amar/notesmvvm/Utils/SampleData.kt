package com.amar.notesmvvm.Utils

import com.amar.notesmvvm.Models.DataEntity
import java.util.Calendar
import java.util.Date

object SampleData {
    val titlePoet = "this is title";
    val messagePoet = "this is the content of your poet";

    fun getDateTime(diff: Int): Date {
        val calender: Calendar = Calendar.getInstance();
        calender.add(Calendar.MILLISECOND, diff);
        return calender.time;
    }

    val poetList: List<DataEntity>
    get () {
        val tempList: MutableList<DataEntity> = ArrayList();
        tempList.add(DataEntity(1, getDateTime(45), titlePoet +" 11", messagePoet));
        tempList.add(DataEntity(2, getDateTime(25), titlePoet +" 22", messagePoet));
        return tempList
    }

}