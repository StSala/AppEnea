package com.example.appenea.folderList

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appenea.data.DataSourceFolder
import com.example.appenea.data.Folder
import kotlin.random.Random

class FoldersListViewModel(val dataSource: DataSourceFolder) : ViewModel() {

    val foldersLiveData = dataSource.getFolderList()

    /* If the name and description are present, create new Flower and add it to the datasource */
    fun insertFolder(folderName: String?, folderDescription: String?) {
        if (folderName == null ) {
            return
        }

        val newFolder = folderDescription?.let {
            Folder(
                Random.nextLong(),
                folderName,
                it
            )
        }

        if (newFolder != null) {
            dataSource.addFolder(newFolder)
        }
    }
}

class FoldersListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoldersListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FoldersListViewModel(
                dataSource = DataSourceFolder.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}