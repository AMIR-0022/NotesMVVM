package com.amar.notesmvvm.MyDb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.amar.notesmvvm.Models.DataEntity

@Dao
interface PoetDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPoet(dataEntity: DataEntity);

    @Delete
    suspend fun deletePoet(dataEntity: DataEntity);

    @Update
    suspend fun updatePoet(dataEntity: DataEntity);

    @Query("DELETE FROM PoetCollection")
    fun deleteAllPoet();

    @Query("SELECT * FROM PoetCollection ORDER BY date DESC")
    fun getAllPoet(): LiveData<List<DataEntity>>;
}