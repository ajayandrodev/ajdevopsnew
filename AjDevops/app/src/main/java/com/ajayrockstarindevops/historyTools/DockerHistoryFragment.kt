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
import com.ajayrockstarindevops.adapter.DockerAdapter.DockerHistoryAdapter
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.DockerModel.DockerHistoryModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DockerHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DockerHistoryFragment : Fragment() {
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

        val view = inflater.inflate(R.layout.fragment_docker_history, container, false)
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
        val users = ArrayList<DockerHistoryModel>()
        users.add(DockerHistoryModel("ABOUT DOCKER", "Linux containers are an operating system level virtualization technology for providing multiple isolated Linux environments on a single Linux host. Unlike virtual machines (VMs), containers do not run dedicated guest operating systems. Rather, they share the host operating system kernel and make use of the guest operating system system libraries for providing the required OS capabilities. Since there is no dedicated operating system, containers start much faster than VMs.\n" +
                "\n" +
                "Virtual Machines Vs ContainersImage credit: Docker Inc.\n" +
                "\n" +
                "Containers make use of Linux kernel features such as Namespaces, Apparmor, SELinux profiles, chroot, and CGroups for providing an isolated environment similar to VMs. Linux security modules guarantee that access to the host machine and the kernel from the containers is properly managed to avoid any intrusion activities.In addition containers can run different Linux distributions from its host operating system if both operating systems can run on the same CPU architecture.\n" +
                "\n" +
                "In general, containers provide a means of creating container images based on various Linux distributions, an API for managing the lifecycle of the containers, client tools for interacting with the API, features to take snapshots, migrating container instances from one container host to another, etc.\n", ""))
        users.add(DockerHistoryModel("Container History", "Below is a short summary of container history extracted from Wikipedia and other sources:\n" +
                "\n" +
                "1979 — chroot\n" +
                "\n" +
                "The concept of containers was started way back in 1979 with UNIX chroot.It’s an UNIX operating-system system call for changing the root directory of a process and it is children to a new location in the filesystem which is only visible to a given process.The idea of this feature is to provide an isolated disk space for each process. Later in 1982 this was added to BSD.\n" +
                "\n" +
                "2000 — FreeBSD Jails\n" +
                "\n" +
                "FreeBSD Jails is one of the early container technologies introduced by Derrick T. Woolworth at R and D Associates for FreeBSD in year 2000. It is an operating-system system call similar to chroot, but included additional process sandboxing features for isolating the filesystem, users, networking, etc. As a result it could provide means of assigning an IP address for each jail, custom software installations and configurations, etc.\n" +
                "\n" +
                "2001 — Linux VServer\n" +
                "\n" +
                "Linux VServer is a another jail mechanism that can be used to securely partition resources on a computer system (file system, CPU time, network addresses and memory). Each partition is called a security context, and the virtualized system within it is called a virtual private server.\n" +
                "\n" +
                "2004 — Solaris Containers\n" +
                "\n" +
                "Solaris Containers were introduced for x86 and SPARC systems, first released publicly in February 2004 in build 51 beta of Solaris 10, and subsequently in the first full release of Solaris 10, 2005. A Solaris Container is a combination of system resource controls and the boundary separation provided by zones. Zones act as completely isolated virtual servers within a single operating system instance.\n" +
                "\n" +
                "2005 — OpenVZ\n" +
                "\n" +
                "OpenVZ is similar to Solaris Containers and makes use of a patched Linux kernel for providing virtualization, isolation, resource management, and checkpointing. Each OpenVZ container would have an isolated file system, users and user groups, a process tree, network, devices, and IPC objects.\n" +
                "\n" +
                "2006 — Process Containers\n" +
                "\n" +
                "Process Containers was implemented at Google in year 2006 for limiting, accounting, and isolating resource usage (CPU, memory, disk I/O, network, etc.) of a collection of processes. Later on it was renamed to Control Groups to avoid the confusion multiple meanings of the term “container” in the Linux kernel context and merged to the Linux kernel 2.6.24. This shows how early Google was involved in container technology and how they have contributed back.\n" +
                "\n" +
                "2007 — Control Groups\n" +
                "\n" +
                "As explained above, Control Groups AKA cgroups was implemented by Google and added to the Linux Kernel in 2007.\n" +
                "\n" +
                "2008 — LXC\n" +
                "\n" +
                "LXC stands for LinuX Containers and it is the first, most complete implementation of Linux container manager. It was implemented using cgroups and Linux namespaces. LXC was delivered in liblxc library and provided language bindings for the API in Python3, Python2, Lua, Go, Ruby, and Haskell. Contrast to other container technologies LXC works on vanila Linux kernel without requiring any patches. Today LXC project is sponsored by Canonical Ltd. and hosted here.\n" +
                "\n" +
                "2011 — Warden\n" +
                "\n" +
                "Warden was implemented by CloudFoundry in year 2011 by using LXC at the initial stage and later on replaced with their own implementation. Unlike LXC, Warden is not tightly coupled to Linux. Rather, it can work on any operating system that can provide ways of isolating environments. It runs as a daemon and provides an API for managing the containers. Refer to Warden documentation and this blog post for more detailed information on Warden.\n" +
                "\n" +
                "2013 — LMCTFY\n" +
                "\n" +
                "lmctfy stands for “Let Me Contain That For You”. It is the open source version of Google’s container stack, which provides Linux application containers. Google started this project with the intention of providing guaranteed performance, high resource utilization, shared resources, over-commitment, and near zero overhead with containers (Ref: lmctfy presentation). The cAdvisor tool used by Kubernetes today was started as a result of lmctfy project. The initial release of lmctfy was made in Oct 2013 and in year 2015 Google has decided to contribute core lmctfy concepts and abstractions to libcontainer. As a result now no active development is done in LMCTFY.\n" +
                "\n" +
                "The libcontainer project was initially started by Docker and now it has been moved to Open Container Foundation.\n" +
                "\n" +
                "2013 — Docker\n" +
                "\n" +
                "Docker is the most popular and widely used container management system as of January 2016. It was developed as an internal project at a platform-as-a-service company called dotCloud and later renamed to Docker. Similar to Warden, Docker also used LXC at the initial stages and later replaced LXC with it’s own library called libcontainer. Unlike any other container platform, Docker introduced an entire ecosystem for managing containers. This includes a highly efficient, layered container image model, a global and local container registries, a clean REST API, a CLI, etc. At a later stage, Docker also took an initiative to implement a container cluster management solution called Docker Swarm.\n" +
                "\n" +
                "2014 — Rocket\n" +
                "\n" +
                "Rocket is a much similar initiative to Docker started by CoreOS for fixing some of the drawbacks they found in Docker. CoreOS has mentioned that their aim is to provide more rigorous security and production requirements than Docker. More importantly, it is implemented on App Container specifications to be a more open standard. In addition to Rocket, CoreOS also develops several other container related products used by Docker and Kubernetes: CoreOS Operating System, etcd, and flannel.\n" +
                "\n" +
                "2016 — Windows Containers\n" +
                "\n" +
                "Microsoft also took an initiative to add container support to the Microsoft Windows Server operating system in 2015 for Windows based applications, called Windows Containers. This is to be released with Microsoft Windows Server 2016. With this implementation Docker would be able to run Docker containers on Windows natively without having to run a virtual machine to run Docker (earlier Docker ran on Windows using a Linux VM).", ""))
        users.add(DockerHistoryModel("The Future of Containers", "As of today (Jan 2016) there is a significant trend in the industry to move towards containers from VMs for deploying software applications. The main reasons for this are the flexibility and low cost that containers provide compared to VMs. Google has used container technology for many years with Borg and Omega container cluster management platforms for running Google applications at scale. More importantly, Google has contributed to container space by implementing cgroups and participating in libcontainer projects. Google may have gained a huge gain in performance, resource utilization, and overall efficiency using containers during past years. Very recently Microsoft, who did not had an operating system level virtualization on the Windows platform took immediate action to implement native support for containers on Windows Server.\n" +
                "\n" +
                "Docker, Rocket, and other container platforms cannot run on a single host in a production environment, the reason is that they are exposed to single point of failure.  While a collection of containers are run on a single host, if the host fails, all the containers that run on that host will also fail. To avoid this, a container host cluster needs to be used. One of the first most open source container cluster management platforms to solve this problem was Apache Mesos.It was initially developed at University of California, Berkeley as a research project and later moved to Apache in around year 2012. Google took a similar step to implement a cutting edge, open source container cluster management system called Kubernetes in year 2014 with the experience they got from Borg.Docker also started a solution called Docker Swarm in year 2015.Today these solutions are at their very early stages and it may take several months and may be another year to complete their full feature set, become stable and widely used in the industry in production environments.\n" +
                "\n" +
                "Microservices are another groundbreaking technology rather a software architecture which uses containers for their deployment.A microservice is nothing new but a lightweight implementation of a web service which can start extremely fast compared to a standard web service.This is done by packaging a unit of functionality (may be a single service/API method) in one service and embedding it into a lightweight web server binary.\n" +
                "\n" +
                "By considering the above facts we can predict that in next few years,containers may take over virtual machines, and sometimes might replace them completely.\n", ""))

        //creating our adapter
        val adapter = DockerHistoryAdapter(users)
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
         * @return A new instance of fragment DockerHistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                DockerHistoryFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
