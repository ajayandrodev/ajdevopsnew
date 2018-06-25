package com.ajayrockstarindevops.util


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajayrockstarindevops.ajdevops.R;
/**
 * Created by Ajay on 6/25/2018.
 */
class ImageViewHolderUpload(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var nameView: TextView
    var imageView: ImageView

    init {

        nameView = itemView.findViewById(R.id.tv_img_name)
        imageView = itemView.findViewById(R.id.img_view) as ImageView
    }
}
