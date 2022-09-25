package com.example.challange4

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.challange4.databinding.ItemNoteBinding
import com.example.challange4.room.DataNote
import com.example.challange4.room.NoteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class NoteAdapter(var requireContext: Context ,var  listNote : List<DataNote>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    var DBNote : NoteDatabase? = null
    class ViewHolder(var binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root){
        fun data(itemData : DataNote){
            binding.datanote = itemData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.id.text = listNote[position].id.toString()
        holder.binding.judul.text = listNote[position].title

    }

    override fun getItemCount(): Int {
        return listNote.size
    }

}