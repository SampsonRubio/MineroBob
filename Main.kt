package com.example.minerobob

import kotlin.random.Random

fun main (){
    val oro = Random.nextInt(1,3)
    val fatiga = Random.nextInt(1,5)

    val minerBob = Minero("Bob",fatiga,0,oro,estadoBob.MINA)
    minerBob.estadoMinero()
}