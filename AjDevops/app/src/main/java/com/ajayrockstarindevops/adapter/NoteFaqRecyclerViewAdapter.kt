package com.ajayrockstarindevops.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.Note
import com.google.firebase.firestore.FirebaseFirestore


/**
 * Created by Ajay on 7/10/2018.
 */
class NoteFaqRecyclerViewAdapter(private val notesList: MutableList<Note>, private val context: Context,
                                 private val firestoreDB: FirebaseFirestore) : RecyclerView.Adapter<NoteFaqRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_faq_note, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notesList[position]

        holder.content.text = note.content

    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var content: TextView


        init {
            content = view.findViewById(R.id.tvContent)


        }
    }
}

