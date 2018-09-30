package example.aula_01.com.projetoxtrackteste.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import example.aula_01.com.projetoxtrackteste.R;
import example.aula_01.com.projetoxtrackteste.config.ConfiguracaoFirebase;
import example.aula_01.com.projetoxtrackteste.models.Usuario;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText senha;
    private Button botaoLogin;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verificarUsuarioLogado();

        email = (EditText) findViewById(R.id.emailUsuario);
        senha = (EditText) findViewById(R.id.senhaUsuario);
        botaoLogin = (Button) findViewById(R.id.botaoLogin);

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuario = new Usuario();
                usuario.setEmail(email.getText().toString());
                usuario.setSenha(senha.getText().toString());
                validarLogin();

            }
        });

    }

    private void verificarUsuarioLogado(){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        if (autenticacao.getCurrentUser() != null){
            abrirTelaPrincipal();

        }
    }


    private void validarLogin(){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Sucesso ao fazer Login", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Erro ao fazer Login", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void abrirTelaPrincipal(){
        Intent intent = new Intent(MainActivity.this,principal.class);
        startActivity(intent);
        finish();
    }


    public void abrirCadastroUsuario (View view){
        Intent intent = new Intent(MainActivity.this,cadastroUsuario.class);
        startActivity(intent);
    }
}
