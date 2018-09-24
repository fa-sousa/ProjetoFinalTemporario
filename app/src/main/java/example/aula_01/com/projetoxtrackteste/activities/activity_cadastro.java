package example.aula_01.com.projetoxtrackteste.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import example.aula_01.com.projetoxtrackteste.R;

public class activity_cadastro extends AppCompatActivity {

    //botoes e campos da tela de cadastro de encomendas
    // id´s que terminam com T referem-se a TextView e com E é EditText

    private Button botaoCancelar;
    private Button botaoConfirmar;
    private EditText codigoDeRastreioE;
    private TextView codigoDeRastreioT;
    private EditText nomeDoPacoteE;
    private TextView nomeDoPacoteT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        botaoCancelar = (Button) findViewById(R.id.botaoCancelar);
        botaoConfirmar = (Button) findViewById(R.id.botaoConfirmar);
        codigoDeRastreioE = (EditText) findViewById(R.id.codigoDeRastreioE);
        codigoDeRastreioT = (TextView) findViewById(R.id.codigoDeRastreioT);
        nomeDoPacoteE = (EditText) findViewById(R.id.nomeDoPacoteE);
        nomeDoPacoteT = (TextView) findViewById(R.id.nomeDoPacoteT);


        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(activity_cadastro.this, principal.class);
                startActivity(it);
            }
        });

        botaoConfirmar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(activity_cadastro.this, principal.class);
                startActivity(it);
            }
        });



    }
}
