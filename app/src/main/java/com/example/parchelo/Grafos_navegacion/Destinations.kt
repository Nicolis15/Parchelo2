package com.example.parchelo.Grafos_navegacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

interface Destinations {
    val route: String
    val titulo : String?
    val icon : ImageVector?
}
object home : Destinations {
    override val route = "Home"
    override val titulo = "Home"
    override val icon = Icons.Filled.Home
}

object user : Destinations {
    override val route = "Usuario"
    override val titulo = "Usuario"
    override val icon = Icons.Filled.Person
}
