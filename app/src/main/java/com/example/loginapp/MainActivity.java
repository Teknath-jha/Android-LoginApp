package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private  EditText eName;
    private  EditText ePassword;
    private  Button   eLogin;
    private TextView  eAttemptsInfo;

    private String Username = "Admin";
    private String Password = "1234";

    boolean isValid=false;
    private int counter=5;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.tvName);
        ePassword = findViewById(R.id.tvPassword);
        eLogin = findViewById(R.id.btnLogin);
        eAttemptsInfo = findViewById(R.id.tvAttemptsInfo);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all details correctly!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    isValid=validate(inputName,inputPassword);
                    if(!isValid)
                    {
                        counter--;

                        Toast.makeText(MainActivity.this, "Please enter all details correctly!", Toast.LENGTH_SHORT).show();
                        eAttemptsInfo.setText("No. of attempts remainning :" + counter);
                        if(counter==0)
                        {
                            eLogin.setEnabled(false);
                        }

                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        //Add the code to next page  activity
                        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(intent);

                    }
                }

            }

        });
    }
    private boolean validate (String name, String password)
    {
        if(name.equals(Username) && password.equals(Password))
        {
            return true;
        }
        return false;
    }
}