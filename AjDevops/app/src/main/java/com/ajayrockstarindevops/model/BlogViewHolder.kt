package com.ajayrockstarindevops.model

import android.support.v7.widget.RecyclerView
import com.squareup.picasso.Picasso
import android.R.attr.description
import android.widget.TextView

import com.ajayrockstarindevops.ajdevops.R
import android.view.View

/**
 * Created by Ajay on 6/14/2018.
 */
class BlogViewHolder(internal var mView: View) : RecyclerView.ViewHolder(mView) {
    internal var textView_title: TextView
    internal var textView_decription: TextView
  //  internal var imageView: ImageView

    init {
        textView_title = mView.findViewById(R.id.title)
        textView_decription = mView.findViewById(R.id.description)
       // imageView = mView.findViewById(R.id.image) as ImageView
    }

    fun setTitle(title: String) {
        textView_title.text = title
    }

    fun setDescription(description: String) {
        textView_decription.text = description
    }

   /* fun setImage(image: String) {
        Picasso.with(mView.getContext())
                .load(image)
                .into(imageView)
    }*/
}