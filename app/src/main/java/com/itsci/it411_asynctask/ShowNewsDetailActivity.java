package com.itsci.it411_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ShowNewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_news_detail);

        Intent intent = getIntent();
        String img_url = intent.getStringExtra("img_url");
        String title = intent.getStringExtra("title");
        String url = intent.getStringExtra("url");

        ImageView img = findViewById(R.id.img_url);
        Picasso.with(ShowNewsDetailActivity.this).load(img_url).into(img);

        TextView txttitle = findViewById(R.id.txtTitle);
        txttitle.setText(title);

        WebView webview = findViewById(R.id.webview);
        webview.loadUrl(url);

    }
}
