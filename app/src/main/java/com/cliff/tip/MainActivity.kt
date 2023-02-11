package com.cliff.tip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.cliff.tip.ui.theme.TipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TipScreen()
                }
            }
        }
    }
}

@Composable
fun TipScreen(){
    var amount by remember {
        mutableStateOf("")
    }

    var tip by remember{ mutableStateOf("")}
    fun calc (num:Double) {
        tip = "KES" + num.times(0.15).toString()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Tip Calculator")
        TextField(value = amount, onValueChange = {input -> amount = input}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) )
        Button(onClick = { calc(amount.toDouble()) }) {
            Text(text = "Generate")
        }
        Text(text = tip)
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipTheme {
        TipScreen()
    }
}