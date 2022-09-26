package com.example.challange4

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challange4.databinding.FragmentHomeBinding
import com.example.challange4.room.NoteDatabase
import com.example.challange4.room.NoteViewModel

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    var NoteDB : NoteDatabase? = null
    lateinit var adapterNote : NoteAdapter
    private val viewModel : NoteViewModel by viewModels()
    lateinit var  sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        viewModel.getNote().observe(viewLifecycleOwner){ listNote ->
            binding.rvNote.layoutManager = LinearLayoutManager(requireContext())
            binding.rvNote.adapter = NoteAdapter(requireContext(),listNote)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefs = requireActivity().getSharedPreferences("registerData", Context.MODE_PRIVATE)

//        NoteDB = NoteDatabase.getInstance(this)
        binding.btnAddNote.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }

        binding.signoutbutton.setOnClickListener {
            var pref = sharedPrefs.edit()
            pref.clear()
            pref.apply()
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }

}