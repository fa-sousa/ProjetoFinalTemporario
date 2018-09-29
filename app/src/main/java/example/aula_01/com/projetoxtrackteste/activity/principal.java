package example.aula_01.com.projetoxtrackteste.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import example.aula_01.com.projetoxtrackteste.R;

//activity da tela principal onde se exibem os códigos de rastreio
public class principal extends AppCompatActivity {

    private Button botaoFiltrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        botaoFiltrar = (Button) findViewById(R.id.botaoFiltrar);

       //botão de filtro do código de rastreio
        botaoFiltrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(principal.this, principal.class);
                startActivity(it);
            }
        });
    }
}
