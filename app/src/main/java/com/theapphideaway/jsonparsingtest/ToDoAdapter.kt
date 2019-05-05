package com.theapphideaway.jsonparsingtest

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.theapphideaway.jsonparsingtest.model.Items
import java.text.SimpleDateFormat

class ToDoAdapter (private val todoItems: List<Items>, private val context: Context):
    RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {

        var itemLayout = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false)

        return ViewHolder(itemLayout)
    }

    override fun getItemCount(): Int {
        return todoItems.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(todoItems[position].title)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(title: String) {
            var titleText: TextView = itemView.findViewById(R.id.todo_title) as TextView
            titleText.text = title
        }
    }
}