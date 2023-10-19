package com.example.prototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity:AppCompatActivity(){
private lateinit var dbReference: DatabaseReference
private lateinit var languageRecyclerview: RecyclerView
private lateinit var languageArrayList: ArrayList<FirebaseData>
private lateinit var database: AppDatabase
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "app_database").build()

    // Example usage, such as when a button is clicked

        val firebaseData = FirebaseData(country = "Country Name", language = "Language", no = 1)
        val countryEntity = CountryEntity(country = firebaseData.country, language = firebaseData.language, no = firebaseData.no)

        // Insert data into the local database
        insertData(countryEntity)
}
    private fun insertData(countryEntity: CountryEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            database.countryDao().insert(countryEntity)
        }

    languageRecyclerview = findViewById(R.id.langView)
    languageRecyclerview.layoutManager = LinearLayoutManager(this)
    languageRecyclerview.setHasFixedSize(true)
    languageArrayList = arrayListOf<FirebaseData>()
    getLangData()
}
private fun getLangData() {
    dbReference = FirebaseDatabase.getInstance().getReference("Languages")
    dbReference.addValueEventListener(object: ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {

            if (snapshot.exists()) {
                for (langSnap in snapshot.children) {
                    val language = langSnap.getValue(FirebaseData::class.java)
                    languageArrayList.add(language!!)

                }
                languageRecyclerview.adapter = DbAdapter( languageArrayList)
            }
        }

        override fun onCancelled(error: DatabaseError) {

        }
    })

}

}