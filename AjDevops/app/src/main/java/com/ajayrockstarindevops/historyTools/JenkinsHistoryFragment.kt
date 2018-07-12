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
import com.ajayrockstarindevops.adapter.JenkinsAdapter.JenkinsHistoryAdapter
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.JenkinsModel.JenkinsHistoryModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.fragment_jenkins_history.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [JenkinsHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class JenkinsHistoryFragment : Fragment() {
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

        val view = inflater.inflate(R.layout.fragment_jenkins_history, container, false)
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
        val users = ArrayList<JenkinsHistoryModel>()
        users.add(JenkinsHistoryModel("ABOUT JENKINS", "Jenkins is a Continuous Integration (CI) server or tool which is written in java.It provides Continuous Integration services for software development,which can be started via command line or web application server. \n" +
                "And also,it is happy to know that Jenkins is free software to download and install.", ""))
        users.add(JenkinsHistoryModel("Before going in details to Jenkins, let me tell you what Continuous Integration (CI) is.", "\n" +
                "1====>Continuous Integration (CI)is a development practice that requires developers to integrate code into a shared repository several times a day.\n" +
                "2===> It is a process of running your tests on a non-developer (say testers) machine automatically when someone pushes new code into the source repository.\n" +
                "\n" +
                " Some of the attractive reasons why you need automate build testing and integration are:\n" +
                "\n" +
                "1.Developer time is concentrated on work that matters:\n" +
                "\n" +
                "Most of the work like integration and testing is managed by automated build and testing systems. So the developer’s time is saved without wasting on large-scale error-ridden integrations.\n" +
                "\n" +
                "2.Software quality is made better: \n" +
                "\n" +
                "Issues are detected and resolved almost right away which keeps the software in a state where it can be released at any time safely.\n" +
                "\n" +
                "3.Makes development faster:\n" +
                "\n" +
                "Most of the integration work is automated. Hence integration issues are less. This saves both time and money over the lifespan of a project.\n" +
                "\n" +
                "Continuous Build System can include tools like Jenkins, Bamboo, and Cruise Control, etc. Bamboo has better UX support but it is not a free tool. Jenkins is an open source tool, easier to setup and configure and also has a very active plug-in development community which makes it favored. Now, let us dive into the Jenkins tool.", ""))
        users.add(JenkinsHistoryModel("Jenkins History", "\n" +
                "\n" +
                "Jenkins was originally developed as the Hudson project. Hudson’s creation started in summer of 2004 at Sun Microsystems. It was first released in java.net in Feb. 2005.\n" +
                "During November 2010,an issue arose in the Hudson community with respect to the infrastructure used, which grew to encompass questions over the stewardship and control by Oracle. Negotiations between the principal project contributors and Oracle took place, and although there were many areas of the agreement a key sticking point was the trademarked name “Hudson” after Oracle claimed the right to the name and applied for a trademark in December 2010. As a result, on January 11, 2011, a call for votes was made to change the project name from “Hudson” to “Jenkins”. The proposal was overwhelmingly approved by community vote on January 29, 2011, creating the Jenkins project.\n" +
                "\n" +
                "On February 1, 2011,Oracle said that they intended to continue development of Hudson, and considered Jenkins a fork rather than a rename. Jenkins and Hudson, therefore, continue as two independent projects, each claiming the other is the fork.As of December 2013,the Jenkins organization on GitHub had 567 project members and around 1,100 public repositories, compared with Hudson’s 32 project members and 17 public repositories.\n" +
                "\n" +
                "Let us depict a scenario where the complete source code of the application was built and then deployed on the test server for testing. It sounds like a robust way to develop software, but this method has many weaknesses. \n" +
                "\n" +
                "They are,\n" +
                "\n" +
                "1===>Developers have to pause till the complete software is developed for the test results.\n" +
                "2===>There is a huge possibility that the test results might show lot many bugs. This makes developers be in a complex situation to find the root cause of those bugs since they have to check the entire source code of the application.\n" +
                "Delivery process of software is slowed down.\n" +
                "3===>Continuous feedback referring to things like coding or architectural issues, build failures, test condition and file release uploads were missing so that the quality of software can go down.\n" +
                "4===>The whole process was manual which increments the risk of repeated failure.\n" +
                "5===>It is obvious from the above-stated problems that along with slow software delivery process, the quality of software also went down. This leads to customer unhappiness.So, to overcome such confusion there was a crucial demand for a system to exist where developers can gradually trigger a build and test for each and every change made in the source code.Therefore, Jenkins tool is used in CI. It is the most mature CI tool possible. Now let us see how Continuous Integration with Jenkins crushes the above shortcomings.\n" +
                "For software development, we can hook it up with most of the repositories like SVN, Git, Mercurial, etc. Jenkins has lots of plugins that are available freely. These plugins help to integrate with various software tools for better convenience.\n" +
                "One really nice thing about Jenkins is, build configuration files will be on disk which makes massive build cloning and reconfiguring easy.\n", ""))
        users.add(JenkinsHistoryModel("Advantages of Jenkins", "\n" +
                "1.Jenkins is an open source tool with much support from its community.\n" +
                "2.Installation is easier.\n" +
                "3.It has more than 1000 plug-in to make the work easier.\n" +
                "4.It is easy to create new Jenkins plugin if one is not available.\n" +
                "5.It is a tool which is written in Java. Hence it can be portable to almost all major platforms.", ""))
        //creating our adapter
        val adapter = JenkinsHistoryAdapter(users)
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
         * @return A new instance of fragment JenkinsHistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                JenkinsHistoryFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
