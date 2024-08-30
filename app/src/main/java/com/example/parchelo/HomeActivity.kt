package com.example.parchelo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parchelo.Componentes.TopAppBar
import com.example.parchelo.Datos.Evento
import com.example.parchelo.Grafos_navegacion.home
import com.example.parchelo.Grafos_navegacion.user
import com.example.parchelo.Screens.Bottomnavigation
import com.example.parchelo.Screens.UserScreen
import com.example.parchelo.Screens.homeScreen
import com.example.parchelo.ui.theme.ParcheloTheme


class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParcheloTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopAppBar() },
                    bottomBar = { Bottomnavigation(navController) },
                ) { innerPadding ->
                    Box(Modifier.padding(innerPadding)) {
                        NavHost(navController = navController, startDestination = home.route) {
                            composable(home.route) {
                                InitUI()
                            }
                            composable(user.route) {
                                UserScreen()
                            }

                        }
                    }
                }
            }
        }
    }

    @Composable
    fun InitUI() {
        homeScreen(this::intentEventoInfo)
    }



    fun intentEventoInfo(evento : Evento){
        val intent = Intent(this, EventoInfo::class.java)
        intent.putExtra("Id", evento.id)
        startActivity(intent)
    }

}







