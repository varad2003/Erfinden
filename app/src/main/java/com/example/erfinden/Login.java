package com.example.erfinden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Login extends AppCompatActivity {


    LinearLayout signup;
    TextView signin,forgot_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup=findViewById(R.id.txt_signup);
        signin=findViewById(R.id.txt_signin);
        forgot_password=findViewById(R.id.fogotpassword);

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ForgotPassword.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MarketPlace.class));
                finish();
            }
        });


    }

    private void register() {
        startActivity(new Intent(getApplicationContext(),SignUp.class));
        finish();
    }
}