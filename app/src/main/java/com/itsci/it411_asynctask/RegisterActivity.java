package com.itsci.it411_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.itsci.manager.WSManager;
import com.itsci.model.LoginModel;
import com.itsci.model.MemberModel;
import com.itsci.model.UserModel;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText birthday = findViewById(R.id.txtDate);
        birthday.setInputType(InputType.TYPE_NULL);
    }

    public void doRegister(View view){
        final EditText idCard = findViewById(R.id.txtIdCard);
        final EditText fullname = findViewById(R.id.txtName);
        final EditText birthday = findViewById(R.id.txtDate);
        final EditText age = findViewById(R.id.txtAge);
        final EditText address = findViewById(R.id.txtAddress);
        final EditText facebook = findViewById(R.id.txtFace);
        final EditText line = findViewById(R.id.txtLine);
        final EditText tell = findViewById(R.id.txtPhoneNumber);
        final EditText email = findViewById(R.id.txtEmail);
        final EditText username = findViewById(R.id.txtUser);
        final EditText pass = findViewById(R.id.txtPass);

        idCard.setError(null);

        if (idCard.getText().toString().trim().equals("")){
            idCard.setError("กรุณากรอกเลขบัตรประชาชน");
        }else {

            WSManager manager = WSManager.getWsManager(this);

            LoginModel loginModel = new LoginModel();
            //loginModel.getLogin().setUsername(username.getText().toString());

            MemberModel memberModel = new MemberModel();
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
            memberModel.getMember().setUsername(username.getText().toString());
            memberModel.getMember().setPassword(pass.getText().toString());


            manager.doRegister(memberModel, new WSManager.WSManagerListener() {
                @Override
                public void onComplete(Object response) {
                    Toast.makeText(RegisterActivity.this, "ลงทะเบียนสำเร็จ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this , LoginActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onError(String err) {
                    Toast.makeText(RegisterActivity.this, err, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void onTxtDateClick(View view){
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                EditText txtDate = findViewById(R.id.txtDate);
                txtDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        }, mYear, mMonth, mDay);
        dialog.show();
    }
}
