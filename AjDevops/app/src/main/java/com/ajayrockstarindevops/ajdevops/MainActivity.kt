package com.ajayrockstarindevops.ajdevops

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.ajayrockstarindevops.model.Note

import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.ajayrockstarindevops.adapter.NoteRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private var mAdapter: NoteRecyclerViewAdapter? = null

    private var firestoreDB: FirebaseFirestore? = null
    private var firestoreListener: ListenerRegistration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firestoreDB = FirebaseFirestore.getInstance()

        loadNotesList()

        firestoreListener = firestoreDB!!.collection("notes")
                .addSnapshotListener(EventListener { documentSnapshots, e ->
                    if (e != null) {
                        Log.e(TAG, "Listen failed!", e)
                        return@EventListener
                    }

                    val notesList = mutableListOf<Note>()

                    for (doc in documentSnapshots) {
                        val note = doc.toObject(Note::class.java)
                        note.id = doc.id
                        notesList.add(note)
                    }

                    mAdapter = NoteRecyclerViewAdapter(notesList, applicationContext, firestoreDB!!)
                    rvNoteList.adapter = mAdapter
                })
    }

    override fun onDestroy() {
        super.onDestroy()

        firestoreListener!!.remove()
    }

    private fun loadNotesList() {
        firestoreDB!!.collection("notes")
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val notesList = mutableListOf<Note>()

                        for (doc in task.result) {
                            val note = doc.toObject<Note>(Note::class.java)
                            note.id = doc.id
                            notesList.add(note)
                        }

                        mAdapter = NoteRecyclerViewAdapter(notesList, applicationContext, firestoreDB!!)
                        val mLayoutManager = LinearLayoutManager(applicationContext)
                        rvNoteList.layoutManager = mLayoutManager
                        rvNoteList.itemAnimator = DefaultItemAnimator()
                        rvNoteList.adapter = mAdapter
                    } else {
                        Log.d(TAG, "Error getting documents: ", task.exception)
                    }
                }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            if (item.itemId == R.id.action_settings) {
                val intent = Intent(this, NoteActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
