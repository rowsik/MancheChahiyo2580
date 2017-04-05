package com.manchehahiyo.www.manchechahiyo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.manchehahiyo.www.manchechahiyo.R;

public class Login_Activity extends AppCompatActivity {

    EditText etusername,etpassword;
    Button bSignin;
    TextView register;
     SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        pref=getSharedPreferences("USERINFO", Context.MODE_PRIVATE);

       bSignin= (Button) findViewById(R.id.bSignIn);
        register= (TextView) findViewById(R.id.register);
        etusername= (EditText) findViewById(R.id.etUsername);
        etpassword= (EditText) findViewById(R.id.etPassword);
        bSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernamevalue=etusername.getText().toString();
                String passwordvalue=etpassword.getText().toString();
                String registeredUsername=pref.getString("username","");
                String registeredPassword=pref.getString("password","");
                if(usernamevalue.equals(registeredUsername)&& passwordvalue.equals(registeredPassword))
                {
                    Toast.makeText(Login_Activity.this,"Login Successful",Toast.LENGTH_SHORT);
                    Intent intent=new Intent(Login_Activity.this,MainActivity.class);
                    startActivity(intent);
                }

                else
                    {
                    Toast.makeText(Login_Activity.this,"Login Failed",Toast.LENGTH_SHORT);
                };

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login_Activity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });


    }

}
