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
import com.ajayrockstarindevops.adapter.AnsibleAdapter.AnsibleHistoryAdapter
import com.ajayrockstarindevops.adapter.AwsAdapter.AwsHistoryAdapter

import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.AnsibleModel.AnsibleHistoryModel
import com.ajayrockstarindevops.model.AwsModel.AwsHistoryModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AnsibleHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class AnsibleHistoryFragment : Fragment() {
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

        val view = inflater.inflate(R.layout.fragment_ansible_history, container, false)
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
        val users = ArrayList<AnsibleHistoryModel>()
        users.add(AnsibleHistoryModel("ABOUT ANSIBLE","Ansible is an open source tool used to deploy applications to remote nodes and provision servers in a repeatable way. It gives you a common framework for pushing multi-tier applications and application artifacts using a push model setup, although you can set it up as master-client if you’d like. Ansible is built on playbooks that you can apply to an extensive variety of systems for deploying your app.\n" +
                "\n" +
                "When to use it:\n" +
                "\n" +
                "If getting up and running quickly and easily is important to you and you don’t want to install agents on remote nodes or managed servers, consider Ansible. It’s good if your need or focus is more on the system administrator side. Ansible is focused on being streamlined and fast, so if those are key concerns for you, give it a shot.\n" +
                "\n" +
                " Price:\n" +
                " Free open source version, with paid plans for Ansible Tower starting at \$5,000 per year (which gives you up to 100 nodes).\n" +
                "\n" +
                " Pros:\n" +
                "\n" +
                "1===>SSH-based, so it doesn’t require installing any agents on remote nodes.\n" +
                "2===>Easy learning curve thanks to the use of YAML.\n" +
                "3===>Playbook structure is simple and clearly structured.\n" +
                "4===>Has a variable registration feature that enables tasks to register variables for later tasks\n" +
                "5===>Much more streamlined code base than some other tools\n" +
                "\n" +
                " Cons:\n" +
                "\n" +
                "1===>Less powerful than tools based in other programming languages.\n" +
                "2===>Does its logic through its DSL, which means checking in on the documentation frequently until you learn it\n" +
                "3===>Variable registration is required for even basic functionality, which can make easier tasks more complicated\n" +
                "4===>Introspection is poor. Difficult to see the values of variables within the playbooks\n" +
                "5===>No consistency between formats of input, output, and config files\n" +
                "6===>Struggles with performance speed at times.",""))
        users.add(AnsibleHistoryModel("Basic Structure of an Ansible Project","As part of the deployment script, we must define the Ansible structure first. In the structure, we need to define staging, production, group_vars, host_vars and roles:\n" +
                "\n" +
                "1===>The staging file will keep all test environments information\n" +
                "2===>The production file will keep all production and Disaster Recovery (DR) environments information\n" +
                "3===>All application server details should be mentioned in host_vars\n" +
                "4===>All variables used in Ansible need to be furnished in group_vars\n" +
                "5===>All templates, files and tasks are defined in roles\n" +
                "\n" +
                "Finally, we need to define a wrapper Ansible playbook to execute the roles. Under one wrapper playbook, the number of roles that will execute depends on developer needs or the project requirements. In the following subsections, I will explain each and every component of an Ansible project.\n" +
                "\n" +
                "*   Inventory\n" +
                "\n" +
                "Inventory plays an important role in identifying which server we will need to deploy the application using Ansible. As a best practice, it is always good to use a separate inventory for pre-production (i.e. test environments and production environment application server details). As a standard, we use it to maintain Staging and Production Ansible inventory for test and production servers respectively.\n" +
                "\n" +
                "*  Group Variables (group_vars)\n" +
                "\n" +
                "Group variables contain all environmental variables as well as common variables. This is the place where we can store all template variables for each environment. While running an Ansible playbook, we will specify a limit, and based on that, Ansible will use the appropriate group variables.\n" +
                "\n" +
                "*  Host Variables (host_vars)\n" +
                "\n" +
                "All the application servers’ IP addresses are stored in host_vars. In the runtime based on the inventory and limit environments, Ansible will identify the application server details from host_vars.\n" +
                "\n" +
                "\n" +
                "*  Vault\n" +
                "\n" +
                "Vault is a password-protected file where deployment engineers store all clear text passwords. Vault has the capability to use its own encryption to protect our passwords. These passwords might include a deployment user password, service account password, database password, and a web service password. We can use ansible-vault create or edit for creating and modifying a vault respectively.\n" +
                "\n" +
                "\n" +
                "*  Roles\n" +
                "\n" +
                "The application deployment process always follows a set of sequential instructions. In Ansible, each instruction has been defined under a role by the software engineers. Each role consists of three components: tasks, templates and files.\n" +
                "\n" +
                "\n" +
                "*  Tasks\n" +
                "\n" +
                "Tasks mainly perform a set of operations, which completely align with the roles objective. In order to perform the tasks, external files are kept under the files directory, and templates are kept under the templates directory. All operations under a particular task are furnished in the main.yml file.\n" +
                "\n" +
                "*  Templates\n" +
                "\n" +
                "For each application, all the environments have some common files. Some attributes of those common files are different based on their environment. We use templates to handle different environments with minimal changes. For example, say we have a database connection string defined in a file and that file must be deployed in all environments, but the database name in each environment is different. In that situation, the deployment engineer would create a template and keep the database name as a variable, and that variable defined under each environment group_vars along with their proper database name.\n" +
                "\n" +
                "*  Files\n" +
                "\n" +
                "Any type of file used by a task is kept under that task role directory. It may be any executable like .sh, .exe, .dat or a simple .txt file. An example of the basic structure of an Ansible project.\n" +
                "\n" +
                "*  Establishing Connectivity with Various Servers\n" +
                "\n" +
                "One of the most important prerequisites of an Ansible deployment is connecting it with other systems like application servers and version control systems (SVN, Bitbucket, Serena Dimension, Visual Source Safe, etc.)\n" +
                "\n" +
                "*  Connectivity with various servers\n" +
                "\n" +
                "We need to establish connectivity between the version control server and the Ansible server to get the application components. We also need to deploy those source components into an application server by building connectivity between the Ansible server and the application server. In general, SSH is used for Red Hat Enterprise Linux (RHEL) system connectivity and NTLM or Kerberos is used for Windows systems.\n" +
                "\n" +
                "*  Mechanism to Run an Ansible Playbook\n" +
                "\n" +
                "There are many parameters we need to consider while running an Ansible playbook. Consider a case where the developers have developed all the Ansible roles and also created some wrapper .yml files, which contain a set of roles to be executed as part of a particular deployment. The deployment engineer will run the wrapper as per their objective (deploying applications, properties, keystores, etc.)\n",""))
        //creating our adapter
        val adapter = AnsibleHistoryAdapter(users)
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
         * @return A new instance of fragment AnsibleHistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                AnsibleHistoryFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
