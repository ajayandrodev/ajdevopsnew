package com.ajayrockstarindevops.adapter.LinuxAdapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.LinuxModel.LinuxCommandsModel


/**
 * Created by Ajay on 6/18/2018.
 */
class LinuxCommandsAdapter(val userList: ArrayList<LinuxCommandsModel>) : RecyclerView.Adapter<LinuxCommandsAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.linux_command_list_layout, parent, false)
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

        fun bindItems(user: LinuxCommandsModel) {
            val textViewLinuxTitle = itemView.findViewById(R.id.linux_title) as TextView
            textViewLinuxTitle.text = user.title
            val textViewLinuxDis = itemView.findViewById(R.id.linux_discription) as TextView
            textViewLinuxDis.text = user.discription

        }
    }
}