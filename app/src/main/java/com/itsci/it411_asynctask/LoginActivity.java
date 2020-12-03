package com.itsci.it411_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.itsci.manager.WSManager;
import com.itsci.model.LoginModel;
import com.itsci.model.MemberModel;
import com.itsci.model.UserModel;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void doLogin(View view) {

        final EditText username = findViewById(R.id.chk_user);
        final EditText pass = findViewById(R.id.chk_pass);

        username.setError(null);

        if (username.getText().toString().trim().equals("")) {
            username.setError("กรุณากรอก username");
        } else {

            WSManager manager = WSManager.getWsManager(this);
            final LoginModel loginModel = new LoginModel();
            loginModel.getLogin().setAddress("");
            loginModel.getLogin().setFacebook("");
            loginModel.getLogin().setLine("");
            loginModel.getLogin().setTel("");
            loginModel.getLogin().setEmail("");
            loginModel.getLogin().setUsername(username.getText().toString());
            loginModel.getLogin().setPasswords(pass.getText().toString());

            manager.doLogins(loginModel, new WSManager.WSManagerListener() {
                @Override
                public void onComplete(Object response) {
                    String result = response.toString();
                    if("1".equals(result)){

                        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                        intent.putExtra("username",loginModel.getLogin().getUsername());
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid username & password", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onError(String err) {

                }
            });
        }
    }
    public void  OnRegisterClick(View view){
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
