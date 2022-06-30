package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WordleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wordle)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()


        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..2) {
            data.add(ItemsViewModel(("Item " + i)))
        }

        // This will pass the ArrayList to our Adapter
        var adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        var recyclerAdapter = recyclerview.adapter
        recyclerview.adapter = adapter

        // add 1 element to the list
        data.add(ItemsViewModel(("Item " + 3)))
        adapter.notifyDataSetChanged()


        var editTextView = findViewById<EditText>(R.id.editTextSample)
        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            if(editTextView.text.toString().length == 5) {
                data.add(ItemsViewModel(editTextView.text.toString()))
                adapter.notifyDataSetChanged()
                editTextView.text.clear()
            }
//            data.add(ItemsViewModel(editTextView.text.toString()))
//            editTextView.setText("")
//            Log.i("Recycler", "Button Clicked")
//            adapter.notifyDataSetChanged();


//            recyclerview.adapter = ItemsAdapter(data)
        }

    }
}