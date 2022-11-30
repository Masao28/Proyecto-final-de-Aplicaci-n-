package com.example.firebaseloginkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_usuario_datos.*

class UsuarioDatos : AppCompatActivity() {
    private val marks2Ref = FirebaseDatabase.getInstance().getReference("marks2")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario_datos)



        /// botton de regreso a inicio
        val btn: Button = findViewById(R.id.regre22)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }
////////////////////////////////
        save_button2.setOnClickListener { saveMarkFromForm() }

        marks2Ref.addChildEventListener(object : ChildEventListener {
            override fun onCancelled(databaseError: DatabaseError) {}
            override fun onChildMoved(dataSnapshot: DataSnapshot, previousName: String?) {}
            override fun onChildChanged(dataSnapshot: DataSnapshot, previousName: String?) {}
            override fun onChildRemoved(dataSnapshot: DataSnapshot) {}

            override fun onChildAdded(dataSnapshot: DataSnapshot, p1: String?) {
                val mark2 = dataSnapshot.getValue(Mark2::class.java)
                if (mark2!= null) writeMark(mark2)
            }
        })
    }

    private fun saveMarkFromForm() {
        val mark2 = Mark2(
            name_editText2.text.toString(),
            subject_editText2.text.toString(),
            mark_editText2.text.toString().toDouble()
        )
        marks2Ref.push().setValue(mark2)
    }

    private fun writeMark(mark2: Mark2) {
        val text = list_textView2.text.toString() + mark2.toString() + "\n"
        list_textView2.text = text
    }
}



