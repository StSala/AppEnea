package com.example.appenea.addFolder

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appenea.R
import com.google.android.material.textfield.TextInputEditText


const val FOLDER_NAME = "name"
const val FOLDER_DESCRIPTION = "description"

class AddFolderActivity : AppCompatActivity() {
    private lateinit var addFolderName: TextInputEditText
    private lateinit var addFolderDescription: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_folder_layout)

        findViewById<Button>(R.id.create_button).setOnClickListener {
            addFolder()
        }
        addFolderName = findViewById(R.id.add_folder_name)
        addFolderDescription = findViewById(R.id.add_folder_description)
    }

    /* onClick per il pulsante crea. chiude l'attività e ritorna la nuova cartella
    e la sua descrizione viene salvata,se esiste. */

    private fun addFolder() {
        val resultIntent = Intent()

        if (addFolderName.text.isNullOrEmpty() ) {
            setResult(RESULT_CANCELED, resultIntent)
        } else if(!(addFolderName.text.isNullOrEmpty()) && addFolderDescription.text.isNullOrEmpty()){
            val name = addFolderName.text.toString()
            resultIntent.putExtra(FOLDER_NAME, name)
            setResult(RESULT_OK, resultIntent)
        } else {
            val name = addFolderName.text.toString()
            val description = addFolderDescription.text.toString()
            resultIntent.putExtra(FOLDER_NAME, name)
            resultIntent.putExtra(FOLDER_DESCRIPTION, description)
            setResult(RESULT_OK, resultIntent)
        }
        finish()
    }
}