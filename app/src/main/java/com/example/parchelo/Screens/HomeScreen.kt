package com.example.parchelo.Screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.parchelo.Componentes.CardHome
import com.example.parchelo.Datos.Eventos
import com.example.parchelo.Grafos_navegacion.Destinations
import com.example.parchelo.Grafos_navegacion.home
import com.example.parchelo.Grafos_navegacion.user
import com.example.parchelo.ui.theme.ParcheloColors

@Composable
fun homeScreen() {
    val list = Eventos.EventoLits
    Surface(modifier = Modifier
        .fillMaxSize()) {
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            itemsIndexed(list){_, evento ->
                CardHome(evento = evento)
            }
        }

    }
}


@Composable
fun Bottomnavigation(navController : NavController){
    val DestinationsList = listOf<Destinations>(home, user)
    val SelectedIndex = rememberSaveable{
        mutableStateOf(0)
    }
    BottomNavigation(backgroundColor = ParcheloColors.Blanco) {
        DestinationsList.forEachIndexed { index, destinations ->
            BottomNavigationItem(
                label = { destinations.titulo?.let {
                    androidx.compose.material.Text(text = it, fontWeight = FontWeight.Bold, color = ParcheloColors.Prymary) } },
                selected = index == SelectedIndex.value,
                onClick = {
                    SelectedIndex.value = index
                    navController.navigate(DestinationsList[index].route){
                        popUpTo(home.route)
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { destinations.icon?.let { Icon(imageVector = it, contentDescription = destinations.titulo, tint = ParcheloColors.Prymary) } })
        }
    }
}