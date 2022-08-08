package com.example.appenea.data

import android.content.res.Resources
import android.os.Build
import android.widget.Toast
import java.time.LocalDate

private lateinit var date: LocalDate

fun folderList(resources: Resources): List<Folder> {
    return listOf(
        Folder(
            id = 1,
            name = "A",
            description = "prova 1",
            author = "Stefano",
            note = "notes"
            //dateOfCreation = date.withDayOfMonth(date.dayOfMonth)
        ),
        Folder(
            id = 2,
            name = "B",
            description = "prova 2",
            author = "Stefano",
            note = "notes"
            //dateOfCreation = date.withDayOfMonth(date.dayOfMonth)
        ),
        Folder(
            id = 3,
            name = "C",
            description = "prova 3",
            author = "Stefano",
            note = "notes"
            //dateOfCreation = date.withDayOfMonth(date.dayOfMonth)
        ),
        Folder(
            id = 4,
            name = "D",
            description = "prova 4",
            author = "Sala",
            note = "notes"
            //dateOfCreation = date.withDayOfMonth(date.dayOfMonth)
        ),
        Folder(
            id = 5,
            name = "E",
            description = "prova 5",
            author = "Sala",
            note = "notes"
            //dateOfCreation = date.withDayOfMonth(date.dayOfMonth)
        )
    )
}