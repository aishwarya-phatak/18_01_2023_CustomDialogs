package com.example.a18_01_2023_customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin1, btnLogin2, btnLogin3, btnLogin;
    EditText edtUsername, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    public void initViews(){
        btnLogin1 = findViewById(R.id.btnLogin1);
        btnLogin2 = findViewById(R.id.btnLogin2);
        btnLogin3 = findViewById(R.id.btnLogin3);
    }

    public void initListeners(){
        btnLogin1.setOnClickListener(new BtnLogin1ClickListener());
        btnLogin2.setOnClickListener(new BtnLogin2ClickListener());
        btnLogin3.setOnClickListener(new BtnLogin3ClickListener());
    }
    //way 3
    class BtnLogin3ClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            LoginDialog loginDialog = new LoginDialog(MainActivity.this);
            loginDialog.setOnLoginListener(new LoginDialog.OnLoginListener() {
                @Override
                public void onSuccess() {
                    Toast.makeText(MainActivity.this, "on Success", Toast.LENGTH_SHORT).show();
                    loginDialog.dismiss();
                }

                @Override
                public void onFailure() {
                    Toast.makeText(MainActivity.this, "on Fail", Toast.LENGTH_SHORT).show();
                    loginDialog.cancel();
                }
            });
            loginDialog.show();
        }
    }

    //way 2
    class BtnLogin2ClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            LoginDialog loginDialog = new LoginDialog(MainActivity.this);
            loginDialog.show();
        }
    }

    //way 1
    class BtnLogin1ClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Dialog loginDialog = new Dialog(MainActivity.this);
            loginDialog.setContentView(R.layout.login_dailog);
            edtUsername = loginDialog.findViewById(R.id.edtUsername);
            edtPassword = loginDialog.findViewById(R.id.edtPassword);
            btnLogin = loginDialog.findViewById(R.id.btnLogin);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edtUsername.getText().toString().equals("bitcode") &&
                            edtPassword.getText().toString().equals("bitcode@1234")){
                        Log.e("tag","Login Success");
                        loginDialog.dismiss();
                    } else{
                        Log.e("tag","Login Failed");
                        loginDialog.cancel();
                    }
                }
            });
            loginDialog.show();
        }
    }
}