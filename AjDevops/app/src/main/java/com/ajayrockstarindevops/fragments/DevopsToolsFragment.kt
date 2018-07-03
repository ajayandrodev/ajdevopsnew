package com.ajayrockstarindevops.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajayrockstarindevops.adapter.DevopsToolAdapter
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.DevopsToolModel
import com.ajayrockstarindevops.util.GridSpacingItemDecoration
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DevopsToolsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DevopsToolsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mAdView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_devops_tools, container, false)
        //getting recyclerview from xml

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(activity, "ca-app-pub-9279514970367399~6950217666")
        mAdView = view.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().addTestDevice("qqqq")
                .build()
        mAdView.loadAd(adRequest)


        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        //adding a layoutmanager
        recyclerView.setHasFixedSize(true)
        val itemDecor = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        val spanCount = 2 // 2 columns
        val spacing = 5 // 10px
        val includeEdge = false
        recyclerView.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing, includeEdge))
        recyclerView.itemAnimator = DefaultItemAnimator()
        //crating an arraylist to store users using the data class user
        val users = ArrayList<DevopsToolModel>()
        //adding some dummy data to the list
        users.add(DevopsToolModel("GIT"))
        users.add(DevopsToolModel("JENKINS"))
        users.add(DevopsToolModel("DOCKER"))
        users.add(DevopsToolModel("ANSIBLE"))
        users.add(DevopsToolModel("MAVEN"))
        users.add(DevopsToolModel("LINUX"))
        /*  users.add(DevopsToolModel("NGINX "))
          users.add(DevopsToolModel("CHEF"))
          users.add(DevopsToolModel("AWS"))
          users.add(DevopsToolModel("PUPPET"))
          users.add(DevopsToolModel("PYTHON"))

          users.add(DevopsToolModel("KUBERNET"))
          users.add(DevopsToolModel("SHELLSCRIPT"))
          users.add(DevopsToolModel("SALTSTACK"))
          users.add(DevopsToolModel("NAGIOS"))
          users.add(DevopsToolModel("ELK"))*/
        //creating our adapter
        val adapter = DevopsToolAdapter(users)
        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DevopsToolsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                DevopsToolsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
