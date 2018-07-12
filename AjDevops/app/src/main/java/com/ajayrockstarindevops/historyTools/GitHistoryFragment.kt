package com.ajayrockstarindevops.historyTools


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.ajayrockstarindevops.adapter.GitAdapter.GitHistoryAdapter
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.GitModel.GitHistoryModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.fragment_git_history.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GitHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class GitHistoryFragment : Fragment() {
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

        val view = inflater.inflate(R.layout.fragment_git_history, container, false)
        //initalize ads
        //initalize ads
        MobileAds.initialize(activity, resources.getString(R.string.addmob_app_id))
        mAdView = view.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        //getting recyclerview from xml
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        //adding a layoutmanager
        recyclerView.setHasFixedSize(true)
        val itemDecor = DividerItemDecoration(context, LinearLayout.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        //crating an arraylist to store users using the data class user
        // //crating an arraylist to store users using the data class user
        val users = ArrayList<GitHistoryModel>()
        users.add(GitHistoryModel("ABOUT GIT", "Git is, first and foremost, a version control system (VCS)and it is open source.\n" +
                "\n" +
                "There are two types of (VCS)\n" +
                "1. Distributed version control system (DVCS)\n" +
                "2.Centralised version control systems (CVCS)\n" +
                "\n" +
                "There are many version control systems out there, for example, CVS, SVN, Mercurial, Fossil etc.\n" +
                "Git is an example of Distributed version control System (DVCS),which keeps track of each modification done to the code over time, and\n" +
                "allows you to backtrack if necessary and undo those changes.Git will allow you to go back to a previous status on a project or to see its entire evolution since the project created.\n" +
                "\n" +
                "Git is also called as source code management (SCM).\n" +
                "\n" +
                "With Git, 3 basic issues were solved when working on projects\n" +
                "   \n" +
                "\n" +
                "It has made easier to manage large projects.\n" +
                "It helps you to avoid overwriting the team’s advances and work.\n" +
                "With git, you just pull the entire code and history to your system. It’s much simpler and much more lightweight.\n" +
                "\n" +
                "Files in a repository go through three stages before being under version control with git\n" +
                "\n" +
                "*  Working Directory (Untracked)\n" +
                "\n" +
                "All the modifications are done in this stage to the files, but is not part of git’s version control. So, to make files part of git version control we use the below command \n" +
                "#git add or #git add . (dot means everything).\n" +
                "\n" +
                "*  Staging (Staged)\n" +
                "\n" +
                "All the files have been added to git’s version control and are tracked by git, but changes have not been committed,\\n so to commit changes we use following  command \n" +
                "#git commit -m “commit message\"\n" +
                "\n" +
                "*  Committed\n" +
                "\n" +
                "All the changes has been committed. There are many tools available in the market right now like Git to revision control and SCM\n" +
                "(source code management) .\n", ""))
        users.add(GitHistoryModel("why Git is the most popular? Well the reasons are:", "\n" +
                "* Git tracks state, history and integrates of the source tree.\n" +
                "* Git keeps old versions for you if any developer occurs any mistake in code, then you will always have the previous version to fix it.\n" +
                "* Multiple developers can work together, once they write code in their local machine and commit it then other developers can pull it easily.\n" +
                "* Large developers community and online websites to upload \\n your source codes or get others source codes to make your work easier.\n" +
                "* Lots of software available for both who comfortable with command line and for others GUI tools.\n" +
                "* Easy and clear documentation to get started with.\n" +
                "* Git will not use much bandwidth you don’t have to connect with your server always you just need to connect to push code when you complete the code.\n" +
                "* Git uses some repositories management services like\n" +
                "   \n" +
                "Github, Gitlab, Bitbucket", ""))
        //creating our adapter
        val adapter = GitHistoryAdapter(users)
        //now adding the adapter to recyclerview

        recyclerView.adapter = adapter
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GitHistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                GitHistoryFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
