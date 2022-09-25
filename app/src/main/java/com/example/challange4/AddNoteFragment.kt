package com.example.challange4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.challange4.databinding.FragmentAddNoteBinding
import com.example.challange4.room.DataNote
import com.example.challange4.room.NoteDatabase
import com.example.challange4.room.NoteViewModel
import kotlinx.android.synthetic.main.item_note.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class AddNoteFragment : Fragment() {
    lateinit var binding : FragmentAddNoteBinding
    var dbNote : NoteDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.SaveNote.setOnClickListener {
            addNote(it)
        }
    }

    fun addNote(it : View?){
        GlobalScope.async {
            var title = binding.noteTitle.text.toString()
            var note  = binding.noteContent.text.toString()
            val viewModel : NoteViewModel by viewModels()
            val data = DataNote(0,title = title, content = note)

            viewModel.addNote(data)

            Toast.makeText(context, "Data Berhasil Dimasukkan", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addNoteFragment_to_homeFragment)
        }

    }

}