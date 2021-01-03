package com.example.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.jar.Attributes


//to make this class an entity we need to annotate @entity
@Entity(tableName = "notes_table")
class Note(@ColumnInfo(name = "note")val text:String) {
    @PrimaryKey(autoGenerate = true) var id =0
}