package com.ajayrockstarindevops.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.ajayrockstarindevops.adapter.MavenAdapter.MavenAdapter

import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.MavenModel.MavenModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MavenFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MavenFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MavenFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_maven, container, false)
        //getting recyclerview from xml
        val recyclerView = view.findViewById(R.id.recyclerView_maven) as RecyclerView
        //adding a layoutmanager
        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        //crating an arraylist to store users using the data class user
        val users = ArrayList<MavenModel>()
        //adding some dummy data to the list
        users.add(MavenModel("MAVEN HISTORY"))
        users.add(MavenModel("MAVEN COMMANDS"))
        users.add(MavenModel("MAVEN INTERVIEW QUESTIONS"))
        users.add(MavenModel("MAVEN ADDITIONAL INFORMATION"))
        //creating our adapter
        val adapter = MavenAdapter(users)
        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
        return view;
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MavenFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                MavenFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
