package br.com.answerdeskportugues;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    private Activity activity = null;

    public MyWebViewClient(Activity activity)
    {
        this.activity = activity;
    }
/*
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        //return false;
        if(url.indexOf("google.com.br") > -1 ) return false;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        //activity.startActivity(intent);
        return true;
    }*/
}
