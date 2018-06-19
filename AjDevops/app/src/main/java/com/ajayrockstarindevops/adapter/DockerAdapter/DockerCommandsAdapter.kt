package com.ajayrockstarindevops.adapter.DockerAdapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.DockerModel.DockerCommandsModel


/**
 * Created by Ajay on 6/18/2018.
 */
class DockerCommandsAdapter(val userList: ArrayList<DockerCommandsModel>) : RecyclerView.Adapter<DockerCommandsAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.docker_command_list_layout, parent, false)
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

        fun bindItems(user: DockerCommandsModel) {
            val textViewDockerTitle = itemView.findViewById(R.id.docker_title) as TextView
            textViewDockerTitle.text = user.title
            val textViewDockerDis = itemView.findViewById(R.id.docker_discription) as TextView
            textViewDockerDis.text = user.discription
            val textViewDockerExam = itemView.findViewById(R.id.docker_example) as TextView
            textViewDockerExam.text = user.example
        }
    }
}