package com.example.fooddelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    private EditText et_email_sign;
    private EditText et_phone_sign;
    private EditText et_password_sign;
    private Button bt_signUp_sign;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth=FirebaseAuth.getInstance();
        mProgressDialog = new ProgressDialog(this);

        et_email_sign = findViewById(R.id.et_email_sign);
        et_password_sign = findViewById(R.id.et_password_sign);
        et_phone_sign = findViewById(R.id.et_phone_sign);
        bt_signUp_sign =findViewById(R.id.btn_signUp_sign);

        bt_signUp_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mEmail = et_email_sign.getText().toString().trim();
                String mPhone = et_phone_sign.getText().toString().trim();
                String mPassword = et_password_sign.getText().toString().trim();

                if(TextUtils.isEmpty(mEmail)){
                    et_email_sign.setError("Requried Field...");
                    return;
                }

                if(TextUtils.isEmpty(mPhone)){
                    et_phone_sign.setError("Requried Field...");
                    return;
                }
                if(TextUtils.isEmpty(mPassword)){
                    et_password_sign.setError("Requried Field...");
                    return;
                }
                mProgressDialog.setMessage("Processing...");
                mProgressDialog.show();

                mAuth.createUserWithEmailAndPassword(mEmail,mPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Sign Up Sucessfull...", Toast.LENGTH_SHORT);
                            mProgressDialog.dismiss();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(getApplicationContext(),"Signing Failed, Try Again",Toast.LENGTH_SHORT);
                            mProgressDialog.dismiss();
                        }
                    }
                });
            }
        });

    }
}
