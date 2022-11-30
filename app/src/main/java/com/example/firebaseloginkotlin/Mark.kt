package com.example.firebaseloginkotlin



    data class Mark(val name: String = "", val fecha: String = "", val hora: String = "") {

        override fun toString() = name + "\t" + fecha + "\t" + hora+ "\t"
    }

