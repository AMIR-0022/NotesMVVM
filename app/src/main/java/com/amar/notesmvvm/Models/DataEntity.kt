package com.amar.notesmvvm.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.amar.notesmvvm.Utils.POET_TABLE
import java.io.Serializable
import java.util.Date

@Entity(tableName = POET_TABLE)
data class DataEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("Id")
    var id: Int?,

    @ColumnInfo(name = "Date")
    var date: Date,

    @ColumnInfo(name = "PoetTitle")
    var title: String,

    @ColumnInfo(name = "PoetMessage")
    var message: String
) : Serializable