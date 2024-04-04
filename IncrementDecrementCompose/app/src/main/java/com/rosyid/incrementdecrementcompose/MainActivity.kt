package com.rosyid.incrementdecrementcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rosyid.incrementdecrementcompose.ui.theme.IncrementDecrementComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IncrementDecrementComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Count()
                }
            }
        }
    }
}

@Composable
fun Count() {
    var count by remember {
        mutableStateOf(0)
    }
    operator(count, increment = {count++}, decrement = {count--}, reset = {count = 0})
}

@Composable
fun operator(
    count: Int,
    increment: () -> Unit,
    decrement: () -> Unit,
    reset: () -> Unit
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "You have pushed the button this many times:")
        Text(
            text = "$count",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp)
        Spacer(modifier = Modifier.padding(5.dp))
        Button(onClick = increment) {
            Text(text = "Add")
        }
        Button(onClick = decrement) {
            Text(text = "Remove")
        }
        Button(onClick = reset) {
            Text(text = "Reset")
        }
    }
}

