package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class

        // sets the text to the textview from our itemHolder class
        holder.textView0.text = ItemsViewModel.text[0].toString()
        holder.textView1.text = ItemsViewModel.text[1].toString()
        holder.textView2.text = ItemsViewModel.text[2].toString()
        holder.textView3.text = ItemsViewModel.text[3].toString()
        holder.textView4.text = ItemsViewModel.text[4].toString()


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
    }
}
