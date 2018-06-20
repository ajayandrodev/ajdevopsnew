package com.ajayrockstarindevops.firebaseData


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.content.Intent
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.ajayrockstarindevops.model.Note
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.ajayrockstarindevops.adapter.NoteRecyclerViewAdapter
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.firebaseData.NoteFragment
import kotlinx.android.synthetic.main.fragment_main.*
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuInflater;
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val TAG = "MainActivity"

    private var mAdapter: NoteRecyclerViewAdapter? = null

    private var firestoreDB: FirebaseFirestore? = null
    private var firestoreListener: ListenerRegistration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            setHasOptionsMenu(true);
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        //getting recyclerview from xml
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

                    mAdapter = NoteRecyclerViewAdapter(notesList, activity!!.applicationContext, firestoreDB!!)
                    rvNoteList.adapter = mAdapter
                })
        return view;
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

                        mAdapter = NoteRecyclerViewAdapter(notesList, activity!!.applicationContext, firestoreDB!!)
                        val mLayoutManager = LinearLayoutManager(context)
                        rvNoteList.layoutManager = mLayoutManager
                        rvNoteList.itemAnimator = DefaultItemAnimator()
                        rvNoteList.adapter = mAdapter
                    } else {
                        Log.d(TAG, "Error getting documents: ", task.exception)
                    }
                }
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        activity?.menuInflater?.inflate(R.menu.menu_main, menu)

        return  super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        super.onPrepareOptionsMenu(menu)
        val menuItem = menu?.findItem(R.id.addNote)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            if (item.itemId == R.id.addNote) {
                var fragment: Fragment? = null
                if (fragment != null) {
                    (activity as AppCompatActivity).supportActionBar?.setTitle("ADD NOTES")
                    fragment = NoteFragment()
                    val ft = activity?.supportFragmentManager?.beginTransaction()
                    ft?.replace(R.id.mainFrame, fragment)
                    ft?.commit()
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        /*
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                MainFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
