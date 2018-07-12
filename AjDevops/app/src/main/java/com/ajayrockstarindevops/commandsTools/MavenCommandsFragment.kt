package com.ajayrockstarindevops.commandsTools


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
import com.ajayrockstarindevops.adapter.MavenAdapter.MavenCommandsAdapter
import com.ajayrockstarindevops.model.MavenModel.MavenCommandsModel

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
 * Use the [MavenCommandsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MavenCommandsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mAdView : AdView

    //https://javabeat.net/apache-maven-for-beginners/
    //https://www.softwaretestinghelp.com/maven-project-setup-for-selenium-selenium-tutorial-24/
    // https://dzone.com/articles/maven-demystified
    // http://tutorials.jenkov.com/maven/maven-tutorial.html====http://www.javawebtutor.com/articles/maven/maven_overview.php
    //http://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html
    //https://stackoverflow.com/questions/3660759/mvn-clean-install-vs-deploy-vs-release
    //https://javarevisited.blogspot.com/2015/01/difference-between-maven-ant-jenkins-and-hudson.html
    //https://javarevisited.blogspot.com/2016/08/top-10-maven-plugins-every-java-developer-know.html
    //http://www.avajava.com/tutorials/lessons/what-are-the-phases-of-the-maven-site-lifecycle.html  usefull
    //http://www.bogotobogo.com/Java/tutorials/Spring-Boot/Maven-mvn-command-cheat-sheet.php
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
        val view = inflater.inflate(R.layout.fragment_maven_commands, container, false)

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
        val users = ArrayList<MavenCommandsModel>()

        users.add(MavenCommandsModel("mvn archetype:create -DgroupId=org.yourcompany.project -DartifactId=application", "create java project", ""))
        users.add(MavenCommandsModel("mvn archetype:create -DgroupId=org.yourcompany.project -DartifactId=application\n" +
                "-DarchetypeArtifactId=maven-archetype-webapp", "create web project", ""))
        users.add(MavenCommandsModel("mvn clean", "clean project: will delete target directory", ""))
        users.add(MavenCommandsModel("mvn validate", "validate project: validate the project is correct and all necessary information is available", ""))
        users.add(MavenCommandsModel("mvn compile", "compile project: compile source code, classes stored in target/classes", ""))
        users.add(MavenCommandsModel("mvn test", "test project: run tests using a suitable unit testing framework", ""))
        users.add(MavenCommandsModel("mvn package", "package project: take the compiled code and package it in its distributable format, such as a JAR / WAR", ""))
        users.add(MavenCommandsModel("mvn verify", "verify project: run any checks to verify the package is valid and meets quality criteria", ""))
        users.add(MavenCommandsModel("mvn install", "install project: install the package into the local repository, for use as a dependency in other projects locally", ""))
        users.add(MavenCommandsModel("mvn deploy", "deploy project: done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects", ""))
        users.add(MavenCommandsModel(" mvn deploy:deploy-file -Dfile=/path/to/jar/file -DrepositoryId=repos-server -Durl=http\n" +
                "://repos.company.org/test -DgroupId=javax -DartifactId=mail -Dpackaging=jar\n" +
                "-Dversion=1.0.1", "deploy-file: can be used for deploying a external jar file to repository", ""))

//creating our adapter
        val adapter = MavenCommandsAdapter(users)
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
         * @return A new instance of fragment MavenCommandsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                MavenCommandsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
