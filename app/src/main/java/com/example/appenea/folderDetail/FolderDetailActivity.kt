package com.example.appenea.folderDetail

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.appenea.R
import com.example.appenea.folderList.FOLDER_ID

class FolderDetailActivity : AppCompatActivity() {

    private val folderDetailViewModel by viewModels<FolderDetailViewModel> {
        FolderDetailViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.folder_detail_activity)

        var currentFolderId: Long? = null

        /* Collegare le variabili all'UI. */
        val folderName: TextView = findViewById(R.id.folder_detail_name)
        //val folderDescription: TextView = findViewById(R.id.folder_detail_description)
        val photoButton: Button = findViewById(R.id.photo_button)
        //val sendButton: Button = findViewById(R.id.send_button)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            currentFolderId = bundle.getLong(FOLDER_ID)
        }

        /* Se currentFolderId non è null allora si hanno i corrspondenti dati */
        currentFolderId?.let {
            val currentFolder = folderDetailViewModel.getFolderForId(it)
            folderName.text = currentFolder?.name

           /* sendButton.setOnClickListener {
                if (currentFolder != null) {
                    folderDetailViewModel.sendFolder(currentFolder)
                }
                finish()
            }*/

            /* photoButton.setOnClickListener {
                if (currentFolder != null) {
                    folderDetailViewModel.savePhoto(currentFolder)
                }
                finish()
            }*/
        }

    }
}