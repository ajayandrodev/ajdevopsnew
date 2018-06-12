package com.ajayrockstarindevops.ajdevops


/**
 * Created by Ajay on 6/12/2018.
 */
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

import com.google.firebase.firestore.FirebaseFirestore
import com.ajayrockstarindevops.model.Note

import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : AppCompatActivity() {

    private val TAG = "AddNoteActivity"

    private var firestoreDB: FirebaseFirestore? = null
    internal var id: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        firestoreDB = FirebaseFirestore.getInstance()

        val bundle = intent.extras
        if (bundle != null) {
            id = bundle.getString("UpdateNoteId")

            edtTitle.setText(bundle.getString("UpdateNoteTitle"))
            edtContent.setText(bundle.getString("UpdateNoteContent"))
            edtName.setText(bundle.getString("UpdateNoteName"))

        }

        btAdd.setOnClickListener {
            val title = edtTitle.text.toString()
            val content = edtContent.text.toString()
            val name = edtName.text.toString()

            if (title.isNotEmpty()) {
                if (id.isNotEmpty()) {
                    updateNote(id, title, content, name)
                } else {
                    addNote(title, content, name)
                }
            }

            finish()
        }
    }

    private fun updateNote(id: String, title: String, content: String, name: String) {
        val note = Note(id, title, content, name).toMap()

        firestoreDB!!.collection("notes")
                .document(id)
                .set(note)
                .addOnSuccessListener {
                    Log.e(TAG, "Note document update successful!")
                    Toast.makeText(applicationContext, "Note has been updated!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Log.e(TAG, "Error adding Note document", e)
                    Toast.makeText(applicationContext, "Note could not be updated!", Toast.LENGTH_SHORT).show()
                }
    }

    private fun addNote(title: String, content: String, name: String) {
        val note = Note(title, content, name).toMap()

        firestoreDB!!.collection("notes")
                .add(note)
                .addOnSuccessListener { documentReference ->
                    Log.e(TAG, "DocumentSnapshot written with ID: " + documentReference.id)
                    Toast.makeText(applicationContext, "Note has been added!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Log.e(TAG, "Error adding Note document", e)
                    Toast.makeText(applicationContext, "Note could not be added!", Toast.LENGTH_SHORT).show()
                }
    }
}