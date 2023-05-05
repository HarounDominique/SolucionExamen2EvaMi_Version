package com.example.solucionexamen2evaalejandro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.example.solucionexamen2evaalejandro.ui.theme.SolucionExamen2EvaAlejandroTheme
import androidx.compose.runtime.*
import com.example.solucionexamen2evaalejandro.ui.elements.Ej01

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



