package com.itsci.it411_asynctask;

import com.itsci.model.EventModel;

import java.util.ArrayList;

public interface CallBackService {
    void onPreCallService();
    void onCallService();
    void onRequestCompleteListener(ArrayList<NewsModel> newsModelArrayList);
    void CompleteListener(ArrayList<EventModel> eventModelArrayList);
    void onRequestFailed(String result);

}
