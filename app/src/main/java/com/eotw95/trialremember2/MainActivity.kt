package com.eotw95.trialremember2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eotw95.trialremember2.ui.theme.TrialRemember2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val countState = CounterState()
        setContent {
            TrialRemember2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Counter(countState)
                }
            }
        }
    }
}

@Composable
fun Counter(state: CounterState) {
    val count by remember {
        println("remember") // remember{}内の処理は初回の呼び出し時のみ走る。再Compositionでは走らない。
        state.count
    }
//    val count = rememberCount()
//    val count = remember { state.count }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "count: $count")
        Spacer(modifier = Modifier.padding(vertical = 100.dp))
        Button(onClick = { state.plus() }) {
            Text(text = "plus")
        }
        Button(onClick = { state.minus() }) {
            Text(text = "minus")
        }
    }

}

//@Composable
//fun rememberCount() = remember { CounterState.count }