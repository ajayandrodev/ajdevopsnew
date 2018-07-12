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
import com.ajayrockstarindevops.adapter.MavenAdapter.MavenHistoryAdapter
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.MavenModel.MavenHistoryModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.fragment_maven_history.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MavenHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MavenHistoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mAdView: AdView
    //    https://myopswork.com/maven-as-a-devops-tool-f5d04b0fc55c
//    https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Learn-Maven-and-master-the-build-tools-fundamental-concepts
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_maven_history, container, false)
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
        val users = ArrayList<MavenHistoryModel>()
        users.add(MavenHistoryModel("about maven", "Apache Maven is project management tool which is following the concept of a project object model (POM). Mavan can manage project’s build and documentation from a central place.\n" +
                "\n" +
                "Maven 1  \n" +
                "actually was started as a sub project of Apache Turbine in 2002 (by Sonatype’s Jason van Zyl).It was released in July 2004 as v1.0.\n" +
                "Maven 2 \n" +
                "was released in Oct 2005.It was a complete rewrite of the previous project. It was not backward compatible.\n" +
                "Maven 3\n" +
                "nwas released in October 2010. It is same as Maven 2 but more stable.\n" +
                "    \n" +
                "Maven is a build and dependencies management system used primarily for Java projects.\n", ""))
        users.add(MavenHistoryModel("Key features include: ", "\n" +
                "\n" +
                "1===>Create new projects through archetypes.\n" +
                "2===>Project configuration in POM file and Settings file\n" +
                "3===>Project building using lifecycles, phases, plugins, goals and build profiles.\n" +
                "4===>Dependency management through repositories\n" +
                "5===>Deployment with the release plugin.", ""))
        users.add(MavenHistoryModel("The Project Object Model", "The Project Object Model or POM is the fundamental unit of work in Maven. \\nIt is an XML file, usually defined in the project root directory, that contains information about the project and the configuration used by Maven to build the project.\n" +
                "\n" +
                "The configuration that can be included in the POM file is as follows: \n" +
                "\n" +
                "1===>Plugins and goals\n" +
                "2===>Dependencies\n" +
                "3===>Repositories\n" +
                "4===>Build profiles\n" +
                "5===>Project metadata such as version, description, developers, etc.\n" +
                "\n" +
                "To facilitate a default configuration for all project, Maven provides what is known as the Super POM.\n" +
                "The Super POM is Maven default POM. All POMs extend the Super Pom thus inheriting the configuration specified in the Super POM.\n", ""))
        users.add(MavenHistoryModel("The Settings File ", "As mentioned above, the POM file contains the project configuration, whilst the Settings file contains the user specific configuration. There can be two settings files, the Global settings file, situated in the Maven install directory, and the user settings file that is situated in the user home directory.\n" +
                "\n" +
                "The settings file can provide the following configuration: \n" +
                "\n" +
                "1===>Simple values\n" +
                "2===>Plugin groups\n" +
                "3===>Server credentials\n" +
                "4===>Proxies\n" +
                "5===>Profiles\n", ""))
        users.add(MavenHistoryModel("Build Lifecycles", "Maven build process is based on lifecycles. The lifecycle provides a clearly defined process for building and distributing project artifacts.\n" +
                "\n" +
                "There are three different lifecycles in Maven.\n" +
                "\n" +
                "Default:  Handles project building and deployment.\n" +
                "Clean: Handles project cleaning.\n" +
                "Site:  Handles project site docs.\n" +
                "\n" +
                "Phases \n" +
                "\n" +
                "Each lifecycle is defined by a series of stages named build phases.A build phase is responsible for a specific step in the lifecycle, but the way it carries out its duty depend on the plugin goals bound to the phase.\n" +
                "\n" +
                "Plugins \n" +
                "\n" +
                "Plugins are artifacts that provide goals for the build phases.Dividing the phases into goals, provided by plugins, make the build process really flexible and customizable.\n" +
                "\n" +
                "A plugin can provide one or more goals. Each goal represents a capability of that plugin.\n" +
                "\n" +
                "For example,\n" +
                "Maven only supports a single source and test directories for a project.If we decided to add additional directories to the project,we could use a plugin that provides goals to add source and test directories to the build process.\n" +
                "\n" +
                "Goals \n" +
                "\n" +
                "Goals are responsible for executing specific tasks during each phase.Some phases have default goals. For the default lifecycle, default goals are provided by the packaging option, defined in the project POM file.In addition to the default goals, extra goals can be defined by configuring plugins in the project POM file.Therefore, a particular build phase can be composed of multiple goals. If a phase does not have any goals,it will not be executed as part of the lifecycle.\n" +
                "\n" +
                "Standalone Plugins\n" +
                "\n" +
                "Most of the plugins provide goals that are bound to build phases. However, there are some plugins that provide goals which are meant to be executed separately, not as part of the build lifecycle.\n" +
                "\n" +
                "The Archetype Plugin\n" +
                "\n" +
                "If you happen to be an IntelliJ user, you may have seen that when creating a new Maven project the first option is a list of archetypes. Have you ever wonder what is it for? I have to say that I did not until I found what archetypes are by digging into Maven features.\n" +
                "An archetype is simply an existing project template.The Archetype plugin provides Maven project templates. It creates the project structure and POM file based on standard templates. The process of creating a new project is done in an interactive way by just providing project specific configuration such as groupid, artifact name, etc.\n" +
                "\n" +
                "It helps to apply project or organisations best practices. New users can have, in seconds, a working project to use as a walking skeleton.\n" +
                "The plugin has additive support, meaning that can be used to add pieces to existing projects, i.e.\n" +
                "Maven site archetype can quickly create a documentation site for the project.\n" +
                "\n" +
                "Users can create their own archertypes in their organisations repository and use them as a base for new projects.\n" +
                "\n" +
                "Being a standalone plugin, the archetype plugin provides goals that are not bound to any lifecycle.The goals are executed directly, as opposed to what is done when using the lifecycle,where goals are executed as part of the lifecycle phases.\n" +
                "\n" +
                "Release Plugin\n" +
                "\n" +
                "Provide a standard mechanism to release project artifacts.\n" +
                "\n" +
                "The Release plugin has two main goals.\n" +
                "\n" +
                "Prepare\n" +
                "\n" +
                "1.Verify there are not uncommitted changes.\n" +
                "2.Prompt user to provide a tag, release, and development version names.\n" +
                "3.Modify and commit release info in the POM file.\n" +
                "4.Tag entire project.\n" +
                "\n" +
                "Perform\n" +
                "\n" +
                "1.Extract file revisions under new tag name\n" +
                "2.Execute the Maven lifecycle on the extracted project instance\n" +
                "3.Deploy the artifacts to local and remote repositories\n" +
                "\n" +
                "Repositories\n" +
                "\n" +
                "Maven uses repositories to hold build artifacts and dependencies.\n" +
                "Maven Repositories are used as in Git, but storing build and dependencies artifacts instead of source code. Doing so, users can easily consume your project artifacts from the repositories.\n" +
                "\n" +
                "There are two types of repositories local and remote, both are structured the same way.\n" +
                "\n" +
                "1.The local repositories live in the users local machines and are used as a cache of the remote repositories, providing offline building capabilities.\n" +
                "2.The remote repository can be divided into two subgroups, public and internal. Public repositories hold artifacts that are publicly available, whilst internal repositories are created in organisations to share internal artifacts between development teams.\n" +
                "It is strongly recommended that when using maven, dependencies JARs are not stored in source control, but in the repositories. Doing so, Maven is able to handle transitive dependencies, as all dependencies information is available through the POM file and the Maven repositories.", ""))
        users.add(MavenHistoryModel("Build Profiles", "Maven Build Profiles are used to facilitate portable builds.The build profiles modify the POM file at build time to provide equivalent-but-difference parameters that are environment dependent.For example, it is the perfect place to define filesystem references that are different for each user.Profiles provide properties that can be referenced in the POM file. The properties are defined in the\n" +
                "<properties> section in the profile declaration.Build profiles can be declared in the POM file, as a per project definition, or in the Settings files. Build profiles defined in the Global Settings file are available for all users of the machine, whilst the ones defined in the User Settings file are available only for a particular user.\n" +
                "\n" +
                "Profiles are triggered in different ways:\n" +
                "\n" +
                "1.Explicitly:\n" +
                "Running a Maven build through the command line, including -P option.\n" +
                "2.Maven settings:\n" +
                "Including the profile in the <active profiles> section. When using this option the profile is always active.\n" +
                "3.<activation> section in profile declaration:\n" +
                "The activation section can activate a certain profile based on environment variables, OS settings, and missing or present files.\n", ""))
        users.add(MavenHistoryModel("Conclusion", "There are many areas where Maven can ease development effort:\n" +
                "\n" +
                "1.Easy build process\n" +
                "2.Uniform build system\n" +
                "3.Rich project information\n" +
                "4.Guidelines for best development\n" +
                "5.Transparent migration to new features\n" +
                "\n", ""))
        //creating our adapter
        val adapter = MavenHistoryAdapter(users)
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
         * @return A new instance of fragment MavenHistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                MavenHistoryFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
