package com.ajayrockstarindevops.adapter.NagiosAdapter

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ajayrockstarindevops.adapter.AwsAdapter.AwsAdapter
import com.ajayrockstarindevops.additionalInfoTools.AwsAdditionalInfoFragment
import com.ajayrockstarindevops.additionalInfoTools.NagiosAdditionalInfoFragment
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.commandsTools.AwsCommandsFragment
import com.ajayrockstarindevops.commandsTools.NagiosCommandsFragment
import com.ajayrockstarindevops.historyTools.AwsHistoryFragment
import com.ajayrockstarindevops.historyTools.NagiosHistoryFragment
import com.ajayrockstarindevops.interviewQuestionsTools.AwsInterviewQuestionsFragment
import com.ajayrockstarindevops.interviewQuestionsTools.NagiosInterviewQuestionsFragment
import com.ajayrockstarindevops.model.AwsModel.AwsModel
import com.ajayrockstarindevops.model.NagiosModel.NagiosModel


/**
 * Created by Ajay on 7/9/2018.
 */
class NagiosAdapter(val userList: ArrayList<NagiosModel>) : RecyclerView.Adapter<NagiosAdapter.ViewHolder>() {

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

        fun bindItems(user: NagiosModel) {
            val textViewName = itemView.findViewById(R.id.textViewUsername) as TextView
            textViewName.text = user.name
            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                val activity = itemView.getContext() as AppCompatActivity
                var myFragment: Fragment? = null
                when (adapterPosition) {
                    0 -> {
                        myFragment = NagiosHistoryFragment()

                    }
                    1 -> {
                        myFragment = NagiosCommandsFragment()

                    }
                    2 -> {
                        myFragment = NagiosInterviewQuestionsFragment()

                    }
                    3 -> {
                        myFragment = NagiosAdditionalInfoFragment()

                    }

                }
                activity.supportFragmentManager.beginTransaction().replace(R.id.mainFrame, myFragment).addToBackStack(null).commit()

            }

        }
    }
}