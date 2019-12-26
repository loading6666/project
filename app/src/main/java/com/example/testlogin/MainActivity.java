package com.example.testlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Login here");
        Button regist=(Button)findViewById(R.id.bregister);
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, register.class);
                startActivity(i);


            }
        });

        Button login=(Button)findViewById(R.id.Blogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText a = (EditText) findViewById(R.id.TFusername);
                EditText b = (EditText) findViewById(R.id.TFpassword);
                String str = a.getText().toString();
                String pass = b.getText().toString();
                String password = helper.searchPass(str);
                if (str.equals("admin")&&pass.equals("admin")){
                    Intent i = new Intent(MainActivity.this, dataevent.class);
                    startActivity(i);
                }else if (a.length() == 0 && b.length() == 0) {
                    a.setError("Mohon di isi");
                    b.setError("Mohon di isi");
                } else if (a.length() == 0) {
                    a.setError("Mohon di isi");
                } else if (b.length() == 0) {
                    b.setError("Mohon di isi");
                } else if (pass.equals(password)) {
                    Intent i = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this,

                            "Password dont match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    }
