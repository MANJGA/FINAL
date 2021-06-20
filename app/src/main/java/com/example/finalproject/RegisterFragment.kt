package com.example.finalproject

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.finalproject.databinding.FragmentRegisterBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init(){
        binding.register.setOnClickListener {
            registerUser()
            findNavController().navigate(R.id.action_registerFragment_to_questionFragment)
        }

        binding.signIn.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_logInFragment)
        }
    }
    private fun registerUser(){
        when{
            TextUtils.isEmpty(binding.email.text.toString().trim { it <= ' ' }) ->{
                Toast.makeText(context, "Please enter email.", Toast.LENGTH_SHORT).show()
            }
            TextUtils.isEmpty(binding.password.text.toString().trim { it <= ' ' }) ->{
                Toast.makeText(context, "Please enter password.", Toast.LENGTH_SHORT).show()
            }
            else -> {
                val email = binding.email.text.toString().trim { it <= ' ' }
                val password = binding.password.text.toString().trim { it <= ' ' }

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                    OnCompleteListener<AuthResult> { task ->
                        if (task.isSuccessful){
                            Toast.makeText(context, "register", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(context, task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

}