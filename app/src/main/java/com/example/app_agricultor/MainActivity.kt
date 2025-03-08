package com.example.app_agricultor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_agricultor.ui.theme.AppagricultorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppagricultorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Llamamos a la función LoginScreen aquí
                    LoginScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoginSuccessful by remember { mutableStateOf<Boolean?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.my_second_icon),
            contentDescription = "My Second Icon",
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .size(600.dp, 200.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.my_first_icon),
            contentDescription = "My First Icon",
            modifier = Modifier
                .size(300.dp, 100.dp)
                //.align(Alignment.Center) // Centra la imagen
                .offset(x = 0.dp, y = (-70).dp)
                .alpha(0.5f)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = AnnotatedString("Comercializadora"),
            style = TextStyle(fontSize = 25.sp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = AnnotatedString("Iniciar Sesión"),
            style = TextStyle(fontSize = 14.sp)
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(90.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Leyenda "¿Olvidaste tu contraseña?"
        ClickableText(
            text = AnnotatedString("¿Olvidaste tu contraseña?"),
            onClick = { /* Aquí iría la lógica para recuperar la contraseña */ },
            style = TextStyle(fontSize = 14.sp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                isLoginSuccessful = validateLogin(username, password)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar Sesión")
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Botón de "Registrarse"
        Button(
            onClick = { /* Aquí iría la lógica para registrarse */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrarse")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isLoginSuccessful != null) {
            if (isLoginSuccessful == true) {
                Text("Inicio de sesión exitoso")
            } else {
                Text("Usuario o contraseña incorrectos")
            }
        }
    }
}

fun validateLogin(username: String, password: String): Boolean {
    // Aquí iría la lógica de validación real
    // Por ejemplo, comprobar contra una base de datos
    return username == "usuario" && password == "contraseña"
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AppagricultorTheme {
        LoginScreen()
    }
}