package com.example.appenea.folderImageDetail

import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.get
import com.example.appenea.R
import kotlinx.android.synthetic.main.folder_image_pick_activity.*
import kotlinx.android.synthetic.main.folder_image_pick_activity.delete_image_button
import kotlinx.android.synthetic.main.folder_image_pick_activity.imageSwitcher
import kotlinx.android.synthetic.main.folder_image_pick_activity.next_button
import kotlinx.android.synthetic.main.folder_image_pick_activity.pick_button
import kotlinx.android.synthetic.main.folder_image_pick_activity.previous_button
import kotlinx.android.synthetic.main.folder_image_switcher_activity.*


class FolderImageActivity : AppCompatActivity() {

    private var images : ArrayList<Uri?>? = null
    private var image : HashMap<Uri? , Int>? = null
    private var id = 0
    private var position = 0
    private val PICK_IMAGES_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.folder_image_pick_activity)
        setContentView(R.layout.folder_image_switcher_activity)

        images = ArrayList()

        imageSwitcher.setFactory{
            ImageView.ScaleType.FIT_CENTER
            ImageView(applicationContext)
        }

        //button to select the images from gallery
        pick_button.setOnClickListener{
            pickImageIntent()
        }

        next_button.setOnClickListener{
            if(position < images!!.size-1){
                position++
                imageSwitcher.setImageURI(images!![position])
            } else{
                Toast.makeText(this, "No more photo" , Toast.LENGTH_SHORT).show()
            }
        }

        previous_button.setOnClickListener{
            if(position > 0){
                position--
                imageSwitcher.setImageURI(images!![position])
            } else{
                Toast.makeText(this, "No previous photo" , Toast.LENGTH_SHORT).show()
            }
        }

        delete_image_button.setOnClickListener{
            val cr:View = imageSwitcher.currentView
            //images!!.removeAt(cr.id)
            imageSwitcher.removeView(cr)
            Toast.makeText(this, images!!.size.toString() , Toast.LENGTH_SHORT).show()


        }

        save_image_button.setOnClickListener{
            finish()
        }

    }


    private fun pickImageIntent(){
        val intent = Intent()
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent , "Select Image" ), PICK_IMAGES_CODE )
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == PICK_IMAGES_CODE){
            if(resultCode == Activity.RESULT_OK){
                if(data!!.clipData != null){
                    val count = data.clipData!!.itemCount
                    for (x: Int in 0 until count){
                        val imageUri = data.clipData!!.getItemAt(x).uri
                        image?.set(imageUri , x)
                        images!!.add(imageUri)
                    }
                    imageSwitcher.setImageURI(images!![0])

                }else{
                    val imageUri = data.data
                    imageSwitcher.setImageURI(imageUri)

                }
            }
        }

    }

}