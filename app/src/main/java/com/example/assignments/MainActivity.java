package com.example.assignments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText et_username = findViewById(R.id.et_username);
        EditText et_password = findViewById(R.id.et_pass);
        Button btnLogin = findViewById(R.id.btn_login);
        Button btnRegister = findViewById(R.id.btn_register);

        Pattern usernamePattern = Pattern.compile("[a-z0-9_-]{3,15}");



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = et_username.getText().toString();
                if (userName.isEmpty()){
                    et_username.setError("Empty!!");
                    et_username.requestFocus();
                }else if (!usernamePattern.matcher(userName).matches()){
                    et_username.setError("Invalid username!");
                    et_username.requestFocus();
                }
                else {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                // Toast.makeText(MainActivity.this, "register button clicked!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}