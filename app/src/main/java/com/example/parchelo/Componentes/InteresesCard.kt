package com.example.parchelo.Componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parchelo.ui.theme.ParcheloColors
import org.w3c.dom.Text


@Composable
fun InteresesCard(nombre : String){
    Card(
        modifier = Modifier.padding(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        border = BorderStroke(1.dp, ParcheloColors.Black)
    ) {
        Text(
            modifier = Modifier
                .background(ParcheloColors.Blanco)
                .padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 2.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            text = nombre,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}

