package com.ajayrockstarindevops.commandsTools


import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ajayrockstarindevops.ajdevops.R
import android.os.Bundle
import android.view.View
import com.google.firebase.database.DatabaseReference
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import com.ajayrockstarindevops.model.Blog
import com.ajayrockstarindevops.model.BlogViewHolder
import com.firebase.ui.database.FirebaseRecyclerAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GitHubCommandsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class GitHubCommandsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val TAG = GitHubCommandsFragment::class.java!!.getSimpleName()
    private var recipeRecyclerview: RecyclerView? = null
    private var linearLayoutManager: LinearLayoutManager? = null
    private var mDatabaseRef: DatabaseReference? = null
    private var childRef: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_git_hub_commands, container, false)
        linearLayoutManager = LinearLayoutManager(activity)
        recipeRecyclerview = view.findViewById(R.id.recipe_categories) as RecyclerView
        recipeRecyclerview?.setHasFixedSize(false)
        mDatabaseRef = FirebaseDatabase.getInstance().getReference()
        childRef = mDatabaseRef?.child("users")
        val recyclerAdapter = object : FirebaseRecyclerAdapter<Blog, BlogViewHolder>(
                Blog::class.java,
                R.layout.recipe_category_list,
                BlogViewHolder::class.java,
                childRef
        ) {
            override protected fun populateViewHolder(viewHolder: BlogViewHolder, model: Blog, position: Int) {
                viewHolder.setTitle(model.title + "")
                viewHolder.setDescription(model.description + "")
                // viewHolder.setImage(model.getImage())
            }
        }
/*
        mRecipeAdapter = RecipeAdapter(Blog::class.java, R.layout.recipe_category_list, BlogViewHolder::class.java, childRef)
*/
        recipeRecyclerview?.layoutManager = linearLayoutManager
        recipeRecyclerview?.adapter = recyclerAdapter

        return view;


    }


    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GitHubCommandsFragment.
         */

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                GitHubCommandsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }

}
