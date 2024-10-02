package com.example.style_core

import DbHelper
import Product
import ProductAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton: Button = findViewById(R.id.loginButton)
        val signupButton: Button = findViewById(R.id.signupButton)
        val emailInput: EditText = findViewById(R.id.emailInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)
        val db = DbHelper(this, null)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (db.getUser(email, password)) {
                Toast.makeText(this, "Successfully logged in!", Toast.LENGTH_SHORT).show()

                setContentView(R.layout.activity_main)

                val products = listOf(
                    Product("Cotton T-Shirt", 43.00, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton T-Shirt", 43.00, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton T-Shirt", 43.00, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton T-Shirt", 43.00, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton T-Shirt", 43.00, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton T-Shirt", 43.00, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton T-Shirt", 43.00, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton T-Shirt", 43.00, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton T-Shirt", 43.00, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                    Product("Cotton Style T", 40.50, R.drawable.item1),
                )

                val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
                recyclerView.layoutManager = GridLayoutManager(this, 2)
                recyclerView.adapter = ProductAdapter(products)

            } else {
                Toast.makeText(this, "Invalid login or password", Toast.LENGTH_SHORT).show()
            }
        }


        signupButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val user = User(email, password)
                db.addUser(user)
                Toast.makeText(this, "New account created!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Email or password cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
