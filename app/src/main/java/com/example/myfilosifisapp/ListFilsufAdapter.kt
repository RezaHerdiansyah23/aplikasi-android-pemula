package com.example.myfilosifisapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfilosifisapp.databinding.ItemRowFilsufBinding

class ListFilsufAdapter(private val listFilsuf: ArrayList<Filsuf>): RecyclerView.Adapter<ListFilsufAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Filsuf)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListFilsufAdapter.ListViewHolder {
        // Use the correct variable name, 'parent' instead of 'viewGroup'
        val binding: ItemRowFilsufBinding = ItemRowFilsufBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListFilsufAdapter.ListViewHolder, position: Int) {
        val (name, description, photo) = listFilsuf[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listFilsuf[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listFilsuf.size

    class ListViewHolder(var binding: ItemRowFilsufBinding) : RecyclerView.ViewHolder(binding.root)
}