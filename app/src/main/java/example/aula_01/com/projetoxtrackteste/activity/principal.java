package example.aula_01.com.projetoxtrackteste.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import example.aula_01.com.projetoxtrackteste.R;
import example.aula_01.com.projetoxtrackteste.config.ConfiguracaoFirebase;

//activity da tela principal onde se exibem os códigos de rastreio
public class principal extends AppCompatActivity {

    private Button botaoFiltrar;
    private Button botaoSair;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        botaoFiltrar = (Button) findViewById(R.id.botaoFiltrar);
        botaoSair = (Button) findViewById(R.id.botaoSair);

        //botao para sair do app (logout)

        botaoSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
                autenticacao.signOut();

                Intent intent = new Intent(principal.this, MainActivity.class);
                startActivity(intent);

            }
        });

       //botão de filtro do código de rastreio
        botaoFiltrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(principal.this, principal.class);
                startActivity(it);
            }
        });
    }
}
