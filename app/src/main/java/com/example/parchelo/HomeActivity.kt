package com.example.parchelo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parchelo.Componentes.CardHome
import com.example.parchelo.Componentes.TopAppBar
import com.example.parchelo.Datos.Evento
import com.example.parchelo.Datos.Eventos
import com.example.parchelo.Grafos_navegacion.Destinations
import com.example.parchelo.Grafos_navegacion.home
import com.example.parchelo.Grafos_navegacion.user
import com.example.parchelo.Screens.Bottomnavigation
import com.example.parchelo.Screens.UserScreen
import com.example.parchelo.Screens.homeScreen
import com.example.parchelo.ui.theme.ParcheloColors
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
                                homeScreen()
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

    private fun intentEventoInfo(evento : Evento){
    }

}





