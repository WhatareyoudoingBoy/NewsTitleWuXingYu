package com.bwei.newstitlewuxingyu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwei.newstitlewuxingyu.R;

/**
 * 创建人 武星宇
 * 创建时间 2017/2/17.
 */

public class NewsInfoWeb extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_item);

        WebView newsinfo_wb = (WebView) findViewById(R.id.newsinfo_wb);

        newsinfo_wb.getSettings().setJavaScriptEnabled(true);
        String url = getIntent().getStringExtra("url");

        newsinfo_wb.loadUrl(url);

        newsinfo_wb.setWebViewClient(new WebViewClient() );
    }
}
