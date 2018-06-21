package com.ajayrockstarindevops.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.DevopsToolModel
import android.widget.Toast
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import com.ajayrockstarindevops.historyTools.GitHistoryFragment

import com.ajayrockstarindevops.fragments.*
import android.support.v7.app.AppCompatActivity



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

                if (position == 0) {
                    Snackbar.make(v, "Click detected on item pppppppppp $position",
                            Snackbar.LENGTH_LONG).setAction("Action", null).show()
                } else if (position == 1) {
                    Snackbar.make(v, "Click detected on item 3333333$position",
                            Snackbar.LENGTH_LONG).setAction("Action", null).show()
                } else {
                    Snackbar.make(v, "Click detected on item44444444 $position",
                            Snackbar.LENGTH_LONG).setAction("Action", null).show()
                }

                }

            }
        }
    }

