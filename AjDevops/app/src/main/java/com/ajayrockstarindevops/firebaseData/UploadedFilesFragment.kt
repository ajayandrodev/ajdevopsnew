package com.ajayrockstarindevops.firebaseData


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import com.ajayrockstarindevops.ajdevops.R
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.ajayrockstarindevops.model.UploadInfo
import com.ajayrockstarindevops.util.ImageViewHolderUpload
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

import kotlinx.android.synthetic.main.fragment_uploaded_files.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private var mAdapter: FirebaseRecyclerAdapter<UploadInfo, ImageViewHolderUpload>? = null
private var mDataReference: DatabaseReference? = null

/**
 * A simple [Fragment] subclass.
 * Use the [UploadedFilesFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class UploadedFilesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_uploaded_files, container, false)
        val rcvListImg = view.findViewById(R.id.recyclerView_upload) as RecyclerView
        mDataReference = FirebaseDatabase.getInstance().getReference("data")
        val query = mDataReference?.limitToLast(3)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.reverseLayout = false
        rcvListImg.setHasFixedSize(false)
        rcvListImg.setLayoutManager(layoutManager)


        mAdapter = object : FirebaseRecyclerAdapter<UploadInfo, ImageViewHolderUpload>(
                UploadInfo::class.java, R.layout.item_image_uploaded, ImageViewHolderUpload::class.java, query) {
            override fun populateViewHolder(viewHolder: ImageViewHolderUpload, model: UploadInfo, position: Int) {
                viewHolder.nameView.setText(model.name)
                Glide.with(context).load(model.url)
                        .error(R.drawable.ic_menu_gallery)
                        .into(viewHolder.imageView)
            }

        }

        rcvListImg.setAdapter(mAdapter)
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UploadedFilesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                UploadedFilesFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
