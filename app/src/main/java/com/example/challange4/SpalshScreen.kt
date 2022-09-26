package com.example.challange4

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

class SpalshScreen : Fragment() {
        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spalsh_screen, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var data = requireActivity().getSharedPreferences("registerData", Context.MODE_PRIVATE)
        var username = data.getString("usernamelgn", null)

        Handler(Looper.myLooper()!!).postDelayed({
            if(username != null)
                findNavController().navigate(R.id.action_spalshScreen_to_homeFragment)
            else
                findNavController().navigate(R.id.action_spalshScreen_to_loginFragment)
        },3000)

    }
}