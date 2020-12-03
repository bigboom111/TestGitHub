package com.itsci.it411_asynctask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itsci.model.EventModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventListAdapter extends BaseAdapter {
    private ArrayList<EventModel> eventModels;
    private LayoutInflater layoutInflater;
    public EventListAdapter(Context aContext, ArrayList<EventModel> eventModels) {
        this.eventModels = eventModels;
        layoutInflater = LayoutInflater.from(aContext);
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
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View currentView = layoutInflater.inflate(R.layout.event_layout , parent, false);
        TextView txtTitle = (TextView) currentView.findViewById(R.id.txt_Title);
        TextView txtDetail  = (TextView) currentView.findViewById(R.id.txt_Detail);


        EventModel eventModel = (EventModel) getItem(position);
        txtTitle.setText(eventModel.getEvent().getTitle());
        txtDetail.setText(eventModel.getEvent().getDetails());


        return currentView;

        /*ViewHolder holder;

        if (v == null) {
            v = layoutInflater.inflate(R.layout.event_layout, null);
            holder = new ViewHolder();
            holder.title = (TextView) v.findViewById(R.id.txt_Event);
            holder.detail = (TextView) v.findViewById(R.id.txt_Detail);

            v.setTag(holder);

        } else {
            holder = (ViewHolder) v.getTag();
        }

        holder.title.setText(eventModels.get(position).getEvent().getTitle());
        holder.detail.setText(eventModels.get(position).getEvent().getDetails());

        return v;*/

    }
    static class ViewHolder {
        TextView title;
        TextView detail;
    }
}
