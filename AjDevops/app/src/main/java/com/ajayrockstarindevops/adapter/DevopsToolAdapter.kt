package com.ajayrockstarindevops.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.DevopsToolModel


/**
 * Created by Ajay on 6/1/2018.
 */
class DevopsToolAdapter(val userList: ArrayList<DevopsToolModel>) : RecyclerView.Adapter<DevopsToolAdapter.ViewHolder>()  {

  //this method is returning the view for each item in the list
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevopsToolAdapter.ViewHolder {
    val v = LayoutInflater.from(parent.context).inflate(R.layout.git_list_layout, parent, false)
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
    }
  }
}
