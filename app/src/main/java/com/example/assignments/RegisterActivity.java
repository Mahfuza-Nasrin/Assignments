package com.example.assignments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        EditText et_username = findViewById(R.id.et_register_username);
        EditText et_set_password = findViewById(R.id.et_set_password);
        EditText et_confirm_password = findViewById(R.id.et_confirm_password);
        EditText et_email= findViewById(R.id.et_register_email);
        Button btn_login = findViewById(R.id.btn_reg_login);
        Button btn_register = findViewById(R.id.btn_reg_register);
        Button btn_back = findViewById(R.id.btn_back);
        TextView outputText = findViewById(R.id.outputText);
        LinearLayout inputLayout = findViewById(R.id.inputLayout);
        LinearLayout outputLayout = findViewById(R.id.outputLayout);




        Pattern usernamePattern = Pattern.compile("[a-z0-9_-]{3,15}");
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = et_username.getText().toString();
                String email = et_email.getText().toString();
                String setPass = et_set_password.getText().toString();
                String confirmPass = et_confirm_password.getText().toString();

                if (userName.isEmpty()){
                    et_username.setError("Empty!!");
                    et_username.requestFocus();
                }else if (!usernamePattern.matcher(userName).matches()){
                    et_username.setError("Invalid username!");
                    et_username.requestFocus();
                }else if (email.isEmpty()){
                    et_email.setError("Empty!!");
                    et_email.requestFocus();
                }else if (!emailPattern.matcher(email).matches()){
                    et_email.setError("Invalid email!");
                    et_email.requestFocus();
                } else if (!setPass.equals(confirmPass)){
                    et_confirm_password.setError("Passwords doesn't match");
                    et_set_password.requestFocus();
                    et_set_password.setText("");
                    et_confirm_password.setText("");

                }else{
                    inputLayout.setVisibility(View.GONE);
                    outputLayout.setVisibility(View.VISIBLE);
                    String s = "Name: " + userName + "\nEmail: " + email;
                    outputText.setText(s);


                }



                //Toast.makeText(RegisterActivity.this, "Register button clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputLayout.setVisibility(View.VISIBLE);
                outputLayout.setVisibility(View.GONE);
                et_set_password.setText("");
                et_confirm_password.setText("");
                et_username.setText("");
                et_email.setText("");

            }
        });
    }
    }
