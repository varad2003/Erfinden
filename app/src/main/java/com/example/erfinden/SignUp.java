package com.example.erfinden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    FirebaseAuth auth;
    TextView signup;
    LinearLayout signin;
    TextInputEditText firstname,lastname,email,phone,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signup=findViewById(R.id.txt_signup);
        signin=findViewById(R.id.txt_signin);
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.passowrd);

        auth=FirebaseAuth.getInstance();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if(firstname.getText().toString().trim().isEmpty()){
                    firstname.setError("Enter First Name");
                }
                else if(lastname.getText().toString().trim().isEmpty()){
                    lastname.setError("Enter Last Name");
                }
                else if(email.getText().toString().trim().isEmpty()){
                    email.setError("Enter valid Email");
                }
                else if(phone.getText().toString().trim().isEmpty()){
                    phone.setError("Enter Valid Phone");
                }
                else if(password.getText().toString().trim().length()<6){
                    password.setError("Password should have minumum six characters");
                }
                else{
                    auth.createUserWithEmailAndPassword(email.getText().toString().trim(),password.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SignUp.this, "Success", Toast.LENGTH_SHORT).show();
                                login();
                            }
                            else{
                                Toast.makeText(SignUp.this, "Error in registration", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }



            }
        });

    }

    public boolean checkemail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    private void login() {
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}