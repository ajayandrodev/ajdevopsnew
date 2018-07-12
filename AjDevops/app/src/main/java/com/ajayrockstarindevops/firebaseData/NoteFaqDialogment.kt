package com.ajayrockstarindevops.firebaseData


import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.fragments.FaqFragment
import com.ajayrockstarindevops.model.Note
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_note_faq_dialogment.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NoteFaqDialogment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class NoteFaqDialogment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var myContext: FragmentActivity? = null
    private var firestoreDB: FirebaseFirestore? = null
    private val TAG = "AddNoteFaqFragmemt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_note_faq_dialogment, container, false)
        //getting recyclerview from xml
        firestoreDB = FirebaseFirestore.getInstance()
        val btAdd = view.findViewById(R.id.btAdd) as Button
        btAdd.setOnClickListener {
            val content = edtContent.text.toString()

            if (content.isEmpty()) {
                Toast.makeText(context, "Please Enter The Question!", Toast.LENGTH_SHORT).show()

            } else if (content.isNotEmpty()) {
                addNote(content)
            }
        }
        return view;
    }

    private fun addNote(content: String) {
        val note = Note(content).toMapFag()
        println(content)

        firestoreDB!!.collection("notesFaq")
                .add(note)
                .addOnSuccessListener { documentReference ->
                    dialog.dismiss()
                    Log.e(TAG, "DocumentSnapshot written with ID: " + documentReference.id)
                    Toast.makeText(context, "Note has been added!", Toast.LENGTH_SHORT).show()
                    var fragment: Fragment? = null
                    fragment = FaqFragment()
                    if (fragment != null) {
                        val ft = myContext?.supportFragmentManager?.beginTransaction()
                        ft?.replace(R.id.mainFrame, fragment)
                        ft?.commit()
                    }
                }
                .addOnFailureListener { e ->
                    Log.e(TAG, "Error adding Note document", e)
                    Toast.makeText(context, "Note could not be added!", Toast.LENGTH_SHORT).show()
                }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NoteFaqDialogment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                NoteFaqDialogment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
