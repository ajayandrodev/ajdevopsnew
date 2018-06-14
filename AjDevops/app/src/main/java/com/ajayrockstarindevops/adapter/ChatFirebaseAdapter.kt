package com.ajayrockstarindevops.adapter

import android.support.v7.widget.RecyclerView
import android.text.format.DateUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.bumptech.glide.util.Util
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Query

import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.model.ChatModel
import hani.momanii.supernova_emoji_library.Helper.EmojiconTextView

/**
 * Created by Alessandro Barreto on 23/06/2016.
 */
class ChatFirebaseAdapter(ref: DatabaseReference, private val nameUser: String, private val mClickListenerChatFirebase: ClickListenerChatFirebase) : FirebaseRecyclerAdapter<ChatModel, ChatFirebaseAdapter.MyChatViewHolder>(ChatModel::class.java, R.layout.item_message_left, ChatFirebaseAdapter.MyChatViewHolder::class.java, ref) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyChatViewHolder {
        val view: View
        if (viewType == RIGHT_MSG) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_message_right, parent, false)
            return MyChatViewHolder(view)
        } else if (viewType == LEFT_MSG) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_message_left, parent, false)
            return MyChatViewHolder(view)
        } else if (viewType == RIGHT_MSG_IMG) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_message_right_img, parent, false)
            return MyChatViewHolder(view)
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_message_left_img, parent, false)
            return MyChatViewHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val model = getItem(position)
        return if (model.mapModel != null) {
            if (model.userModel?.name == nameUser) {
                RIGHT_MSG_IMG
            } else {
                LEFT_MSG_IMG
            }
        } else if (model.file != null) {
            if (model?.file.type == "img" && model.userModel?.name == nameUser) {
                RIGHT_MSG_IMG
            } else {
                LEFT_MSG_IMG
            }
        } else if (model.userModel?.name == nameUser) {
            RIGHT_MSG
        } else {
            LEFT_MSG
        }
    }

    override protected fun populateViewHolder(viewHolder: MyChatViewHolder, model: ChatModel, position: Int) {
        viewHolder.setIvUser(model?.userModel?.photo_profile)
        viewHolder.setTxtMessage(model.message)
        viewHolder.setTvTimestamp(model.timeStamp)
        viewHolder.tvIsLocation(View.GONE)
        if (model.file != null) {
            viewHolder.tvIsLocation(View.GONE)
            viewHolder.setIvChatPhoto(model?.file?.url_file)
        } else if (model.mapModel != null) {
            viewHolder.setIvChatPhoto(com.ajayrockstarindevops.util.Util.local(model.mapModel?.latitude, model.mapModel?.longitude))
            viewHolder.tvIsLocation(View.VISIBLE)
        }
    }

    inner class MyChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        internal var tvTimestamp: TextView? = null
        internal var tvLocation: TextView? = null
        internal var txtMessage: EmojiconTextView? = null
        internal var ivUser: ImageView? = null
        internal var ivChatPhoto: ImageView? = null

        init {
            tvTimestamp = itemView.findViewById(R.id.timestamp) as TextView
            txtMessage = itemView.findViewById(R.id.txtMessage) as EmojiconTextView
            tvLocation = itemView.findViewById(R.id.tvLocation) as TextView
            ivChatPhoto = itemView.findViewById(R.id.img_chat) as ImageView
            ivUser = itemView.findViewById(R.id.ivUserChat) as ImageView
        }

        override fun onClick(view: View) {
            val position = getAdapterPosition()
            val model = getItem(position)
            if (model.mapModel != null) {
                mClickListenerChatFirebase.clickImageMapChat(view, position, model.mapModel?.latitude, model.mapModel?.longitude)
            } else {
                mClickListenerChatFirebase.clickImageChat(view, position, model.userModel?.name, model.userModel?.photo_profile, model.file?.url_file)
            }
        }

        fun setTxtMessage(message: String) {
            if (txtMessage == null) return
            txtMessage!!.setText(message)
        }

        fun setIvUser(urlPhotoUser: String) {
            if (ivUser == null) return
            Glide.with(ivUser!!.context).load(urlPhotoUser).centerCrop().transform(CircleTransform(ivUser!!.context)).override(40, 40).into(ivUser!!)
        }

        fun setTvTimestamp(timestamp: String) {
            if (tvTimestamp == null) return
            tvTimestamp!!.text = converteTimestamp(timestamp)
        }

        fun setIvChatPhoto(url: String) {
            if (ivChatPhoto == null) return
            Glide.with(ivChatPhoto!!.context).load(url)
                    .override(100, 100)
                    .fitCenter()
                    .into(ivChatPhoto!!)
            ivChatPhoto!!.setOnClickListener(this)
        }

        fun tvIsLocation(visible: Int) {
            if (tvLocation == null) return
            tvLocation!!.visibility = visible
        }

    }

    private fun converteTimestamp(mileSegundos: String): CharSequence {
        return DateUtils.getRelativeTimeSpanString(java.lang.Long.parseLong(mileSegundos), System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS)
    }

    companion object {

        private val RIGHT_MSG = 0
        private val LEFT_MSG = 1
        private val RIGHT_MSG_IMG = 2
        private val LEFT_MSG_IMG = 3
    }

}
