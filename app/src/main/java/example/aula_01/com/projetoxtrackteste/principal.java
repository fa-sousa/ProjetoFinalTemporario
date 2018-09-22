package example.aula_01.com.projetoxtrackteste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//activity da tela principal onde se exibem os códigos de rastreio
public class principal extends AppCompatActivity {

    Button botaoFiltrar = (Button) findViewById(R.id.botaoFiltrar);


    public Button getBotaoFiltrar() {
        return botaoFiltrar;
    }

    public void setBotaoFiltrar(Button botaoFiltrar) {
        this.botaoFiltrar = botaoFiltrar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

       //botão de filtro do código de rastreio
        botaoFiltrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(principal.this, principal.class);
                startActivity(it);
            }
        });
    }
}
