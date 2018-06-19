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
import com.ajayrockstarindevops.adapter.GitAdapter.GitCommandsAdapter

import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.DockerModel.DockerCommandsModel
import com.ajayrockstarindevops.model.GitModel.GitCommandsModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DockerCommnadsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DockerCommnadsFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_docker_commnads, container, false)
        //getting recyclerview from xml
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        //adding a layoutmanager
        recyclerView.setHasFixedSize(true)
        val itemDecor = DividerItemDecoration(context, LinearLayout.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        //crating an arraylist to store users using the data class user
        val users = ArrayList<DockerCommandsModel>()
        //adding some dummy data to the list
        /*used below links*/
/*
    https@ //www.edureka.co/blog/docker-commands/
*/
        users.add(DockerCommandsModel("docker –version", "This command is used to get the currently installed version of docker", ""))
        users.add(DockerCommandsModel("docker pull <image name>", "This command is used to pull images from the docker repository(hub.docker.com)", "Example+"\ n "+ docker pull ubuntu"))
        users.add(DockerCommandsModel("docker run -it -d <image name>", "This command is used to create a container from an image", "Example+\"\\n\"+ docker run -it -d ubuntu"))
        users.add(DockerCommandsModel("docker ps", "This command is used to list the running containers\n", ""))
        users.add(DockerCommandsModel("docker ps -a", "This command is used to show all the running and exited containers", ""))
        users.add(DockerCommandsModel("docker exec -it <container id> bash", "This command is used to access the running container", "Example+\"\\ n \"+ docker exec -it fe63e70a1c9c bash"))
        users.add(DockerCommandsModel("docker stop <container id>", "This command stops a running container", "Example+\"\\ n \"+ docker stop fe63e70a1c9c"))
        users.add(DockerCommandsModel("docker kill <container id>", "This command kills the container by stopping its execution immediately. The difference between ‘docker kill’ and ‘docker stop’ is that ‘docker stop’ gives the container time to shutdown gracefully, in situations when it is taking too much time for getting the container to stop, one can opt to kill it", "Example+\"\\ n \"+ docker kill fe63e70a1c9c"))
        users.add(DockerCommandsModel("docker commit <conatainer id> <username/imagename>", "This command creates a new image of an edited container on the local system\n" +
                "\n", "Example+\"\\ n \"+ docker commit fe63e70a1c9c ajay/ubuntunew"))
        users.add(DockerCommandsModel("docker login", "This command is used to login to the docker hub repository\n" +
                "\n", ""))
        users.add(DockerCommandsModel("docker push <username/image name>", "This command is used to push an image to the docker hub repository", "Example+\"\\ n \"+docker push  ajay/ubuntunew"))
        users.add(DockerCommandsModel("docker images", "This command lists all the locally stored docker images\n" +
                "\n", ""))
        users.add(DockerCommandsModel("docker rm <container id>", "This command is used to delete a stopped container", "Example+\"\\ n \"+ docker rm fe63e70a1c9c"))
        users.add(DockerCommandsModel("docker rmi <image-id>", "This command is used to delete an image from local storage", "Example+\"\\ n \"+ docker rmi fe63e70a1c9c"))
        users.add(DockerCommandsModel("docker build <path to docker file>", "This command is used to build an image from a specified docker file\n" +
                "\n", "Example+\"\\ n \"+ docker build ."))
        users.add(DockerCommandsModel("Usage: docker [OPTIONS] COMMAND [arg...]\n" +
                "       docker daemon [ --help | ... ]\n" +
                "       docker [ --help | -v | --version ] +"\ n "+A self-sufficient runtime for containers.", "Options:\n" +
                "\n" +
                "  --config=~/.docker              Location of client config files\n" +
                "  -D, --debug                     Enable debug mode\n" +
                "  -H, --host=[]                   Daemon socket(s) to connect to\n" +
                "  -h, --help                      Print usage\n" +
                "  -l, --log-level=info            Set the logging level\n" +
                "  --tls                           Use TLS; implied by --tlsverify\n" +
                "  --tlscacert=~/.docker/ca.pem    Trust certs signed only by this CA\n" +
                "  --tlscert=~/.docker/cert.pem    Path to TLS certificate file\n" +
                "  --tlskey=~/.docker/key.pem      Path to TLS key file\n" +
                "  --tlsverify                     Use TLS and verify the remote\n" +
                "  -v, --version                   Print version information and quit", "Commands:\n" +
                "    attach    Attach to a running container\n" +
                "    build     Build an image from a Dockerfile\n" +
                "    commit    Create a new image from a container's changes\n" +
                "    cp        Copy files/folders between a container and the local filesystem\n" +
                "    create    Create a new container\n" +
                "    diff      Inspect changes on a container's filesystem\n" +
                "    events    Get real time events from the server\n" +
                "    exec      Run a command in a running container\n" +
                "    export    Export a container's filesystem as a tar archive\n" +
                "    history   Show the history of an image\n" +
                "    images    List images\n" +
                "    import    Import the contents from a tarball to create a filesystem image\n" +
                "    info      Display system-wide information\n" +
                "    inspect   Return low-level information on a container or image\n" +
                "    kill      Kill a running container\n" +
                "    load      Load an image from a tar archive or STDIN\n" +
                "    login     Log in to a Docker registry\n" +
                "    logout    Log out from a Docker registry\n" +
                "    logs      Fetch the logs of a container\n" +
                "    network   Manage Docker networks\n" +
                "    pause     Pause all processes within a container\n" +
                "    port      List port mappings or a specific mapping for the CONTAINER\n" +
                "    ps        List containers\n" +
                "    pull      Pull an image or a repository from a registry\n" +
                "    push      Push an image or a repository to a registry\n" +
                "    rename    Rename a container\n" +
                "    restart   Restart a container\n" +
                "    rm        Remove one or more containers\n" +
                "    rmi       Remove one or more images\n" +
                "    run       Run a command in a new container\n" +
                "    save      Save one or more images to a tar archive\n" +
                "    search    Search the Docker Hub for images\n" +
                "    start     Start one or more stopped containers\n" +
                "    stats     Display a live stream of container(s) resource usage statistics\n" +
                "    stop      Stop a running container\n" +
                "    tag       Tag an image into a repository\n" +
                "    top       Display the running processes of a container\n" +
                "    unpause   Unpause all processes within a container\n" +
                "    update    Update configuration of one or more containers\n" +
                "    version   Show the Docker version information\n" +
                "    volume    Manage Docker volumes\n" +
                "    wait      Block until a container stops, then print its exit code"))
        users.add(DockerCommandsModel("docker info ", "Let's Check if docker is properly installed", ""))
        users.add(DockerCommandsModel("ocker history <image_name>", "The history of the images can be found by executing this command:", ""))


        //creating our adapter
        val adapter = DockerCommandsAdapter(users)
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
         * @return A new instance of fragment DockerCommnadsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                DockerCommnadsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
