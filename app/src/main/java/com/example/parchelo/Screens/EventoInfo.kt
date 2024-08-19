package com.example.parchelo.Screens


import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parchelo.Datos.Eventos
import com.example.parchelo.R
import com.example.parchelo.ui.theme.ParcheloColors



@Composable
fun EventoInfo(id : Int?){


    val context = LocalContext.current
    val evento = requireNotNull(id?.let { Eventos.getEvento(id) })
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ParcheloColors.Prymary)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = evento.nombre,
            textAlign = TextAlign.Center,
            color = ParcheloColors.Blanco,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
            )
        Row {
            Text(
                modifier = Modifier.padding(end = 20.dp),
                text = evento.fecha,
                textAlign = TextAlign.Center,
                color = ParcheloColors.Blanco,
                fontSize = 16.sp,
            )
            Text(
                modifier = Modifier.padding(bottom = 5.dp),
                text = evento.lugar,
                textAlign = TextAlign.Center,
                color = ParcheloColors.Blanco,
                fontSize = 16.sp,
            )

        }
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = evento.image),
            contentDescription = "Image evento")

        Text(
            modifier = Modifier
                .padding(10.dp),
            text = "Creador",
            color = ParcheloColors.Blanco,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp)

        Divider(
            modifier = Modifier.fillMaxWidth(0.95f),
            color = ParcheloColors.Blanco
        )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                ){

                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                        shape = CircleShape,
                        border = BorderStroke(3.dp, ParcheloColors.Blanco),
                    ) {
                        Image(
                            modifier = Modifier
                                .width(105.dp)
                                .height(105.dp)
                                .fillMaxWidth(0.4f),
                            painter = painterResource(id = R.drawable.nicolas),
                            contentScale = ContentScale.Crop,
                            contentDescription = "perfil"
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ){
                        Text(
                            text = "Nicolas Lis Cruz",
                            color = ParcheloColors.Blanco,
                            fontSize = 18.sp,
                        )
                        Text(
                            text = "21,Masculino",
                            color = ParcheloColors.Blanco,
                            fontSize = 18.sp,
                            )
                    }
                }
            }

        Column(
            modifier = Modifier
                .background(color = ParcheloColors.Blanco)
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(bottom = 10.dp),
                text = "Descripcion",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = evento.descripcion,
                )

        }

        Text(
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.Start),
            text = "Integrantes: 8/8",
            color = ParcheloColors.Blanco,
            fontSize = 16.sp)

        LazyRow {
            items(8){ number ->
                fotosPerfil()
            }
        }

        Button(
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
            colors = ButtonDefaults.buttonColors(ParcheloColors.Blanco),
            onClick = {
                Toast.makeText(context,"Se ha enviado la solicitud correctamente", Toast.LENGTH_SHORT).show()
            })
        {
            Text(
                text = "Enviar Solicitud",
                color = ParcheloColors.Black,
                fontWeight = FontWeight.Bold)
        }

    }
}




@Composable
fun fotosPerfil(){
    Card(
        modifier = Modifier.padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp, ParcheloColors.Blanco),
    ) {
        Image(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .fillMaxWidth(0.4f),
            painter = painterResource(id = R.drawable.nicolas),
            contentScale = ContentScale.Crop,
            contentDescription = "perfil"
        )
    }
}