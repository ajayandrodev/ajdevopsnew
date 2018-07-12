package com.ajayrockstarindevops.commandsTools


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ajayrockstarindevops.ajdevops.R

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NagiosCommandsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class NagiosCommandsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mAdView : AdView

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
        val view = inflater.inflate(R.layout.fragment_nagios_commands, container, false)
        //initalize ads
        MobileAds.initialize(activity, resources.getString(R.string.addmob_app_id))
        mAdView = view.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        /*  //getting recyclerview from xml
          val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
          //adding a layoutmanager
          recyclerView.setHasFixedSize(true)
          val itemDecor = DividerItemDecoration(context, LinearLayout.VERTICAL)
          recyclerView.addItemDecoration(itemDecor)
          recyclerView.itemAnimator = DefaultItemAnimator()
          recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
          //crating an arraylist to store users using the data class user
          val users = ArrayList<AwsCommandsModel>()
          users.add(AwsCommandsModel("","",""))

          //creating our adapter
          val adapter = AwsCommandsAdapter(users)
          //now adding the adapter to recyclerview
          recyclerView.adapter = adapter*/
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NagiosCommandsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                NagiosCommandsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
