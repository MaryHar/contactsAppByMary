package com.example.contactsappbymary

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var adapter:ContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contacts = arrayListOf(
            ContactDesign(R.drawable.avatar1, "Arsen", "094989454"),
            ContactDesign(R.drawable.avatar2, "Narek", "055757575"),
            ContactDesign(R.drawable.avatar3, "Alex", "099123456"),
            ContactDesign(R.drawable.avatar4, "Angelina", "077445566"),
            ContactDesign(R.drawable.avatar5, "Alik", "098979695"),
            ContactDesign(R.drawable.avatar20, "Karen", "055667788"),
            ContactDesign(R.drawable.avatar6, "Mari", "077889977"),
            ContactDesign(R.drawable.avatar7, "Vardan", "094989455"),
            ContactDesign(R.drawable.avatar8, "Monika", "055667788"),
            ContactDesign(R.drawable.avatar9, "Aram", "094989454"),
            ContactDesign(R.drawable.avatar10, "Maria", "077757575"),
            ContactDesign(R.drawable.avatar11, "Sargis", "099999999"),
            ContactDesign(R.drawable.avatar12, "Armen", "094949494"),
            ContactDesign(R.drawable.avatar13, "Adriana", "094989454"),
            ContactDesign(R.drawable.avatar14, "Rocky", "055757575"),
            ContactDesign(R.drawable.avatar15, "Aro", "099123456"),
            ContactDesign(R.drawable.avatar16, "Angelina", "077445566"),
            ContactDesign(R.drawable.avatar17, "Meecky", "098979695"),
            ContactDesign(R.drawable.avatar18, "Mari", "077889977"),
            ContactDesign(R.drawable.avatar19, "Vardan", "094989455"),
            ContactDesign(R.drawable.avatar9, "Aram", "094989454"),
            ContactDesign(R.drawable.avatar10, "Maria", "077757575"),
            ContactDesign(R.drawable.avatar11, "Sargis", "099999999"),
            ContactDesign(R.drawable.avatar12, "Armen", "094949494"),
            )

        val recycleView = findViewById<RecyclerView>(R.id.myRec)
        recycleView.layoutManager = LinearLayoutManager(this)
        adapter = ContactAdapter(this, contacts)
        recycleView.adapter = adapter

        val addContact = findViewById<ImageView>(R.id.addImage)
        val editName = findViewById<EditText>(R.id.editName)
        val editNumber = findViewById<EditText>(R.id.editNumber)

        addContact.setOnClickListener{
            Dialog(this).apply {
                setContentView(R.layout.add_update)

                val createBtn = findViewById<Button>(R.id.buttonCreate)
                createBtn.setOnClickListener {
                    if(editName.text.toString() != "" && editNumber.text.toString() != ""){
                        contacts.add(
                            ContactDesign(
                                R.drawable.avatar7,
                                editName.text.toString(),
                                editNumber.text.toString())
                        )

                        adapter.notifyItemChanged(contacts.size - 1)
                        dismiss()
                    }else{
                        Toast.makeText(this@MainActivity, "Please fill  all required fields", Toast.LENGTH_SHORT).show()
                    }
                }

                val cancelButton = findViewById<Button>(R.id.buttonCreate)
                cancelButton.setOnClickListener{
                    dismiss()
                }

                show()
            }
        }
    }
}