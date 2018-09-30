package example.aula_01.com.projetoxtrackteste.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import example.aula_01.com.projetoxtrackteste.R;

public class cadastroEncomenda extends AppCompatActivity {

    //botoes e campos da tela de cadastro de encomendas
    // id´s que terminam com T referem-se a TextView e com E é EditText

    private Button botaoCancelar;
    private Button botaoConfirmar;
    private EditText codigoDeRastreioE;
    private EditText nomeDoPacoteE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_encomenda);

        botaoCancelar = (Button) findViewById(R.id.botaoCancelar);
        botaoConfirmar = (Button) findViewById(R.id.botaoConfirmar);
        codigoDeRastreioE = (EditText) findViewById(R.id.codigoDeRastreioE);
        nomeDoPacoteE = (EditText) findViewById(R.id.nomeDoPacoteE);


        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(cadastroEncomenda.this, principal.class);
                startActivity(it);
            }
        });

        botaoConfirmar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(cadastroEncomenda.this, principal.class);
                startActivity(it);
            }
        });



    }
}
