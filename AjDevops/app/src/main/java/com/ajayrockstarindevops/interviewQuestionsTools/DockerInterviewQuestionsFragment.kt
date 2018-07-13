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
import com.ajayrockstarindevops.adapter.DockerAdapter.DockerInterAdapter

import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.DockerModel.DockerInterviewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DockerInterviewQuestionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
//https://www.wisdomjobs.com/e-university/docker-software-interview-questions.html
//https://convox.com/?gclid=Cj0KCQjw-JvaBRDGARIsAFjqkkq2qFLuOYvYePN0V_vIkLV70oGYuC0ZK_fGsjpxqmbgpOJzbQINCmcaAs5BEALw_wcB
//http://rafalgolarz.com/blog/2017/03/11/docker_interview/
//http://www.lazyquestion.com/interview-questions-and-answer/docker
//https://www.simplilearn.com/devops-practitioner-exam-free-practice-test  for test the devops
//https://djitz.com/certification/docker-certified-associate-test-review-questions-set-2-image-management-and-registry/
//https://svrtechnologies.com/devops-interview-questions/top-50-devops-engineer-interview-questions-and-answers-pdf
//http://dockerinterviewquestion.blogspot.com/
//https://codingcompiler.com/docker-interview-questions-answers/   full data
//https://www.wisdomjobs.com/e-university/docker-software-interview-questions.html
//https://mindmajix.com/docker-interview-questions
//https://www.mytectra.com/interview-question/docker-interview-questions/
//https://tekslate.com/docker-interview-questions/
//https://foxutech.com/docker-interview-question-and-answers/
class DockerInterviewQuestionsFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_docker_interview_questions, container, false)
        //getting recyclerview from xml
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        //adding a layoutmanager
        recyclerView.setHasFixedSize(true)
        val itemDecor = DividerItemDecoration(context, LinearLayout.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        //crating an arraylist to store users using the data class user
        val users = ArrayList<DockerInterviewModel>()
        users.add(DockerInterviewModel("1.What is Docker?", "Docker is a containerization platform which packages your application and all its dependencies together in the form of containers so as to ensure that your application works seamlessly in any environment be it development or test or production."))
        users.add(DockerInterviewModel("2.What Is The Advantage Of Docker Over Hypervisors?", "Docker is light weight and more efficient in terms of resource uses because it uses the host underlying kernel rather than creating its own hypervisor."))
        users.add(DockerInterviewModel("3.What Is Docker Container?", "Docker Container is the instantiation of docker image. In other words, it is the run time instance of images. Images are set of files whereas containers is the one who run the image inside isolated."))
        users.add(DockerInterviewModel("4.Is Container Technology New?", "No, it is not. Different variations of containers technology were out there in *NIX world for a long time.Examples are:-Solaris container (aka Solaris Zones)-FreeBSD Jails-AIX Workload Partitions (aka WPARs)-Linux OpenVZ."))
        users.add(DockerInterviewModel("5.How Is Docker Different From Other Container Technologies?", "Well, Docker is a quite fresh project. It was created in the Era of Cloud, so a lot of things are done much nicer than in other container technologies. Team behind Docker looks to be full of enthusiasm, which is of course very good.I am not going to list all the features of Docker here but i will mention those which are important to me.\n" +
                "\n" +
                "Docker can run on any infrastructure, you can run docker on your laptop or you can run it in the cloud.\n" +
                "\n" +
                "Docker has a Container HUB, it is basically a repository of containers which you can download and use. You can even share containers with your applications.\n" +
                "\n" +
                "Docker is quite well documented."))
        users.add(DockerInterviewModel("6.Difference Between Docker Image And Container?", "Docker container is the runtime instance of docker image.\n" +
                "\n" +
                "Docker Image does not have a state and its state never changes as it is just set of files whereas docker container has its execution state."))
        users.add(DockerInterviewModel("7.What Is The Use Case For Docker?", "Well, I think, docker is extremely useful in development environments. Especially for testing purposes. You can deploy and re-deploy apps in a blink of eye.\n" +
                "Also, I believe there are use cases where you can use Docker in production. Imagine you have some Node.js application providing some services on web. Do you really need to run full OS for this\n" +
                "Eventually, if docker is good or not should be decided on an application basis. For some apps it can be sufficient, for others not."))
        users.add(DockerInterviewModel("8.How Exactly Containers (docker In Our Case) Are Different From Hypervisor Virtualization (vsphere)? What Are The Benefits?", "To run an application in virtualized environment (e.g. vSphere), we first need to create a VM, install an OS inside and only then deploy the application.To run same application in docker all you need is to deploy that application in Docker. There is no need of additional OS layer. You just deploy the application with its dependent libraries, the rest (kernel, etc.) is provided by Docker engine.This table from a Docker official website shows it in a quite clear way.\n" +
                "\n" +
                "Another benefit of Docker, from my perspective, is speed of deployment. Lets imagine a scenario:\n" +
                "\n" +
                "ACME inc. needs to virtualize application GOOD APP for testing purposes.\n" +
                "\n" +
                "Conditions are:\n" +
                "\n" +
                "Application should run in an isolated environment.\n" +
                "Application should be available to be redeployed at any moment in a very fast manner.\n" +
                "\nSolution 1.\n" +
                "\n" +
                "In vSphere world what we would usually do, is:\n" +
                "\n" +
                "Deploy OS in a VM running on vSphere.\n" +
                "Deploy an application inside OS.\n" +
                "Create a template.\n" +
                "Redeploy the template in case of need. Time of redeployment around 5-10 minutes.\n" +
                "Sounds great! Having app up and running in an hour and then being able to redeploy it in 5 minutes.\n" +
                "\nSolution 2.\n" +
                "\n" +
                "-Deploy Docker.\n" +
                "-Deploy the app GOODAPP in container.\n" +
                "-Redeploy the container with app when needed.\n" +
                "\n" +
                "Benefits: No need of deploying full OS for each instance of the application. Deploying a container takes seconds."))
        users.add(DockerInterviewModel("9.How Did You Become Involved With The Docker Project?", "I came across Docker not long after Solomon open sourced it. I knew a bit about LXC and containers (a past life includes working on Solaris Zones and LPAR on IBM hardware too), and so I decided to try it out. I was blown away by how easy it was to use. My prior interactions with containers had left me with the feeling they were complex creatures that needed a lot of tuning and nurturing. Docker just worked out of the box. Once I saw that and then saw the CI/CD-centric workflow that Docker was building on top I was sold."))
        users.add(DockerInterviewModel("10.Docker Is The New Craze In Virtualization And Cloud Computing. Why Are People So Excited About It?", "I think it’s the lightweight nature of Docker combined with the workflow. It’s fast, easy to use and a developer-centric DevOps-ish tool. Its mission is basically: make it easy to package and ship code. Developers want tools that abstract away a lot of the details of that process. They just want to see their code working. That leads to all sorts of conflicts with Sys Admins when code is shipped around and turns out not to work somewhere other than the developer’s environment. Docker turns to work around that by making your code as portable as possible and making that portability user friendly and simple."))
        users.add(DockerInterviewModel("11.What, In Your Opinion, Is The Most Exciting Potential Use For Docker?", "It’s definitely the build pipeline. I mean I see a lot of folks doing hyper-scaling with containers, indeed you can get a lot of containers on a host and they are blindingly fast. But that doesn’t excite me as much as people using it to automate their dev-test-build pipeline."))
        users.add(DockerInterviewModel("12. How Is Docker Different From Standard Virtualization?", "Docker is operating system level virtualization. Unlike hypervisor virtualization, where virtual machines run on physical hardware via an intermediation layer (“the hypervisor”), containers instead run user space on top of an operating system’s kernel. That makes them very lightweight and very fast."))
        users.add(DockerInterviewModel("13. Do You Think Cloud Technology Development Has Been Heavily Influenced By Open Source Development?", "I think open source software is closely tied to cloud computing. Both in terms of the software running in the cloud and the development models that have enabled the cloud. Open source software is cheap, it’s usually low friction both from an efficiency and a licensing perspective."))
        users.add(DockerInterviewModel("14.Docker Vs VM (Virtual Machine)?", "* Virtual Machines *\n" +
                "\n" +
                "1.Need more resources\t  \n" +
                "2.Process isolation is done at hardware level\t\n" +
                "3.Separate Operating System for each VM\t\n" +
                "4.VMs can be customized.  \n" +
                "5.Takes time to create Virtual Machine\n" +
                "6.Booting takes minutes\n" +
                "\n" +
                "* Docker Containers *\n" +
                "\n" +
                "1.Less resources are used\n" +
                "2.Process Isolation is done at Operating System level\n" +
                "3.Operating System resources can be shared within Docker\n" +
                "4.Custom container setup is easy\n" +
                "5.Creation of docker is very quick\n" +
                "6.Booting is done within seconds"))
        users.add(DockerInterviewModel("15. How Do You Think Docker Will Change Virtualization And Cloud Environments? Do You Think Cloud Technology Has A Set Trajectory, Or Is There Still Room For Significant Change?", "I think there are a lot of workloads that Docker is ideal for, as I mentioned earlier both in the hyper-scale world of many containers and in the dev-test-build use case. I fully expect a lot of companies and vendors to embrace Docker as an alternative form of virtualization on both bare metal and in the cloud.\n" +
                "\n" +
                "As for cloud technology’s trajectory. I think we’ve seen significant change in the last couple of years. I think they’ll be a bunch more before we’re done. The question of OpenStack and whether it will succeed as an IAAS alternative or DIY cloud solution.\n" +
                "\n" +
                "I think we’ve only touched on the potential for PAAS and there’s a lot of room for growth and development in that space. It’ll also be interesting to see how the capabilities of PAAS products develop and whether they grow to embrace or connect with consumer cloud-based products."))
        users.add(DockerInterviewModel("16. Can You Give Us A Quick Rundown Of What We Should Expect From Your Docker Presentation At Oscon This Year?", "It’s very much a crash course introduction to Docker. It’s aimed at Developers and SysAdmins who want to get started with Docker in a very hands on way. We’ll teach the basics of how to use Docker and how to integrate it into your daily workflow."))
        users.add(DockerInterviewModel("17.Your Bio Says “for A Real Job” You’re The Vp Of Services For Docker. Do You Consider Your Other Open Source Work A Hobby?", "\n" +
                "That’s mostly a joke related to my partner. Like a lot of geeks, I’m often on my computer, tapping away at a problem or writing something. My partner jokes that I have two jobs: my “real” job and my open source job. Thankfully over the last few years, at places like Puppet Labs and Docker, I’ve been able to combine my passion with my paycheck."))
        users.add(DockerInterviewModel("18.Why Is Docker The New Craze In Virtualization And Cloud Computing?", "It’s OSCON time again, and this year the tech sector is abuzz with talk of cloud infrastructure. One of the more interesting startups is Docker, an ultra-lightweight containerization app that’s brimming with potential\n" +
                "\n" +
                "I caught up with the VP of Services for Docker, James Turnbull, who’ll be running a Docker crash course at the con. Besides finding out what Docker is anyway, we discussed the cloud, open source contributing, and getting a real job."))
        users.add(DockerInterviewModel("19.Why Do My Services Take 10 Seconds To Recreate Or Stop?", "Compose stop attempts to stop a container by sending a SIGTERM. It then waits for a default timeout of 10 seconds. After the timeout, a SIGKILL is sent to the container to forcefully kill it. If you are waiting for this timeout, it means that your containers aren’t shutting down when they receive the SIGTERM signal.\n" +
                "\n" +
                "There has already been a lot written about this problem of processes handling signals in containers.\n" +
                "\n" +
                "To fix this problem, try the following:\n" +
                "\n" +
                "Make sure you’re using the JSON form of CMD and ENTRYPOINT in your Dockerfile.\n" +
                "\n" +
                "For example: use [\"program\", \"arg1\", \"arg2\"] not\"program arg1 arg2\". Using the string form causes Docker to run your process using bash which doesn’t handle signals properly. Compose always uses the JSON form, so don’t worry if you override the command or entrypoint in your Compose file.\n" +
                "\n" +
                "If you are able, modify the application that you’re running to add an explicit signal handler for SIGTERM.\n" +
                "Set the stop_signal to a signal which the application knows how to handle:\n" +
                "web: build: . stop_signal: SIGINT\n" +
                "If you can’t modify the application, wrap the application in a lightweight init system (like s6) or a signal proxy (like dumb-init or tini). Either of these wrappers take care of handling SIGTERM properly."))
        users.add(DockerInterviewModel("20.How Do I Run Multiple Copies Of A Compose File On The Same Host?", "Compose uses the project name to create unique identifiers for all of a project’s containers and other resources. To run multiple copies of a project, set a custom project name using the -p command line option or theCOMPOSE_PROJECT_NAME environment variable."))
        users.add(DockerInterviewModel("21.What’s The Difference Between Up,run, And Start?", "Typically, you want docker-compose up. Use up to start or restart all the services defined in a docker-compose.yml. In the default “attached” mode, you’ll see all the logs from all the containers. In “detached” mode (-d), Compose exits after starting the containers, but the containers continue to run in the background.\n" +
                "\n" +
                "The docker-compose run command is for running “one-off” or “adhoc” tasks. It requires the service name you want to run and only starts containers for services that the running service depends on. Use run to run tests or perform an administrative task such as removing or adding data to a data volume container. The run command acts like docker run -ti in that it opens an interactive terminal to the container and returns an exit status matching the exit status of the process in the container.\n" +
                "\n" +
                "The docker-compose start command is useful only to restart containers that were previously created, but were stopped. It never creates new containers."))
        users.add(DockerInterviewModel("22.Can I Use Json Instead Of Yaml For My Compose File?", "\n" +
                "Yes. Yaml is a superset of json so any JSON file should be valid Yaml. To use a JSON file with Compose, specify the filename to use.\n" +
                "\n" +
                "for example:\n" +
                "\n" +
                "docker-compose -f docker-compose.json up"))
        users.add(DockerInterviewModel("23.Should I Include My Code With Copy/add Or A Volume?", "You can add your code to the image using COPY or ADD directive in a Dockerfile. This is useful if you need to relocate your code along with the Docker image, for example when you’re sending code to another environment (production, CI, etc).\n" +
                "\n" +
                "You should use a volume if you want to make changes to your code and see them reflected immediately, for example when you’re developing code and your server supports hot code reloading or live-reload.\n" +
                "\n" +
                "There may be cases where you’ll want to use both. You can have the image include the code using a COPY, and use a volume in your Compose file to include the code from the host during development. The volume overrides the directory contents of the image."))
        users.add(DockerInterviewModel("24.Where Can I Find Example Compose Files?", "There are many examples of Compose files on github.\n" +
                "\n" +
                "Compose documentation:\n" +
                "\n" +
                "Installing Compose\n" +
                "Get started with Django\n" +
                "Get started with Rails\n" +
                "Get started with WordPress\n" +
                "Command line reference\n" +
                "Compose file reference"))
        users.add(DockerInterviewModel("25. Are You Operationally Prepared To Manage Multiple Languages/libraries/repositories?", "Last year, we encountered an organization that developed a modular application while allowing developers to “use what they want” to build individual components. It was a nice concept but a total organizational nightmare — chasing the ideal of modular design without considering the impact of this complexity on their operations.\n" +
                "\n" +
                "The organization was then interested in Docker to help facilitate deployments, but we strongly recommended that this organization not use Docker before addressing the root issues.\n" +
                "\n" +
                "Making it easier to deploy these disparate applications wouldn’t be an antidote to the difficulties of maintaining several different development stacks for long-term maintenance of these apps."))
        users.add(DockerInterviewModel("26. Do You Already Have A Logging, Monitoring, Or Mature Deployment Solution?", "Chances are that your application already has a framework for shipping logs and backing up data to the right places at the right times. To implement Docker, you not only need to replicate the logging behavior you expect in your virtual machine environment, but you also need to prepare your compliance or governance team for these changes.\n" +
                "\n" +
                "New tools are entering the Docker space all the time, but many do not match the stability and maturity of existing solutions. Partial updates, rollbacks and other common deployment tasks may need to be reengineered to accommodate a containerized deployment.\n" +
                "\n" +
                "If it’s not broken, don’t fix it. If you’ve already invested the engineering time required to build a continuous integration/continuous delivery (CI/CD) pipeline, containerizing legacy apps may not be worth the time investment."))
        users.add(DockerInterviewModel("27.Will Cloud Automation Overtake Containerization?", "At AWS Re:Invent last month, Amazon chief technology officer Werner Vogels spent a significant portion of his keynote on AWS Lambda, an automation tool that deploys infrastructure based on your code. While Vogels did mention AWS’ container service, his focus on Lambda implies that he believes dealing with zero infrastructure is preferable to configuring and deploying containers for most developers.\n" +
                "\n" +
                "Containers are rapidly gaining popularity in the enterprise, and are sure to be an essential part of many professional CI/CD pipelines. But as technology experts and CTOs, it is our responsibility to challenge new methodologies and services and properly weigh the risks of early adoption. I believe Docker can be extremely effective for organizations that understand the consequences of containerization."))
        users.add(DockerInterviewModel("28.You Say That Ansible Can Take Up To 20x Longer To Provision, But Why?", "Docker uses cache to speed up builds significantly. Every command in Dockerfile is build in another docker container and it’s results are stored in separate layer. Layers are built on top of each other.\n" +
                "\n" +
                "Docker scans Dockerfile and try to execute each steps one after another, before executing it probes if this layer is already in cache. When cache is hit, building step is skipped and from user perspective is almost instant.\n" +
                "\n" +
                "When you build your Dockerfile in a way that the most changing things such as application source code are on the bottom, you would experience instant builds.\n" +
                "\n" +
                "You can learn more about caching in docker in this article.\n" +
                "\n" +
                "Another way of amazingly fast building docker images is using good base image – which you specify inFROM command, you can then only make necessary changes, not rebuild everything from scratch. This way, build will be quicker. It’s especially beneficial if you have a host without the cache like Continuous Integration server.\n" +
                "\n" +
                "Summing up, building docker images with Dockerfile is faster than provisioning with ansible, because of using docker cache and good base images. Moreover you can completely eliminate provisioning, by using ready to use configured images such stgresus.\n" +
                "\n" +
                "\$ docker run --name some-postgres -d postgres No installing postgres at all - it's ready to run."))
        users.add(DockerInterviewModel("29.Also You Mention That Docker Allows Multiple Apps To Run On One Server.?", "It depends on your use case. You probably should split different components into separate containers. It will give you more flexibility.\n" +
                "\n" +
                "Docker is very lightweight and running containers is cheap, especially if you store them in RAM – it’s possible to spawn new container for every http callback, however it’s not very practical.\n" +
                "\n" +
                "At work I develop using set of five different types of containers linked together.\n" +
                "\n" +
                "In production some of them are actually replaced by real machines or even clusters of machine – however settings on application level don’t change.\n" +
                "\n" +
                "Here you can read more about linking containers.\n" +
                "\n" +
                "It’s possible, because everything is communicating over the network. When you specify links in dockerrun command – docker bridges containers and injects environment variables with information about IPs and ports of linked children into the parent container.\n" +
                "\n" +
                "This way, in my app settings file, I can read those values from environment. In python it would be:\n" +
                "\n" +
                "import os VARIABLE = os.environ.get('VARIABLE')\n" +
                "\n" +
                "There is a tool which greatly simplifies working with docker containers, linking included. It’s called fig and you can read more about it here."))
        users.add(DockerInterviewModel("30.Finally, What Does The Deploy Process Look Like For Dockerized Apps Stored In A Git Repo?", "It depends how your production environment looks like.\n" +
                "\n" +
                "Example deploy process may look like this:\n" +
                "\n" +
                "Build an app using docker build . in the code directory.\n" +
                "Test an image.\n" +
                "Push the new image out to registry docker push myorg/myimage.\n" +
                "Notify remote app server to pull image from registry and run it (you can also do it directly using some configuration management tool).\n" +
                "Swap ports in a http proxy.\n" +
                "Stop the old container.\n" +
                "You can consider using amazon elastic beanstalk with docker or dokku.\n" +
                "\n" +
                "Elastic beanstalk is a powerful beast and will do most of deployment for you and provide features such as autoscaling, rolling updates, zero deployment deployments and more.\n" +
                "\n" +
                "Dokku is very simple platform as a service similar to heroku."))
        users.add(DockerInterviewModel("31.What is Docker image?", "Docker image can be understood as a template from which Docker containers can be created as many as we want out of that single Docker image. Having said that, to put it in layman terms, Docker containers are created out of Docker images. Docker images are created with the build command, and this produces a container that starts when it is run. Docker images are stored in the Docker registry such as the public Docker registry (registry.hub.docker.com) as these are designed to be constituted with layers of other images, enabling just the minimal amount of data over the network."))
        users.add(DockerInterviewModel("32.What is Docker container?", "This is a very important question so just make sure you don’t deviate from the topic and I will advise you to follow the below mentioned format:\n" +
                "\n" +
                "1. Docker containers include the application and all of its dependencies, but share the kernel with other containers, running as isolated processes in user space on the host operating system. Docker containers are not tied to any specific infrastructure: they run on any computer, on any infrastructure, and in any cloud.\n" +
                "2. Now explain how to create a Docker container, Docker containers can be created by either creating a Docker image and then running it or you can use Docker images that are present on the Dockerhub.\n" +
                "3. Docker containers are basically runtime instances of Docker images."))
        users.add(DockerInterviewModel("33.What is Docker hub?", "Docker hub is a cloud-based registry service which allows you to link to code repositories, build your images and test them, stores manually pushed images, and links to Docker cloud so you can deploy images to your hosts. It provides a centralized resource for container image discovery, distribution and change management, user and team collaboration, and workflow automation throughout the development pipeline."))
        users.add(DockerInterviewModel("34.What is Docker Swarm?", "Docker Swarm can be best understood as the native way of Clustering implementation for Docker itself. Docker Swarm turns a pool of Docker hosts into a single and virtual Docker host. It serves the standard Docker API or any other tool that can already communicate with a Docker daemon can make use of Docker Swarm to scale in a transparent way to multiple hosts. Following are the list of some of the supported tools that will be helpful in achieving what we have discussed just now.\n" +
                "\n" +
                "• Dokku\n" +
                "• Docker Compose\n" +
                "• Docker Machine\n" +
                "• Jenkins"))
        users.add(DockerInterviewModel("35.What is Dockerfile used for?", "Dockerfile is nothing but a set of instructions that have to be passed on to Docker itself, so that it can build images automatically reading these instructions from that specified Dockerfile. A Dockerfile is a text document that contains all the commands a user could call on the command line to assemble an image. Using docker build users can create an automated build that executes several command-line instructions in succession."))
        users.add(DockerInterviewModel("36.Can I use JSON instead of YAML for my compose file in Docker?", "YES, you can very comfortably use JSON instead of the default YAML for your Docker compose file. In order to use JSON file with compose, you need to specify the filename to use as the following:\n" +
                "docker-compose -f docker-compose.json up"))
        users.add(DockerInterviewModel("37.Tell us how you have used Docker in your past position?", "This is a question that you could bring upon your whole experience with Docker and if you have used any other Container technologies before Docker. You could also explain the ease that this technology has brought in the automation of the development to production lifecycle management. You can also discuss about any other integrations that you might have worked along with Docker such as Puppet, Chef or even the most popular of all technologies – Jenkins. If you do not have any experience with Docker itself but similar tools from this space, you could convey the same and also show in your interest towards learning this leading containerization technology."))
        users.add(DockerInterviewModel("38.How to create Docker container?", "You can create a Docker container out of any specific Docker image of your choice and the same can be achieved using the command given below:\n" +
                "docker run -t -i command name\n" +
                "The command above will create the container and also starts it for you. In order to check whether the Docker container is created and whether it is running or not, you could make use of the following command. This command will list out all the Docker containers along with its statuses on the host that the Docker container runs.\n" +
                "docker ps -a"))
        users.add(DockerInterviewModel("39.How to stop and restart the Docker container?", "The following command can be used to stop a certain Docker container with the container id as\n" +
                "\n" +
                "CONTAINER_ID:\n" +
                "docker stop CONTAINER_ID\n" +
                "The following command can be used to restart a certain Docker container with the container id as\n" +
                "\n" +
                "CONTAINER_ID:\n" +
                "docker restart CONTAINER_ID"))
        users.add(DockerInterviewModel("40.How far do Docker containers scale?", "Best examples in the Web deployments like Google, Twitter and best examples in the Platform Providers like Heroku, dotCloud run on Docker which can scale from the ranges of hundreds of thousands to millions of containers running in parallel, given the condition that the OS and the memory doesn’t run out from the hosts which runs all these innumerable containers hosting your applications."))
        users.add(DockerInterviewModel("41.What platforms does Docker run on?", "Docker is currently available on the following platforms and also on the following Vendors or Linux:\n" +
                "\n" +
                "• Ubuntu 12.04, 13.04\n" +
                "• Fedora 19/20+\n" +
                "• RHEL 6.5+\n" +
                "• CentOS 6+\n" +
                "• Gentoo\n" +
                "• ArchLinux\n" +
                "• openSUSE 12.3+\n" +
                "• CRUX 3.0+\n" +
                "Docker is currently available and also is able to run on the following Cloud environment setups given as below:\n" +
                "• Amazon EC2\n" +
                "• Google Compute Engine\n" +
                "• Microsoft Azure\n" +
                "• Rackspace\n" +
                "\n" +
                "Docker is extending its support to Windows and Mac OSX environments and support on Windows has been on the growth in a very drastic manner."))
        users.add(DockerInterviewModel("42.Do I lose my data when the Docker container exits?", "There is no loss of data when any of your Docker containers exits as any of the data that your application writes to the disk in order to preserve it. This will be done until the container is explicitly deleted. The file system for the Docker container persists even after the Docker container is halted."))
        users.add(DockerInterviewModel("43.What, in your opinion, is the most exciting potential use for Docker?", "The most exciting potential use of Docker that I can think of is its build pipeline. Most of the Docker professionals are seen using hyper-scaling with containers, and indeed get a lot of containers on the host that it actually runs on. These are also known to be blatantly fast. Most of the development – test build pipeline is completely automated using the Docker framework."))
        users.add(DockerInterviewModel("44.What’s the benefit of “Dockerizing?”", "Dockerizing enterprise environments helps teams to leverage over the Docker containers to form a service platform as like a CaaS (Container as a Service). It gives teams that necessary agility, portability and also lets them control staying within their own network / environment.\n" +
                "\n" +
                "Most of the developers opt to use Docker and Docker alone because of the flexibility and also the ability that it provides to quickly build and ship applications to the rest of the world. Docker containers are portable and these can run on any environment without making any additional changes when the application developers have to move between Developer, Staging and Production environments. This whole process is seamlessly implemented without the need of performing any recoding activities for any of the environments. These not only helps reduce the time between these lifecycle states, but also ensures that the whole process is performed with utmost efficiency. There is every possibility for the Developers to debug any certain issue, fix it and also update the application with it and propagate this fix to the higher environments with utmost ease.\n" +
                "\n" +
                "The operations teams can handle the security of the environments while also allowing the developers build and ship the applications in an independent manner. The CaaS platform that is provided by Docker framework can deploy on-premise and is also loaded with full of enterprise level security features such as role-based access control, integration with LDAP or any Active Directory, image signing and etc. Operations teams have heavily rely on the scalability provided by Docker and can also leverage over the Dockerized applications across any environments.\n" +
                "\n" +
                "Docker containers are so portable that it allows teams to migrate workloads that run on an Amazon’s AWS environment to Microsoft Azure without even having to change its code and also with no downtime at all. Docker allows teams to migrate these workloads from their cloud environments to their physical datacenters and vice versa. This also enables the Organizations to focus on the infrastructure from the gained advantages both monetarily and also the self-reliability over Docker. The lightweight nature of Docker containers compared to traditional tools like virtualization, combined with the ability for Docker containers to run within VMs, allowing teams to optimize their infrastructure by 20X, and save money in the process."))
        users.add(DockerInterviewModel("45.How many containers can run per host?", "Depending on the environment where Docker is going to host the containers, there can be as many containers as the environment supports. The application size, available resources (like CPU, memory) will decide on the number of containers that can run on an environment. Though containers create newer CPU on their own but they can definitely provide efficient ways of utilizing the resources. The containers themselves are super lightweight and only last as long as the process they are running."))
        users.add(DockerInterviewModel("46.Is there a possibility to include specific code with COPY/ADD or a volume?", "This can be easily achieved by adding either the COPY or the ADD directives in your dockerfile. This will count to be useful if you want to move your code along with any of your Docker images, example, sending your code an environment up the ladder – Development environment to the Staging environment or from the Staging environment to the Production environment. \n" +
                "\n" +
                "Having said that, you might come across situations where you’ll need to use both the approaches. You can have the image include the code using a COPY, and use a volume in your Compose file to include the code from the host during development. The volume overrides the directory contents of the image."))
        users.add(DockerInterviewModel("47.Will cloud automation overtake containerization any sooner?", "Docker containers are gaining the popularity each passing day and definitely will be a quintessential part of any professional Continuous Integration / Continuous Development pipelines. Having said that there is equal responsibility on all the key stakeholders at each Organization to take up the challenge of weighing the risks and gains on adopting technologies that are budding up on a daily basis. In my humble opinion, Docker will be extremely effective in Organizations that appreciate the consequences of Containerization."))
        users.add(DockerInterviewModel("48.Is there a way to identify the status of a Docker container?", "We can identify the status of a Docker container by running the command ‘docker ps –a’, which will in turn list down all the available docker containers with its corresponding statuses on the host. From there we can easily identify the container of interest to check its status correspondingly."))
        users.add(DockerInterviewModel("49.What are the differences between the ‘docker run’ and the ‘docker create’?", "The most important difference that can be noted is that, by using the ‘docker create’ command we can create a Docker container in the Stopped state. We can also provide it with an ID that can be stored for later usages as well.\n" +
                "This can be achieved by using the command ‘docker run’ with the option –cidfile FILE_NAME as like this:\n" +
                "‘docker run –cidfile FILE_NAME’"))
        users.add(DockerInterviewModel("50.What are the various states that a Docker container can be in at any given point in time?", "There are four states that a Docker container can be in, at any given point in time. Those states are as given as follows:\n" +
                "\n" +
                "• Running\n" +
                "• Paused\n" +
                "• Restarting\n" +
                "• Exited"))
        users.add(DockerInterviewModel("51.Can you remove a paused container from Docker?", "To answer this question blatantly, No, it is not possible to remove a container from Docker that is just paused. It is a must that a container should be in the stopped state, before it can be removed from the Docker container."))
        users.add(DockerInterviewModel("52.Is there a possibility that a container can restart all by itself in Docker?", "To answer this question blatantly, No, it is not possible. The default –restart flag is set to never restart on its own. If you want to tweak this, then you may give it a try."))
        users.add(DockerInterviewModel("53.What is the preferred way of removing containers - ‘docker rm -f’ or ‘docker stop’ then followed by a ‘docker rm’?", "The best and the preferred way of removing containers from Docker is to use the ‘docker stop’, as it will allow sending a SIG_HUP signal to its recipients giving them the time that is required to perform all the finalization and cleanup tasks. Once this activity is completed, we can then comfortably remove the container using the ‘docker rm’ command from Docker and thereby updating the docker registry as well."))
        users.add(DockerInterviewModel("54.How to know the container status?", "Just fire docker ps –a to list out all running container with stauts (running or stopped) on a host"))
        users.add(DockerInterviewModel("55.What is the difference between ‘docker run’ and ‘docker create’?", "The primary difference is that using ‘docker create’ creates a container in a stopped state.\n" +
                "\n" +
                "Bonus point: You can use ‘docker create’ and store an outputed container ID for later use. The best way to do it is to use ‘docker run’ with --cidfile FILE_NAME as running it again won’t allow to overwrite the file. A good practice is to keep well ogranised directory structure: /containers/web/server1/ws.cid containers/web/server3/ws.cid"))
        users.add(DockerInterviewModel("56.Can you create containers wihout their own PID namespace?", "yes"))
        users.add(DockerInterviewModel("57.Does the order of starting containers is important, if yes why?", "Of course. Let’s say you have linked containers, so there’s a dependency between them."))
        users.add(DockerInterviewModel("58.How to build envrionment-agnostic systems with Docker?", "There are three main features helping to achieve that:\n" +
                "\n" +
                "Volumes\n" +
                "Environment variable injection\n" +
                "Read-only file systems"))
        users.add(DockerInterviewModel("59.What are the four states that a Docker container can be in?", "Running\n" +
                "Paused\n" +
                "Restarting\n" +
                "Exited"))
        users.add(DockerInterviewModel("60.Can you remove (‘docker rm’) a container that is paused?", "No, to remove a container it must be stopped first."))
        users.add(DockerInterviewModel("61.Does a Docker container automatically restart itself?", "No. The default –restart flag is set to never restart.\n" +
                "\n"))
        users.add(DockerInterviewModel("62.Which way of removing containters is preffered, ‘docker rm -f’ or docker stop followed by docker rm?", "‘docker stop’ is preffered as it will send a SIG_HUP signal to its recipients giving them time to perform finalization and cleanup tasks."))
        users.add(DockerInterviewModel("63.When would you use ‘docker kill’ or ‘docker rm -f’?", "If you must stop the container really quickly… (someone pushed something to production on Friday evening?… ;) )"))
        users.add(DockerInterviewModel("64.What’s the difference between a repository and a registry?", "Docker registry is a service for hosting and distributing images (the default one is the Docker Hub). Docker repository is a collection of related Docker images (the same name but with different tags)."))
        users.add(DockerInterviewModel("65.How to link containers?\n", "The simplest way is to use network port mapping. There’s also the - -link flag which is deprecated.\n" +
                "\n"))
        users.add(DockerInterviewModel("66.What happens to a data volume after a container is deleted?\n", "It persists.\n" +
                "\n"))
        users.add(DockerInterviewModel("67.What is an orphant volume and how to remove it?\n", "An orphant volume is a volume without any containers attached to it. Prior Docker v. 1.9 it was very problematic to remove it.\n" +
                "\n"))
        users.add(DockerInterviewModel("68.When you limit the memory for a container, does it reserve (guarantee) the memory?\n", "No, it only protects from overconsumption.\n" +
                "\n"))
        users.add(DockerInterviewModel("69.When you limit the memory for a container, does it reserve (guarantee) the memory?", "No, it only protects from overconsumption."))
        users.add(DockerInterviewModel("70.What is the default CPU limit set for a container?", "No limit by default, it can consume up to 100% of the CPU."))
        users.add(DockerInterviewModel("71.Does Docker support User Namespaces?", "Yes, you can map the root user in a container to a non uid-0 user outside then container (it is not enabled by default).\n" +
                "\n"))
        users.add(DockerInterviewModel("72.What is the difference between Docker RUN, CMD and ENTRYPOINT?\n", "CMD does not execute anything at build time, but specifies the intended command for the image.\n" +
                "RUN actually runs a command and commits the result.\n" +
                "If you would like your container to run the same executable every time, then you should consider using ENTRYPOINT in combination with CMD."))
        users.add(DockerInterviewModel("73.Why did Docker jump from version 1.13 to 17.03?", " would ask this only to see if someone is following updates. Starting with version 17.03 Docker is on a monthly release cycle and uses a new YY.MM versioning scheme to reflect this."))
        users.add(DockerInterviewModel("74.Which instruction must be given first in a Dockerfile?\n", "FROM"))
        users.add(DockerInterviewModel("75.Do instructions in Dockerfile are case-sensitive?\n", "No. However, convention is for them to be uppercase (to distinguish them from arguments more easily).\n" +
                "\n"))
        users.add(DockerInterviewModel("76.What happens if you add more than one CMD instruction to a Dockerfile?\n", "Only the last CMD will take effect.\n" +
                "\n"))
        users.add(DockerInterviewModel("77.Can you run Docker containers natively on Windows?\n", "With Windows Server 2016 you can run Docker containers natively on Windows, and with Windows Nano Server you’ll have a lightweight OS to run inside containers, so you can run .NET apps on their native platform."))
        //creating our adapter
        val adapter = DockerInterAdapter(users)
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
         * @return A new instance of fragment DockerInterviewQuestionsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                DockerInterviewQuestionsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
