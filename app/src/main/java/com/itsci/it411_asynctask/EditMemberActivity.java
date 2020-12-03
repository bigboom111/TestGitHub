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

public class EditMemberActivity extends AppCompatActivity {

    private String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_member);

        Intent intent = getIntent();
        userid = intent.getStringExtra("username");
        this.getMember(userid);
        //this.doEditProfile(userid);
    }

    public void  getMember(String username){

        final WSManager manager = WSManager.getWsManager(this);
        final MemberModel memberModel = new MemberModel();
        memberModel.getMember().setUsername(username);

        manager.getMember(memberModel, new WSManager.WSManagerListener() {
            @Override
            public void onComplete(Object response) {

                MemberModel memberModel = new MemberModel(response.toString());
                //memberModel.getMember().setUsername(username);
                final EditText idCard = findViewById(R.id.txtIdCard);
                final EditText fullname = findViewById(R.id.txtName);
                final EditText birthday = findViewById(R.id.txtDate);
                final EditText age = findViewById(R.id.txtAge);
                final EditText address = findViewById(R.id.txtAddress);
                final EditText facebook = findViewById(R.id.txtFace);
                final EditText line = findViewById(R.id.txtLine);
                final EditText tell = findViewById(R.id.txtPhoneNumber);
                final EditText email = findViewById(R.id.txtEmail);


                idCard.setText(memberModel.getMember().getIdCard());
                fullname.setText(memberModel.getMember().getFullname());
                birthday.setText(memberModel.getMember().getBirthday());
                age.setText(memberModel.getMember().getAge());
                address.setText(memberModel.getMember().getLogin().getAddress());
                facebook.setText(memberModel.getMember().getLogin().getFacebook());
                line.setText(memberModel.getMember().getLogin().getLine());
                tell.setText(memberModel.getMember().getLogin().getTel());
                email.setText(memberModel.getMember().getLogin().getEmail());

                //memberModel.getMember().getPassword();
            }

            @Override
            public void onError(String err) {
                Toast.makeText(EditMemberActivity.this, err, Toast.LENGTH_SHORT).show();
            }
        });

        /*manager.getLogin(memberModel, new WSManager.WSManagerListener() {
            @Override
            public void onComplete(Object response) {

                MemberModel memberModel = new MemberModel(response.toString());
                final EditText address = findViewById(R.id.txtAddress);
                final EditText facebook = findViewById(R.id.txtFace);
                final EditText line = findViewById(R.id.txtLine);
                final EditText tell = findViewById(R.id.txtPhoneNumber);
                final EditText email = findViewById(R.id.txtEmail);
                //final EditText username = findViewById(R.id.txtUser);

                address.setText(memberModel.getMember().getAddress());
                facebook.setText(memberModel.getMember().getFacebook());
                line.setText(memberModel.getMember().getLine());
                tell.setText(memberModel.getMember().getTel());
                email.setText(memberModel.getMember().getEmail());
                //username.setText(memberModel.getMember().getUsername());
            }

            @Override
            public void onError(String err) {
                Toast.makeText(EditMemberActivity.this, err, Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    public void doEditProfile(View view) {
        final EditText idCard = findViewById(R.id.txtIdCard);
        final EditText fullname = findViewById(R.id.txtName);
        final EditText birthday = findViewById(R.id.txtDate);
        final EditText age = findViewById(R.id.txtAge);
        final EditText address = findViewById(R.id.txtAddress);
        final EditText facebook = findViewById(R.id.txtFace);
        final EditText line = findViewById(R.id.txtLine);
        final EditText tell = findViewById(R.id.txtPhoneNumber);
        final EditText email = findViewById(R.id.txtEmail);
        //final EditText username = findViewById(R.id.txtUser);

        idCard.setError(null);
        if (idCard.getText().toString().trim().equals("")) {
            idCard.setError("กรุณากรอก id");
        } else {

            final WSManager manager = WSManager.getWsManager(this);
            final MemberModel memberModel = new MemberModel();

            memberModel.getMember().setIdCard(idCard.getText().toString());
            memberModel.getMember().setFullname(fullname.getText().toString());
            memberModel.getMember().setBirthday(birthday.getText().toString());
            memberModel.getMember().setAge(age.getText().toString());
            memberModel.getMember().setAddress(address.getText().toString());
            memberModel.getMember().setFacebook(facebook.getText().toString());
            memberModel.getMember().setLine(line.getText().toString());
            memberModel.getMember().setTel(tell.getText().toString());
            memberModel.getMember().setEmail(email.getText().toString());
            memberModel.getMember().setProfilePicture(null);
            memberModel.getMember().setPhotoIdCard(null);
            memberModel.getMember().setUsername(userid);


            manager.doEditProfile(memberModel, new WSManager.WSManagerListener() {
                @Override
                public void onComplete(Object response) {
                    Toast.makeText(EditMemberActivity.this, "แก้ไขข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(String err) {
                    Toast.makeText(EditMemberActivity.this, err, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}