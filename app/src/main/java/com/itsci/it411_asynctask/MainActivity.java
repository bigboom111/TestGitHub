package com.itsci.it411_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.itsci.manager.WSManager;
import com.itsci.model.EventModel;
import com.itsci.model.UserModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CallBackService {

    private String url_json = "https://newsapi.org/v2/top-headlines?country=th&category=health&apiKey=8c5053e10c4a4d7b85385663d2211eab";
    ArrayList<NewsModel> newsModelArrayList = null;
    private ListView listViewNews;
    private NewsAdapter adapter;
    private String userid = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
            userid = intent.getStringExtra("username");

        listViewNews = findViewById(R.id.listnews);
        new JSONCallServiceAsyncTask(this).execute(url_json);
        newsModelArrayList = new ArrayList<>();
        listViewNews.setAdapter(adapter = new NewsAdapter());
        listViewNews.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ShowNewsDetailActivity.class);
                intent.putExtra("title", newsModelArrayList.get(position).getTitle());
                intent.putExtra("url", newsModelArrayList.get(position).getLink());
                intent.putExtra("pubDate", newsModelArrayList.get(position).getPubDate());
                intent.putExtra("img_url", newsModelArrayList.get(position).getImage_url());
                intent.putExtra("description", newsModelArrayList.get(position).getDescription());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPreCallService() {
        Log.e("PreCallService", "Called");
    }

    @Override
    public void onCallService() {

    }

    @Override
    public void onRequestCompleteListener(ArrayList<NewsModel> newsModelArrayList) {
        Log.e("RequestCompleted", "Called");
        Log.e("RequestCompleted", "Size = " + newsModelArrayList.size());
        if (newsModelArrayList != null && newsModelArrayList.size() > 0) {
            Log.i("Check data", "" + newsModelArrayList.size());
            this.newsModelArrayList = newsModelArrayList;
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void CompleteListener(ArrayList<EventModel> eventModelArrayList) {

    }

    @Override
    public void onRequestFailed(String result) {

    }

    class NewsAdapter extends BaseAdapter {
        public void setDataNotifyData(){
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return newsModelArrayList.size();
        }
        @Override
        public Object getItem(int position) {
            return newsModelArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View currentView = getLayoutInflater().inflate(R.layout.news_layout, parent, false);
            TextView txtTitle = (TextView) currentView.findViewById(R.id.txtTitle);
            TextView txtDate = (TextView) currentView.findViewById(R.id.txtPubDate);
            ImageView imgView = (ImageView) currentView.findViewById(R.id.img_cover);
            NewsModel newsModels = (NewsModel) getItem(position);
            txtTitle.setText(Html.fromHtml(newsModels.getTitle()));
            txtDate.setText(newsModels.getPubDate());
            Picasso.with(MainActivity.this).load(newsModels.getImage_url()).into(imgView);
            return currentView;
        }
    }


    public void  OnEditProfileClick(View view){
        Intent intent = new Intent(MainActivity.this,EditProfileActivity.class);
        intent.putExtra("username",userid);
        startActivity(intent);
    }
    public void  OnDeleteClick(View view){

      /*  WSManager manager = WSManager.getWsManager(this);
        UserModel userModel = new UserModel();
        userModel.getUser().setId(userid);

        manager.doDeleteUser(userModel, new WSManager.WSManagerListener() {
            @Override
            public void onComplete(Object response) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onError(String err) {
                    Toast.makeText(MainActivity.this , "ลบผู้ใช้งานไม่สำเร็จ" , Toast.LENGTH_LONG).show();
            }
        });*/

    }
}
