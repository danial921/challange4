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
import com.example.challange4.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    lateinit var  sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefs = requireActivity().getSharedPreferences("registerData", Context.MODE_PRIVATE)


        var username = sharedPrefs.getString("username", null)
        var password = sharedPrefs.getString("password", null)

        binding.login.setOnClickListener{
            var usernamelgn = binding.username.text.toString()
            var passwordlgn = binding.passwrd.text.toString()
            if(username == usernamelgn && password == passwordlgn){
                var addData = sharedPrefs.edit()
                addData.putString("usernamelgn", usernamelgn)
                addData.putString("passwordlgn", passwordlgn)
                addData.apply()
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
            else
                Toast.makeText(requireContext(), "The username or password is incorrect !", Toast.LENGTH_SHORT).show()
        }
        binding.register.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

}