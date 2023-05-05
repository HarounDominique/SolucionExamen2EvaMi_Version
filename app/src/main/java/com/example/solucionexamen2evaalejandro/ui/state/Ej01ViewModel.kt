package com.example.solucionexamen2evaalejandro.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class Ej01ViewModel(): ViewModel(){
    private var _numCounters by mutableStateOf(0)
    val numCounters get() = _numCounters

    private var _textFieldValue by mutableStateOf("")
    val textFieldValue get() = _textFieldValue

    private var _counterValue by mutableStateOf(0)
    val counterValue get() = _counterValue


    fun changeNumCounters(number: Int){
        _numCounters = number
    }


    fun setNumCounters(text:String){
        _numCounters = text.toIntOrNull() ?: 0; setTextFieldValue("")

    }

    fun setTextFieldValue(text:String){
        _textFieldValue = text
    }

    fun incrementCounterValue(){
        _counterValue++
    }

    fun decrementCounterValue(){
        _counterValue--
    }
}
