package com.example.parchelo.Componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parchelo.R
import com.example.parchelo.ui.theme.ParcheloColors

@Preview(showBackground = true)
@Composable
fun TopAppBar(){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(ParcheloColors.Blanco)
            .padding(5.dp),
        ) {
        Row (
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 20.dp)
                .fillMaxWidth(0.87f)
        ){
            Image(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo"
            )
            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    //.fillMaxWidth(0.85f)
                    .align(Alignment.CenterVertically),
                text = stringResource(id = R.string.app_name),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = ParcheloColors.Prymary,
            )
        }

        IconButton(onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterVertically)) {
            Icon(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                painter = painterResource(id = R.drawable.bell),
                contentDescription = "Notificaciones"
            )
        }
    }

}

