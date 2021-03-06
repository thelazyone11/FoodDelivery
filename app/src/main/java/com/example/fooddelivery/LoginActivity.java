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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private Button btn_Confire;
    private EditText et_Email_log;
    private EditText et_Password_log;
    private TextView tv_toSign;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_Confire =  findViewById(R.id.btn_Confire);
        et_Email_log = findViewById(R.id.et_email_log);
        et_Password_log = findViewById(R.id.et_password_log);
        tv_toSign = findViewById(R.id.tv_toSign);
        mAuth = FirebaseAuth.getInstance();
        mProgressDialog = new ProgressDialog(this);

        tv_toSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SignInActivity.class);
                startActivity(i);
            }
        });

        btn_Confire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mEmail =et_Email_log.getText().toString().trim();
                final String mPassword = et_Password_log.getText().toString().trim();

                if(TextUtils.isEmpty(mEmail)){
                    et_Email_log.setError("Requried Field");
                    return;
                }
                if(TextUtils.isEmpty(mPassword)){
                    et_Password_log.setError("Requried Field");
                    return;
                }
                mProgressDialog.setMessage("Processing...");
                mProgressDialog.show();

                mAuth.signInWithEmailAndPassword(mEmail,mPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            mProgressDialog.dismiss();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else{
                            mProgressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),"check your email and password",Toast.LENGTH_SHORT);
                        }

                    }
                });
            }
        });
    }
}
