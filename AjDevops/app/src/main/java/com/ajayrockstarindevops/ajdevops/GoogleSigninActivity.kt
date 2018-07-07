package com.ajayrockstarindevops.ajdevops

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_google_signin.*

class GoogleSigninActivity : AppCompatActivity(), View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private val TAG = "AJAYGoogleSignIn"
    private val REQUEST_CODE_SIGN_IN = 1234
    private val WEB_CLIENT_ID = "885498913691-ji39kjot48v9er73end7b0p98uu1h6s3.apps.googleusercontent.com"

    private var mAuth: FirebaseAuth? = null

    private var mGoogleApiClient: GoogleApiClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_signin)
        btn_sign_in.setOnClickListener(this)
        btn_phone_login.setOnClickListener(this)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(WEB_CLIENT_ID)
                .requestEmail()
                .build()

        mGoogleApiClient = GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build()

        mAuth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth!!.currentUser
        updateUI(currentUser)
    }

    override fun onClick(v: View?) {
        val i = v!!.id
        when (i) {
            R.id.btn_sign_in -> signIn()
            R.id.btn_phone_login -> loginWithPhone()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent();
        if (requestCode == REQUEST_CODE_SIGN_IN) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            if (result.isSuccess) {
                // successful -> authenticate with Firebase
                val account = result.signInAccount
                firebaseAuthWithGoogle(account!!)
            }
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        mAuth!!.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success
                        Toast.makeText(applicationContext, "signInWithCredential: Success!", Toast.LENGTH_SHORT).show()
                        val user = mAuth!!.currentUser
                        updateUI(user)
                    } else {
                        Toast.makeText(applicationContext, "Something Went Wrong", Toast.LENGTH_LONG).show();
                        updateUI(null)
                        Log.e(TAG, "onConnectionFailed():qqqqq" + task.exception);

                    }
                }
    }

    override fun onConnectionFailed(connectionResult: ConnectionResult) {
        Log.e(TAG, "onConnectionFailed():" + connectionResult);
        Toast.makeText(applicationContext, "Google Play Services error.", Toast.LENGTH_SHORT).show();
    }

    private fun signIn() {
        val intent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
        startActivityForResult(intent, REQUEST_CODE_SIGN_IN)
    }

    private fun loginWithPhone() {
        val intent = Intent(this, FirebasePhoneAuthentication::class.java)
        startActivity(intent)
    }


    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {

            val intent = Intent(this, NavigationDrawerActivity::class.java)
            /* intent.putExtra("name", user.displayName)
             intent.putExtra("email", user.email)*/
            startActivity(intent)
        } else {
            /* tvStatus.text = "Signed Out"
             tvDetail.text = null
             btn_sign_in.visibility = View.VISIBLE
             layout_sign_out_and_disconnect.visibility = View.GONE*/
        }
    }
}
