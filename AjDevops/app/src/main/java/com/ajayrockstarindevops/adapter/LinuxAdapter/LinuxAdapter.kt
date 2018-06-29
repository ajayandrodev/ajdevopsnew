package com.ajayrockstarindevops.adapter.LinuxAdapter

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ajayrockstarindevops.additionalInfoTools.LinuxAdditionalInfoFragment
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.commandsTools.LinuxCommandsFragment
import com.ajayrockstarindevops.historyTools.LinuxHistoryFragment
import com.ajayrockstarindevops.interviewQuestionsTools.LinuxInterviewQuestionsFragment
import com.ajayrockstarindevops.model.LinuxModel.LinuxModel


/**
 * Created by Ajay on 5/31/2018.
 */
class LinuxAdapter(val userList: ArrayList<LinuxModel>) : RecyclerView.Adapter<LinuxAdapter.ViewHolder>() {

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

        fun bindItems(user: LinuxModel) {
            val textViewName = itemView.findViewById(R.id.textViewUsername) as TextView
            textViewName.text = user.name
            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                val activity = itemView.getContext() as AppCompatActivity
                var myFragment: Fragment? = null
                when (adapterPosition) {
                    0 -> {
                         myFragment = LinuxHistoryFragment()

                    }
                    1 -> {
                         myFragment = LinuxCommandsFragment()

                    }
                    2 -> {
                         myFragment = LinuxInterviewQuestionsFragment()

                    }
                    3 -> {
                         myFragment = LinuxAdditionalInfoFragment()

                    }

                }
                activity.supportFragmentManager.beginTransaction().replace(R.id.mainFrame, myFragment).addToBackStack(null).commit()

            }

        }
    }
}