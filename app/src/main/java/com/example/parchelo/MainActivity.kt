package com.example.parchelo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.parchelo.Screens.inicioSesion
import com.example.parchelo.ui.theme.ParcheloTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContent {
            ParcheloTheme {
                inicioSesion({ intentHomeScreen() }, auth, {intentRegistrarse()})
            }
        }
    }

    private fun intentHomeScreen(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
    private fun intentRegistrarse(){
        val intent = Intent(this, RegistrarseActivity::class.java)
        startActivity(intent)
    }

}

