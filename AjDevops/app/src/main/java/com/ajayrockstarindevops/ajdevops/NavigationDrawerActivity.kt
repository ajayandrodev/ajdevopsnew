package com.ajayrockstarindevops.ajdevops

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.ajayrockstarindevops.firebaseData.MainFragment
import com.ajayrockstarindevops.firebaseData.NoteFragment
import com.ajayrockstarindevops.firebaseData.StorageFragment
import com.ajayrockstarindevops.fragments.DevopsToolsFragment
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_navigation_drawer.*
import kotlinx.android.synthetic.main.app_bar_navigation_drawer.*


class NavigationDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setTitle("DEVOPS TOOLS")
        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.setCheckedItem(R.id.nav_dev_tool);
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.mainFrame, DevopsToolsFragment())
        ft.commit()
        val header = navigationView.getHeaderView(0)
        mAuth = FirebaseAuth.getInstance()
        val imageView = header.findViewById<CircleImageView>(R.id.circleView) as CircleImageView
        val textName = header.findViewById(R.id.name) as TextView
        val textEmail = header.findViewById(R.id.email) as TextView
        val user = mAuth!!.getCurrentUser()

        Glide.with(this).load(user?.getPhotoUrl()).into(imageView)
        textName.setText(user?.getDisplayName())
        textEmail.setText(user?.getEmail())
        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
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
                .setPositiveButton("Yes") { dialog, id ->
                    // finish()
                    FirebaseAuth.getInstance().signOut()
                    startActivity(Intent(this@NavigationDrawerActivity, GoogleSigninActivity::class.java))
                    finish()
                }
                .setNegativeButton("No") { dialog, id -> dialog.cancel() }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> {
                // Toast.makeText(this@NavigationDrawerActivity, "Its working!", Toast.LENGTH_SHORT).show()
                var fragment: Fragment? = null
                getSupportActionBar()!!.setTitle("ADD NOTE")
                fragment = NoteFragment.newInstance()
                //NOTE: Fragment changing code
                if (fragment != null) {
                    val ft = supportFragmentManager.beginTransaction()
                    ft.replace(R.id.mainFrame, fragment).addToBackStack(null)
                    ft.commit()
                }
                return true
            }
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
                getSupportActionBar()!!.setTitle("DEVOPS TOOLS")
                fragment = DevopsToolsFragment()
            }
            R.id.nav_added_notes -> {
                getSupportActionBar()!!.setTitle("ADD NOTES")
                fragment = MainFragment()

            }
            R.id.nav_upload_file -> {

                getSupportActionBar()!!.setTitle("UPLOAD FILES")
                fragment = StorageFragment()

            }
            R.id.nav_share -> {
                val sharingIntent = Intent(android.content.Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                val shareBodyText = "Install this cool application: " + " " + "https://play.google.com/store/apps/details?id=com.ajayrockstarindevops.ajdevops"
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Download App")
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText)
                startActivity(Intent.createChooser(sharingIntent, "Shearing Option"))
            }
            R.id.nav_send -> {
                val i = Intent(Intent.ACTION_SENDTO)
                i.type = "message/rfc822"
                i.data = Uri.parse("mailto:")
                i.putExtra(Intent.EXTRA_EMAIL, arrayOf("ajaygoudandrodevops86@gmail.com"))
                i.putExtra(Intent.EXTRA_SUBJECT, "Enter the subject here")
                i.putExtra(Intent.EXTRA_TEXT, "Enter the message here")
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."))
                } catch (ex: android.content.ActivityNotFoundException) {
                    Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show()
                }

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
