package com.cloudmpower.www.uiklario;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import com.github.nkzawa.emitter.Emitter.Listener;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private EditText userName, password;
    private AppCompatTextView userNameError, passwordError;
    private boolean appState = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        userNameError = (AppCompatTextView) findViewById(R.id.userNameError);
        passwordError = (AppCompatTextView) findViewById(R.id.passwordError);
        AppSocket socket = new AppSocket();
    }

    public boolean validator() {
        boolean err = true;
        if (userName.getText().toString().isEmpty()) {
            userNameError.setText(R.string.userNameError);
            err = false;
        }
        if (password.getText().toString().isEmpty()) {
            passwordError.setText(R.string.passwordError);
            err = false;
        }
        if(err) this.appState = false;
        return err;
    }

    public void loginClickHandler(View view) {
        if (validator()) {
            JSONObject obj = new JSONObject();
            try {
                obj.put("userName", (String) userName.getText().toString());
                obj.put("password", (String) password.getText().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            AppSocket.socket.emit("authorize", obj.toString());
            AppSocket.socket.on("success_authorization", authorizeSuccessCallback);
        }
    }
    public Listener  authorizeSuccessCallback = new Listener() {
        @Override
        public void call(final Object... args) {
            if(!appState) {
                appState = true;
                Intent intent = new Intent(getBaseContext(), Home.class);
                startActivity(intent);
            }
        }
    };
}
