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
    /**
     *  初回コンポーズ以外のタイミングでcalculationラムダを再実行したい場合は、rememberにkeyを指定。
     *  再コンポーズ時にkeyが変化していた場合はラムダが再実行され、新しい計算結果を記憶する。
     *  再コンポーズ時にkeyが変化していなかった場合はラムダは実行されず、記憶している直近の計算結果を返す。
     */
//    val count by state.count
//    val eventCount = remember(count) {  // count keyを指定
//        println("remember count: $count")
//        count
//    }
    val count = rememberCount(state)
//    println("eventCount: $eventCount")

//    val count = rememberCount(state)
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

// keyに指定された値が更新されたら再度ラムダ内の処理が走るわけではなく、
// rememberCount()が再Composeされた時にkeyが変更されていたらラムダ内の処理が再度走る
@Composable
fun rememberCount(state: CounterState) = remember(state.count) {
    println("rememberCount")
    state.count
}
@Composable
fun rememberEventCount(count: Int) = remember(count) { // 再Compose時にkeyに指定された値が更新されていたら再度ラムダ内の処理が走る
    count
}