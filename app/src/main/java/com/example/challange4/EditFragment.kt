package com.example.challange4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.challange4.databinding.FragmentEditBinding
import com.example.challange4.room.DataNote
import com.example.challange4.room.NoteDatabase
import com.example.challange4.room.NoteViewModel
import kotlinx.android.synthetic.main.fragment_edit.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class EditFragment : Fragment() {

    lateinit var binding : FragmentEditBinding
    var dbNote: NoteDatabase? = null
    val viewModel : NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditBinding.inflate(inflater,container,false)
        var getid = arguments?.getString("id")
        var getcontent = arguments?.getString("content")
        var gettitle = arguments?.getString("title")

        binding.idNote.setText(getid)
        binding.editTitle.setText(gettitle)
        binding.editNotee.setText(getcontent)

        binding.btnEditNote.setOnClickListener {
            var idNote = binding.idNote.text.toString().toInt()
            var title = binding.editTitle.text.toString()
            var content = binding.editNotee.text.toString()

            val data = DataNote(getid.toString().toInt(), title, content)
            viewModel.updateNote(data)

           findNavController().navigate(R.id.action_editFragment_to_homeFragment)
        }
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        var getDataNote = intent.getSerializableExtra("dataedit")
//    }

}