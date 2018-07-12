package com.ajayrockstarindevops.ajdevops

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_firebase_phone_authentication.*



class FirebasePhoneAuthentication : AppCompatActivity(), View.OnClickListener {
    lateinit var mAuth: FirebaseAuth
    // [END declare_auth]
    internal var mVerificationInProgress = false
    lateinit var mVerificationId: String
    lateinit var mResendToken: PhoneAuthProvider.ForceResendingToken
    lateinit var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    lateinit var mPhoneNumberViews: ViewGroup
    lateinit var mSignedInViews: ViewGroup
    lateinit var mStatusText: TextView
    lateinit var mDetailText: TextView
    lateinit var mPhoneNumberField: EditText
    lateinit var mVerificationField: EditText
    lateinit var mStartButton: Button
    lateinit var mVerifyButton: Button
    lateinit var mResendButton: Button
    lateinit var mSignOutButton: Button
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_phone_authentication)

        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState)
        }
        progressBar = findViewById(R.id.progressBar) as ProgressBar
        // Assign views
        mPhoneNumberViews = findViewById(R.id.phone_auth_fields) as ViewGroup
        mSignedInViews = findViewById(R.id.signed_in_buttons) as ViewGroup
        mStatusText = findViewById(R.id.status) as TextView
        mDetailText = findViewById(R.id.detail) as TextView
        mPhoneNumberField = findViewById(R.id.field_phone_number) as EditText
        mVerificationField = findViewById(R.id.field_verification_code) as EditText
        mStartButton = findViewById(R.id.button_start_verification) as Button
        mVerifyButton = findViewById(R.id.button_verify_phone) as Button
        mResendButton = findViewById(R.id.button_resend) as Button
        mSignOutButton = findViewById(R.id.sign_out_button) as Button
        // Assign click listeners
        mStartButton.setOnClickListener(this)
        mVerifyButton.setOnClickListener(this)
        mResendButton.setOnClickListener(this)
        mSignOutButton.setOnClickListener(this)
        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance()
        // [END initialize_auth]
        // Initialize phone auth callbacks
        // [START phone_auth_callbacks]
        mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override
            fun onVerificationCompleted(credential: PhoneAuthCredential) {
                // This callback will be invoked in two situations:
                // 1 - Instant verification. In some cases the phone number can be instantly
                // verified without needing to send or enter a verification code.
                // 2 - Auto-retrieval. On some devices Google Play services can automatically
                // detect the incoming verification SMS and perform verificaiton without
                // user action.
                Log.d(TAG, "onVerificationCompleted:" + credential)
                // [START_EXCLUDE silent]
                mVerificationInProgress = false
                // [END_EXCLUDE]
                // [START_EXCLUDE silent]
                // Update the UI and attempt sign in with the phone credential
                updateUI(STATE_VERIFY_SUCCESS, credential)
                // [END_EXCLUDE]
                signInWithPhoneAuthCredential(credential)
            }

            override
            fun onVerificationFailed(e: FirebaseException) {
                // This callback is invoked in an invalid request for verification is made,
                // for instance if the the phone number format is not valid.
                Log.w(TAG, "onVerificationFailed", e)
                // [START_EXCLUDE silent]
                mVerificationInProgress = false
                // [END_EXCLUDE]
                if (e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                    // [START_EXCLUDE]
                    mPhoneNumberField.setError("Invalid phone number.")
                    // [END_EXCLUDE]
                } else if (e is FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                    // [START_EXCLUDE]
                    Snackbar.make(findViewById(android.R.id.content), "Quota exceeded.",
                            Snackbar.LENGTH_SHORT).show()
                    // [END_EXCLUDE]
                }
                // Show a message and update the UI
                // [START_EXCLUDE]
                updateUI(STATE_VERIFY_FAILED)
                // [END_EXCLUDE]
            }

            override
            fun onCodeSent(verificationId: String,
                           token: PhoneAuthProvider.ForceResendingToken) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                Log.d(TAG, "onCodeSent:" + verificationId)
                // Save verification ID and resending token so we can use them later
                mVerificationId = verificationId
                mResendToken = token
                // [START_EXCLUDE]
                // Update UI
                updateUI(STATE_CODE_SENT)
                // [END_EXCLUDE]
            }
        }
        // [END phone_auth_callbacks]
    }

    // [START on_start_check_user]
    override
    fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth.getCurrentUser()
        updateUI(currentUser)
        // [START_EXCLUDE]
        if (mVerificationInProgress && validatePhoneNumber()) {
            startPhoneNumberVerification(mPhoneNumberField.getText().toString())
        }
        // [END_EXCLUDE]
    }

    // [END on_start_check_user]
    override
    protected fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_VERIFY_IN_PROGRESS, mVerificationInProgress)
    }

    override
    protected fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mVerificationInProgress = savedInstanceState.getBoolean(KEY_VERIFY_IN_PROGRESS)
    }

    private fun startPhoneNumberVerification(phoneNumber: String) {
        // [START start_phone_auth]
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber, // Phone number to verify
                60, // Timeout duration
                TimeUnit.SECONDS, // Unit of timeout
                this, // Activity (for callback binding)
                mCallbacks) // OnVerificationStateChangedCallbacks
        // [END start_phone_auth]
        mVerificationInProgress = true
        mStatusText.visibility = View.INVISIBLE
    }

    private fun verifyPhoneNumberWithCode(verificationId: String, code: String) {
        // [START verify_with_code]
        val credential = PhoneAuthProvider.getCredential(verificationId, code)
        // [END verify_with_code]
        signInWithPhoneAuthCredential(credential)
    }

    // [START resend_verification]
    private fun resendVerificationCode(phoneNumber: String, token: PhoneAuthProvider.ForceResendingToken) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNumber, // Phone number to verify
                60, // Timeout duration
                TimeUnit.SECONDS, // Unit of timeout
                this, // Activity (for callback binding)
                mCallbacks, // OnVerificationStateChangedCallbacks
                token) // ForceResendingToken from callbacks
    }

    // [END resend_verification]
    // [START sign_in_with_phone]
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, object : OnCompleteListener<AuthResult> {
                    override
                    fun onComplete(@NonNull task: Task<AuthResult>) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success")
                            val user = task.getResult().getUser()
                            // [START_EXCLUDE]
                            updateUI(STATE_SIGNIN_SUCCESS, user)
                            // [END_EXCLUDE]
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException())
                            if (task.getException() is FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                // [START_EXCLUDE silent]
                                mVerificationField.setError("Invalid code.")
                                // [END_EXCLUDE]
                            }
                            // [START_EXCLUDE silent]
                            // Update UI
                            updateUI(STATE_SIGNIN_FAILED)
                            // [END_EXCLUDE]
                        }
                    }
                })
    }

    // [END sign_in_with_phone]
    private fun signOut() {
        mAuth.signOut()
        updateUI(STATE_INITIALIZED)
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            updateUI(STATE_SIGNIN_SUCCESS, user)
        } else {
            updateUI(STATE_INITIALIZED)
        }
    }

    private fun updateUI(uiState: Int, user: FirebaseUser?) {
        updateUI(uiState, user, null)
    }

    private fun updateUI(uiState: Int, cred: PhoneAuthCredential) {
        updateUI(uiState, null, cred)
    }


    private fun updateUI(uiState: Int, user: FirebaseUser? = mAuth.getCurrentUser(), cred: PhoneAuthCredential? = null) {
        when (uiState) {
            STATE_INITIALIZED -> {
                // Initialized state, show only the phone number field and start button
                enableViews(mStartButton, mPhoneNumberField)
                disableViews(mVerifyButton, mResendButton, mVerificationField)
                mDetailText.setText(null)
            }
            STATE_CODE_SENT -> {
                // Code sent state, show the verification field, the
                enableViews(mVerifyButton, mResendButton, mPhoneNumberField, mVerificationField)
                disableViews(mStartButton)
                mDetailText.setText(R.string.status_code_sent)
                mDetailText.setTextColor(Color.parseColor("#43a047"))
            }
            STATE_VERIFY_FAILED -> {
                // Verification has failed, show all options
                enableViews(mStartButton, mVerifyButton, mResendButton, mPhoneNumberField,
                        mVerificationField)
                mDetailText.setText(R.string.status_verification_failed)
                mDetailText.setTextColor(Color.parseColor("#dd2c00"))
                progressBar.visibility = View.INVISIBLE
            }
            STATE_VERIFY_SUCCESS -> {
                // Verification has succeeded, proceed to firebase sign in
                disableViews(mStartButton, mVerifyButton, mResendButton, mPhoneNumberField,
                        mVerificationField)
                mDetailText.setText("Verfication Sucessfull")
                mDetailText.setTextColor(Color.parseColor("#43a047"))
                progressBar.visibility = View.INVISIBLE
                // Set the verification text based on the credential
                if (cred != null) {
                    if (cred.getSmsCode() != null) {
                        mVerificationField.setText(cred.getSmsCode())
                    } else {
                        mVerificationField.setText(R.string.instant_validation)
                        mVerificationField.setTextColor(Color.parseColor("#4bacb8"))
                    }
                }
            }
            STATE_SIGNIN_FAILED -> {
                // No-op, handled by sign-in check
                mDetailText.setText(R.string.status_sign_in_failed)
                mDetailText.setTextColor(Color.parseColor("#dd2c00"))
                progressBar.visibility = View.INVISIBLE
            }
            STATE_SIGNIN_SUCCESS ->
                // Np-op, handled by sign-in check
                mStatusText.setText(R.string.signed_in)
        }
        if (user == null) {
            // Signed out
            mPhoneNumberViews.visibility = View.VISIBLE
            mSignedInViews.visibility = View.GONE
            mStatusText.setText(R.string.signed_out)
        } else {
            // Signed in
            mPhoneNumberViews.visibility = View.GONE
/*
            mSignedInViews.setVisibility(View.VISIBLE);
            enableViews(mPhoneNumberField, mVerificationField);
            mPhoneNumberField.setText(null);
            mVerificationField.setText(null);
            mStatusText.setText(R.string.signed_in);
            mDetailText.setText(getString(R.string.firebase_status_fmt, user.getUid()));*/

            val intent = Intent(this, NavigationDrawerActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validatePhoneNumber(): Boolean {
        val phoneNumber = mPhoneNumberField.getText().toString()
        if (TextUtils.isEmpty(phoneNumber)) {
            mPhoneNumberField.setError("Invalid phone number.")
            mPhoneNumberField.setTextColor(Color.parseColor("#ff1744"));
            return false
        }
        return true
    }

    private fun enableViews(vararg views: View) {
        for (v in views) {
            v.setEnabled(true)
        }
    }

    private fun disableViews(vararg views: View) {
        for (v in views) {
            v.setEnabled(false)
        }
    }

    override
    fun onClick(view: View) {
        when (view.getId()) {
            R.id.button_start_verification -> {
                if (!validatePhoneNumber()) {
                    return
                }
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(mVerificationField.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS)

                /*  ///////hide keyboard start
                val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS)
                /////////hide keyboard end*/
                //mStatusText.setText("Authenticating....!");
                progressBar.visibility = View.VISIBLE
                startPhoneNumberVerification(mPhoneNumberField.getText().toString())
            }
            R.id.button_verify_phone -> {
                val code = mVerificationField.getText().toString()
                if (TextUtils.isEmpty(code)) {
                    mVerificationField.setError("Cannot be empty.")
                    return
                }
                verifyPhoneNumberWithCode(mVerificationId, code)
            }
            R.id.button_resend -> resendVerificationCode(mPhoneNumberField.getText().toString(), mResendToken)
            R.id.sign_out_button -> signOut()
        }
    }

    /*  override
      fun onCreateOptionsMenu(menu: Menu): Boolean {
          // Inflate the menu; this adds items to the action bar if it is present.
          getMenuInflater().inflate(R.menu.menu_main, menu)
          return true
      }

      override
      fun onOptionsItemSelected(item: MenuItem): Boolean {
          // Handle action bar item clicks here. The action bar will
          // automatically handle clicks on the Home/Up button, so long
          // as you specify a parent activity in AndroidManifest.xml.
          val id = item.getItemId()
          if (id == R.id.action_settings) {
              return true
          }
          return super.onOptionsItemSelected(item)
      }
  */
    companion object {
        private val TAG = "PhoneAuthActivity"
        private val KEY_VERIFY_IN_PROGRESS = "key_verify_in_progress"
        private val STATE_INITIALIZED = 1
        private val STATE_CODE_SENT = 2
        private val STATE_VERIFY_FAILED = 3
        private val STATE_VERIFY_SUCCESS = 4
        private val STATE_SIGNIN_FAILED = 5
        private val STATE_SIGNIN_SUCCESS = 6
    }
}
