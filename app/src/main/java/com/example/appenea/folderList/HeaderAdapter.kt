package com.example.appenea.folderList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appenea.R
import kotlinx.android.synthetic.main.item_folder.view.*

/* Una lista che fa vedere sempre quanti elementi contiene. */

class HeaderAdapter: RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    private var folderCount: Int = 0

    /* ViewHolder for displaying header. */
    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val folderNumberTextView: TextView = itemView.findViewById(R.id.folder_number_text)


        fun bind(folderCount: Int) {
            folderNumberTextView.text = folderCount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.folder_header_item, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind(folderCount)
    }

    override fun getItemCount(): Int {
        return 1
    }

    /* Aggiorna il count */
    fun updateFolderCount(updatedFolderCount: Int) {
        folderCount = updatedFolderCount
        notifyDataSetChanged()
    }
}