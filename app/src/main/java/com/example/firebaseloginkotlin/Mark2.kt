package com.example.firebaseloginkotlin


data class Mark2(val nombre: String = "", val direccion: String = "", val numero:Double= 0.0) {

    override fun toString() = nombre + "\t" + direccion + "\t" + numero
}