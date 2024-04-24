package com.eotw95.trialremember2

import androidx.compose.runtime.mutableStateOf

//object CounterState {
//    var count = mutableStateOf(0)
//
//    fun plus() {
//        count.value += 1
//    }
//    fun minus() {
//        count.value -= 1
//    }
//}

class CounterState() {
    var count = mutableStateOf(0)

    fun plus() {
        count.value += 1
        println("plus count: $count")
    }
    fun minus() {
        count.value -= 1
        println("minus count: $count")
    }
}