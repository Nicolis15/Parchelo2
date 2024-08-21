package com.example.parchelo.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.parchelo.Datos.Evento
import com.example.parchelo.Datos.Eventos
import com.example.parchelo.Grafos_navegacion.Destinations
import com.example.parchelo.Grafos_navegacion.home
import com.example.parchelo.Grafos_navegacion.user
import com.example.parchelo.R
import com.example.parchelo.ui.theme.ParcheloColors

@Composable
fun homeScreen(onClick : (evento: Evento) -> Unit) {
    val list = Eventos.EventoLits
    Surface(modifier = Modifier
        .fillMaxSize()) {
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            itemsIndexed(list){_, evento ->
                Card (
                    modifier = Modifier
                        .width(350.dp)
                        .height(190.dp)
                        .padding(10.dp),
                    elevation =  CardDefaults.cardElevation(defaultElevation = 6.dp)
                ){
                    Column(
                        modifier = Modifier
                            .background(ParcheloColors.Prymary)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(0.6f)
                                    .align(Alignment.CenterVertically),
                                text = evento.nombre,
                                color = ParcheloColors.Blanco,
                                fontWeight = FontWeight.Bold
                            )
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    fontSize = 12.sp,
                                    text = evento.fecha,
                                    color = ParcheloColors.Blanco)

                                Text(
                                    fontSize = 12.sp,
                                    text = evento.lugar,
                                    color = ParcheloColors.Blanco)
                            }
                        }


                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.7f)
                                .clickable {
                                    onClick(evento)
                                },
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = evento.image),
                            contentDescription = ""
                        )


                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.align(Alignment.End)) {
                            Icon(
                                tint = ParcheloColors.Blanco,
                                painter = painterResource(id = R.drawable.safe),
                                contentDescription = null)
                        }
                    }
                }
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