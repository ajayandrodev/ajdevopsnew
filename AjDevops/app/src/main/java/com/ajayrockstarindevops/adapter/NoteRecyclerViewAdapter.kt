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

import android.content.Intent
import android.support.v4.app.Fragment
import com.ajayrockstarindevops.ajdevops.NoteActivity
import android.widget.Toast
import com.ajayrockstarindevops.firebaseData.NoteFragment
import com.ajayrockstarindevops.model.Note
import android.support.v7.app.AppCompatActivity


class NoteRecyclerViewAdapter(private val notesList: MutableList<Note>, private val context: Context,
                              private val firestoreDB: FirebaseFirestore) : RecyclerView.Adapter<NoteRecyclerViewAdapter.ViewHolder>() {
    var appCompatActivity: AppCompatActivity? = null
    var fragment: Fragment? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_note, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notesList[position]

        holder!!.title.text = note.title
        holder.content.text = note.content
        holder.name.text = note.name

        holder.edit.setOnClickListener { updateNote(note) }
        holder.delete.setOnClickListener { deleteNote(note.id!!, position) }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var title: TextView
        internal var content: TextView
        internal var name: TextView
        internal var edit: ImageView
        internal var delete: ImageView

        init {
            title = view.findViewById(R.id.tvTitle)
            content = view.findViewById(R.id.tvContent)
            name = view.findViewById(R.id.tvName)

            edit = view.findViewById(R.id.ivEdit)
            delete = view.findViewById(R.id.ivDelete)
        }
    }

    private fun updateNote(note: Note) {
        /*  val intent = Intent(context, NoteActivity::class.java)
          intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
          intent.putExtra("UpdateNoteId", note.id)
          intent.putExtra("UpdateNoteTitle", note.title)
          intent.putExtra("UpdateNoteContent", note.content)
          intent.putExtra("UpdateNoteName", note.name)
          context.startActivity(intent)*/
        Toast.makeText(context, "Note has been updated!", Toast.LENGTH_SHORT).show()
      /*  var fragment: Fragment? = null
        appCompatActivity?.getSupportActionBar()?.setTitle("esw")
        fragment = NoteFragment.newInstance()
        //NOTE: Fragment changing code
        if (fragment != null) {
            val ft = appCompatActivity?.supportFragmentManager?.beginTransaction()
            ft?.replace(R.id.mainFrame, fragment)
            ft?.commit()

        }*/


    }

    private fun deleteNote(id: String, position: Int) {
        firestoreDB.collection("notes")
                .document(id)
                .delete()
                .addOnCompleteListener {
                    notesList.removeAt(position)
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, notesList.size)
                    Toast.makeText(context, "Note has been deleted!", Toast.LENGTH_SHORT).show()
                }
    }
}