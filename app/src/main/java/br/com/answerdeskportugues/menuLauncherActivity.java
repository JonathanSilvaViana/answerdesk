package br.com.answerdeskportugues;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class menuLauncherActivity extends AppCompatActivity {

    String url_office, url_windows, url_skype;
    ImageButton skype, windows, office;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_launcher);

        //define título à activity
        setTitle("Clique em uma opção abaixo:");


        //urls utilizadas abaixo
        url_office = "https://support.microsoft.com/pt-br/contactus/office/tech-services/";

        url_skype = "https://support.microsoft.com/pt-br/contactus/skype/tech-services/";

        url_windows = "https://support.microsoft.com/pt-br/contactus/windows/tech-services/";

        //botões usados abaixo

        skype = (ImageButton)findViewById(R.id.skype);

        windows = (ImageButton) findViewById(R.id.windows2);

        office = (ImageButton) findViewById(R.id.office);

        //função skype
        skype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("skype", "skp");

                finish();
            }
        });

        //função windows
        windows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("windows", "wns");

                finish();
            }
        });

        //função office
        office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("office", "ofc");

                finish();
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK)
            Log.d("back button:", "Botão voltar do aparelho pressionado");

        return false;
        //desabilitou o o botão voltar nativo do aparelho, desta forma evita erros de rotas
    }
}
