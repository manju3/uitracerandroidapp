package com.cloudmpower.www.uiklario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText userName,password;
    AppCompatTextView userNameError, passwordError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        userNameError = (AppCompatTextView) findViewById(R.id.userNameError);
        passwordError = (AppCompatTextView) findViewById(R.id.passwordError);
    }
    public void validator() {
        //Toast.makeText(MainActivity.this, userName.getText().toString(), Toast.LENGTH_SHORT).show();
        if(userName.getText().toString().isEmpty()) {
            userNameError.setText(R.string.userNameError);
        }
    }

    public void loginClickHandler(View view) {
        validator();
    }

}
