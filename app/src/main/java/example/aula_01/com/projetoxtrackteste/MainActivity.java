package example.aula_01.com.projetoxtrackteste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button botaoLogin = (Button) findViewById(R.id.botaoLogin);
    ImageView imagemFacebook = (ImageView) findViewById(R.id.imagemFacebook);
    ImageView imagemGoogle = (ImageView) findViewById(R.id.imagemGoogle);
    EditText emailUsuario = (EditText) findViewById(R.id.emailUsuario);
    EditText senhaUsuario = (EditText) findViewById(R.id.senhaUsuario);
    TextView campoSenha = (TextView) findViewById(R.id.campoSenha);
    TextView campoOu= (TextView) findViewById(R.id.campoOu);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, principal.class);
                startActivity(it);
            }
        });
    }
}
