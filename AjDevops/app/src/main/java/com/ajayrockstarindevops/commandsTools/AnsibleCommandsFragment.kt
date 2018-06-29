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
import com.ajayrockstarindevops.adapter.AnsibleAdapter.AnsibleCommandsAdapter

import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.AnsibleModel.AnsibleCommandsModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AnsibleCommandsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class AnsibleCommandsFragment : Fragment() {
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
    val view = inflater.inflate(R.layout.fragment_ansible_commands, container, false)
    //getting recyclerview from xml
    val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
    //adding a layoutmanager
    recyclerView.setHasFixedSize(true)
    val itemDecor = DividerItemDecoration(context, LinearLayout.VERTICAL)
    recyclerView.addItemDecoration(itemDecor)
    recyclerView.itemAnimator = DefaultItemAnimator()
    recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
    //crating an arraylist to store users using the data class user
    val users = ArrayList<AnsibleCommandsModel>()
    //adding some dummy data to the list
/*
    https@ //linuxtechlab.com/ansible-tutorial-simple-commands/
    https://serversforhackers.com/c/an-ansible-tutorial
    https://linoxide.com/linux-how-to/started-ansible-command-line/
    http://codeheaven.io/15-things-you-should-know-about-ansible/
    https://foxutech.com/ansible-commands/
    https://www.ansible.com/blog/getting-started-writing-your-first-playbook
*/
    users.add(AnsibleCommandsModel("ansible <group> -m ping","The command to check connectivity of hosts ",""))
    users.add(AnsibleCommandsModel("ansible <group> -a “/sbin/reboot”","Rebooting hosts",""))
    users.add(AnsibleCommandsModel("ansible <group> -m setup | less","Ansible collects the system’s information for all the hosts connected to it. To display the information of hosts, run",""))
    users.add(AnsibleCommandsModel("ansible <group> -m setup -a “filter=ansible_distribution","Secondly, to check a particular info from the collected information by passing an argument",""))
    users.add(AnsibleCommandsModel("ansible <group> -m copy -a “src=/home/dan dest=/tmp/home","For transferring files we use a module ‘copy’ & complete command that is used",""))
    users.add(AnsibleCommandsModel("ansible <group> -m user -a “name=testuser password=<encrypted password>","Creating a new user",""))
    users.add(AnsibleCommandsModel("ansible <group> -m user -a “name=testuser state=absent","Deleting a user","Note:- \n To create an encrypted password, use the ‘mkpasswd –method=sha-512’ command."))
    users.add(AnsibleCommandsModel("ansible <group> -m file -a “dest=/home/dan/file1.txt mode=777","Changing permission of a file",""))
    users.add(AnsibleCommandsModel("ansible <group> -m file -a “dest=/home/dan/file1.txt mode=777 owner=dan group=dan","Changing ownership of a file",""))
    users.add(AnsibleCommandsModel("ansible <group> -m yum -a “name=ntp state=latest","Check if package is installed & update it",""))
    users.add(AnsibleCommandsModel("ansible <group> -m yum -a “name=ntp state=present","Check if package is installed & don’t update it",""))
    users.add(AnsibleCommandsModel("ansible <group> -m yum -a “name= ntp-1.8 state=present","Check if package is at a specific version",""))
    users.add(AnsibleCommandsModel("ansible <group> -m yum -a “name=ntp state=absent","Check if package is not installed",""))
    users.add(AnsibleCommandsModel("ansible <group> -m service -a “name=httpd state=started","Starting a service",""))
    users.add(AnsibleCommandsModel("ansible <group> -m service -a “name=httpd state=stopped","Stopping a service",""))
    users.add(AnsibleCommandsModel("ansible <group> -m service -a “name=httpd state=restarted","Restarting a service",""))
    users.add(AnsibleCommandsModel("ansible <pattern> -m <module> [-a <arguments>]","<pattern> specifies which hosts the module should be applied to.\n" +
            "<module> tells Ansible which command (module) to execute.\n" +
            "<arguments> are optional module parameters.",""))
    users.add(AnsibleCommandsModel("ansible-playbook --check playbook.yml","Ansible supports running a playbook in dry run mode (also called Check Mode), in this mode, Ansible will not make any changes to your host, but simply report what changes would have been made if the playbook was run without this flag.",""))
    users.add(AnsibleCommandsModel("ansible-vault encrypt secrets.yml","Encrypt an existing file. You'll need to create an encryption password.","If one of your tasks requires sensitive information (let’s say the database user and password), it’s a good practice to keep this information encrypted, instead of storing it in plain text.\n" +
            "\n" +
            "Ansible ships with a command line tool called ansible-vault, that allows you to create and manage encrypted files. This way you can commit the encrypted file to your source control and only users with the decryption password will be able to read it."))
    users.add(AnsibleCommandsModel("ansible-vault create secrets.yml ","Creates a new, encrypted file. You'll need to create an encryption password.",""))
    users.add(AnsibleCommandsModel("ansible-vault decrypt secrets.yml ","Decrypt a file. You'll have to enter password used for encryption.","Use it with caution! Don't leave your files unecrypted."))
    users.add(AnsibleCommandsModel("ansible-vault edit secrets.yml ","Edit an encrypted file (uses vim by default, can be overriden by the environment variable EDITOR)",""))
    users.add(AnsibleCommandsModel("ansible-vault edit secrets.yml","Print the contents of the encrypted file",""))
    users.add(AnsibleCommandsModel("ansible-playbook playbook.yml -i hosts --ask-vault-password","If you import the vars_file secrets.yml in your playbook, Ansible will fail, as it will not know how to read the encrypted file. You’ll have to specify the command line argument –ask-vault-pass, which will make Ansible prompt you the password of the encrypted file.","Another way is to store the password in a file (which should not be committed) and specify the path to the file using the –vault-password-file argument. If this file is marked as executable, Ansible will run it and use the output as the password."))
    users.add(AnsibleCommandsModel("15 Things You Should Know About Ansible","",""))
    users.add(AnsibleCommandsModel("1 - You can pass parameters to roles","It’s a good practice to create roles to organize your playbooks. Let’s say we want to create a role for installing Jenkins. The folder structure for this role could look something like this:\n" +
            "\n" +
            "jenkins/\n" +
            "   files/\n" +
            "   templates/\n" +
            "   tasks/\n" +
            "   handlers/\n" +
            "   defaults/\n" +
            "The folder defaults is used to store the values of default vars for a role. Inside of it we could have this main.yml file:\n" +
            "\n" +
            "jenkins_port: 8080\n" +
            "jenkins_context_path: /jenkins\n" +
            "jenkins_home: /jenkins\n" +
            "You could overwrite the default variables, by passing different parameters to the role like so:\n" +
            "\n" +
            "roles:\n" +
            "   - { role: jenkins, jenkins_port: 8181, jenkins_home: '/jenkins1' }\n" +
            "   - { role: jenkins, jenkins_port: 8080, jenkins_home: '/jenkins2' }",""))
    users.add(AnsibleCommandsModel("2 - How to make the command module idempotent","Idempotence is the property of certain operations that can be executed multiple times without changing the result of the initial application. This concept is present in most Ansible modules: you specify the desired final state and Ansible decides if the task should be run. This principle is not applied by default to the command module. By default, if you have the task below in your playbook, it will always be run:\n" +
            "\n" +
            "- command: /usr/bin/create-database.sh\n" +
            "In order to achieve idempotence, you could use the attribute creates. When present, Ansible will only run the command task if the file specified by the pattern does not exists. Alternatively you could use removes, which will only execute the task if the file specified exists.\n" +
            "\n" +
            "- command: /usr/bin/create-database.sh creates=/path/to/database\n" +
            "Always have in mind that Ansible has a lot of modules and most common operations do not require the use of the command module. For instance, there are modules for creating filesystems, modifying the iptables and managing cron entries. All these modules are idempotent by default, so you always should prefer them.",""))
    users.add(AnsibleCommandsModel("3 - Using Ansible setup’s module to gather information about your hosts","You probably have seen that the first thing Ansible does when it runs a playbook is something like this:\n" +
            "\n" +
            "TASK [setup] *******************************************************************\n" +
            "ok: [servername]\n" +
            "This happens because Ansible invokes the special module setup before executing the first task. The setup module connects to the host and gather facts for all kind of details: IP address, disk space, CPU architecture, available memory and more. It could be useful to invoke this module manually as a quick way to gather information about your hosts. In order to do so simply run the command below:","\$ ansible localhost -m setup\n" +
            "localhost | SUCCESS => {\n" +
            "  \"ansible_facts\": {\n" +
            "    \"ansible_all_ipv4_addresses\": [\n" +
            "        \"10.27.12.77\",\n" +
            "        \"192.168.33.1\"\n" +
            "    ],\n" +
            "    (MANY more facts)\n" +
            "  }"))
    users.add(AnsibleCommandsModel("4 - You can list all tasks of a playbook","Want to remember what a playbook does? Run ansible-playbook using the --list-tasks flag and Ansible will list all its tasks:","\$ ansible-playbook install-jenkins.yml --list-tasks\n" +
            "PLAY: #1\n" +
            "  tasks:\n" +
            "    TASK: meta\n" +
            "    TASK: open-jdk : Install open jdk 1.8\n" +
            "    TASK: mount-partition : Creating the filesystem for the device {{ device }}  (if needed)\n" +
            "    TASK: mount-partition : Mounting the device {{ device }} on path {{ path }}\n" +
            "    TASK: jenkins : Ensure Jenkins repo is installed.\n" +
            "    TASK: jenkins : Add Jenkins repo GPG key.\n" +
            "    TASK: jenkins : Ensure Jenkins is present.\n" +
            "    TASK: jenkins : Ensures that the home directory exists\n" +
            "    TASK: jenkins : include\n" +
            "    TASK: jenkins : Ensure Jenkins is started and runs on startup.\n" +
            "    TASK: jenkins : Wait for Jenkins to start up before proceeding.\n" +
            "    TASK: jenkins : Get the jenkins-cli jarfile from the Jenkins server."))
    users.add(AnsibleCommandsModel("5 - Use ansible-vault when you want to store sensitive information","If one of your tasks requires sensitive information (let’s say the database user and password), it’s a good practice to keep this information encrypted, instead of storing it in plain text.\n" +
            "\n" +
            "Ansible ships with a command line tool called ansible-vault, that allows you to create and manage encrypted files. This way you can commit the encrypted file to your source control and only users with the decryption password will be able to read it.",""))
    users.add(AnsibleCommandsModel("6 - Using with_items might be a good idea","When you use the with_items clause, Ansible will create a variable called {{item}} containing the value for the current iteration. Some modules handle collections of items really well and are actually faster than running the same task multiple times with different parameters."," # Installing all packages with one task (faster)\n" +
            "  - name: install required packages using the apt module\n" +
            "    apt: package={{ item }}  update_cache=yes\n" +
            "    sudo: True\n" +
            "    with_items:\n" +
            "      - git\n" +
            "      - memcached\n" +
            "      - nginx\n" +
            "\n" +
            "  # Installing packages individually (slower)\n" +
            "  - name: install git\n" +
            "    apt: package=git update_cache=yes\n" +
            "    sudo: True\n" +
            "\n" +
            "  - name: install memcached\n" +
            "    apt: package=memcached update_cache=yes\n" +
            "    sudo: True\n" +
            "\n" +
            "  - name: install nginx\n" +
            "    apt: package=nginx update_cache=yes\n" +
            "    sudo: True"))
    users.add(AnsibleCommandsModel("7 - How Local Actions work","Sometimes you might want to run a task on your local machine instead of running it on the remote machine. This could be useful when we want to wait for the server to start (if it has just booted) or when we want to add some nodes in a load balancer pool (or remove them):","tasks:\n" +
            " - name: take out of load balancer pool\n" +
            "   local_action: >\n" +
            "      command /usr/bin/take_out_of_pool {{ inventory_hostname }}\n" +
            "\n" +
            " - name: update application\n" +
            "   yum: name=acme-web-stack state=latest\n" +
            "\n" +
            " - name: add back to load balancer pool\n" +
            "   local_action: >\n" +
            "      command /usr/bin/take_out_of_pool {{ inventory_hostname }}\n" +
            "\n" +
            "Below is an example of how to launch an EC2 instance and wait for it to be available:\n" +
            "\n" +
            "- name: Launching EC2 Instance\n" +
            "    # instance options here\n" +
            "  register: ec2\n" +
            "\n" +
            "\n" +
            "- name: Waiting for ec2 instances to listen on port 22\n" +
            "  wait_for:\n" +
            "    state=started\n" +
            "    host={{ item.public_dns_name }}\n" +
            "    port=22\n" +
            "  with_items: ec2.instances"))
    users.add(AnsibleCommandsModel("8 - You can tell Ansible to run a task only once","Sometimes you might want to run a task only once, even when there are multiple hosts. As an example, let’s say you have several application servers that connect to the same database and you have a task that performs a database migration. In this case, you need to run this task only once.\n" +
            "\n" +
            "To achieve that, you can use the run_once parameter to tell Ansible to run the command only one time:","- name: run the database migrations\n" +
            "  command: bundle exec rake db:migrate\n" +
            "  run_once: true"))
    users.add(AnsibleCommandsModel("9 - Handlers are special types of tasks","Handlers are tasks with unique names that will only be executed if notified by another task. They are really useful for restarting a service or rebooting the system.\n" +
            "\n" +
            "Handlers that were notified will be executed one time at the end of the playbook and, regardless of how many times they were notified. You can declare them with the handler clause and trigger them using notify.\n" +
            "\n" +
            "Here is an example of how restart two services when the contents of a file change, but only if the file changes (extracted from Ansible docs):","- name: template configuration file\n" +
            "  template: src=template.j2 dest=/etc/foo.conf\n" +
            "  notify:\n" +
            "     - restart memcached\n" +
            "     - restart apache\n" +
            "The handlers should be declared somewhere else in your playbook:\n" +
            "\n" +
            "handlers:\n" +
            "    - name: restart memcached\n" +
            "      # The service module was used, but you could use whatever module you wanted\n" +
            "      service: name=memcached state=restarted\n" +
            "    - name: restart apache\n" +
            "      service: name=apache state=restarted"))
    users.add(AnsibleCommandsModel("10 - Speeding things up with pipelining","There are some things you can do to make Ansible run even faster:\n" +
            "\n" +
            "Enable pipelining\n" +
            "Enabling pipelining reduces the number of SSH operations required to execute a module on the remote server, by piping scripts to the SSH session instead of copying it. This can result in a very significant performance improvement when enabled.\n" +
            "You should be careful, though. Pipelining will only work if the option requiretty is disabled on all remote machines in the sudoers file (/etc/sudoers).\n" +
            "\n" +
            "[ssh_connection]\n" +
            "pipelining = True","Turn off fact gathering or enable fact caching\n" +
            "If you are not using any Ansible facts in your tasks, you can disable the “fact gathering” step for improved speed. To do so, simply add the property gather_facts: False in your playbook:\n" +
            "- hosts: servername\n" +
            "  gather_facts: False\n" +
            "  tasks:\n" +
            "    - name: ...\n" +
            "    # ...\n" +
            "Alternatively, if you do need to use Ansible facts (automatically gathered by the setup task) you can cache them so subsequent executions will be faster. "))
    users.add(AnsibleCommandsModel("11 - Ansible has several notification modules","Using Ansible to automate your blue-green deployment? Running playbooks to provision new instances on AWS? Let your team know using one of their notifications modules. As an example, the task below will send a slack notification with a custom message:","- hosts: servername\n" +
            "  tasks:\n" +
            "    - name: Send notification message via Slack\n" +
            "      local_action:\n" +
            "        module: slack\n" +
            "        # To retrieve your slack token, open your team settings and look for the\n" +
            "        # Incoming Webhooks plugin\n" +
            "        token: <your>/<token>/<goes here>\n" +
            "        msg: \"Hello team! I just finished updating our production environment.\"\n" +
            "        channel: \"#general\"\n" +
            "        username: \"ansible-bot\"\n" +
            "There are also modules available for notificating irc, twillio, hipchat, jabber and many more."))
    users.add(AnsibleCommandsModel("12 - EC2 instances are automatically grouped by their tags","When using Amazon Web Services and Ansible’s EC2 dynamic inventory script, all instances will be grouped based on their characteristics, such as their type, keypairs and tags. EC2 tags are simply key=name values associated with your instances and you can use them however you like. Some use tags to group their production/staging servers, mark the web servers or even the “active” servers during a blue-green deployment.\n" +
            "\n" +
            "EC2 Dynamic Inventory script uses the following pattern (without the brackets) when grouping hosts by tag:\n" +
            "\n" +
            "tag_[TAG_NAME]_[TAG_VALUE]\n" +
            "So, if you want to run a task on all hosts with a tag env=staging, simply add this to your playbook:"," hosts: tag_env_staging\n" +
            "  tasks:\n" +
            "    - name: This task will be run on all servers with env == staging\n" +
            "    # ...\n" +
            "To make it even more interesting, you can use Ansible patterns (docs) to be more specific about what hosts should be affected by a task. For example, if you want to execute a particular task on your production db servers (assuming they are properly tagged), you could use the intersect pattern (:&), like this:\n" +
            "\n" +
            "  hosts: tag_env_production&:tag_type_db\n" +
            "  tasks:\n" +
            "    - name: This task will be run on all servers with tags 'env=production' and 'type=db'\n" +
            "    # ..."))
    users.add(AnsibleCommandsModel("13 - You can run things in “Dry Run” Mode","Ansible supports running a playbook in dry run mode (also called Check Mode), in this mode, Ansible will not make any changes to your host, but simply report what changes would have been made if the playbook was run without this flag.\n" +
            "\n" +
            "\$ ansible-playbook --check playbook.yml\n" +
            "While this is useful in some scenarios, it might not work properly if your tasks use conditional steps.",""))
    users.add(AnsibleCommandsModel("14 - Tasks can be run step-by-step","Sometimes you don’t want to run all tasks in your playbook. This is somewhat common when you’re writing a new playbook and want to test it. Ansible provides a way to let you decide which tasks you want to run, through the use of the --step flag. It will let you choose if you want to run the task (y), skip it (n), or (c)ontinue without asking.","# playbook.yml\n" +
            "- hosts: servername\n" +
            "  tasks:\n" +
            "    - name: First task\n" +
            "      # ...\n" +
            "    - name: Second task\n" +
            "      # ...\n" +
            "\n" +
            "\$ ansible-playbook provision.yml -i hosts --step\n" +
            "\n" +
            "> Perform task: TASK: setup  (y/n/c): n  #\n" +
            "> Perform task: TASK: First task (y/n/c): n\n" +
            "> Perform task: TASK: Second task (y/n/c): y"))
    users.add(AnsibleCommandsModel("15 - Tasks can be run based on their tags","You can add one or more tags to a task or a play. To do so, simply mark what you want to tag with the tags attribute:","# playbook.yml\n" +
            "- hosts: servername\n" +
            "  tags:\n" +
            "    - server\n" +
            "  tasks:\n" +
            "    - name: Download optional files\n" +
            "      tags:\n" +
            "        - download\n" +
            "        - optional\n" +
            "    - name: Install dependencies\n" +
            "      tags:\n" +
            "        - dependencies\n" +
            "Later on you can decide which tags to run or skip using the flags --tags <tagname> (or simply -t) and --skip-tags <tagnames>:\n" +
            "\n" +
            "# will run only tasks with the tag 'dependencies'\n" +
            "\$ ansible-playbook --tags=dependencies playbook.yml\n" +
            "\n" +
            "# will run all tasks except the ones that contain the tag 'optional'\n" +
            "\$ ansible-playbook --skip-tags=optional playbook.yml"))

    //creating our adapter
    val adapter = AnsibleCommandsAdapter(users)
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
     * @return A new instance of fragment AnsibleCommandsFragment.
     */
    // TODO: Rename and change types and number of parameters
    @JvmStatic
    fun newInstance(param1: String, param2: String) =
      AnsibleCommandsFragment().apply {
        arguments = Bundle().apply {
          putString(ARG_PARAM1, param1)
          putString(ARG_PARAM2, param2)
        }
      }
  }
}
