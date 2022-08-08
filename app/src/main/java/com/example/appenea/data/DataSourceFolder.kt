package com.example.appenea.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/* Gestisce le operazioni di flowersLiveData. */
class DataSourceFolder(resources: Resources) {
    private val initialFolderList = folderList(resources)
    private val foldersLiveData = MutableLiveData(initialFolderList)

    /* Aggiunge folder a liveData */
    fun addFolder(folder: Folder) {
        val currentList = foldersLiveData.value
        if (currentList == null) {
            foldersLiveData.postValue(listOf(folder))
        } else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, folder)
            foldersLiveData.postValue(updatedList)
        }
    }

    /* Rimuove Folder da liveData. */

    fun removeFolder(folder: Folder) {
        val currentList = foldersLiveData.value
        if (currentList != null) {
            val updatedList = currentList.toMutableList()
            updatedList.remove(folder)
            foldersLiveData.postValue(updatedList)
        }
    }

    /* Ritorna il folder dell'id dato. */
    fun getFolderForId(id: Long): Folder? {
        foldersLiveData.value?.let { folders ->
            return folders.firstOrNull{ it.id == id}
        }
        return null
    }

    fun getFolderList(): LiveData<List<Folder>> {
        return foldersLiveData
    }


    companion object {
        private var INSTANCE: DataSourceFolder? = null

        fun getDataSource(resources: Resources): DataSourceFolder {
            return synchronized(DataSourceFolder::class) {
                val newInstance = INSTANCE ?: DataSourceFolder(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}