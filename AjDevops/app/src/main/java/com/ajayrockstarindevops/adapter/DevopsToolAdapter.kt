package com.ajayrockstarindevops.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.DevopsToolModel
import android.widget.Toast
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment

import com.ajayrockstarindevops.fragments.*
import android.support.v7.app.AppCompatActivity
import com.ajayrockstarindevops.firebaseData.MainFragment
import kotlinx.android.synthetic.main.devops_list_layout.*
import android.view.View


/**
 * Created by Ajay on 6/1/2018.
 */
class DevopsToolAdapter(val userList: ArrayList<DevopsToolModel>) : RecyclerView.Adapter<DevopsToolAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevopsToolAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.devops_list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: DevopsToolAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: DevopsToolModel) {
            val textViewName = itemView.findViewById(R.id.textViewUsername) as TextView
            textViewName.text = user.name
            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                val activity = itemView.getContext() as AppCompatActivity
                var myFragment: Fragment? = null

                when (adapterPosition) {
                    0 -> {
                         myFragment = GitHubFragment()

                    }
                    1 -> {
                         myFragment = JenkinsFragment()

                    }
                    2 -> {
                         myFragment = DockerFragment()

                    }
                    3 -> {
                         myFragment = AnsibleFragment()

                    }
                    4 -> {
                         myFragment = NginxFragment()

                    }
                    5 -> {
                         myFragment = ChefFragment()

                    }
                    6 -> {
                         myFragment = AwsFragment()

                    }
                    7 -> {
                         myFragment = PuppetFragment()

                    }
                    8 -> {
                         myFragment = PythonFragment()

                    }
                    9 -> {
                         myFragment = LinuxFragment()

                    }
                    10 -> {
                         myFragment = KubernetFragment()

                    }
                    11 -> {
                         myFragment = ShellScriptFragment()

                    }
                    12 -> {
                         myFragment = SaltFragment()

                    }
                    13 -> {
                         myFragment = NagiosFragment()

                    }
                    14 -> {
                         myFragment = ElkFragment()

                    }

                }
                activity.supportFragmentManager.beginTransaction().replace(R.id.mainFrame, myFragment).addToBackStack(null).commit()


            }

        }
    }
}

