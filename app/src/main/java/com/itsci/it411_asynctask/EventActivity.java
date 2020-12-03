package com.itsci.it411_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.itsci.manager.WSManager;
import com.itsci.model.EventModel;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class EventActivity extends AppCompatActivity  {
    private String userid="";
    private NewsAdapter adapter;
    ArrayList<EventModel> eventModelArrayList = null;
    private ListView listEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Intent intent = getIntent();
        userid = intent.getStringExtra("username");

        /*ArrayList eventList = getListData();
        final ListView lv = (ListView) findViewById(R.id.listEvent);
        lv.setAdapter(new NewsAdapter(EventActivity.this, eventList));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*/

        ArrayList eventList = getListData();
        listEvent = findViewById(R.id.listEvent);
        eventModelArrayList = new ArrayList<>();
        listEvent.setAdapter(adapter = new NewsAdapter(EventActivity.this, eventList));

    }

    private ArrayList getListData() {
        final ArrayList<EventModel> results = new ArrayList<EventModel>();
        final WSManager manager = WSManager.getWsManager(this);
        final EventModel eventModel = new EventModel();
        manager.getListEvent(eventModel, new WSManager.WSManagerListener() {
            @Override
            public void onComplete(Object response) {
                JSONArray jsonArray = null;
                try {
                    jsonArray = new JSONArray(response.toString());
                    Toast.makeText(EventActivity.this, jsonArray.length()+"", Toast.LENGTH_SHORT).show();
                    if (jsonArray != null){
                        for (int i = 0 ; i < jsonArray.length(); i++){
                            EventModel eventModel = new EventModel();
                            JSONObject json = jsonArray.optJSONObject(i);
                            eventModel.getEvent().setEventId(json.getString("eventId"));
                            eventModel.getEvent().setTitle(json.getString("title"));
                            eventModel.getEvent().setEventType(json.getString("eventType"));
                            eventModel.getEvent().setGender(json.getString("gender"));
                            eventModel.getEvent().setSpanofAge(json.getString("spanofAge"));
                            eventModel.getEvent().setDetails(json.getString("details"));
                            eventModel.getEvent().setStartDateEvent(json.getString("startDateEvent"));
                            eventModel.getEvent().setEndDateEvent(json.getString("EndDateEvent"));
                            eventModel.getEvent().setRedioIncome(json.getString("redioIncome"));
                            eventModel.getEvent().setLocationName(json.getString("locationName"));
                            eventModel.getEvent().setLocationURL(json.getString("locationURL"));
                            eventModel.getEvent().setLatitude(json.getString("latitude"));
                            eventModel.getEvent().setLongitude(json.getString("longitude"));
                            eventModel.getEvent().setImgEventPR(json.getString("imgEventPR"));
                            eventModel.getEvent().setApplicationClosed(json.getString("ApplicationClosed"));
                            eventModel.getEvent().getCompany().setCompanyId(json.getString("companyId"));
                            results.add(eventModel);
                        }
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onError(String err) {
                Toast.makeText(EventActivity.this, "err", Toast.LENGTH_SHORT).show();
            }
        });

        return results;
    }

    class NewsAdapter extends BaseAdapter{
        private ArrayList<EventModel> eventModels;
        private LayoutInflater layoutInflater;
        public NewsAdapter(Context aContext, ArrayList<EventModel> eventModels) {
            this.eventModels = eventModels;
            layoutInflater = LayoutInflater.from(aContext);
        }
        public void setDataNotifyData(){
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return eventModels.size();
        }

        @Override
        public Object getItem(int position) {
            return eventModels.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View currentView = layoutInflater.inflate(R.layout.event_layout , parent, false);
            TextView txtTitle = (TextView) currentView.findViewById(R.id.txt_Title);
            TextView txtDetail  = (TextView) currentView.findViewById(R.id.txt_Detail);

            EventModel eventModel = (EventModel) getItem(position);
            txtTitle.setText(eventModel.getEvent().getTitle());
            txtDetail.setText(eventModel.getEvent().getDetails());

            return currentView;
        }
    }

}