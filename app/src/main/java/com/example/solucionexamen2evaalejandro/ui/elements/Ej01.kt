package com.example.solucionexamen2evaalejandro.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.solucionexamen2evaalejandro.R

@Composable
fun Ej01() {

    var numCounters by rememberSaveable { mutableStateOf(0) }

    //Función composable (dentro de otra función composable, no sabía que esto era posible) encargada
    //de generar un botón incrementar, seguido de un text con el valor del contador, seguido de un
    //botón decrementar.

    @Composable
    fun Counter() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            Arrangement.SpaceEvenly
        ) {
            var counterValue by rememberSaveable { mutableStateOf(0) }
            Button(onClick = { counterValue++ }) {
                Text(text = stringResource(R.string.Incrementar))
            }
            Text(text = counterValue.toString())
            //la propiedad enabled es la solución de Alejandro; yo había habilitado el efecto del
            //decremento en el onClick
            Button(onClick = { counterValue--},  enabled = counterValue>=1) {
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
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var text by rememberSaveable { mutableStateOf("") }
                TextField(value = text, onValueChange = { text = it })
                Button(onClick = { numCounters = text.toIntOrNull() ?: 0; text = "" }) {
                    Text(text = stringResource(R.string.Mostrar))
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(paddingValues = it)
                    .fillMaxSize()
                    //la siguiente línea permite el scroll dentro de la column (solución Alejandro;
                    //yo intenté usar una LazyColumn sin éxito)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                for (i in 0 until numCounters) {
                    Counter()
                }
            }
        }
    }
}