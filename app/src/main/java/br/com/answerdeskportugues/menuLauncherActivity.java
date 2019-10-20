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
import android.widget.ImageButton;
import android.widget.Toast;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class menuLauncherActivity extends AppCompatActivity {

    String url_office, url_windows, url_skype, endereco;
    ImageButton skype, windows, office;
    Cipher encripta;
    ConnectivityManager conexao;
    NetworkInfo informacao_de_rede;

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

                //define o skype
                if (endereco == null)
                {
                    endereco = url_skype;
                }

                else { Log.d("endereço", "não foi possível converter");}
                //corre();

                ChecaConexao();
            }
        });

        //função windows
        windows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("windows", "wns");

                //define o windows
                endereco = url_windows;
                ChecaConexao();
                //corre();
            }
        });

        //função office
        office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("office", "ofc");

                //define o office
                endereco = url_office;
                ChecaConexao();
                //corre();
            }
        });


    }

    //realiza a transição de activities
    public void corre()
    {
        Intent mudaActivity = new Intent(this, WebViewer.class);
        mudaActivity.putExtra("endereco", endereco);
        startActivity(mudaActivity);

    }

    public void ChecaConexao()
    {

        //variável que permite checar a conectividade em base do contexto da aplicação
        conexao = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        //variável que permite checar a informação de rede
        informacao_de_rede = conexao.getActiveNetworkInfo();

        //usando a variável conexão em um método condicional
        if(informacao_de_rede != null)
        {

            //condicional que permite checar a conexão

            if (informacao_de_rede.getType() == ConnectivityManager.TYPE_WIFI)
            {

                Log.d("wifi", "rede wireless");
                corre();
            }

            else if (informacao_de_rede.getType() == ConnectivityManager.TYPE_MOBILE)
            {
                Log.d("mobile", "rede móvel");
                corre();
            }
            else {

                Toast.makeText(this, "Sem conexão", Toast.LENGTH_SHORT).show();
                Log.d("Rede Offline", "Não está conectado");

            }
        }

        else {

            Toast.makeText(this, "Conexão nula", Toast.LENGTH_SHORT).show();
            Log.d("Rede nula", "Não está conectado, nula");

        }

    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK)
            Log.d("back button:", "Botão voltar do aparelho pressionado");

        return false;
        //desabilitou o o botão voltar nativo do aparelho, desta forma evita erros de rotas
    }
}
