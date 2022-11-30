package com.example.firebaseloginkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)


        /// boton de regresar a perfil
        val btn: Button = findViewById(R.id.regre)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        /////Boton de informacion
        val btn2: ImageButton = findViewById(R.id.informacion2)
        btn2.setOnClickListener {
            val intent: Intent = Intent(this, Informacion::class.java)
            startActivity(intent)

        }
        /////Boton de APP
        val btn4: ImageButton = findViewById(R.id.appp2)
        btn4.setOnClickListener {
            val intent: Intent = Intent(this, APP::class.java)
            startActivity(intent)
        }
        /////Boton usuarios
        val btn28: ImageButton = findViewById(R.id.datosusu2)
        btn28.setOnClickListener {
            val intent: Intent = Intent(this, UsuarioDatos::class.java)
            startActivity(intent)
        }
        /// boton de regresar a perfil
        val btn30: ImageButton = findViewById(R.id.perf)
        btn30.setOnClickListener {
            val intent: Intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }
        /// boton de  especialidades
        val btn305: ImageButton = findViewById(R.id.espec2)
        btn305.setOnClickListener {
            val intent: Intent = Intent(this, Especialidades::class.java)
            startActivity(intent )
       }

    }

}