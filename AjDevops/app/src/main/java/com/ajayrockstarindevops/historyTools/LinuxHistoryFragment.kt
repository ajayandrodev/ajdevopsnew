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
import com.ajayrockstarindevops.adapter.LinuxAdapter.LinuxHistoryAdapter
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.LinuxModel.LinuxHistoryModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LinuxHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LinuxHistoryFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_linux_history, container, false)
        //initalize ads
        //initalize ads
        MobileAds.initialize(activity, "ca-app-pub-9279514970367399~6950217666")
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
        val users = ArrayList<LinuxHistoryModel>()

        users.add(LinuxHistoryModel("ABOUT LINUX", "Linux is, in simplest terms, an Operating System. It is the software on a computer that enables applications and the computer operator to access the devices on the computer to perform desired functions. The Operating System (OS) relays instructions from an application to, for instance, the computer processor. The processor performs the instructed task, then sends the results back to the application via the Operating System.Explained in these terms, Linux is very similar to other Operating Systems, such as Windows and OS X.\n", ""))
        users.add(LinuxHistoryModel("What is Linux?", "Linux is an example of Open Source software development and Free Operating System (OS).\n" +
                "\n" +
                "Architectures \n" +
                "\n" +
                "Linux Originally developed for Intel is x86 hardware, ports available for over two dozen CPU types including ARM.\n" +
                "\n" +
                "File system Support \n" +
                "\n" +
                "Linux use Ext2, Ext3, Ext4, Jfs, ReiserFS, Xfs, Btrfs format.\n" +
                "\n" +
                " Usage \n" +
                "\n" +
                "Linux can be installed on a wide variety of computer hardware, ranging from mobile phones, tablet computers and video game consoles, to mainframes and supercomputers.\n" +
                "\n" +
                "GUI \n" +
                "\n" +
                "Linux typically provides two GUIs, KDE and Gnome. But Linux GUI is optional.\n" +
                "\n" +
                "Market Share for Desktop PC\n" +
                "\n" +
                "The market share of Linux is about 1.29%.\n" +
                "\n" +
                " Threat Detection and Solution \n" +
                "\n" +
                "In case of Linux, threat detection and solution is very fast, as Linux is mainly community driven and whenever any Linux user post s any kind of threat, several developers start working on it from different parts of the world.\n" +
                "\n" +
                "Cost \n" +
                "\n" +
                "Linux can be freely distributed, downloaded freely, distributed through magazines, Books etc. There are priced versions for Linux also, but they are normally cheaper than Windows.\n" +
                "\n" +
                "Security\n" +
                "\n" +
                "Linux has had about 60-100 viruses listed till date.\n" +
                "\n" +
                "Text Mode Interface \n" +
                "\n" +
                "BASH (Bourne Again Shell) is the Linux default shell. It can support multiple command interpreters.\n" +
                "\n" +
                "Development and Distribution \n" +
                "\n" +
                "Linux is developed by Open Source development i.e. through sharing and collaboration of code and features through forums etc. and it is distributed by various vendors such as Debian, Red Hat, SUSE, Ubuntu, and GentuX etc.\n" +
                "\n" +
                "User \n" +
                "\n" +
                "Linux Operating System for everyone, from home users to developers and computer enthusiasts alike.\n" +
                "\n" +
                "Kernel \n" +
                "\n" +
                "Linux kernel is freely available. Linux kernel is developed by the community. Linus Torvalds oversees things.\n" +
                "\n" +
                "Patches \n" +
                "\n" +
                "Linux patches are not highly tested as UNIX patches.\n" +
                "\n" +
                "Linux Distribution Names\n" +
                "\n" +
                "A few popular names:\n" +
                "Redhat Enterprise Linux, Fedora Linux, Debian Linux, Suse Enterprise Linux, Ubuntu Linux\n", ""))
        users.add(LinuxHistoryModel("Linux Advantages", "One of the most valued advantages of Linux over the other platforms lies with the high security levels it ensures. Every Linux user is happy to work in a virus-free environment and use the regular virus-prevention time needed when working with other Operating Systems for other more important tasks.\n" +
                "\n" +
                "Thanks to its open-source distribution,Linux is being constantly developed and updated by the constantly expanding community of programmers supporting it. Despite its dynamic nature, it is totally complete in terms of functionality and interface. All those ongoing development efforts are made with the sole purpose of keeping the platform flexible and ever adaptable to the changeable climate of the WWW.\n" +
                "\n" +
                "Linux in World Wide We \n" +
                "\n" +
                "Due to its innate stability, the Linux-based distributions are a top choice for Internet servers, with a great part of the World Wide Web being powered by Linux. Linux is often used with Apache, thus creating the stable Linux-Apache combination.\n" +
                "\n" +
                "As a fundamental part of the web, Linux has deservedly found its place in the popular LAMP open source web platform, which represents a combination between the most popular website building technologies: Linux, Apache (web server), MySQL (database) and PHP/Perl/Python (web application languages).\n", ""))
        users.add(LinuxHistoryModel("Disadvantages", "Understanding \n" +
                "\n" +
                "Becoming familiar with the Linux Operating System requires patience as well as a strong learning curve. You must have the desire to read and figure things out on your own, rather than having everything done for you.\n" +
                "\n" +
                "Compatibility\n" +
                "\n" +
                "Because of its free nature, Linux is sometimes behind the curve when it comes to brand new hardware compatibility. Though the kernel contributors and maintainers work hard at keeping the kernel up to date, Linux does not have as much of a corporate backing as alternative Operating Systems. Sometimes you can find third party applications, sometimes you can not.", ""))
        //creating our adapter
        val adapter = LinuxHistoryAdapter(users)

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
         * @return A new instance of fragment LinuxHistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                LinuxHistoryFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
