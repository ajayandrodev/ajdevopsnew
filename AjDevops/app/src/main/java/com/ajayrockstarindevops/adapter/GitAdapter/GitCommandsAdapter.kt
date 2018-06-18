package com.ajayrockstarindevops.adapter.GitAdapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.GitModel.GitCommandsModel


/**
 * Created by Ajay on 6/18/2018.
 */
class GitCommandsAdapter(val userList: ArrayList<GitCommandsModel>) : RecyclerView.Adapter<GitCommandsAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.git_command_list_layout, parent, false)
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

        fun bindItems(user: GitCommandsModel) {
            val textViewCommand = itemView.findViewById(R.id.git_command) as TextView
            textViewCommand.text = user.command
            val textViewDis = itemView.findViewById(R.id.git_discription) as TextView
            textViewDis.text = user.discription
        }
    }
}
