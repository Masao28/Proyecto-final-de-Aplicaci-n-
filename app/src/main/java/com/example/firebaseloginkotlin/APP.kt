package com.example.firebaseloginkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_app.*

class APP : AppCompatActivity() {
    private val marksRef = FirebaseDatabase.getInstance().getReference("marks")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
///boton de regreso al menu
        val btn: Button = findViewById(R.id.appregresar)
        btn.setOnClickListener {
            val intent: Intent = Intent( this, Inicio::class.java)
            startActivity( intent)}
//// mandar datos a la base de datos

        save_button2.setOnClickListener { saveMarkFromForm() }

        marksRef.addChildEventListener(object : ChildEventListener {
            override fun onCancelled(databaseError: DatabaseError) {}
            override fun onChildMoved(dataSnapshot: DataSnapshot, previousName: String?) {}
            override fun onChildChanged(dataSnapshot: DataSnapshot, previousName: String?) {}
            override fun onChildRemoved(dataSnapshot: DataSnapshot) {}

            override fun onChildAdded(dataSnapshot: DataSnapshot, p1: String?) {
                val mark = dataSnapshot.getValue(Mark::class.java)
                if (mark != null) writeMark(mark)
            }
        })
    }

    private fun saveMarkFromForm() {
        val mark = Mark(
            name_editText2.text.toString(),
            subject_editText2.text.toString(),
            mark_editText2.text.toString()
        )
        marksRef.push().setValue(mark)
    }

    private fun writeMark(mark: Mark) {
        val text = list_textView2.text.toString() + mark.toString() + "\n"
        list_textView2.text = text





    }

}