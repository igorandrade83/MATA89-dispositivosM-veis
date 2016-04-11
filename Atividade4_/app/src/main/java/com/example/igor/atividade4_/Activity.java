package com.example.igor.atividade4_;

import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.os.Bundle;

public class Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        String site = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            site = extras.getString("Site");
        }

        WebView myWebView = (WebView) findViewById(R.id.web_view);
        if (myWebView != null) {
            myWebView.loadUrl("http://" + site);
        }
    }
}
