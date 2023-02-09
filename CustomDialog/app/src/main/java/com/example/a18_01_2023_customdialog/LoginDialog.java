package com.example.a18_01_2023_customdialog;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

public class LoginDialog extends Dialog {

    public LoginDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.login_dailog);
        findViewById(R.id.edtUsername);
        findViewById(R.id.edtPassword);
        findViewById(R.id.btnLogin);

    }
}
