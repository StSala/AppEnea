package com.example.appenea.data


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(tableName = "folders")
data class Folder(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @Transient
    // ID is transient during serialization since notes are mapped by ID in JSON,
    // so repeating this field would be superfluous.
    val id: Long,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "author")
    val author: String?,

    @ColumnInfo(name = "note")
    val note: String

    //@ColumnInfo(name = "date")
    //val dateOfCreation: Date

)

