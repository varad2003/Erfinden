package com.example.erfinden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    Button submit;
    EditText gmail;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        submit=findViewById(R.id.submit);
        gmail=findViewById(R.id.email);

        auth=FirebaseAuth.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gmail.getText().toString().trim().isEmpty()){
                    gmail.setError("Enter Valid Email");
                }
                else{
                    auth.sendPasswordResetEmail(gmail.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgotPassword.this, "Email is sent to reset Password", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(ForgotPassword.this, "Something Wrong Happen", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}