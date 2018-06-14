package com.ajayrockstarindevops.ajdevops

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.bumptech.glide.Glide
import com.bumptech.glide.request.Request
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.SizeReadyCallback
import com.bumptech.glide.request.target.Target

import alessandro.firebaseandroid.R
import alessandro.firebaseandroid.adapter.CircleTransform

class FullScreenImageActivity : AppCompatActivity() {

    private var mImageView: TouchImageView? = null
    private var ivUser: ImageView? = null
    private var tvUser: TextView? = null
    private var progressDialog: ProgressDialog? = null

    protected fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_image)
        bindViews()
    }

    protected fun onResume() {
        super.onResume()
        setValues()
    }

    fun onBackPressed() {
        super.onBackPressed()
        System.gc()
        finish()
    }

    fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }


    private fun bindViews() {
        progressDialog = ProgressDialog(this)
        mImageView = findViewById(R.id.imageView) as TouchImageView
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        getSupportActionBar().setDisplayShowTitleEnabled(false)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true)
        ivUser = toolbar.findViewById(R.id.avatar)
        tvUser = toolbar.findViewById(R.id.title)
    }

    private fun setValues() {
        val nameUser: String
        val urlPhotoUser: String
        val urlPhotoClick: String
        nameUser = getIntent().getStringExtra("nameUser")
        urlPhotoUser = getIntent().getStringExtra("urlPhotoUser")
        urlPhotoClick = getIntent().getStringExtra("urlPhotoClick")
        Log.i("TAG", "imagem recebida $urlPhotoClick")
        tvUser!!.text = nameUser // Name
        Glide.with(this).load(urlPhotoUser).centerCrop().transform(CircleTransform(this)).override(40, 40).into(ivUser!!)

        Glide.with(this).load(urlPhotoClick).asBitmap().override(640, 640).fitCenter().into(object : SimpleTarget<Bitmap>() {

            override fun onLoadStarted(placeholder: Drawable?) {
                progressDialog!!.setMessage("Carregando Imagem...")
                progressDialog!!.show()
            }

            override fun onResourceReady(resource: Bitmap, glideAnimation: GlideAnimation<in Bitmap>) {
                progressDialog!!.dismiss()
                mImageView!!.setImageBitmap(resource)
            }

            override fun onLoadFailed(e: Exception?, errorDrawable: Drawable?) {
                Toast.makeText(this@FullScreenImageActivity, "Erro, tente novamente", Toast.LENGTH_LONG).show()
                progressDialog!!.dismiss()
            }
        })
    }

}
