package com.example.parchelo.Datos


import com.example.parchelo.R

data class Evento(
    val id: Int,
    val nombre: String,
    val fecha : String,
    val lugar : String,
    val image: Int, val
    descripcion : String)

object Eventos {

    val EventoLits = listOf<Evento>(
        Evento(1, "Ciclovia Nocturna", "13/07/2024; 6:00pm", "Torre Colpatira", R.drawable.cicla, "Llegaremos a la hora estipulada a la Torre Colpatria, tendremos algunos minutos para conocernos, luego tomaremos toda la septima hasta Girardot y de ahi nos quedamos 5 dias en Pereira, lavamos las bicis y nos devolvemos en bus a Bogota."),
        Evento(2, "Fiesta en dakiti", "12/08/2024; 7:30pm", "Dakiti", R.drawable.dakiti, "Estoy buscando un parche para plan nada tranquilo en dakiti bar, la idea es ir al casisno, enbriagranos mucho y apostarle todo al negro, posteriormente iremos a perrearnos unas sucias y pos ultimo iremos a donde las sucias, solo gente seria que este interesada en el plan"),
        Evento(3, "Scape room", "13/07/2024; 3:30pm", "Multiplaza", R.drawable.ecape,"Buscamos personas que esten interesadas en ir a un scape room ubicado en el centro comercial multiplaza, queremos resolver todos los niveles y pasar un buen rato, la idea es ir a las 3:30 y despues conocernos mejor, podemos salir y comer todos juntos"),
        Evento(4, "Jugar tenis", "13/07/2024; 4:00pm", "Canchas de salitre", R.drawable.tennis,"Buscamos personas interesadas en jugar o aprender a jugar tennis, nos justa mucho el tennis y queremos aprender a jugarlo y practicarlo, inicialmente podemos empezar jugando este dia y despues reunirnos mas seguido con mas personas interesadas en jugar"),
        Evento(5, "Subir moncerrate", "13/07/2024; 5:50am", "Moncerrate", R.drawable.moncerrate,"Nos encontraremos en la avenida boyaca para comenzar el tramo hasta la 26, de ahi iremos hasta la torre colpatria y nos quedaremos un ratoe en el parque nacional"),
        Evento(6, "Pegarlo", "13/07/2024; 7:00pm", "Biblioteca tintal", R.drawable.pegarlo,"Nos encontraremos en la avenida boyaca para comenzar el tramo hasta la 26, de ahi iremos hasta la torre colpatria y nos quedaremos un ratoe en el parque nacional")
    )

    fun getEvento(id: Int) = EventoLits.firstOrNull { it.id == id }
}