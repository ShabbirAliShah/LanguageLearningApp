package com.example.prototype

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Buttons : AppCompatActivity() {
    private lateinit var  dbReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons)

        val textView=findViewById<TextView>(R.id.myTextView)
        textView.text="Language Learning App"

        val sync:Button=findViewById(R.id.btn1)
        val view:Button=findViewById(R.id.btn2)
        val delete:Button=findViewById(R.id.btn3)

        sync.setOnClickListener{
            Toast.makeText(this ,"Database synced from Firebase",Toast.LENGTH_SHORT).show()
            dbReference = FirebaseDatabase.getInstance().getReference("Languages")
            dbReference.keepSynced(true)
        }

        view.setOnClickListener{
            Toast.makeText(this ,"View Firebase Realtime Database",Toast.LENGTH_SHORT).show()
            val intent= Intent(this, RecyclerView::class.java)
            startActivity(intent)
        }

        delete.setOnClickListener{
            dbReference = FirebaseDatabase.getInstance().getReference("Languages")
            Toast.makeText(this ,"Delete synced Database",Toast.LENGTH_SHORT).show()
            dbReference.removeValue()
        }
    }
}