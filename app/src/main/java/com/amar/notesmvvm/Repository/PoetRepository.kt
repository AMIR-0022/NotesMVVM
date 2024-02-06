package com.amar.notesmvvm.Repository

import androidx.lifecycle.LiveData
import com.amar.notesmvvm.Models.DataEntity
import com.amar.notesmvvm.MyDb.PoetDAO


class PoetRepository (private val poetDAO: PoetDAO){

    val allPoet: LiveData<List<DataEntity>> = poetDAO.getAllPoet();

    suspend fun insert(dataEntity: DataEntity){
        poetDAO.insertPoet(dataEntity);
    }

    suspend fun delete(dataEntity: DataEntity){
        poetDAO.deletePoet(dataEntity);
    }

    suspend fun update(dataEntity: DataEntity){
        poetDAO.updatePoet(dataEntity);
    }

}