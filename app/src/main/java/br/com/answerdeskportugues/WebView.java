package br.com.answerdeskportugues;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;


public class WebView extends AppCompatActivity {

    menuLauncherActivity mLA;
    Intent obterUrl;
    //WebView webView;
    String endereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        //define o título da activity
        setTitle("Contatar");

        //instancia da classe anterior
        mLA = new menuLauncherActivity();

        obterUrl = getIntent();
        endereco = obterUrl.getStringExtra("endereco");

        Log.d("endereço", endereco);

        //encontro da webview
//        webView = (WebView) findViewById(R.id.webview);



    }


}


