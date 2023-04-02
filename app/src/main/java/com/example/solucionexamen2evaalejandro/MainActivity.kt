package com.example.solucionexamen2evaalejandro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.ui.Modifier
import com.example.solucionexamen2evaalejandro.ui.theme.SolucionExamen2EvaAlejandroTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolucionExamen2EvaAlejandroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Ej01()
                }
            }
        }
    }
}

@Composable
fun Ej01() {

    var numCounters by rememberSaveable { mutableStateOf(0) }

    //Función composable (dentro de otra función composable, no sabía que esto era posible) encargada
    //de generar un botón incrementar, seguido de un text con el valor del contador, seguido de un
    //botón decrementar.
    @Composable
    fun Counter() {
        Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center) {
            var counterValue by rememberSaveable { mutableStateOf(0) }
            Button(onClick = { counterValue++ }) {
                Text(text = stringResource(R.string.Incrementar))
            }
            Text(text = counterValue.toString())
            Button(onClick = { counterValue-- }) {
                Text(text = stringResource(R.string.Decrementar))
            }
        }
    }

    Scaffold(topBar = {
        TopAppBar {
            Text(
                text = stringResource(R.string.Contadores),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(0.9F)
                    .padding(start = 16.dp)
            )
            IconButton(onClick = { numCounters = 0 }) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "",
                    modifier = Modifier.weight(0.1F)
                )
            }
        }
    }) {
        if (numCounters == 0) {
            Column(
                modifier = Modifier
                    .padding(paddingValues = it)
                    .fillMaxSize(),
                horizontalAlignment = CenterHorizontally
            ) {
                var text by rememberSaveable { mutableStateOf("") }
                TextField(value = text, onValueChange = { text = it })
                Button(onClick = { numCounters = text.toInt() }) {
                    Text(text = stringResource(R.string.Mostrar))
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(paddingValues = it)
                    .fillMaxSize(),
                horizontalAlignment = CenterHorizontally
            ) {
                for (i in 0 until numCounters) {
                    Counter()
                }
            }
        }
    }
}

