package com.itsci.it411_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    private String userid = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        userid = intent.getStringExtra("username");
    }

    public void  OnEditMemmberClick(View view){
        Intent intent = new Intent(HomeActivity.this,EditMemberActivity.class);
        intent.putExtra("username",userid);
        startActivity(intent);
    }

    public void  OnListEventClick(View view){
        Intent intent = new Intent(HomeActivity.this, EventActivity.class);
        intent.putExtra("username",userid);
        startActivity(intent);
    }

    public void OcClickSearch(View view){
        Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
        intent.putExtra("username",userid);
        intent.putExtra("eventId" , "e1" );
        startActivity(intent);

    }

}