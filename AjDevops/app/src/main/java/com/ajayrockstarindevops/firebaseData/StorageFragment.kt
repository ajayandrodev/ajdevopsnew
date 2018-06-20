package com.ajayrockstarindevops.firebaseData


import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.Toast

import com.ajayrockstarindevops.ajdevops.R
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_storage.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StorageFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class StorageFragment : Fragment(), View.OnClickListener  {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val TAG = "StorageActivity"
    //track Choosing Image Intent
    private val CHOOSING_IMAGE_REQUEST = 1234

    private var fileUri: Uri? = null
    private var bitmap: Bitmap? = null
    private var imageReference: StorageReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_storage, container, false)
        //getting recyclerview from xml
        tvFileName.text = ""

        imageReference = FirebaseStorage.getInstance().reference.child("images")

        btn_choose_file.setOnClickListener(this)
        btn_upload_file.setOnClickListener(this)
        return view
    }

    override fun onClick(view: View?) {
        val i = view!!.id

        when (i) {
            R.id.btn_choose_file -> showChoosingFile()
            R.id.btn_upload_file -> uploadFile()
        }
    }
    private fun uploadFile() {
        if (fileUri != null) {
            val fileName = edtFileName.text.toString()

            if (!validateInputFileName(fileName)) {
                return
            }

            val fileRef = imageReference!!.child(fileName + "." + getFileExtension(fileUri!!))
            fileRef.putFile(fileUri!!)
                    .addOnSuccessListener { taskSnapshot ->
                        Log.e(TAG, "Uri: " + taskSnapshot.downloadUrl)
                        Log.e(TAG, "Name: " + taskSnapshot.metadata!!.name)
                        tvFileName.text = taskSnapshot.metadata!!.path + " - " + taskSnapshot.metadata!!.sizeBytes / 1024 + " KBs"
                        Toast.makeText(context, "File Uploaded ", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener { exception ->
                        Toast.makeText(context, exception.message, Toast.LENGTH_LONG).show()
                    }
                    .addOnProgressListener { taskSnapshot ->
                        // progress percentage
                        val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot.totalByteCount

                        // percentage in progress dialog
                        val intProgress = progress.toInt()
                        tvFileName.text = "Uploaded " + intProgress + "%..."
                    }
                    .addOnPausedListener { System.out.println("Upload is paused!") }

        } else {
            Toast.makeText(context, "No File!", Toast.LENGTH_LONG).show()
        }
    }
    private fun showChoosingFile() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Image"), CHOOSING_IMAGE_REQUEST)
    }

    private fun getFileExtension(uri: Uri): String {
        val contentResolver = activity?.contentResolver
        val mime = MimeTypeMap.getSingleton()

        return mime.getExtensionFromMimeType(contentResolver?.getType(uri))
    }

    private fun validateInputFileName(fileName: String): Boolean {
        if (TextUtils.isEmpty(fileName)) {
            Toast.makeText(context, "Enter file name!", Toast.LENGTH_SHORT).show()
            return false
        }
        /* else if (fileName.equals(edtFileName.text.toString())) {
             Toast.makeText(this, "File is already exist!", Toast.LENGTH_SHORT).show()
             return false
         }*/

        return true
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StorageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                StorageFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}