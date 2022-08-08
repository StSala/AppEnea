package com.example.appenea.folderDetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appenea.data.DataSourceFolder
import com.example.appenea.data.Folder

class FolderDetailViewModel(private val datasource: DataSourceFolder) : ViewModel() {

    /* Query che ritorna un folder che corrisponde all'id */
    fun getFolderForId(id: Long) : Folder? {
        return datasource.getFolderForId(id)
    }

    fun removeFolder(folder: Folder){
        datasource.removeFolder(folder)
    }

}

class FolderDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FolderDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FolderDetailViewModel(
                datasource = DataSourceFolder.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}