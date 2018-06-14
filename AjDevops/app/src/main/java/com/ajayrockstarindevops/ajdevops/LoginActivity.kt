package com.ajayrockstarindevops.ajdevops

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

import com.ajayrockstarindevops.ajdevops.MainActivity
import com.ajayrockstarindevops.ajdevops.R
import com.ajayrockstarindevops.util.Util
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    //UI
    private var mSignInButton: SignInButton? = null

    //Firebase and GoogleApiClient
    private var mGoogleApiClient: GoogleApiClient? = null
    private var mFirebaseAuth: FirebaseAuth? = null

    protected fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (!Util.verificaConexao(this)) {
            Util.initToast(this, "Você não tem conexão com internet")
            finish()
        }

        mSignInButton = findViewById(R.id.sign_in_button) as SignInButton
        mSignInButton!!.setOnClickListener(this)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        mGoogleApiClient = GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build()

        // Initialize FirebaseAuth
        mFirebaseAuth = FirebaseAuth.getInstance()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            if (result.isSuccess()) {
                val account = result.getSignInAccount()
                firebaseAuthWithGoogle(account)
            } else {
                Log.e(TAG, "Google Sign In failed.")
            }
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.sign_in_button -> signIn()
            else -> return
        }
    }

   override fun onConnectionFailed(connectionResult: ConnectionResult) {
        Log.d(TAG, "onConnectionFailed:$connectionResult")
        Util.initToast(this, "Google Play Services error.")
    }

    private fun signIn() {
        val signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        Log.d(TAG, "firebaseAuthWithGooogle:" + acct.getId())
        val credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null)
        mFirebaseAuth!!.signInWithCredential(credential)
                .addOnCompleteListener(this, object : OnCompleteListener<AuthResult> {
                   override fun onComplete(task: Task<AuthResult>) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful())
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException())
                            Util.initToast(this@LoginActivity, "Authentication failed")
                        } else {
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                            finish()
                        }
                    }
                })
    }

    companion object {

        //Constants
        private val TAG = LoginActivity::class.java!!.getSimpleName()
        private val RC_SIGN_IN = 9001
    }

}
