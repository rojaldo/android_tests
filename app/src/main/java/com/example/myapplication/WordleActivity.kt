package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WordleActivity : AppCompatActivity() {
    private val word = "gatos"

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


        // This will pass the ArrayList to our Adapter
        var adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        var recyclerAdapter = recyclerview.adapter
        recyclerview.adapter = adapter



        var editTextView = findViewById<EditText>(R.id.editTextSample)
        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            if (editTextView.text.toString().length == 5) {
                data.add(ItemsViewModel(editTextView.text.toString(), handleString((editTextView.text.toString()))))
                adapter.notifyDataSetChanged()
                editTextView.text.clear()
            }
        }


    }

    private fun handleString(str: String): ArrayList<LetterState> {
        // move through the string and create a list of LetterState
        var list = ArrayList<LetterState>()
        Log.d("handleString", "handleString: " + str + " : " + word)
        for (i in 0 until str.length) {
            Log.d("handleString", "handleString: " + str[i] + " : " + word[i])

            // else if letter is in the word in the same position
            if (word[i] == str[i]) {
                list.add(LetterState.RIGHT)
            }else if (this.word.toUpperCase().contains(str[i].toUpperCase())) {
                list.add(LetterState.MISSPLACED)
            }
            else {
                list.add(LetterState.WRONG)
            }
        }
        return list
    }

}


    enum class LetterState {
        WHITE,
    WRONG,
    MISSPLACED,
    RIGHT,
}