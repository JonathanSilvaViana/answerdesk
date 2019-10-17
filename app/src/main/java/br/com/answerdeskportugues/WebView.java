package br.com.answerdeskportugues;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;


public class WebView extends AppCompatActivity {

    menuLauncherActivity mLA;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        //define o título da activity
        setTitle("Contatar");

        //instancia da classe anterior
        mLA = new menuLauncherActivity();

        //encontro da webview
        webView = (WebView) findViewById(R.id.webview);

    }


}


