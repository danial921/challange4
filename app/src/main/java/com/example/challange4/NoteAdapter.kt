package com.example.challange4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.challange4.databinding.FragmentEditBinding
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
        holder.binding.id.text = listNote[position].title.toString()
        holder.binding.judul.text = listNote[position].content.toString()
        val data = listNote[position]

        holder.binding.delete.setOnClickListener{
            DBNote = NoteDatabase.getInstance(it.context)
            GlobalScope.async {
                val del = DBNote?.noteDao()?.deleteNote(listNote[position])
                if ( del != 0){
                    Toast.makeText(it.context, "Data ${listNote[position].id} Data Berhasil di Hapus", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(it.context, "Data ${listNote[position].id} Data Gagal di Hapus ", Toast.LENGTH_SHORT).show()
                }
            }
        }

        holder.binding.edit.setOnClickListener{
            var bund = Bundle()
            bund.putInt("id", listNote[position].id)
            bund.putString("content", listNote[position].content)
            bund.putString("title", listNote[position].title)
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_editFragment, bund)
        }

    }


    override fun getItemCount(): Int {
        return listNote.size
    }


}