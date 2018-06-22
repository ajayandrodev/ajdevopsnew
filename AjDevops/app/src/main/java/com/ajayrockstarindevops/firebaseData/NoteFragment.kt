package com.ajayrockstarindevops.firebaseData


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.util.Log
import android.view.Menu
import android.widget.Button
import android.widget.Toast

import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.Note
import com.google.firebase.firestore.FirebaseFirestore
import android.support.v4.app.FragmentActivity
import android.widget.ImageView
import kotlinx.android.synthetic.main.fragment_note.*
import android.app.DatePickerDialog
import android.widget.DatePicker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "UpdateNoteId"
private const val ARG_PARAM2 = "UpdateNoteTitle"
private const val ARG_PARAM3 = "UpdateNoteContent"
private const val ARG_PARAM4 = "UpdateNoteName"

/**
 * A simple [Fragment] subclass.
 * Use the [NoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class NoteFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var param4: String? = null
    private val TAG = "AddNoteFragmemt"
    private var myContext: FragmentActivity? = null
    private var firestoreDB: FirebaseFirestore? = null
    internal var id: String = ""
    private val myCalendar = Calendar.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true);
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
            param4 = it.getString(ARG_PARAM4)
/*
            if (param1 != null && param2 != null && param3 != null && param4 != null) {
                edtTitle.setText(param2)
                edtContent.setText(param3)
                edtName.setText(param4)
            }
*/

        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        myContext = activity as FragmentActivity
        super.onAttach(activity)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_note, container, false)
        //getting recyclerview from xml
        firestoreDB = FirebaseFirestore.getInstance()
        val btAdd = view.findViewById(R.id.btAdd) as Button
        val btCal = view.findViewById(R.id.img_calender) as ImageView

        val datePickerListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "MM-dd-yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            edDate.setText(sdf.format(myCalendar.time))
        }

        btCal.setOnClickListener {
            DatePickerDialog(context, datePickerListener, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
        btAdd.setOnClickListener {
            val date = edDate.text.toString()
            val title = edtTitle.text.toString()
            val content = edtContent.text.toString()
            val name = edtName.text.toString()

            if (date.isEmpty()) {
                Toast.makeText(context, "Please Enter Current Date!", Toast.LENGTH_SHORT).show()

            } else if (name.isEmpty()) {
                Toast.makeText(context, "Please Enter The Name!", Toast.LENGTH_SHORT).show()

            } else if (title.isEmpty()) {
                Toast.makeText(context, "Please Enter The Title!", Toast.LENGTH_SHORT).show()

            } else if (content.isEmpty()) {
                Toast.makeText(context, "Please Enter The Content!", Toast.LENGTH_SHORT).show()

            } else if (date.isNotEmpty() && title.isNotEmpty() && content.isNotEmpty() && name.isNotEmpty()) {
                addNote(date, title, content, name)

            }


        }

        return view;
    }


    private fun addNote(date: String, title: String, content: String, name: String) {
        val note = Note(date, title, content, name).toMap()
        println(date)

        firestoreDB!!.collection("notes")
                .add(note)
                .addOnSuccessListener { documentReference ->
                    Log.e(TAG, "DocumentSnapshot written with ID: " + documentReference.id)
                    Toast.makeText(context, "Note has been added!", Toast.LENGTH_SHORT).show()
                    var fragment: Fragment? = null
                    fragment = MainFragment()
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
         * @return A new instance of fragment NoteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: String, param4: String) =
                NoteFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                        putString(ARG_PARAM3, param3)
                        putString(ARG_PARAM4, param4)
                    }
                }

        fun newInstance() =
                NoteFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        menu?.clear();
    }
}
