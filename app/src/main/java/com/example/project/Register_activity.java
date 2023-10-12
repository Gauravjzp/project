package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register_activity extends AppCompatActivity {

    EditText username, password, eemail;
    Button btnlogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    username = (EditText) findViewById(R.id.username);
    eemail=(EditText) findViewById(R.id.email);
    password=(EditText) findViewById(R.id.password);
    btnlogin = (Button) findViewById(R.id.signup);
    DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String email = eemail.getText().toString();
                String pass = password.getText().toString();

                //String repass = repassword.getText().toString();

                if (user.equals("") || email.equals("") || pass.equals(""))
                    Toast.makeText(Register_activity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    // if (pass.equals("TEXT")) {
                    Boolean checkuser = DB.checkusername(email);
                    if (checkuser == false) {
                        Boolean insert = DB.insertData(email, pass);
                        if (insert == true) {
                            Toast.makeText(Register_activity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Register_activity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Register_activity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                    }
                }
                //else {Toast.makeText(Register_activity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();}
            }
       // }

        });
}
}

