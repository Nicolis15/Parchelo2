package com.example.parchelo.Screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parchelo.R
import com.example.parchelo.ui.theme.ParcheloColors
import com.google.firebase.auth.FirebaseAuth


@Composable
fun RegistrarseScreen(auth: FirebaseAuth, onClick: () -> Unit){
    var context = LocalContext.current

    var Nombre : String by remember{ mutableStateOf("") }
    var Apellido: String by remember{ mutableStateOf("") }
    var Email : String by remember{ mutableStateOf("") }
    var ConfirmarEmail : String by remember{ mutableStateOf("") }
    var Contrasenia : String by remember{ mutableStateOf("") }
    var ConfirmarContrasenia : String by remember{ mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth(0.4f),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "LogoParchelo"
        )

        Spacer(modifier = Modifier.height(50.dp))
        TextField(value = Nombre,
            onValueChange = {Nombre = it},
            label = { Text(text = stringResource(id = R.string.nombre), color = Color.Gray) },
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = Apellido,
            onValueChange = {Apellido = it},
            label = { Text(text = stringResource(id = R.string.apellido), color = Color.Gray) },
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = Email,
            onValueChange = {Email = it},
            label = { Text(text = stringResource(id = R.string.email), color = Color.Gray) },
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = ConfirmarEmail,
            onValueChange = {ConfirmarEmail = it},
            label = { Text(text = stringResource(id = R.string.confirmaremail), color = Color.Gray) },
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = Contrasenia,
            onValueChange = {Contrasenia = it},
            label = { Text(text = stringResource(id = R.string.contrasenia), color = Color.Gray) },
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = ConfirmarContrasenia,
            onValueChange = {ConfirmarContrasenia = it},
            label = { Text(text = stringResource(id = R.string.confirmarcontrasenia), color = Color.Gray) },
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            modifier = Modifier.width(250.dp).height(50.dp),
            onClick = {
                if(Nombre.isNotEmpty() && Apellido.isNotEmpty() && Email.isNotEmpty() && ConfirmarEmail.isNotEmpty() && Contrasenia.isNotEmpty() && ConfirmarContrasenia.isNotEmpty()){
                    //if(Email.trim() == ConfirmarEmail.trim()){
                        if(Contrasenia.trim() == ConfirmarContrasenia.trim()){
                            auth.createUserWithEmailAndPassword(Email,Contrasenia).addOnCompleteListener{task ->
                                if(task.isSuccessful){
                                    Toast.makeText(context,"Se ha registrado correctamente",Toast.LENGTH_SHORT).show()
                                    onClick()
                                }else{
                                    Toast.makeText(context,"No se ha podido hacer el registro",Toast.LENGTH_SHORT).show()
                                }

                            }
                        }else{
                            Toast.makeText(context,"La contraseña debe ser la misma",Toast.LENGTH_SHORT).show()
                        }
                    //}else{
                        //Toast.makeText(context,"El email debe ser el mismo",Toast.LENGTH_SHORT).show()
                    //}
                }else{
                    Toast.makeText(context,"Todos los campos deben llenarse",Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(ParcheloColors.Prymary)
        ) {
            Text(
                text = stringResource(id = R.string.registrarse),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }

}