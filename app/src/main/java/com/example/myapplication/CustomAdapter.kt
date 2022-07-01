package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class

        // sets the text to the textview from our itemHolder class
        holder.textView0.text = ItemsViewModel.text[0].toString()
        holder.textView1.text = ItemsViewModel.text[1].toString()
        holder.textView2.text = ItemsViewModel.text[2].toString()
        holder.textView3.text = ItemsViewModel.text[3].toString()
        holder.textView4.text = ItemsViewModel.text[4].toString()

        // put all cells in a array
        val cells = arrayOf(holder.cell0, holder.cell1, holder.cell2, holder.cell3, holder.cell4)
        Log.d("CustomAdapter", "cells: ${cells.indices}")
        for (i in cells.indices) {
            if (ItemsViewModel.colorLetters[i] == LetterState.RIGHT) {
                cells[i].setBackgroundColor(Color.GREEN)
            } else if (ItemsViewModel.colorLetters[i] == LetterState.WRONG) {
                cells[i].setBackgroundColor(Color.RED)
            } else if (ItemsViewModel.colorLetters[i] == LetterState.MISSPLACED) {
                cells[i].setBackgroundColor(Color.YELLOW)
            }

        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView0: TextView = itemView.findViewById(R.id.textView1)
        val textView1: TextView = itemView.findViewById(R.id.textView2)
        val textView2: TextView = itemView.findViewById(R.id.textView3)
        val textView3: TextView = itemView.findViewById(R.id.textView4)
        val textView4: TextView = itemView.findViewById(R.id.textView5)
        val cell0: LinearLayout = itemView.findViewById(R.id.cell_0)
        val cell1: LinearLayout = itemView.findViewById(R.id.cell_1)
        val cell2: LinearLayout = itemView.findViewById(R.id.cell_2)
        val cell3: LinearLayout = itemView.findViewById(R.id.cell_3)
        val cell4: LinearLayout = itemView.findViewById(R.id.cell_4)
    }
}
