package com.example.devha.systemapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Main2Activity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "EmailPassword";
    private TextView mStatusTextView;
    private TextView mDetailTextView;
    private EditText mPasswordField, confPass, usrName,mEmailField;
    // [END declare_auth]


    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    // [START declare_auth_listener]
    private FirebaseAuth.AuthStateListener mAuthListener;
    // [END declare_auth_listener]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Buttons
//        findViewById(R.id.email_sign_in_button).setOnClickListener(this);
        findViewById(R.id.ID_signUp).setOnClickListener(this);
//        findViewById(R.id.sign_out_button).setOnClickListener(this);


        usrName = (EditText) findViewById(R.id.ID_fullNm);
        mEmailField = (EditText) findViewById(R.id.ID_E_adrs);
        mPasswordField = (EditText) findViewById(R.id.ID_password);
        confPass = (EditText) findViewById(R.id.ID_passwordConf);


        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

        // [START auth_state_listener]
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // [START_EXCLUDE]
//                updateUI(user);
                // [END_EXCLUDE]
            }
        };
        // [END auth_state_listener]
    }


    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }

        showProgressDialog();

        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(Main2Activity.this, "Registration failed ",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(Main2Activity.this, Main3Activity.class));

                        }

                        // [START_EXCLUDE]
                        hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
        // [END create_user_with_email]
    }




    private boolean validateForm() {
        boolean valid = true;
        String email = mEmailField.getText().toString();
        String name = usrName.getText().toString();
        String password = mPasswordField.getText().toString();
        String passwordconf = confPass.getText().toString();

        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required.");
            valid = false;
        } else {
            mEmailField.setError(null);
        }
        if (TextUtils.isEmpty(name)) {
            usrName.setError("Required.");
            valid = false;
        } else {
            usrName.setError(null);
        }
        if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Required.");
            valid = false;
        } else {
            mPasswordField.setError(null);
        }
        if (TextUtils.isEmpty(passwordconf)) {
            confPass.setError("Required.");
            valid = false;
        } else {
            confPass.setError(null);
        }
        if (!password.equals(passwordconf)) {
            confPass.setError("Password not confirmed.");
            valid = false;
        } else {
            confPass.setError(null);
        }

        return valid;
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.ID_signUp) {
            createAccount(mEmailField.getText().toString(), mPasswordField.getText().toString());
        }


    }
}
