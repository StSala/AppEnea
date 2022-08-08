package com.example.appenea.addFolder

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appenea.R
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.item_folder.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*


const val FOLDER_NAME = "name"
const val FOLDER_DESCRIPTION = "description"
const val FOLDER_AUTHOR = "author"
const val FOLDER_NOTE = "note"

class AddFolderActivity : AppCompatActivity() {
    private lateinit var addFolderName: TextInputEditText
    private lateinit var addFolderDescription: TextInputEditText
    private lateinit var addFolderAuthor: TextInputEditText
    private lateinit var addFolderNote: TextInputEditText


    //private lateinit var addFolderDate: TextInputEditText
    private var currentTime: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_folder_layout)

        findViewById<Button>(R.id.create_button).setOnClickListener {
            addFolder()
        }

        findViewById<Button>(R.id.undo_button).setOnClickListener {
            undoFolder()
        }

        addFolderName = findViewById(R.id.add_folder_name)
        addFolderDescription = findViewById(R.id.add_folder_description)
        addFolderAuthor = findViewById(R.id.add_folder_author)
        addFolderNote = findViewById(R.id.add_folder_note)
    }

    /* l'azione di onClick per il pulsante crea. chiude l'attività e ritorna la nuova cartella. */

    private fun addFolder() {
        val resultIntent = Intent()

        //date time
        val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.ROOT)
        currentTime = sdf.format(Date())


        if (addFolderName.text.isNullOrEmpty() || addFolderAuthor.text.isNullOrEmpty() ) {
            setResult(RESULT_CANCELED, resultIntent)
        } else {
            val name = addFolderName.text.toString()
            val description = addFolderDescription.text.toString()
            val author = addFolderAuthor.text.toString()
            val note = addFolderNote.text.toString()
            resultIntent.putExtra(FOLDER_NAME, name)
            resultIntent.putExtra(FOLDER_DESCRIPTION, description)
            resultIntent.putExtra(FOLDER_AUTHOR, author)
            resultIntent.putExtra(FOLDER_NOTE, note)
            setResult(RESULT_OK, resultIntent)
        }
        finish()
    }

    private fun undoFolder() {
        val resultIntent = Intent()
        setResult(RESULT_CANCELED, resultIntent)
        finish()
    }
}