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
import com.ajayrockstarindevops.adapter.DockerAdapter.DockerCommandsAdapter
import com.ajayrockstarindevops.adapter.JenkinsAdapter.JenkinsCommandsAdaper

import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.DockerModel.DockerCommandsModel
import com.ajayrockstarindevops.model.JenkinsModel.JenkinsCommandsModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [JenkinsCommandsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class JenkinsCommandsFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_jenkins_commands, container, false)
        //getting recyclerview from xml
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        //adding a layoutmanager
        recyclerView.setHasFixedSize(true)
        val itemDecor = DividerItemDecoration(context, LinearLayout.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        //crating an arraylist to store users using the data class user
        val users = ArrayList<JenkinsCommandsModel>()
        //adding some dummy data to the list
        users.add(JenkinsCommandsModel("Here is a list of my own and the team’s top 10 must-have Jenkins features/plugins.", "Pipeline\n" +
                "Easy Installation\n" +
                "Easy Upgrades\n" +
                "Scriptability\n" +
                "View Filters\n" +
                "Maven\n" +
                "Amazon EC2\n" +
                "HTML Publisher\n" +
                "Throttle Builds\n" +
                "Join\n" +
                "Green Balls"))
        users.add(JenkinsCommandsModel("Pipeline", "Jenkins Pipeline is an incredibly useful addition that came to life with the Jenkins 2.0 release. It allows you to script your build pipeline consisting of one or more build jobs into a single workflow. It makes the visualization of the pipeline much easier, the monitoring of which parts have been run and which jobs are still in the queue a non-issue. The best part is that it’s integrated with the SCM, so you can develop your pipeline definition script using proper tools and see the historical changes, audit, do the code reviews, etc. The build pipeline can become the essential part of your mental model about the CI."))
        users.add(JenkinsCommandsModel("Easy Installation", "Jenkins comes as a WAR file (there are also a wide variety of Linux packages available and a Windows installer) that you can drop into your favourite JEE container (Tomcat, Jetty, Glassfish etc.) or you can start the WAR file directly with java -jar jenkins.war. That’s it! Now that it is up and running, you can start configuring jobs and installing plugins. It will use a folder in your HOME to persist the configuration and store the actual jobs. No database, no special installation, no special registration. Clean and easy. You can even easily chain the job executions and visualize the whole pipeline of multiple jobs."))
        users.add(JenkinsCommandsModel("Easy Upgrades", "Jenkins has very quick release cycles, and statistics shows that there is a release for every 6.59 days. The release process page will state that an RC freeze is schedules for Monday, and then late Friday the RC is released. Also, there is a Long-term Support version available that is put together every 3 months and is suitable for more stable installations.\n" +
                "\n" +
                "The upgrade process itself is super easy. It does not matter if you are using Linux, Mac OS or Windows; there is a single, easy way for upgrades built into the product itself."))
        users.add(JenkinsCommandsModel("Scriptability", "Jenkins provides different means to communicate with it. There is a web-based GUI that everyone is accustomed to, the command line interface and also a Rest API for Python, XML and JSON. You can feel that this is a tool from developers for developers. For example, to iterate through all jobs available in a Jenkins installation, all you need in Python is 3 lines of code.\n" +
                "\n" +
                "import urllib\n" +
                "\n" +
                "obj = eval(urllib.urlopen(\"http://ci.jenkins-ci.org/api/python\").read());\n" +
                "for job in obj['jobs']:\n" +
                "   print job['name']\n" +
                "To generate a graph relationship of all your jobs in your installation, you don’t need much more code (mind the configurability and usability sections)."))
        users.add(JenkinsCommandsModel("View Filters", "Once you get a large number of jobs in your installation (we have about 200 defined), you will want to organize them so that the right people can get a quick grasp of the current status of the builds in which they are interested. This is where the little plus sign (+) comes to work. You are able to construct views for your branches, projects and persons that will list only a subset of your jobs. The subset can be defined either by a regular expression or explicit project selection."))
        users.add(JenkinsCommandsModel("Amazon EC2", "One of the little-mentioned features, which I think is totally taken for granted in Jenkins, is its ability to scale out to a large number of nodes and distribute the workload between them. If your own infrastructure is not large enough, then this plugin lets you tap into the resources of the Amazon EC2 infrastructure. You can specify the AMIs to use, label them, provide connection credentials and test the connectivity.\n" +
                "\n" +
                "We use EC2 to run our JEE container tests. This means that to test WebSphere 7.0.1 we launch the specific AMI and start up WebSphere with our agent (XRebel or JRebel) and go through the test suite. This is orchestrated by Jenkins using this plugin and then copying back the results."))
        users.add(JenkinsCommandsModel("Maven 2 Project", "This plugin allows you to download the internets and take advantage of Maven’s features. Jenkins reads your project’s dependencies from your POM and, if those are also built on Jenkins, sets up triggers in such a way that a new build in one of those dependencies will automatically start a new build in this project. Jenkins understands all kinds of dependencies in POM, namely:\n" +
                "\n" +
                "parent POM\n" +
                "<dependencies> section of your project\n" +
                "<extensions> section of your project\n" +
                "<reporting> section of your project\n" +
                "This process takes versions into account, so you can have multiple versions/branches in your project on the same Jenkins instance and it will correctly determine dependencies. Of course, there are over 20 plugins listed under the Maven section of the Jenkins Plugins Page.\n" +
                "\n"))
        users.add(JenkinsCommandsModel("HTML Publisher", "This plugin is handy with built-in copy to master functionality. Imagine that you have some files generated through your builds that are not actual artifacts. Let’s say logs, debug info, obfuscation maps whatnot. This plugin lets you to copy them to a master and provide an easy HTML file that will have links to these special files of yours for really quick access.\n" +
                "\n"))
        users.add(JenkinsCommandsModel("Copy Artifact", "If you are not using a dependency management system, your build jobs become isolated as they do not know anything about each other. This plugin helps to solve this problem by allowing you to copy needed files from one job to another. So it may be handy to copy a resulting artifact from one build job into another job that will run tests against it. It does sound a bit hackish, but it is way better than referencing your artifacts from one job folder to another."))
        users.add(JenkinsCommandsModel("Jenkins Throttle Concurrent Builds", "I am pretty sure that you have some jobs running in Jenkins that should not interfere with each other. This plugin allows you to group jobs, and allow only some defined number of jobs run concurrently (in most cases, it is one) in the same environment. Take test jobs that use some container instances preinstalled on your master/slaves, for example: this plugin allows you to configure your jobs so that they will run on different slaves or wait for another job to finish before starting."))
        users.add(JenkinsCommandsModel("Join", "This plugin allows a job to be run after all the immediate downstream jobs have completed. In this way, the execution can branch out and perform many steps in parallel, and then run a final aggregation step just once after all the parallel work is finished. This plugin is useful for creating a diamond shape project dependency. This means there is a single parent job that starts several downstream jobs. Once those jobs are finished, a single aggregation job runs. Unfortunately, more complex interactions are not possible with this plugin."))
        users.add(JenkinsCommandsModel("Green Balls", "Historically Jenkins has used the blue color to denote successful builds. So, all status messages throughout the GUI use blue as the color of success. I don’t know the history of this, but closest thing that comes to mind is the The Matrix, where the blue pill was designated as the safe choice. If you are like me and feel that green is the way to go (Green Hornet, Green Lantern, Gumby, traffic lights, etc) then you can change your preference to green with the Green Balls plugin."))


        //creating our adapter
        val adapter = JenkinsCommandsAdaper(users)
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
         * @return A new instance of fragment JenkinsCommandsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                JenkinsCommandsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
