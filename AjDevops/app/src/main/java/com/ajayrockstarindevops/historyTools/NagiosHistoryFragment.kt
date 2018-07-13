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
import com.ajayrockstarindevops.adapter.NagiosAdapter.NagiosHistoryAdapter
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.NagiosModel.NagiosHistoryModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NagiosHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
//https://www.slashroot.in/what-nagios-introduction-enterprise-level-server-monitoring
//https://networklore.com/nagios/
//https://www.nagios.com/solutions/server-monitoring/
//https://searchitoperations.techtarget.com/definition/Nagios
//https://medium.com/linux-monitoring-with-nagios/what-is-nagios-64e547db57ca
//https://www.janbasktraining.com/blog/what-is-nagios/
//https://www.janbasktraining.com/blog/devops-tutorial/ important*******************************
class NagiosHistoryFragment : Fragment() {
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

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_nagios_history, container, false)
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
        val users = ArrayList<NagiosHistoryModel>()
        users.add(NagiosHistoryModel("ABOUT NAGIOS", "Nagios is a free and open source computer software application that monitors systems, networks and infrastructure. Nagios offers monitoring and alerting services for servers, switches, applications and services. It alerts users when things go wrong and alerts them a second time when the problem has been resolved.\n" +
                "For getting the exact status of server machines, we use monitoring tools. Now a days a lot of monitoring tools are available with good monitoring capabilities and alert capabilities. I was in a search for finding a good monitoring as well as alert tool for hadoop clusters. From my observation, I found some free tools\n" +
                "\n" +
                "1) Ganglia\n" +
                "2) Nagios\n" +
                "3) Zabbix\n" +
                "4) Cloudera Manager\n" +
                "6) Apache Ambari\n" +
                "\n", ""))
        users.add(NagiosHistoryModel("What is Continuous Monitoring?", "Once the application is deployed to the server, the role of continuous monitoring comes into existence. The process is all about taking care of Company infrastructure and respond immediately as soon as some error occurs. The concept is not new but it is around for a long time.\n" +
                "\n" +
                "The technique you must have heard about is the static analysis that is responsible to detect, respond or report the logs but the analysis is not so much accurate as expected by the organizations. With the Continuous monitoring, you can perform and respond each of the activities in the best possible way.\n" +
                "\n" +
                "When we discuss the continuous monitoring, this is necessary that all pieces of information should be connected well like database, warehouse, security tools, security management system, AI, security intelligence, data analytics etc. Connecting different pieces together in a well-organized manner is the crux of the process that makes the continuous monitoring more successful and useful requirement by the organizations?\n" +
                "\n" +
                "Further, the process is performed on the continuous (on-going) basis that reports immediately about the risks that can be faced by Company for its poor infrastructure. You can also check the behavior of networks and data analytics report when required. According to a saying, if you cannot ‘measure’ the risks how will you ‘manage’ them and continuous monitoring is the solution that works best here.", ""))
        users.add(NagiosHistoryModel("Why is Continuous Monitoring useful?", "Continuous Monitoring has the capability to detect the system errors before they could have negative impacts on your business productivity. Here, is a quick list of features that explain to you why continuous monitoring is useful –\n" +
                "\n" +
                "* The process helps in detecting network errors or server crashes.\n" +
                "* With CM, you can detect or report any type of infrastructure issues quickly.\n" +
                "* It also helps in maintaining security issues and service availability.\n" +
                "* You can troubleshoot or monitor the performance issues of the server.\n" +
                "* The process gives you a perfect idea of infrastructure upgrades, how can you make it even better that suits Company needs.\n" +
                "* The process has the capability of reporting issues at first glance only.\n" +
                "* The issues can be fixed automatically as soon as they are identified during the monitoring process.\n" +
                "*On successful completion of continuous monitoring, it makes sure that it does not have any negative impact on your Company infrastructure and business operations.\n" +
                "* The entire business process and IT infrastructure can be monitored in a single pass only.", ""))
        users.add(NagiosHistoryModel("Services provided", "* Monitoring of network services such as SMTP, POP2, HTTP, NNTP, ICMP, SNMP, FTP, SSH.\n" +
                "\n" +
                "* Monitoring of host resources such as processor load, disk usage, system log on a majority of network operating systems, including Microsoft Windows, using monitoring agents.\n" +
                "\n" +
                "* Monitoring of any hardware like probes for temperature, alarms,etc. which have the ability to send collected data via a network to specifically written plugins.\n" +
                "\n" +
                "* Remote monitoring using Nagios Remote Plugin Executor or through SSH or SSL encrypted tunnels.\n" +
                "\n" +
                "* Parallelized service checks and automatic log file rotation.\n" +
                "\n" +
                "* Support for implementing redundant monitoring hosts, performance data graphing and database backend.\n" +
                "\n" +
                "* A web-interface for viewing current network status, notifications, problem history, log files, etc.", ""))
        users.add(NagiosHistoryModel("Nagios agents", "\n" +
                "* NRPE — Nagios Remote Plugin Executor\n" +
                "\n" +
                "* NRDP — Nagios Remote Data Processor\n" +
                "\n" +
                "* NSClient++ — (program used to monitor Windows machines)\n" +
                "\n" +
                "* NCPA — Nagios cross Platform Agent", ""))
        users.add(NagiosHistoryModel("Nagios checks the status of a remote service or program in multiple ways.", "       **********     ", ""))
        users.add(NagiosHistoryModel("1. Directly monitor services through network", "\n" +
                "\n" +
                "* In this  method the nagios server will execute a plugin on the nagios server itself, which will basically try to connect to a network service on the target server. monitoring publicly available service using nagios.\n" +
                "\n" +
                "* we have tried to depict how nagios process execute an example check(which is also sometimes called plugin), on the nagios server itself, which will connect to the http port 80 on the target server, and will record the response time.\n" +
                "\n" +
                "* Nagios server will execute the check at regular interval(as configured), to check the availability of the service.The plugin is placed inside the nagios server, and no changes are done at the client side. You cant monitor all properties of a client that counts, through this method. This method can be used only to monitor, services that are available publicly. The main reason behind this is that, you need to login inside the client server, in order to monitor stuff like memory usage, process status, cpu load, and other stuff.\n" +
                "\n" +
                "* Hence this kind of plugins are very limited in its capability, but you can surely achieve a considerable amount of good 24x7 monitoring using this method, for publicly available services like SMTP, HTTP, DNS, FTP, PORT availability check, Remote MySQL & MSSQL etc.", ""))
        users.add(NagiosHistoryModel("2. Nagios monitoring through SSH and NRPE", "* As mentioned in the previous method, without getting a login to the remote machine, the level of monitoring you can achieve is very limited, and also you cannot monitor all the services using that method.\n" +
                "\n" +
                "* You can achieve a 24 x 7 monitoring of the things that cannot be monitored directly through network with the help of two different methods, they are as mentioned below.\n" +
                "\n" +
                "* Check the status of a remote service by executing a plugin, that will be placed on the remote client, by loging inside the client with the help of SSH.\n" +
                "\n" +
                "* NRPE (Nagios Remote Plugin Executor), is a daemon that's installed as a stand alone or an inetd daemon that waits for requests from the nagios server on port 5666, to execute commands that are defined in its configuration file.\n" +
                "Let's frst undersand monitoring a remote host using SSH method. In this method, a user is made on all the client machines, which allows ssh login from the nagios server with the help of a predifined ssh key and execute a requred plugin to monior a required service.\n" +
                "\n" +
                "* check by ssh Nagios  *\n" +
                "\n" +
                "* This method of executing remote plugins on remote client with the help of SSH is a secure way to monitor. As a normal user logs in the remote client, the nagios server will be able to run any command that the normal user will be able to run(when i say run, i mean execute).\n" +
                "\n" +
                "* The plugins that reside in the remote client are sometimes called as local plugins as they are local to the remote host. to run local plugins on remote host, nagios uses a ready made command called check_by_ssh(we will be discussing the complete command usage of this plugin in a dedicated post of its own).\n" +
                "\n" +
                "* Of cource you will not be sitting and entering passwords each and every time the check is executed by the nagios daemon. Login and execution of the remote plugin on the remote server using ssh must be seamless and also must be password less login. For this, you need to set up public key authentication of the user, which will be loging inside the remote server for executing the plugins.\n" +
                "\n" +
                "* Now let's see the another method of executing remote plugins. *\n" +
                " \n" +
                "* Another method that is commonly used to achieve the successful execution of a remote plugin is NRPE. NRPE stands for Nagios Remote Plugin Executor. NRPE is a package that will be installed on all the remote hosts, that needs to be monitored. Mostly NRPE is installed as Xinetd service on the remote host, and by default it listens on the tcp port 5666.\n" +
                "\n" +
                "* Suppose the nrpe daemon receives a query from the nagios server, to execute a command on the local server, nrpe daemon looks inside the nrpe configuration files, for a command with the same name what nagios asked to run. Unlike ssh method, nrpe cannot run any command that the nagios server asks to run. Commands first need to be defined inside the nrpe configuration file. And only those commands can be run from the nagios server. Deploying ssh based nagios checks are much easier compared to nrpe method, because in nrpe method, you need to first install nrpe package on all the client servers that requires to be monitored.\n" +
                "\n" +
                "* nagios checks using nrpe *\n" +
                "\n" +
                "* The nrpe method of executing remote checks on a remote client with nagios. Nagios server has a check_nrpe plugin (which is very similar to the plugin check_by_ssh used in ssh method), which connects to the remote client on the port 5666, and executes the command, which is given as an argument to check_nrpe plugin(the command given as argument to check_nrpe plugin on the nagios server must also be defined in nrpe configuration files on the client, where the command will be executed.)\n" +
                "\n" +
                "* Nrpe method of monitoring remote host, by executing plugins on the remote machine is limited to the commands defined inside the nrpe configuration files on the client. Which means the command which you require to run on the remote machine, must be predefined in the nrpe configuration files on the client.\n" +
                "\n" +
                "* But check_by_ssh can be used to run any command, with executable permission to the user used to login to the remote machine.\n" +
                "\n", ""))
        users.add(NagiosHistoryModel("3. Monitoring remote host with the help of SNMP in nagios", "* SNMP can be used to fetch the current value of different properties of a network device or any SNMP aware device. if you have SNMP daemon installed on your remote host, which needs to be monitored, then you can monitor hard drive, load, etc with the help of SNMP daemon.\n" +
                "\n" +
                "* Advantage behind using SNMP to monitor is because it is supported by a wide variety of devices like network switches, routers, UPS devices etc.\n" +
                "\n" +
                "* We will be doing a couple of posts on SNMP, for getting a better overview of the protocol and its usage. We will also be doing a dedicated post for monitoring devices with nagios and SNMP.\n", ""))
        users.add(NagiosHistoryModel("4.  Nagios Passive monitoring or NSCA (Nagios Service Check Acceptor)", "\n" +
                "* Let's now see a method, in which the client will execute a required plugin at a regular interval, and report the output of the execution to the nagios server. This is achieved with the help of a daemon called NSCA.\n" +
                "\n" +
                "* NSCA stands for Nagios Service Check Acceptor. This is installed as a daemon on the nagios server itself, and it will wait for the command result from the client.\n" +
                "\n" +
                "* This kind of nagios monitoring is called as passive monitoring, because nagios server is not the one that initates the checks on the client, but the client will execute the plugins specified, at regular interval with the help of a cron and report the output to the nsca daemon on the nagios server.\n" +
                "\n" +
                "* While reporting the output, the client will also send details like the service name, hostname, the output of the command executed to the nsca daemon, so that the nagios server can report the output exactly in the same way active checks are executed(active checks are those checks in which the command execution is initiated by the nagios server. Examples are check by ssh, nrpe etc.)\n" +
                "\n" +
                "* passive checks in nagios * \n" +
                "\n" +
                "* There are couple of things that needs to be understood, from the above shown diagram. NSCA is a daemon on the nagios server that waits for the command result from the client.\n" +
                "\n" +
                "* Send_nsca is a program that can be used to send a command result to the nagios server. The hostname, the service name, and other related details will be included in the command result send using send_nsca to the nagios server.\n", ""))
        users.add(NagiosHistoryModel("Capabilities", "* Nagios is recognized as the top solution to monitor servers in a variety of different ways.  Server monitoring is made easy in Nagios because of the flexibility to monitor your servers with and without agents.  With over 3500 different addons available to monitor your servers, the community at the Nagios Exchange have left no stone unturned.\n" +
                "\n" +
                "* Nagios is fully capable of monitoring Windows servers, Linux servers, Unix servers, Solaris, AIX, HP-UX, and Mac OS/X and more.", ""))
        users.add(NagiosHistoryModel("Benefits", "Implementing effective server monitoring with Nagios offers the following benefits:\n" +
                "\n" +
                "* Increased server, services, process, and application availability\n" +
                "* Fast detection of network and server outages and protocol failures\n" +
                "* Fast detection of failed servers, services, processes and batch jobs\n" +
                " ", ""))
        users.add(NagiosHistoryModel("Solutions", "These Nagios solutions provide server monitoring capabilities and benefits:\n" +
                "\n" +
                "* Nagios XI\n" +
                "* Nagios Core", ""))

        //creating our adapter
        val adapter = NagiosHistoryAdapter(users)
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
         * @return A new instance of fragment NagiosHistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                NagiosHistoryFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
