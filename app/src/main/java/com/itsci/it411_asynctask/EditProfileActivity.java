package com.itsci.it411_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.itsci.manager.WSManager;
import com.itsci.model.MemberModel;
import com.itsci.model.UserModel;

public class EditProfileActivity extends AppCompatActivity {

    private String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Intent intent = getIntent();
        userid = intent.getStringExtra("username");
        this.getMember(userid);
    }

    public void  getMember(String username){

        WSManager manager = WSManager.getWsManager(this);
        MemberModel memberModel = new MemberModel();
        memberModel.getMember().setUsername(username);


        manager.getMember(memberModel, new WSManager.WSManagerListener() {
            @Override
            public void onComplete(Object response) {

                UserModel  userModel = new UserModel(response.toString());
                EditText id = findViewById(R.id.id);
                EditText firstname = findViewById(R.id.firstName);
                EditText lastname = findViewById(R.id.lastName);
                EditText email = findViewById(R.id.email);

                id.setText(userModel.getUser().getId());
                firstname.setText(userModel.getUser().getFirstName());
                lastname.setText(userModel.getUser().getLastName());
                email.setText(userModel.getUser().getEmail());
            }

            @Override
            public void onError(String err) {
                Toast.makeText(EditProfileActivity.this, err, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void doEditProfile(View view) {

        EditText id = findViewById(R.id.id);
        EditText firstname = findViewById(R.id.firstName);
        EditText lastname = findViewById(R.id.lastName);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);

        id.setError(null);

        if (id.getText().toString().trim().equals("")) {
            id.setError("กรุณากรอก id");
        } else {

            WSManager manager = WSManager.getWsManager(this);
            UserModel userModel = new UserModel();
            userModel.getUser().setId(id.getText().toString());
            userModel.getUser().setFirstName(firstname.getText().toString());
            userModel.getUser().setLastName(lastname.getText().toString());
            userModel.getUser().setEmail(email.getText().toString());
            userModel.getUser().setPassword(password.getText().toString());

            manager.doEditProfile(userModel, new WSManager.WSManagerListener() {
                @Override
                public void onComplete(Object response) {
                    Toast.makeText(EditProfileActivity.this, "แก้ไขข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(String err) {
                    Toast.makeText(EditProfileActivity.this, err, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
