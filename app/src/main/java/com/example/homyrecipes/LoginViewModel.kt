package com.example.homyrecipes

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginViewModel (private val auth: FirebaseAuth): ViewModel() {

    fun signIn(email: String, password: String, navController: NavController){
        auth.signInWithEmailAndPassword(email, password)
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
            navController.navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }
}
