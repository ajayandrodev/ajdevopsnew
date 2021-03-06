package com.ajayrockstarindevops.adapter.AnsibleAdapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.AnsibleModel.AnsibleCommandsModel
import com.ajayrockstarindevops.model.AnsibleModel.AnsibleModel


/**
 * Created by Ajay on 6/18/2018.
 */
class AnsibleCommandsAdapter(val userList: ArrayList<AnsibleCommandsModel>) : RecyclerView.Adapter<AnsibleCommandsAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.ansible_command_list_layout, parent, false)
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

        fun bindItems(user: AnsibleCommandsModel) {
            val textViewAnsibleTitle = itemView.findViewById(R.id.ansible_title) as TextView
            textViewAnsibleTitle.text = user.title
            val textViewAnsibleDis = itemView.findViewById(R.id.ansible_discription) as TextView
            textViewAnsibleDis.text = user.discription
            val textViewAnsibleExa = itemView.findViewById(R.id.ansible_example) as TextView
            textViewAnsibleExa.text = user.example
        }
    }
}