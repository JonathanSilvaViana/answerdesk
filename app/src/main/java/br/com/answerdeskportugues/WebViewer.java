package br.com.answerdeskportugues;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import org.w3c.dom.Text;
import android.webkit.WebView;


public class WebViewer extends AppCompatActivity{

    menuLauncherActivity mLA;
    Intent obterUrl;
    private WebView webView = null;
    String endereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        //define o título da activity
        setTitle("Contatar");

        WebView S_C;

        //instancia da classe anterior
        mLA = new menuLauncherActivity();

        obterUrl = getIntent();
        endereco = obterUrl.getStringExtra("endereco");

        Log.d("endereço", endereco);

        S_C = (WebView)findViewById(R.id.webview);

        ConnectivityManager CN = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (CN.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED
                || CN.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
        {
            //habilitando javascript
            S_C.getSettings().setJavaScriptEnabled(true);

            S_C.setWebViewClient(new MyWebViewClient(this));

            S_C.loadUrl(endereco);

        }

        else {

            Toast.makeText(this, "Verifique a conexão", Toast.LENGTH_LONG).show();
            Log.d("sem conexão", "não há rede wireless nem móvel");

        }



    }


}


