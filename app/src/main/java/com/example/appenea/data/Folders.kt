package com.example.appenea.data

import android.content.res.Resources
import com.example.appenea.R


fun folderList(resources: Resources): List<Folder> {
    return listOf(
        Folder(
            id = 1,
            name = "cartella di prova a",
            description = "prova 1"
        ),
        Folder(
            id = 2,
            name = "B",
            description = "prova 2"
        ),
        Folder(
            id = 3,
            name = "C",
            description = "prova 3"
        ),
        Folder(
            id = 4,
            name = "D",
            description = "prova 4"
        ),
        Folder(
            id = 5,
            name = "E",
            description = "prova 5"
        )
    )
}