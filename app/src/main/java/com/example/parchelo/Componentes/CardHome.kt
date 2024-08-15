package com.example.parchelo.Componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parchelo.Datos.Evento
import com.example.parchelo.Datos.Eventos
import com.example.parchelo.R
import com.example.parchelo.ui.theme.ParcheloColors

@Composable
fun CardHome(evento: Evento){
    val id = evento.id.toString()
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
                        //Agregar click
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

@Composable
@Preview(showBackground = true)
fun ver(){
    val evento = Eventos
    CardHome(evento = evento.EventoLits[0])
}

