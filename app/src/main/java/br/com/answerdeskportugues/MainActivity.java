package br.com.answerdeskportugues;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    Intent menuLancher;
    private static int SPLASH_TIME_OUT = 2665;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //desabilita actionbar
        getSupportActionBar().hide();

        //cria a transição da splash screen
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          mudaActivity();
                                          finish();
                                      }
                                  },
                //encerra o tempo de exibição
                SPLASH_TIME_OUT);

    }


    //menu que inicia a activity de menu
    public void mudaActivity()
    {

        menuLancher = new Intent(this, menuLauncherActivity.class);
        startActivity(menuLancher);

    }
}
