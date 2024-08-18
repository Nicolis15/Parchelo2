package com.example.parchelo.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parchelo.Componentes.InteresesCard
import com.example.parchelo.R
import com.example.parchelo.ui.theme.ParcheloColors

@Composable
fun UserScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff6FC5BF))
    ){
        superior()
        medio()
        bajo()
    }
}

@Composable
fun superior(){

    Column(
        modifier = Modifier
            .background(ParcheloColors.Prymary)
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            shape = CircleShape,
            border = BorderStroke(4.dp, ParcheloColors.Blanco),
        ) {
            Image(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.nicolas),
                contentDescription = "nicolas"
            )
        }
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Nicolas, 21",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = ParcheloColors.Blanco
        )

    }
}
@Preview(showBackground = true)
@Composable
fun medio(){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.padding(10.dp),
        //border = BorderStroke(1.dp, ParcheloColors.Black),
        colors = CardDefaults.cardColors(ParcheloColors.Blanco)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(),
                text = "Sobre mi",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                modifier = Modifier.padding(end = 5.dp, start = 5.dp, bottom = 5.dp),
                textAlign = TextAlign.Center,
                text = "Soy una persona sociable, alegre y carismatica, me gustan los chistes negros, las mujeres y el alcohol, no obstante, soy buen ciclista, me gusta correr y al finalizar tomarme mis polas.",
            )
        }

    }
}

@Composable
fun bajo() {
    val intereses = listOf<String>("Gym", "Programar", "Videojuegos", "Futbol", "Caminar")
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.padding(10.dp),
        //border = BorderStroke(1.dp, ParcheloColors.Black),
        colors = CardDefaults.cardColors(ParcheloColors.Blanco)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(5.dp),
                text = "Mis intereses",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                itemsIndexed(intereses){_, interes ->
                    InteresesCard(nombre = interes)
                }
            }
        }
    }
}