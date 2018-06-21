package com.ajayrockstarindevops.adapter.GitAdapter

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ajayrockstarindevops.additionalInfoTools.GitHubAdditionalInfoFragment
import com.ajayrockstarindevops.model.GitModel.GitModel
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.commandsTools.GitHubCommandsFragment
import com.ajayrockstarindevops.fragments.AnsibleFragment
import com.ajayrockstarindevops.fragments.DockerFragment
import com.ajayrockstarindevops.fragments.GitHubFragment
import com.ajayrockstarindevops.fragments.JenkinsFragment
import com.ajayrockstarindevops.historyTools.GitHistoryFragment
import com.ajayrockstarindevops.interviewQuestionsTools.GitInterviewQuestionsFragment

/**
 * Created by Ajay on 5/31/2018.
 */
class GitAdapter(val userList: ArrayList<GitModel>) : RecyclerView.Adapter<GitAdapter.ViewHolder>() {

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

        fun bindItems(user: GitModel) {
            val textViewName = itemView.findViewById(R.id.textViewUsername) as TextView
            textViewName.text = user.name
            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                val activity = itemView.getContext() as AppCompatActivity
                var myFragment: Fragment? = null

                when (adapterPosition) {
                    0 -> {
                        myFragment = GitHistoryFragment()

                    }
                    1 -> {
                        myFragment = GitHubCommandsFragment()

                    }
                    2 -> {
                        myFragment = GitInterviewQuestionsFragment()

                    }
                    3 -> {
                        myFragment = GitHubAdditionalInfoFragment()

                    }
                }
                activity.supportFragmentManager.beginTransaction().replace(R.id.mainFrame, myFragment).addToBackStack(null).commit()

            }
        }
    }
}
