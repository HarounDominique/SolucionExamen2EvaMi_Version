package com.example.solucionexamen2evaalejandro.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ej01ViewModel() : ViewModel() {

//    //número de contadores
//    private val _list = mutableStateListOf<Int>()
//    val list get() = _list

    //Valor contenido en cada uno de los contadores
    private val _counterValueList = mutableStateListOf<Int>()
    val counterValueList get() = _counterValueList

    private var _textFieldValue by mutableStateOf("")
    val textFieldValue get() = _textFieldValue

    //variable que almacena el número de contadores que habrá (por defecto el 0, y hasta que este valor no cambia, no se dispara la segunda pantalla)
    private var _numberOfCounters by mutableStateOf(0)
    val numberOfCounters get() = _numberOfCounters


//    fun changeNumCounters(number: Int) {
//        repeat(number) { _list.add(0) }
//    }

    fun setNumberOfCounters(text: String) {
        //función que en la primera pantalla establece el número total de contadorea que habrá
        // (estos contadores serán inicializados a cero, pero eso no lo hace esta función)
        _counterValueList.add(text.toIntOrNull() ?: 0)
        _numberOfCounters = text.toIntOrNull() ?: 0
    }

//    fun setCounterValue(text: String, int: Int) {
//
//        _counterValueList[int]=(text.toIntOrNull() ?: 0)
//    }

    fun setTextFieldValue(text: String) {
        _textFieldValue = text
    }

    fun incrementCounterValue(int:Int) {
        _counterValueList[int]++
    }

    fun decrementCounterValue(int:Int) {
        _counterValueList[int]--
    }
}
