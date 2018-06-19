package com.ajayrockstarindevops.adapter.DockerAdapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.DockerModel.DockerModel


/**
 * Created by Ajay on 5/31/2018.
 */
class DockerAdapter(val userList: ArrayList<DockerModel>) : RecyclerView.Adapter<DockerAdapter.ViewHolder>()  {

  //this method is returning the view for each item in the list
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val v = LayoutInflater.from(parent.context).inflate(R.layout.git_list_layout, parent, false)
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

    fun bindItems(user: DockerModel) {
      val textViewName = itemView.findViewById(R.id.textViewUsername) as TextView
      textViewName.text = user.name
    }
  }
}