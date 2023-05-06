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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.solucionexamen2evaalejandro.R
import com.example.solucionexamen2evaalejandro.ui.state.ej01ViewModel


//Función composable (dentro de otra función composable, no sabía que esto era posible) encargada
//de generar un botón incrementar, seguido de un text con el valor del contador, seguido de un
//botón decrementar.

@Composable
fun Counter(
    index: Int,
    onClickStartButton: () -> Unit,
    onClickEndButton: () -> Unit,
    startButtonText: String = stringResource(R.string.Incrementar),
    endButtonText: String = stringResource(R.string.Decrementar),
    viewModel: ej01ViewModel
) {
    viewModel.counterValueList[index]=0
    Row(
        modifier = Modifier.fillMaxWidth(),
        Arrangement.SpaceEvenly
    ) {
        Button(onClick = { onClickEndButton}, enabled = viewModel.counterValueList[index]<=0) {
            Text(text = endButtonText)
        }
        Text(text = viewModel.counterValueList[index].toString())
        //la propiedad enabled es la solución de Alejandro; yo había habilitado el efecto del
        //decremento en el onClick
        Button(onClick = { onClickStartButton}) {
            Text(text = startButtonText)
        }
    }
}


@Composable
fun Ej01() {

    val ej01ViewModel: ej01ViewModel = viewModel()

    Scaffold(topBar = {
        TopAppBar {
            Text(
                text = stringResource(R.string.Contadores),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(0.9F)
                    .padding(start = 16.dp)
            )
            IconButton(onClick = { ej01ViewModel.setNumberOfCounters("0") }) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    contentDescription = "",
                    modifier = Modifier.weight(0.1F)
                )
            }
        }
    }) {
        if (ej01ViewModel.numberOfCounters == 0) {
            Column(
                modifier = Modifier
                    .padding(paddingValues = it)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = ej01ViewModel.textFieldValue,
                    onValueChange = { ej01ViewModel.setTextFieldValue(it) })
                Button(onClick = { ej01ViewModel.setNumberOfCounters(ej01ViewModel.textFieldValue) }) {
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
                for (it in 0..ej01ViewModel.numberOfCounters) {
                    Counter(
                        //number = ej01ViewModel.counterValueList[it],
                        index = it,
                        onClickEndButton = { ej01ViewModel.decrementCounterValue(it) },
                        onClickStartButton = { ej01ViewModel.incrementCounterValue(it) },
                        viewModel = ej01ViewModel
                    )
                }/*
                repeat(Ej01ViewModel.numCounters) {
                    Counter(Ej01ViewModel, it)

                }
                */
            }
        }
    }
}