package example.aula_01.com.projetoxtrackteste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class activity_cadastro extends AppCompatActivity {

    //botoes e campos da tela de cadastro de encomendas com os getters and setters
    // no final do código a ação dos botões
    Button botaoCancelar = (Button) findViewById(R.id.botaoCancelar);
    Button botaoConfirmar = (Button) findViewById(R.id.botaoConfirmar);
    EditText getCodigoDeRastreioE = (EditText) findViewById(R.id.codigoDeRastreioE);
    TextView codigoDeRastreioT = (TextView) findViewById(R.id.codigoDeRastreioT);
    EditText nomeDoPacoteE = (EditText) findViewById(R.id.nomeDoPacoteE);
    TextView nomeDoPacoteT = (TextView) findViewById(R.id.nomeDoPacoteT);

    public activity_cadastro(EditText getCodigoDeRastreioE, TextView codigoDeRastreioT, EditText nomeDoPacoteE, TextView nomeDoPacoteT) {
        this.getCodigoDeRastreioE = getCodigoDeRastreioE;
        this.codigoDeRastreioT = codigoDeRastreioT;
        this.nomeDoPacoteE = nomeDoPacoteE;
        this.nomeDoPacoteT = nomeDoPacoteT;
    }

    public TextView getCodigoDeRastreioT() {
        return codigoDeRastreioT;
    }

    public void setCodigoDeRastreioT(TextView codigoDeRastreioT) {
        this.codigoDeRastreioT = codigoDeRastreioT;
    }

    public TextView getNomeDoPacoteT() {
        return nomeDoPacoteT;
    }

    public void setNomeDoPacoteT(TextView nomeDoPacoteT) {
        this.nomeDoPacoteT = nomeDoPacoteT;
    }


    public EditText getNomeDoPacoteE() {
        return nomeDoPacoteE;
    }

    public void setNomeDoPacoteE(EditText nomeDoPacoteE) {
        this.nomeDoPacoteE = nomeDoPacoteE;
    }


    public EditText getGetCodigoDeRastreioE() {
        return getCodigoDeRastreioE;
    }

    public void setGetCodigoDeRastreioE(EditText getCodigoDeRastreioE) {
        this.getCodigoDeRastreioE = getCodigoDeRastreioE;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

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
