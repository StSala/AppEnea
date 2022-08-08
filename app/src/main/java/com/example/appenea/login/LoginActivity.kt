package com.example.appenea.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.appenea.R
import com.example.appenea.addFolder.AddFolderActivity
import com.example.appenea.folderList.FoldersListActivity

class LoginActivity : AppCompatActivity() {

    private var newFoldersListActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        findViewById<Button>(R.id.skipLogin_button).setOnClickListener {
            skipOnClick()
        }
    }

    private fun skipOnClick() {
        val intent = Intent(this, FoldersListActivity::class.java)
        startActivityForResult(intent, newFoldersListActivityRequestCode)
    }

}