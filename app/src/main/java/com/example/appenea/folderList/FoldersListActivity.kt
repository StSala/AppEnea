package com.example.appenea.folderList

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appenea.folderDetail.FolderDetailActivity
import com.example.appenea.R
import com.example.appenea.addFolder.*
import com.example.appenea.data.Folder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_folder.*
import java.time.LocalDate
import java.time.LocalDateTime

const val FOLDER_ID = "folder id"
//private lateinit var date: LocalDate

class FoldersListActivity : AppCompatActivity() {

    private val newFolderActivityRequestCode = 1

    private val foldersListViewModel by viewModels<FoldersListViewModel> {
        FoldersListViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val search : SearchView
        val headerAdapter = HeaderAdapter()
        val foldersAdapter = FoldersAdapter { folder -> adapterOnClick(folder) }
        val concatAdapter = ConcatAdapter(headerAdapter, foldersAdapter)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = concatAdapter

        foldersListViewModel.foldersLiveData.observe(this) {
            it?.let {
                foldersAdapter.submitList(it as MutableList<Folder>)
                headerAdapter.updateFolderCount(it.size)
            }
        }

        val fab: View = findViewById(R.id.addButton)
        fab.setOnClickListener {
            fabOnClick()
        }

    }

    private fun searchOnClick() {
    }


    /* Apre FolderDetailActivity quando un item è cliccato. */
    private fun adapterOnClick(folder: Folder) {
        val intent = Intent(this, FolderDetailActivity()::class.java)
        intent.putExtra(FOLDER_ID, folder.id)
        startActivity(intent)
    }

    /* Aggiunge il folder alla lista quando il tasto di aggiunta è cliccato. */
    private fun fabOnClick() {
        val intent = Intent(this, AddFolderActivity::class.java)
        startActivityForResult(intent, newFolderActivityRequestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        /* Inserisce un item in viewModel. */
        if (requestCode == newFolderActivityRequestCode && resultCode == RESULT_OK) {
            intentData?.let { data ->
                val folderName = data.getStringExtra(FOLDER_NAME)
                val folderDescription = data.getStringExtra(FOLDER_DESCRIPTION)
                val folderAuthor = data.getStringExtra(FOLDER_AUTHOR)
                val folderNote = data.getStringExtra(FOLDER_NOTE)

                foldersListViewModel.insertFolder(folderName, folderDescription,folderAuthor , folderNote)

            }
        }
    }
}