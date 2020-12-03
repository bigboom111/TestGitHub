package com.itsci.it411_asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class JSONCallServiceAsyncTask extends AsyncTask {

    private CallBackService callBackService;

    public JSONCallServiceAsyncTask(Context context) {
        callBackService = (CallBackService) context;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            Log.i(TAG,"Call Service");
            if(callBackService!=null){
                callBackService.onCallService();
            }
            return downloadContent(objects[0].toString());
        } catch (IOException e) {
            return  "Unable to retrieve data. URL may be invalid";
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (callBackService != null) {
            callBackService.onPreCallService();
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        if (callBackService != null) {
            ArrayList<NewsModel> newsList = onParserContentToModel(o.toString());
            callBackService.onRequestCompleteListener(newsList);
        }
    }

    private String downloadContent(String myUrl) throws IOException {
        InputStream is = null;
        try {
            URL url = new URL(myUrl);
            Log.e("url", myUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            int response = conn.getResponseCode();
            Log.d(TAG, "The response is : " + response);
            Log.e("response", "" + response);
            is = conn.getInputStream();
            Log.e("is", is.toString());
            String result = convertInputStreamToString(is);
            return result;
        }catch(Exception e) {
            Log.e("error exp", e.getMessage());
            return "error";
        }finally {
            if (is != null) {
                is.close();
            }
        }
    }

    private String convertInputStreamToString(InputStream is) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine())!=null){
            sb.append(line + "\n");
        }
        br.close();
        return sb.toString();
    }

    public ArrayList<NewsModel> onParserContentToModel(String dataJSon) {
        Log.e("data json", dataJSon);
        ArrayList<NewsModel> newsList = new ArrayList<NewsModel>();
        try {
            JSONObject jsonObject = new JSONObject(dataJSon);
            JSONArray jsonArray = jsonObject.optJSONArray("articles");
            if (jsonArray != null) {
                for (int i = 0; i<jsonArray.length(); i++) {
                    NewsModel newsModel = new NewsModel();
                    JSONObject json = jsonArray.optJSONObject(i);
                    newsModel.setTitle(json.getString("title"));
                    newsModel.setDescription(json.getString("description"));
                    newsModel.setLink(json.getString("url"));
                    newsModel.setPubDate(json.getString("publishedAt"));
                    newsModel.setImage_url(json.getString("urlToImage"));
                    newsList.add(newsModel);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return newsList;
    }

}
