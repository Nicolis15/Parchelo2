package com.example.parchelo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.parchelo.Screens.EventoInfo
import com.example.parchelo.ui.theme.ParcheloTheme

class EventoInfo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id_evento = intent.getIntExtra("Id",0)
        setContent {
            ParcheloTheme {
                EventoInfo(id = id_evento)
            }
        }
    }
}

