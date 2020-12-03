package com.itsci.it411_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.itsci.manager.WSManager;
import com.itsci.model.EventModel;
import com.itsci.model.TimeModel;

public class SearchActivity extends AppCompatActivity {

    private String userid="";
    private String eventId="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent = getIntent();
        userid = intent.getStringExtra("username");
        eventId = intent.getStringExtra("eventId");
        this.getEvent(eventId);

        //this.getTime(eventId);
    }

    public void getEvent(String eventId){
        final WSManager manager = WSManager.getWsManager(this);
        final EventModel eventModel = new EventModel();
        eventModel.getEvent().setEventId(eventId);

        manager.getEvent(eventModel, new WSManager.WSManagerListener() {
            @Override
            public void onComplete(Object response) {
                EventModel eventModel = new EventModel(response.toString());
                final TextView event = findViewById(R.id.txtEventtt);

                event.setText(eventModel.getEvent().getEventId());

            }

            @Override
            public void onError(String err) {

            }
        });

    }

    public void getTime(String eventId){
        final WSManager manager = WSManager.getWsManager(this);
        final TimeModel timeModel = new TimeModel();
        timeModel.getTime().setEventId(eventId);

        manager.getTime(timeModel, new WSManager.WSManagerListener() {
            @Override
            public void onComplete(Object response) {
                TimeModel timeModel = new TimeModel(response.toString());
                TextView event = findViewById(R.id.txtEventtt);
                event.setText(timeModel.getTime().getEvent().getTitle());
            }

            @Override
            public void onError(String err) {

            }
        });
    }
}