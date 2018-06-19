package com.ajayrockstarindevops.adapter.JenkinsAdapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.JenkinsModel.JenkinsCommandsModel
import com.ajayrockstarindevops.model.JenkinsModel.JenkinsModel


/**
 * Created by Ajay on 6/18/2018.
 */
class JenkinsCommandsAdaper(val userList: ArrayList<JenkinsCommandsModel>) : RecyclerView.Adapter<JenkinsCommandsAdaper.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.jenkins_command_list_layout, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: JenkinsCommandsModel) {
            val textViewJenkinsTitle = itemView.findViewById(R.id.jenkins_title) as TextView
            textViewJenkinsTitle.text = user.title
            val textViewJenkinsDis = itemView.findViewById(R.id.jenkins_discription) as TextView
            textViewJenkinsDis.text = user.discription

        }
    }
}
