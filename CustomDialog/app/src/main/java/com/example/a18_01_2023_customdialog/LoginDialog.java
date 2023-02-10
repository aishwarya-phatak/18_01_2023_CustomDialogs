package com.example.a18_01_2023_customdialog;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class LoginDialog extends Dialog {
    EditText edtUsername, edtPassword;
    Button btnLogin;

    public interface OnLoginListener{
        void onSuccess();
        void onFailure();
    }
    public OnLoginListener onLoginListener;

    public void setOnLoginListener(OnLoginListener onLoginListener){
        this.onLoginListener = onLoginListener;
    }

    public LoginDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.login_dailog);
        initViews();
        initListeners();
    }

    private void initViews(){
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void initListeners(){
        btnLogin.setOnClickListener(new BtnLoginClickListener());
    }

    class BtnLoginClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if((edtUsername.getText().toString().equals("bitcode")) &&
                    (edtPassword.getText().toString().equals("bitcode@123"))){
                onLoginListener.onSuccess();
                //Log.e("tag","Login Success");
            } else {
                onLoginListener.onFailure();
                //Log.e("tag","Login Failure");
            }
        }
    }
}
