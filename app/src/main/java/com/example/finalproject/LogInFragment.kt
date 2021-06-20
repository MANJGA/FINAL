package com.example.finalproject

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.finalproject.databinding.FragmentLogInBinding
import com.google.firebase.auth.FirebaseAuth


class LogInFragment : Fragment() {
    
    private lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init(){
        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_registerFragment)
        }
        binding.logIn.setOnClickListener {
            logInUser()
        }
    }

    private fun logInUser(){
        when{
            TextUtils.isEmpty(binding.loginEmail.text.toString().trim { it <= ' ' }) ->{
                Toast.makeText(context, "Please enter email.", Toast.LENGTH_SHORT).show()
            }
            TextUtils.isEmpty(binding.loginPassword.text.toString().trim { it <= ' ' }) ->{
                Toast.makeText(context, "Please enter password.", Toast.LENGTH_SHORT).show()
            }
            else -> {
                val email = binding.loginEmail.text.toString().trim { it <= ' ' }
                val password = binding.loginPassword.text.toString().trim { it <= ' ' }

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(context, "log in", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_logInFragment_to_questionFragment)
                    }else{
                        Toast.makeText(context, task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}