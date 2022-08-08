package com.example.appenea.folderList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appenea.R
import com.example.appenea.data.Folder
import java.time.LocalDateTime

class FoldersAdapter(private val onClick: (Folder) -> Unit) :
    ListAdapter<Folder, FoldersAdapter.FolderViewHolder>(FolderDiffCallback) {


    class FolderViewHolder(itemView: View, val onClick: (Folder) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val folderNameView: TextView = itemView.findViewById(R.id.folder_name)
        private val folderDescriptionView: TextView = itemView.findViewById(R.id.folder_description)
        private val folderAuthorView: TextView = itemView.findViewById(R.id.folder_author)
        private var currentFolder: Folder? = null

        init {
            itemView.setOnClickListener {
                currentFolder?.let {
                    onClick(it)
                }
            }
        }

        /* Bind folder name and the first image of the album. */
        fun bind(folder: Folder) {
            currentFolder = folder

            folderNameView.text = folder.name
            folderDescriptionView.text = folder.description
            folderAuthorView.text = folder.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_folder, parent, false)
        return FolderViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: FolderViewHolder, position: Int) {
        val folder = getItem(position)
        holder.bind(folder)

    }
}

object FolderDiffCallback : DiffUtil.ItemCallback<Folder>() {
    override fun areItemsTheSame(oldItem: Folder, newItem: Folder): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Folder, newItem: Folder): Boolean {
        return oldItem.id == newItem.id
    }
}