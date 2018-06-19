package com.ajayrockstarindevops.ajdevops

import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_navigation_drawer.*
import kotlinx.android.synthetic.main.app_bar_navigation_drawer.*
import android.widget.TextView
import android.view.View;
import android.widget.Toast
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import com.ajayrockstarindevops.fragments.*
import com.ajayrockstarindevops.historyTools.AnsibleHistoryFragment
import com.ajayrockstarindevops.historyTools.DockerHistoryFragment
import com.ajayrockstarindevops.historyTools.GitHistoryFragment
import com.ajayrockstarindevops.historyTools.JenkinsHistoryFragment
import android.content.Intent
import com.ajayrockstarindevops.commandsTools.AnsibleCommandsFragment
import com.ajayrockstarindevops.commandsTools.DockerCommnadsFragment
import com.ajayrockstarindevops.commandsTools.GitHubCommandsFragment
import com.ajayrockstarindevops.commandsTools.JenkinsCommandsFragment


class NavigationDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setTitle("DEVOPS TOOLS")
        val personName = intent.getStringExtra("name")
        val personEmail = intent.getStringExtra("email")
        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.setCheckedItem(R.id.nav_dev_tool);
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.mainFrame, DevopsToolsFragment())
        ft.commit()
        val header = navigationView.getHeaderView(0)
        val name = header.findViewById(R.id.name) as TextView
        val email = header.findViewById(R.id.email) as TextView
        name.setText(personName)
        email.setText(personEmail)

        fab.setOnClickListener { view ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
               .setAction("Action", null).show()*/
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        /*  if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
          } else {
            super.onBackPressed()
            Toast.makeText(this@NavigationDrawerActivity, "Its backpressed!", Toast.LENGTH_SHORT).show()
          }*/
        val f = supportFragmentManager.findFragmentById(R.id.mainFrame)
        if (f is DevopsToolsFragment) {
            alertDialog()
        } else {
            super.onBackPressed()
        }
    }

    private fun alertDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Exit")
        alertDialogBuilder
                .setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id -> finish() }
                .setNegativeButton("No") { dialog, id -> dialog.cancel() }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation_drawer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        //NOTE: creating fragment object
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.nav_dev_tool -> {
                // Handle the camera action
                // Toast.makeText(this@NavigationDrawerActivity, "Its git!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("DEVOPS TOOLS")
                fragment = DevopsToolsFragment()
            }
            R.id.nav_git -> {
                // Handle the camera action
                // Toast.makeText(this@NavigationDrawerActivity, "Its git!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("GIT")
                fragment = GitHubCommandsFragment()
            }
            R.id.nav_ansible -> {
                //  Toast.makeText(this@NavigationDrawerActivity, "Its ansible!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("ANSIBLE")
                fragment = AnsibleCommandsFragment()
            }
            R.id.nav_jenkins -> {
                ///  Toast.makeText(this@NavigationDrawerActivity, "Its jenkins!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("JENKINS")
                fragment = JenkinsCommandsFragment()
            }
            R.id.nav_docker -> {
                //   Toast.makeText(this@NavigationDrawerActivity, "Its docker!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("DOCKER")
                fragment = DockerCommnadsFragment()
            }
            R.id.nav_linux -> {
                //   Toast.makeText(this@NavigationDrawerActivity, "Its docker!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("LINUX")
                fragment = LinuxFragment()
            }
            R.id.nav_aws -> {
                //   Toast.makeText(this@NavigationDrawerActivity, "Its docker!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("AWS")
                fragment = AwsFragment()
            }
            R.id.nav_kubernet -> {
                //   Toast.makeText(this@NavigationDrawerActivity, "Its docker!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("KUBERNET")
                fragment = KubernetFragment()
            }
            R.id.nav_nginx -> {
                //   Toast.makeText(this@NavigationDrawerActivity, "Its docker!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("NGINX")
                fragment = NginxFragment()
            }
            R.id.nav_shellscript -> {
                //   Toast.makeText(this@NavigationDrawerActivity, "Its docker!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("SHELL SCRIPT")
                fragment = ShellScriptFragment()
            }
            R.id.nav_nagios -> {
                //   Toast.makeText(this@NavigationDrawerActivity, "Its docker!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("NAGIOS")
                fragment = NagiosFragment()
            }
            R.id.nav_chef -> {
                //   Toast.makeText(this@NavigationDrawerActivity, "Its docker!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("CHEF")
                fragment = ChefFragment()
            }
            R.id.nav_puppet -> {
                //   Toast.makeText(this@NavigationDrawerActivity, "Its docker!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("PUPPET")
                fragment = PuppetFragment()
            }
            R.id.nav_python -> {
                //   Toast.makeText(this@NavigationDrawerActivity, "Its docker!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("PYTHON")
                fragment = PythonFragment()
            }
            R.id.nav_salt -> {
                //   Toast.makeText(this@NavigationDrawerActivity, "Its docker!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("SALTSTACK")
                fragment = SaltFragment()
            }
            R.id.nav_elk -> {
                //   Toast.makeText(this@NavigationDrawerActivity, "Its docker!", Toast.LENGTH_SHORT).show()
                getSupportActionBar()!!.setTitle("ELK")
                fragment = ElkFragment()
            }
            R.id.nav_share -> {
                //  Toast.makeText(this@NavigationDrawerActivity, "Its share!", Toast.LENGTH_SHORT).show()
                val sharingIntent = Intent(android.content.Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                val shareBodyText = "Check it out. Your message goes here"
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject here")
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText)
                startActivity(Intent.createChooser(sharingIntent, "Shearing Option"))
            }
            R.id.nav_send -> {
                //  Toast.makeText(this@NavigationDrawerActivity, "Its send!", Toast.LENGTH_SHORT).show()

            }
        }
        //NOTE: Fragment changing code
        if (fragment != null) {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.mainFrame, fragment)
            ft.commit()
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
