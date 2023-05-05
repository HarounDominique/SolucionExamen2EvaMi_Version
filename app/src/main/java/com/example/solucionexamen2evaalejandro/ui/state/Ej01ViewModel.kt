package com.example.solucionexamen2evaalejandro.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.asStateFlow

class Ej01ViewModel() : ViewModel() {

    //lista de contadores
    private val _list = mutableStateListOf<Int>()
    val list get() = _list

    //Valor contenido en cada uno de los contadores
    private val _counterValueList = mutableStateListOf<Int>()
    val counterValueList get() = _counterValueList

    //número de contadores
    private var _numCounters by mutableStateOf(0)
    val numCounters get() = _numCounters

    private var _textFieldValue by mutableStateOf("")
    val textFieldValue get() = _textFieldValue


    private var _counterValue by mutableStateOf(0)
    val counterValue get() = _counterValue


    fun changeNumCounters(number: Int) {
        repeat(number) { _list.add(0) }
    }


    fun setNumCounters(text: String) {

        _numCounters = text.toIntOrNull() ?: 0; setTextFieldValue("")

    }

    fun setTextFieldValue(text: String) {
        _textFieldValue = text
    }

    fun incrementCounterValue() {
        _counterValue++
    }

    fun decrementCounterValue() {
        _counterValue--
    }
}
