package com.example.project;

import static org.xmlpull.v1.XmlPullParser.TEXT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, email;
    Button signup, signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password1);
        email = (EditText) findViewById(R.id.username1);
        signup = (Button) findViewById(R.id.register);
        signin = (Button) findViewById(R.id.signin);
        DB = new DBHelper(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  String user = username.getText().toString();
                String eemail = email.getText().toString();
                String pass = password.getText().toString();
                if(password.equals("")||email.equals(""))
            Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        else{
            Boolean checkuserpass = DB.checkusernamepassword(eemail, pass);
            if(checkuserpass==true){
                Toast.makeText(MainActivity.this, "Sign in Sucessfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        }
    }
});

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register_activity.class);
                startActivity(intent);
            }
        });
    }
}

