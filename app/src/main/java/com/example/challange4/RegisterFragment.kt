package com.example.challange4

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.challange4.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    lateinit var  sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefs = requireActivity().getSharedPreferences("registerData", Context.MODE_PRIVATE)

        binding.register.setOnClickListener{
            registerBtn()
        }

        binding.login.setOnClickListener{
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
    fun registerBtn (){
        val username = binding.username.text.toString()
        val fullName = binding.fullname.text.toString()
        val password = binding.passwrd.text.toString()
        val password2 = binding.passwrd2.text.toString()
        if (password == password2){
            var addData = sharedPrefs.edit()
            addData.putString("username", username)
            addData.putString("fullName", fullName)
            addData.putString("password", password)
            addData.apply()
            Toast.makeText(requireContext(), "Data Save", Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(requireContext(), "Password Not Match", Toast.LENGTH_SHORT).show()
    }
}