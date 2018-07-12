package com.ajayrockstarindevops.adapter


/**
 * Created by Ajay on 6/12/2018.
 */
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.google.firebase.firestore.FirebaseFirestore
import com.ajayrockstarindevops.ajdevops.R

import android.support.v4.app.Fragment
import android.widget.Toast
import com.ajayrockstarindevops.model.Note
import android.support.v7.app.AppCompatActivity


class NoteRecyclerViewAdapter(private val notesList: MutableList<Note>, private val context: Context,
                              private val firestoreDB: FirebaseFirestore) : RecyclerView.Adapter<NoteRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_note, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notesList[position]

        holder.title.text = note.title
        holder.content.text = note.content
        holder.name.text = note.name
        holder.date.text =note.date

    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var title: TextView
        internal var content: TextView
        internal var name: TextView
        internal var date: TextView


        init {
            title = view.findViewById(R.id.tvTitle)
            content = view.findViewById(R.id.tvContent)
            name = view.findViewById(R.id.tvName)
            date = view.findViewById(R.id.tvDate)


        }
    }


}