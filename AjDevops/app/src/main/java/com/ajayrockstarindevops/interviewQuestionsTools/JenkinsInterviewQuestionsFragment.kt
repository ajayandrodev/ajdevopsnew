package com.ajayrockstarindevops.interviewQuestionsTools


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
import com.ajayrockstarindevops.adapter.JenkinsAdapter.JenkinsInterAdapter

import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.JenkinsModel.JenkinsInterviewModel

import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.fragment_jenkins_interview_questions.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [JenkinsInterviewQuestionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */

//https://mindmajix.com/jenkins-interview-questions-answers
//https://career.guru99.com/top-12-jenkin-interview-questions/
//https://codingcompiler.com/jenkins-interview-questions-answers/   this is all interview quesions important
//https://www.wisdomjobs.com/e-university/jenkins-interview-questions.html
//https://tekslate.com/interview-questions-on-jenkins/
//https://www.buggybread.com/2015/03/jenkins-interview-questions-and-answers.html
//
class JenkinsInterviewQuestionsFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_jenkins_interview_questions, container, false)

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
        val users = ArrayList<JenkinsInterviewModel>()
        //users.add(JenkinsInterviewModel("", ""))

        users.add(JenkinsInterviewModel("1.What is Jenkins?", "Jenkins is an open source Continuous Integration and Continuous Delivery Tool."))
        users.add(JenkinsInterviewModel("2. What is the programming language used to build Jenkins?", "Jenkins is an open source automation server written in Java."))
        users.add(JenkinsInterviewModel("3.Explain what is continuous integration?", "n software development, when multiple developers or teams are working on different segments of same web application, we need to perform integration test by integrating all modules.  In order to do that an automated process for each piece of code is performed on daily bases so that all your code get tested."))
        users.add(JenkinsInterviewModel("4.What is the requirement for using Jenkins?", "To use Jenkins you require\n" +
                "\n" +
                "A source code repository which is accessible, for instance, a Git repository\n" +
                "A working build script, e.g., a Maven script, checked into the repository"))
        users.add(JenkinsInterviewModel("5.What are the features of Jenkins?", " Jenkins has many features like: \n" +
                "\n" +
                "Continuous Integration and Continuous Delivery - As an extensible automation server, Jenkins can be used as a simple CI server or turned into the continuous delivery hub for any project.\n" +
                "\n" +
                "Easy installation - Jenkins is a self-contained Java-based program, ready to run out-of-the-box, with packages for Windows, Mac OS X and other Unix-like operating systems.\n" +
                "\n" +
                "Easy configuration - Jenkins can be easily set up and configured via its web interface, which includes on-the-fly error checks and built-in help.\n" +
                "\n" +
                "Plugins - With hundreds of plugins in the Update Center, Jenkins integrates with practically every tool in the continuous integration and continuous delivery toolchain.\n" +
                "\n" +
                "Extensible - Jenkins can be extended via its plugin architecture, providing nearly infinite possibilities for what Jenkins can do.\n" +
                "\n" +
                "Distributed - Jenkins can easily distribute work across multiple machines, helping drive builds, tests and deployments across multiple platforms faster."))
        users.add(JenkinsInterviewModel("6.What is a Jenkins Pipeline?", " Jenkins Pipeline (or simply \"Pipeline\") is a suite of plugins which supports implementing and integrating continuous delivery pipelines into Jenkins."))
        users.add(JenkinsInterviewModel("7.What is a Continuous delivery pipeline?", "A continuous delivery pipeline is an automated expression of your process for getting software from version control right through to your users and customers."))
        users.add(JenkinsInterviewModel("8.What is Jenkinsfile and what it does?", " The definition of a Jenkins Pipeline is typically written into a text file called a Jenkinsfile which in turn is checked into a project’s source control repository."))
        users.add(JenkinsInterviewModel("9.Can you write a simple Jenkins Pipeline Code for Java?", "Here is the simple Jenkins Pipeline Code for Java:\n" +
                "\n" +
                "Jenkinsfile (Declarative Pipeline)\n" +
                "pipeline {\n" +
                "    agent { docker 'maven:3.3.3' }\n" +
                "    stages {\n" +
                "        stage('build') {\n" +
                "            steps {\n" +
                "                sh 'mvn --version'\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}"))
        users.add(JenkinsInterviewModel("10. What is Declarative Pipeline in Jenkins?", "Declarative Pipeline is a relatively recent addition to Jenkins Pipeline [1] which presents a more simplified and opinionated syntax on top of the Pipeline sub-systems.\n" +
                "\n" +
                "All valid Declarative Pipelines must be enclosed within a pipeline block, for example:\n" +
                "\n" +
                "pipeline {\n" +
                "    /* insert Declarative Pipeline here */\n" +
                "}\n" +
                "\n"))
        users.add(JenkinsInterviewModel("11.What is the agent directive in Jenkins?", "The agent directive tells Jenkins where and how to execute the Pipeline, or subset thereof. As you might expect, the agent is required for all Pipelines.\n" +
                "\n" +
                "Underneath the hood, there are a few things agent causes to happen:\n" +
                "\n" +
                "All the steps contained within the block are queued for execution by Jenkins. As soon as an executor is available, the steps will begin to execute.\n" +
                "\n" +
                "A workspace is allocated which will contain files checked out from source control as well as any additional working files for the Pipeline."))
        users.add(JenkinsInterviewModel("12.What is agent in Jenkins?", "The agent section specifies where the entire Pipeline, or a specific stage, will execute in the Jenkins environment depending on where the agent section is placed. The section must be defined at the top-level inside the pipeline block, but stage-level usage is optional.\n" +
                "\n"))
        users.add(JenkinsInterviewModel("13.What are Parameters in Jenkins?", "In order to support the wide variety of use-cases Pipeline authors may have, the agent section supports a few different types of parameters. These parameters can be applied at the top-level of the pipeline block, or within each stage directive."))
        users.add(JenkinsInterviewModel("14.What is post?", "The post section defines one or more additional steps that are run upon the completion of a Pipeline’s or stage’s run (depending on the location of the post section within the Pipeline). \n" +
                "post can support one of the following post-condition blocks: always, changed, failure, success, unstable, and aborted. These condition blocks allow the execution of steps within the post section depending on the completion status of the Pipeline or stage."))
        users.add(JenkinsInterviewModel("15. What are stages?", "Containing a sequence of one or more stage directives, the stages section is where the bulk of the \"work\" described by a Pipeline will be located. At a minimum it is recommended that stages contain at least one stage directive for each discrete part of the continuous delivery process, such as Build, Test, and Deploy."))
        users.add(JenkinsInterviewModel("16.What is environment directive?", "The environment directive specifies a sequence of key-value pairs which will be defined as environment variables for the all steps, or stage-specific steps, depending on where the environment directive is located within the Pipeline."))
        users.add(JenkinsInterviewModel("17.What are triggers?", " The triggers directive defines the automated ways in which the Pipeline should be re-triggered. For Pipelines which are integrated with a source such as GitHub or BitBucket, triggers may not be necessary as webhooks-based integration will likely already be present. The triggers currently available are cron, pollSCM and upstream."))
        users.add(JenkinsInterviewModel("18.What is input directive?", "The input directive on a stage allows you to prompt for input, using the input step. The stage will pause after any options have been applied, and before entering the stage`s `agent or evaluating its when condition. If the input is approved, the stage will then continue. Any parameters provided as part of the input submission will be available in the environment for the rest of the stage."))
        users.add(JenkinsInterviewModel("19.What is Parallel in Jenkins?", "Stages in Declarative Pipeline may declare a number of nested stages within them, which will be executed in parallel. Note that a stage must have one and only one of either steps or parallel. The nested stages cannot contain further parallel stages themselves, but otherwise behave the same as any other stage. Any stage containing parallel cannot contain agent or tools, since those are not relevant without steps."))
        users.add(JenkinsInterviewModel("20.What is Scripted Pipeline in Jenkins?", "Scripted Pipeline, like Declarative Pipeline, is built on top of the underlying Pipeline sub-system. Unlike Declarative, Scripted Pipeline is effectively a general purpose DSL [2] built with Groovy. Most functionality provided by the Groovy language is made available to users of Scripted Pipeline, which means it can be a very expressive and flexible tool with which one can author continuous delivery pipelines.\n" +
                "\n" +
                " "))
        users.add(JenkinsInterviewModel("21. What is Flow Control in Jenkins?", "Scripted Pipeline is serially executed from the top of a Jenkinsfile downwards, like most traditional scripts in Groovy or other languages."))
        users.add(JenkinsInterviewModel("22.Why do we use Jenkins?", "Jenkins is an open-source continuous integration software tool written in the Java programming language for testing and reporting on isolated changes in a larger code base in real time. The Jenkins software enables developers to find and solve defects in a code base rapidly and to automate testing of their builds."))
        users.add(JenkinsInterviewModel("23. What is Maven and what is Jenkins?", "Maven is a build tool, in short a successor of ant. It helps in build and version control. However, Jenkins is continuous integration system, where in maven is used for build. Jenkins can be used to automate the deployment process."))
        users.add(JenkinsInterviewModel("24.What is the difference between Hudson and Jenkins?", "Hudson was the earlier name and version of current Jenkins. After some issue, the project name was changed from Hudson to Jenkins."))
        users.add(JenkinsInterviewModel("25.  Why do we use Jenkins with selenium?", " Running Selenium tests in Jenkins allows you to run your tests every time your software changes and deploy the software to a new environment when the tests pass. Jenkins can schedule your tests to run at specific time."))
        users.add(JenkinsInterviewModel("26.What are CI Tools?", "Here is the list of the top 8 Continuous Integration tools:\n" +
                "\n" +
                "Jenkins\n" +
                "TeamCity\n" +
                "Travis CI\n" +
                "Go CD\n" +
                "Bamboo\n" +
                "GitLab CI\n" +
                "CircleCI\n" +
                "Codeship"))
        users.add(JenkinsInterviewModel("27.What is a DSL Jenkins?", "The Jenkins “Job DSL / Plugin” is made up of two parts: The Domain Specific Language (DSL) itself that allows users to describe jobs using a Groovy-based language, and a Jenkins plugin which manages the scripts and the updating of the Jenkins jobs which are created and maintained as a result."))
        users.add(JenkinsInterviewModel("28.What is continuous integration and deployment?", "Continuous Integration (CI) is a development practice that requires developers to integrate code into a shared repository several times a day. Each check-in is then verified by an automated build, allowing teams to detect problems early."))
        users.add(JenkinsInterviewModel("29. What is the tool used for provisioning and configuration?", "Ansible is an agent-less configuration management as well as orchestration tool. In Ansible, the configuration modules are called “Playbooks”. Like other tools, Ansible can be used for cloud provisioning."))
        users.add(JenkinsInterviewModel("30.What is the difference between Maven, Ant and Jenkins?", "Maven and Ant are Build Technologies whereas Jenkins is a continuous integration tool."))
        users.add(JenkinsInterviewModel("31.Which Scm Tools Does Jenkins Support?", "Jenkins supports the following SCM tools:\n" +
                "\n" +
                "AccuRev\n" +
                "CVS\n" +
                "Subversion\n" +
                "Git\n" +
                "Mercurial\n" +
                "Perforce\n" +
                "Clearcase\n" +
                "RTC"))
        users.add(JenkinsInterviewModel("32.How To Make Sure That Your Project Builds Doesn’t Break In Jenkins?", "ou must follow these steps to make sure that your project builds doesn’t break in Jenkins:\n" +
                "\n" +
                "First, perform successful clean install on your local machine with all unit tests.\n" +
                "Check all your code changes.\n" +
                "Synchronize with repository to make sure that all required config and POM changes and any difference is checked into the repository."))
        users.add(JenkinsInterviewModel("33.How Can You Move Or Copy Jenkins From One Server To Another?", "Follow these steps to move or copy Jenkins from one server to another:\n" +
                "\n" +
                "First, copy the related job directory and slide a job from one installation of Jenkins to another.\n" +
                "Make a copy of an already existing job by making clone of a job directory by a different name.\n" +
                "Renaming an existing job by rename a directory."))
        users.add(JenkinsInterviewModel("34.Which Commands Can Be Used To Start Jenkins Manually?", "You can use any one of the following commands to start Jenkins manually:\n" +
                "\n" +
                "(Jenkins_url)/restart: Forces a restart without waiting for builds to complete.\n" +
                "\n" +
                "(Jenkin_url)/safeRestart: Allows all running builds to complete."))
        users.add(JenkinsInterviewModel("35.Steps to setup Jenkins jobs?", "Step by step procedure:\n" +
                "\n" +
                "1.Select item forms the menu.\n" +
                "2.Enter the name of the job → free-style job.\n" +
                "3.Press OK to continue & create a new job in Jenkins.\n" +
                "4.Configure you jon in the next page."))
        users.add(JenkinsInterviewModel("36.Minimum JRE required for a run of Jenkin 2.1?", "JRE8 or Else JDK8\n" +
                "\n"))
        users.add(JenkinsInterviewModel("37.What you do to make sure that your project build doesn't break in Jenkins ?\n", "I make sure that I perform successful clean install on my local machine with all unit tests.\n" +
                "Then I make sure that I check in all code changes.\n" +
                "Then I do a Synchronize with repository to make sure that all required config and POM changes and any difference is checked into the repository. "))
        users.add(JenkinsInterviewModel("38.What you do when you see a broken build for your project in Jenkins ?", "I will open the console output for the build and will try to see if any file changes were missed.\n" +
                "If not able to find the issue that way, Will clean and update my local workspace to replicate the problem on my local and will try to solve it."))
        users.add(JenkinsInterviewModel("39.Jenkins is integrated with 2 components what are they?", "Jenkin is mainly integrated with two components\n" +
                "\n" +
                "Version Control system like GIT, SVN\n" +
                "And build tools like Apache Maven."))
        users.add(JenkinsInterviewModel("40.How schedule a build in Jenkins?", "In Jenkins, under the job configuration we can define various build triggers. Simple find the ‘Build Triggers’ section, and check the ‘ Build Periodically’ checkbox. With the periodically build you can schedule the build definition by the date or day of the week and the time to execute the build.\n" +
                "\n" +
                "The format of the ‘Schedule’ textbox is as follows:\n" +
                "\n" +
                "MINUTE (0-59), HOUR (0-23), DAY (1-31), MONTH (1-12), DAY OF THE WEEK (0-7)"))
        users.add(JenkinsInterviewModel("41.Why do we use Pipelines in Jenkins?", "Pipeline adds a powerful set of automation tools onto Jenkins, supporting use cases that span from simple continuous integration to comprehensive continuous delivery pipelines. By modeling a series of related tasks, users can take advantage of the many features of Pipeline:\n" +
                "\n" +
                "Code: Pipelines are implemented in code and typically checked into source control, giving teams the ability to edit, review, and iterate upon their delivery pipeline.\n" +
                "Durable: Pipelines can survive both planned and unplanned restarts of the Jenkins master.\n" +
                "Pausable: Pipelines can optionally stop and wait for human input or approval before continuing the Pipeline run.\n" +
                "Versatile: Pipelines support complex real-world continuous delivery requirements, including the ability to fork/join, loop, and perform work in parallel.\n" +
                "Extensible: The Pipeline plugin supports custom extensions to its DSL and multiple options for integration with other plugins."))
        users.add(JenkinsInterviewModel("42.How do you create Multibranch Pipeline in Jenkins?", "The Multibranch Pipeline project type enables you to implement different Jenkinsfiles for different branches of the same project. In a Multibranch Pipeline project, Jenkins automatically discovers, manages and executes Pipelines for branches which contain a Jenkinsfile in source control."))
        users.add(JenkinsInterviewModel("43.What is blue ocean in Jenkins?", "Blue Ocean is a project that rethinks the user experience of Jenkins, modelling and presenting the process of software delivery by surfacing information that’s important to development teams with as few clicks as possible, while still staying true to the extensibility that is core to Jenkins."))
        users.add(JenkinsInterviewModel("44. What are the important plugins in Jenkins?", "Here is the list of some important Plugins in Jenkins:\n" +
                "\n" +
                "Maven 2 project\n" +
                "Git\n" +
                "Amazon EC2\n" +
                "HTML publisher\n" +
                "Copy artifact\n" +
                "Join\n" +
                "Green Balls"))
        users.add(JenkinsInterviewModel("45.What are Jobs in Jenkins?", "Jenkins can be used to perform the typical build server work, such as doing continuous/official/nightly builds, run tests, or perform some repetitive batch tasks. This is called “free-style software project” in Jenkins."))
        users.add(JenkinsInterviewModel("46.How do you create a Job in Jenkins?", "Go to Jenkins top page, select “New Job”, then choose “Build a free-style software project”. This job type consists of the following elements:\n" +
                "\n" +
                "optional SCM, such as CVS or Subversion where your source code resides.\n" +
                "optional triggers to control when Jenkins will perform builds.\n" +
                "\n" +
                "some sort of build script that performs the build (ant, maven, shell script, batch file, etc.) where the real work happens optional steps to collect information out of the build, such as archiving the artifacts and/or recording javadoc and test results.\n" +
                "\n" +
                "optional steps to notify other people/systems with the build result, such as sending e-mails, IMs, updating issue tracker, etc."))
        users.add(JenkinsInterviewModel("47.How do you configuring automatic builds in Jenkins?", "Builds in Jenkins can be triggered periodically (on a schedule, specified in configuration), or when source changes in the project have been detected, or they can be automatically triggered by requesting the URL:\n" +
                "\n" +
                "http://YOURHOST/jenkins/job/PROJECTNAME/build"))
        users.add(JenkinsInterviewModel("48. How to create a backup and copy files in Jenkins?", "To create a backup, all you need to do is to periodically back up your JENKINS_HOME directory. This contains all of your build jobs configurations, your slave node configurations, and your build history. To create a back-up of your Jenkins setup, just copy this directory."))
        users.add(JenkinsInterviewModel("49.Define Few Plugins Of Jenkins?", "Here are some plugins that can be used with Jenkins:\n" +
                "\n" +
                "Delivery Pipeline\n" +
                "Join Plugin\n" +
                "Copy Artifact\n" +
                "Git\n" +
                "Android Emulator\n" +
                "Cobertura\n" +
                "Email-ext\n" +
                "Docker\n" +
                "Amazon EC2\n" +
                "Openstack Cloud\n" +
                "CloudBees Folders"))
        users.add(JenkinsInterviewModel("50.How Can You Clone A Git Repository Via Jenkins?", "If you want to clone a Git repository via Jenkins, you have to enter the e-mail and user name for your Jenkins system. Switch into your job directory and execute the “git config” command for that."))
        users.add(JenkinsInterviewModel("51. Explain how you can deploy a custom build of a core plugin?", "To deploy a custom field of a core plugin, you have to do following things\n" +
                "\n" +
                "Stop Jenkins\n" +
                "Copy the custom HPI to Jenkins_Home/plugins\n" +
                "Delete the previously expanded plugin directory\n" +
                "Make an empty file called <plugin>.hpi.pinned\n" +
                "Start Jenkins"))
        //users.add(JenkinsInterviewModel("", ""))

        //creating our adapter
        val adapter = JenkinsInterAdapter(users)
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
         * @return A new instance of fragment JenkinsInterviewQuestionsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                JenkinsInterviewQuestionsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
