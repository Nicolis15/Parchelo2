package com.example.parchelo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.parchelo.Screens.RegistrarseScreen
import com.example.parchelo.ui.theme.ParcheloTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegistrarseActivity : ComponentActivity() {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        auth = Firebase.auth
        setContent {
            ParcheloTheme {
                RegistrarseScreen(auth = auth) { intentMain() }
            }
        }
    }
    private fun intentMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

