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
import com.ajayrockstarindevops.adapter.LinuxAdapter.LinuxCommandsAdapter
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.LinuxModel.LinuxCommandsModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LinuxCommandsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LinuxCommandsFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_linux_commands, container, false)
        //getting recyclerview from xml
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        //adding a layoutmanager
        recyclerView.setHasFixedSize(true)
        val itemDecor = DividerItemDecoration(context, LinearLayout.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        //crating an arraylist to store users using the data class user
        val users = ArrayList<LinuxCommandsModel>()
        users.add(LinuxCommandsModel("1 - SYSTEM INFORMATION", ""))
        users.add(LinuxCommandsModel("uname -a", "Display Linux system information"))
        users.add(LinuxCommandsModel("uname -r", "Display kernel release information"))
        users.add(LinuxCommandsModel("cat /etc/redhat-release", "Show which version of redhat installed"))
        users.add(LinuxCommandsModel("uptime", "Show how long the system has been running + load"))
        users.add(LinuxCommandsModel("hostname", "Show system host name"))
        users.add(LinuxCommandsModel("hostname -I", "Display the IP addresses of the host"))
        users.add(LinuxCommandsModel("last reboot", "Show system reboot history"))
        users.add(LinuxCommandsModel("date", "Show the current date and time"))
        users.add(LinuxCommandsModel("cal", "Show this month's calendar"))
        users.add(LinuxCommandsModel("w", "Display who is online"))
        users.add(LinuxCommandsModel("whoami", " Who you are logged in as"))
        users.add(LinuxCommandsModel("2 - HARDWARE INFORMATION", ""))
        users.add(LinuxCommandsModel("dmesg", " Display messages in kernel ring buffer"))
        users.add(LinuxCommandsModel("cat /proc/cpuinfo", "Display CPU information"))
        users.add(LinuxCommandsModel(" cat /proc/meminfo", "Display memory information"))
        users.add(LinuxCommandsModel(" free -h ", "Display free and used memory ( -h for human readable,-m for MB, -g for GB.)"))
        users.add(LinuxCommandsModel("lspci -tv", "Display PCI devices"))
        users.add(LinuxCommandsModel(" lsusb -tv", "Display USB devices"))
        users.add(LinuxCommandsModel(" dmidecode", "Display DMI/SMBIOS (hardware info) from the BIOS"))
        users.add(LinuxCommandsModel("  hdparm -i /dev/sda ", "Show info about disk sda"))
        users.add(LinuxCommandsModel(" hdparm -tT /dev/sda ", "Perform a read speed test on disk sda"))
        users.add(LinuxCommandsModel("  badblocks -s /dev/sda", " Test for unreadable blocks on disk sda"))
        users.add(LinuxCommandsModel("3 - PERFORMANCE MONITORING AND STATISTICS", ""))
        users.add(LinuxCommandsModel("top", "Display and manage the top processes"))
        users.add(LinuxCommandsModel("htop", "Interactive process viewer (top alternative)"))
        users.add(LinuxCommandsModel(" mpstat 1", "Display processor related statistics"))
        users.add(LinuxCommandsModel("vmstat 1", "Display virtual memory statistics"))
        users.add(LinuxCommandsModel(" iostat 1", "Display I/O statistics"))
        users.add(LinuxCommandsModel("  tail 100 /var/log/messages", "Display the last 100 syslog messages (Use /var/log/syslog for Debian based systems.)"))
        users.add(LinuxCommandsModel(" tcpdump -i eth0", "Capture and display all packets on interface eth0"))
        users.add(LinuxCommandsModel(" tcpdump -i eth0 'port 80'", " Monitor all traffic on port 80 ( HTTP )"))
        users.add(LinuxCommandsModel(" lsof", "List all open files on the system"))
        users.add(LinuxCommandsModel("  lsof -u user", "List files opened by user"))
        users.add(LinuxCommandsModel("  free -h", " Display free and used memory ( -h for human readable, -m for MB, -g for GB.)"))
        users.add(LinuxCommandsModel(" watch df -h ", "Execute \"df -h\", showing periodic updates"))

        users.add(LinuxCommandsModel("4 - USER INFORMATION AND MANAGEMENT", ""))
        users.add(LinuxCommandsModel("id", "Display the user and group ids of your current user."))
        users.add(LinuxCommandsModel("last", "Display the last users who have logged onto the system."))
        users.add(LinuxCommandsModel(" who", "Show who is logged into the system."))
        users.add(LinuxCommandsModel("w", "Show who is logged in and what they are doing."))
        users.add(LinuxCommandsModel(" groupadd test", "Create a group named \"test\"."))
        users.add(LinuxCommandsModel(" useradd -c \"John Smith\" -m john", "Create an account named john, with a comment of \"John Smith\" and create the user's home directory."))
        users.add(LinuxCommandsModel("  userdel john ", "Delete the john account"))
        users.add(LinuxCommandsModel("usermod -aG sales john", "Add the john account to the sales group"))
        users.add(LinuxCommandsModel("5 - FILE AND DIRECTORY COMM", ""))
        users.add(LinuxCommandsModel("ls -al", "List all files in a long listing (detailed) format"))
        users.add(LinuxCommandsModel("pwd", "Display the present working directory"))
        users.add(LinuxCommandsModel(" mkdir directory", "Create a directory"))
        users.add(LinuxCommandsModel("  rm file", " Remove (delete) file"))
        users.add(LinuxCommandsModel("  rm -r directory ", " Remove the directory and its contents recursively"))
        users.add(LinuxCommandsModel(" rm -f file", " Force removal of file without prompting for confirmation"))
        users.add(LinuxCommandsModel(" rm -rf directory ", "Forcefully remove directory recursively"))
        users.add(LinuxCommandsModel("   cp file1 file2", "Copy file1 to file2"))
        users.add(LinuxCommandsModel(" cp -r source_directory destination", "Copy source_directory recursively to destination. If destination exists, copy source_directory into destination,otherwise create destination with the contents of source_directory."))
        users.add(LinuxCommandsModel(" mv file1 file2", "Rename or move file1 to file2. If file2 is an existing directory, move file1 into directory file2"))
        users.add(LinuxCommandsModel("  ln -s /path/to/file linkname ", "Create symbolic link to linkname"))
        users.add(LinuxCommandsModel("  touch file", " Create an empty file or update the access and modification times of file."))
        users.add(LinuxCommandsModel(" cat file", "View the contents of file"))
        users.add(LinuxCommandsModel(" less file ", "Browse through a text file"))
        users.add(LinuxCommandsModel("head file", "Display the first 10 lines of file"))
        users.add(LinuxCommandsModel(" tail file", "Display the last 10 lines of file"))
        users.add(LinuxCommandsModel(" tail -f file", "Display the last 10 lines of file and follow the file as it grows."))
        users.add(LinuxCommandsModel("6 - PROCESS MANAGEMENT", ""))
        users.add(LinuxCommandsModel("ps", "Display your currently running processes"))
        users.add(LinuxCommandsModel("ps -ef", "Display all the currently running processes on the system."))
        users.add(LinuxCommandsModel("ps -ef | grep processname", "Display process information for processname"))
        users.add(LinuxCommandsModel("top", "Display and manage the top processes"))
        users.add(LinuxCommandsModel(" htop ", "Interactive process viewer (top alternative)"))
        users.add(LinuxCommandsModel(" kill pid", "Kill process with process ID of pid"))
        users.add(LinuxCommandsModel(" killall processname", "Kill all processes named processname"))
        users.add(LinuxCommandsModel("  program &", "Start program in the background"))
        users.add(LinuxCommandsModel(" bg ", "Display stopped or background jobs"))
        users.add(LinuxCommandsModel("fg", "Brings the most recent background job to foreground"))
        users.add(LinuxCommandsModel(" fg n ", "Brings job n to the foreground"))
        users.add(LinuxCommandsModel("7 -FILE PERMISSIONS", ""))
        users.add(LinuxCommandsModel(" U G W\n" + "rwx rwx rwx", " chmod 777 filename.U = User\n" +
                " G = Group\n" +
                " W = World\n" +
                " r = Read\n" +
                " w = write\n" +
                " x = execute\n" +
                " - = no access"))
        users.add(LinuxCommandsModel("rwx rwx r-x ", "Example:\n" + "chmod 775 filename.Here " + "(-)-->regular file,d-->directory"))
        users.add(LinuxCommandsModel("rwx r-x r-x", "Example:\n" + "chmod 755 filename"))
        users.add(LinuxCommandsModel("rw- rw- r--", "Example:\n" + "chmod 664 filename"))
        users.add(LinuxCommandsModel("rw- r-- r--", "Example:\n" + "chmod 644 filename"))
        users.add(LinuxCommandsModel("Absolute(Numeric) Mode", "0\tNo Permission\t---\n" +
                "1\tExecute\t--x\n" +
                "2\tWrite\t-w-\n" +
                "3\tExecute + Write\t-wx\n" +
                "4\tRead\tr--\n" +
                "5\tRead + Execute\tr-x\n" +
                "6\tRead +Write\trw-\n" +
                "7\tRead + Write +Execute\trwx"))
        users.add(LinuxCommandsModel("Symbolic Mode", "+\tAdds a permission to a file or directory\n" +
                "-\tRemoves the permission\n" +
                "=\tSets the permission and overrides the permissions set earlier."))
        users.add(LinuxCommandsModel("User Denotations", "u\tuser/owner\n" +
                "g\tgroup\n" +
                "o\tother\n" +
                "a\tall"))
        users.add(LinuxCommandsModel("8 - NETWORKING", ""))
        users.add(LinuxCommandsModel(" ifconfig -a", " Display all network interfaces and ip address"))
        users.add(LinuxCommandsModel(" ifconfig eth0", "Display eth0 address and details"))
        users.add(LinuxCommandsModel("   ethtool eth0", "Query or control network driver and hardware settings"))
        users.add(LinuxCommandsModel("  ping host", "Send ICMP echo request to host"))
        users.add(LinuxCommandsModel(" whois domain", " Display whois information for domain"))
        users.add(LinuxCommandsModel(" dig domain", "Display DNS information for domain"))
        users.add(LinuxCommandsModel("  dig -x IP_ADDRESS", "Reverse lookup of IP_ADDRESS"))
        users.add(LinuxCommandsModel("   host domain", "Display DNS ip address for domain"))
        users.add(LinuxCommandsModel("  hostname -i", "Display the network address of the host name."))
        users.add(LinuxCommandsModel("  hostname -I", "Display all local ip addresses"))
        users.add(LinuxCommandsModel("wget http://domain.com/file", "Download http://domain.com/file"))
        users.add(LinuxCommandsModel(" netstat -nutlp", "Display listening tcp and udp ports and corresponding programs"))

        users.add(LinuxCommandsModel("9 - ARCHIVES (TAR FILES) tar", ""))
        users.add(LinuxCommandsModel("  tar cf archive.tar directory", "Create tar named archive.tar containing directory."))
        users.add(LinuxCommandsModel(" tar xf archive.tar", "Extract the contents from archive.tar."))
        users.add(LinuxCommandsModel("  tar czf archive.tar.gz directory", "Create a gzip compressed tar file name\n" +
                "                archive.tar.gz ."))
        users.add(LinuxCommandsModel("  tar xzf archive.tar.gz", "Extract a gzip compressed tar file."))
        users.add(LinuxCommandsModel(" tar cjf archive.tar.bz2 directory", "Create a tar file with bzip2 compression"))
        users.add(LinuxCommandsModel("  tar xjf archive.tar.bz2", "Extract a bzip2 compressed tar file."))
        users.add(LinuxCommandsModel("10 - INSTALLING PACKAGES", ""))
        users.add(LinuxCommandsModel("   yum search keyword ", "Search for a package by keyword."))
        users.add(LinuxCommandsModel("  yum install package", "Install package "))
        users.add(LinuxCommandsModel("   yum info package ", "Display description and summary information about package"))
        users.add(LinuxCommandsModel(" rpm -i package.rpm", "Install package from local file named package.rpm"))
        users.add(LinuxCommandsModel(" yum remove package", "Remove/uninstall package"))
        users.add(LinuxCommandsModel("tar zxvf sourcecode.tar.gz\n" +
                "cd sourcecode\n" +
                "./configure\n" +
                "make\n" +
                "make install", "Install software from source code"))
        users.add(LinuxCommandsModel("11 - SEARCH", ""))

        users.add(LinuxCommandsModel("  grep pattern file", "Search for pattern in file"))
        users.add(LinuxCommandsModel(" grep -r pattern directory", " Search recursively for pattern in directory"))
        users.add(LinuxCommandsModel(" locate name ", " Find files and directories by name"))
        users.add(LinuxCommandsModel(" find /home/john -name\n" +
                "        'prefix*'", "Find files in /home/john that start with \"prefix\""))
        users.add(LinuxCommandsModel(" find /home -size +100M ", "Find files larger than 100MB in /home"))
        users.add(LinuxCommandsModel("12 - SSH LOGINS", ""))
        users.add(LinuxCommandsModel("  ssh host", "Connect to host as your local username"))
        users.add(LinuxCommandsModel("ssh user@host", "Connect to host as user"))
        users.add(LinuxCommandsModel("ssh -p port user@host", "Connect to host using port"))

        users.add(LinuxCommandsModel("13 - FILE TRANSFERS", ""))


        users.add(LinuxCommandsModel("scp file.txt server:/tmp", "Secure copy file.txt to the /tmp folder on server"))
        users.add(LinuxCommandsModel("scp server:/var/www/*.html /tmp", "Copy *.html files from server to the local /tmp folder."))
        users.add(LinuxCommandsModel("scp -r server:/var/www /tmp", "Copy all files and directories recursively from server to the current system's /tmp folder."))
        users.add(LinuxCommandsModel("rsync -a /home /backups/", "Synchronize /home to /backups/home"))
        users.add(LinuxCommandsModel("rsync -avz /home server:/backups/", "Synchronize files/directories between the local and remote system with compression enabled"))
        users.add(LinuxCommandsModel("14 - DISK USAGE", ""))

        users.add(LinuxCommandsModel(" df -h ", " Show free and used space on mounted filesystems"))
        users.add(LinuxCommandsModel(" df -i", "Show free and used inodes on mounted filesystems"))
        users.add(LinuxCommandsModel("fdisk -l", "Display disks partitions sizes and types"))
        users.add(LinuxCommandsModel("  du -ah ", "Display disk usage for all files and directories in human readable format"))
        users.add(LinuxCommandsModel(" du -sh ", "Display total disk usage off the current directory"))
        users.add(LinuxCommandsModel("  15 - DIRECTORY NAVIGATION", ""))
        users.add(LinuxCommandsModel("cd .. ", "To go up one level of the directory tree. (Change into the parent directory.)"))
        users.add(LinuxCommandsModel("cd", " Go to the HOME directory"))
        users.add(LinuxCommandsModel(" cd /etc", "Change to the /etc directory"))
        //creating our adapter
        val adapter = LinuxCommandsAdapter(users)
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
         * @return A new instance of fragment LinuxCommandsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                LinuxCommandsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
