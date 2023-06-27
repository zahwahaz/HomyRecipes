package com.example.homyrecipes

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import androidx.navigation.NavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseUser

class RegisterViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth

    fun signUpUser(email: String, password: String, navController: NavController){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user, navController)
                } else {
                    updateUI(null, navController)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?, navController: NavController) {
        if(user != null){
            navController.navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

}


