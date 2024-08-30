package com.example.parchelo.Screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parchelo.R
import com.example.parchelo.ui.theme.ParcheloColors
import com.google.firebase.auth.FirebaseAuth

@Composable
fun inicioSesion(onclick : () -> Unit, auth : FirebaseAuth){
    var context = LocalContext.current

    var usuario : String by remember{ mutableStateOf("") }
    var contrasenia: String by remember{ mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ParcheloColors.Blanco),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .padding(bottom = 40.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "LogoParchelo"
        )
        TextField(
            modifier = Modifier.padding(bottom = 40.dp),
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text(text = stringResource(id = R.string.usuario), color = Color.Gray) },
            leadingIcon = {
                Box {
                    Icon(
                        modifier = Modifier.fillMaxSize(0.05f),
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = stringResource(id = R.string.usuario)
                    )
                }
            }
        )
        TextField(
            modifier = Modifier.padding(bottom = 5.dp),
            value = contrasenia,
            onValueChange = { contrasenia = it },
            label = { Text(text = stringResource(id = R.string.contrasenia), color = Color.Gray) },
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Box {
                    Icon(
                        painter = painterResource(id = R.drawable.candado),
                        contentDescription = stringResource(id = R.string.contrasenia)
                    )
                }
            }
        )

        Text(
            modifier = Modifier.padding(bottom = 40.dp),
            text = stringResource(id = R.string.usuarioycontrasenia),
            textDecoration = TextDecoration.Underline
        )


        Button(
            modifier = Modifier.padding(bottom = 35.dp),
            onClick = {
                if(usuario.isNotEmpty() && contrasenia.isNotEmpty()) {
                    auth.signInWithEmailAndPassword(usuario, contrasenia).addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(context, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                                onclick()
                            } else {
                                Toast.makeText(context, "Usuario o Contraseña incorrectos", Toast.LENGTH_SHORT).show()
                            }
                        }
                } else{
                    Toast.makeText(context, "Ingrese Usuario y Contraseña", Toast.LENGTH_SHORT).show()
                }
                      },
            colors = ButtonDefaults.buttonColors(ParcheloColors.Prymary)
        ) {
            Text(
                text = stringResource(id = R.string.inicioSesion),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .height(40.dp)
                .padding(5.dp)
        ) {
            Image(
                modifier = Modifier.padding(end = 50.dp),
                painter = painterResource(id = R.drawable.gmail),
                contentDescription = "gmail"
            )
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "facebook"
            )
        }

        Row {
            Text(
                modifier = Modifier.padding(end = 2.dp),
                text = stringResource(id = R.string.notienescuenta)
            )
            Text(
                modifier = Modifier.clickable {

                },
                text = stringResource(id = R.string.registrarse),
                textDecoration = TextDecoration.Underline)
        }

    }
}