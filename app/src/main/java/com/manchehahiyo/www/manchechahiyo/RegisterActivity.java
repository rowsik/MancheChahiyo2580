package com.manchehahiyo.www.manchechahiyo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    EditText username,password,dob,phone;
    Button registerbutton,canselbutton;
SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        pref=getSharedPreferences("USERINFO", Context.MODE_PRIVATE);
        username= (EditText) findViewById(R.id.editusserrname);
        password= (EditText) findViewById(R.id.editsemester);
        dob= (EditText) findViewById(R.id.editdob);
        phone= (EditText) findViewById(R.id.editphone);
        registerbutton= (Button) findViewById(R.id.registerbutton);
        canselbutton= (Button) findViewById(R.id.canselbutton);



        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernnamveValue= username.getText().toString();
                String passwordValue= password.getText().toString();
                String dobValue= dob.getText().toString();
                String PhoneValue= phone.getText().toString();


                SharedPreferences.Editor editor=pref.edit();
                editor.putString("username",usernnamveValue);
                editor.putString("password",passwordValue);
                editor.putString("dob",dobValue);
                editor.putString("phone",PhoneValue);
                editor.commit();

                Toast.makeText(RegisterActivity.this,"User Registered",Toast.LENGTH_LONG).show();
                Response.Listener<String>responseListener=new  Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                        boolean success= jsonResponse.getBoolean("Success");
                            if(success){
                                    Intent intent = new Intent(RegisterActivity.this,Login_Activity.class);
                                    RegisterActivity.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder= new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            };
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };
                //RegisterRequest registerRequest= new RegisterRequest(password);

            }
        });


    }

}
