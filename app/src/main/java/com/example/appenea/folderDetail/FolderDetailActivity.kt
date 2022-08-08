package com.example.appenea.folderDetail


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.appenea.R
import com.example.appenea.folderList.FOLDER_ID
import kotlinx.android.synthetic.main.folder_detail_activity.*
import android.text.TextWatcher;
import android.view.View
import android.widget.Toast
import com.example.appenea.addFolder.FOLDER_AUTHOR
import com.example.appenea.addFolder.FOLDER_DESCRIPTION
import com.example.appenea.addFolder.FOLDER_NAME
import com.example.appenea.folderImageDetail.FolderImageActivity


private const val REQUEST_CODE = 42

class FolderDetailActivity : AppCompatActivity() {

    private val newFolderImageActivityRequestCode = 1


    private val folderDetailViewModel by viewModels<FolderDetailViewModel> {
        FolderDetailViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.folder_detail_activity)

        var currentFolderId: Long? = null

        /* Collegare le variabili all'UI. */

        val folderName: TextView = findViewById(R.id.folder_detail_name)
        val folderNote: TextView = findViewById(R.id.folder_detail_note)
        val sendFolderButton: Button = findViewById(R.id.send_button)
        val deleteFolderButton: Button = findViewById(R.id.delete_button)
        //val addNoteButton : Button = findViewById(R.id.add_note_button)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            currentFolderId = bundle.getLong(FOLDER_ID)
        }

        val folderIm: View = findViewById(R.id.frameLayout_imageFolder)
        folderIm.setOnClickListener {
            folderOnClickll()
        }

        /* Se currentFolderId non è null allora si hanno i corrspondenti dati */
        currentFolderId?.let {
            val currentFolder = folderDetailViewModel.getFolderForId(it)
            folderName.text = currentFolder?.name
            folderNote.text = currentFolder?.note


            deleteFolderButton.setOnClickListener {
                if (currentFolder != null) {
                    folderDetailViewModel.removeFolder(currentFolder)
                }
                finish()
            }

            /* sendButton.setOnClickListener {
                if (currentFolder != null) {
                    folderDetailViewModel.sendFolder(currentFolder)
                }
                finish()
            }*/

        }

    }

    private fun folderOnClick() {
        val intent = Intent(this, FolderImageActivity::class.java)
        startActivityForResult(intent, newFolderImageActivityRequestCode)
    }

    private fun folderOnClickll(){
        val intent = Intent(this, FolderImageActivity::class.java)
        startActivityForResult(intent, newFolderImageActivityRequestCode)
    }


}
