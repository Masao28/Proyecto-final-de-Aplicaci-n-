package com.example.firebaseloginkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class Informacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)

        /// botton de regreso a inicio
        val btn: Button = findViewById(R.id.regreinfo)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, Inicio::class.java)
            startActivity(intent)
      }

        /////enviar mensajes a amigos
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "consultorio.consultoriosmilestoluca.com")
            type = "text/plain" }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
 ////


    }
}