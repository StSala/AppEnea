package com.example.appenea.addFolder

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appenea.R
import com.google.android.material.textfield.TextInputEditText


class CancelAddFolderActivity : AppCompatActivity() {

    private lateinit var addFolderName: TextInputEditText
    private lateinit var addFolderDescription: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_folder_layout)

        findViewById<Button>(R.id.cancel_button).setOnClickListener {
            cancelAddFolder()
        }
        addFolderName = findViewById(R.id.add_folder_name)
        addFolderDescription = findViewById(R.id.add_folder_description)
    }

    /* onClick per il pulsante cancel. chiude l'attività e ritorna alla schermata home, non viene salvato
    * il nome e la descrizione della cartella */

    private fun cancelAddFolder() {
        val resultIntent = Intent()
        setResult(Activity.RESULT_CANCELED, resultIntent)

        finish()
    }

}