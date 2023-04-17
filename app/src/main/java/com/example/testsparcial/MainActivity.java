package com.example.testsparcial;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.testsparcial.db.DbProductos;
import com.example.testsparcial.db.BaseHelper;

public class MainActivity extends AppCompatActivity {

    BaseHelper baseHelper;
    EditText username;
    EditText password;
    Button loginButton;
    Button registroButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.usuario);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        registroButton = findViewById(R.id.registroButton);



        baseHelper = new BaseHelper(this);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1 = username.getText().toString().trim();
                String password1 = password.getText().toString().trim();

                boolean result = baseHelper.checkUser(username1, password1);

                if (result) {
                    Toast.makeText(MainActivity.this, "Ingreso exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, DbProductos.class);
                    startActivity(intent);


                } else {
                    Toast.makeText(MainActivity.this, "Ingreso fallido", Toast.LENGTH_SHORT).show();

                }
            }
        });

        registroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username2 = username.getText().toString().trim();
                String password2 = password.getText().toString().trim();

                boolean result = baseHelper.insertUser(username2, password2);

                if (result) {
                    Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}





