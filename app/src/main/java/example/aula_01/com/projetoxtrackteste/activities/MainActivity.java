package example.aula_01.com.projetoxtrackteste.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import example.aula_01.com.projetoxtrackteste.R;

public class MainActivity extends AppCompatActivity {

    //configuração do Firebase com a conta da Fátima
    private FirebaseAuth firebaseAuth;

    //variáveis da tela de login
    private Button botaoLogin;
    private ImageView imagemFacebook;
    private ImageView imagemGoogle;
    private EditText emailUsuario;
    private EditText senhaUsuario;
    private TextView campoSenha;
    private TextView campoOu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       firebaseAuth = FirebaseAuth.getInstance();

       //login
        firebaseAuth.signInWithEmailAndPassword("testando", "testado")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.i("signIn","sucesso");
                        } else {
                            Log.i("signIn","erro no cadastro" + task.getException());
                        }
                    }
                });

        //usuario está logado ?
        if(firebaseAuth.getCurrentUser() != null ){
            Log.i("verificar usuario", "usuario esta logado");
        } else {
            Log.i("verifica usuario", "usuario nao esta logado");
        }


        //cadastro
       firebaseAuth.createUserWithEmailAndPassword("teste", "teste").addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {

               if (task.isSuccessful()){
                   Log.i("createUser","sucesso");
               } else {
                   Log.i("create user","erro no cadastro" + task.getException());
               }

           }
       });

        botaoLogin = (Button) findViewById(R.id.botaoLogin);
        imagemFacebook = (ImageView) findViewById(R.id.imagemFacebook);
        imagemGoogle = (ImageView) findViewById(R.id.imagemGoogle);
        emailUsuario = (EditText) findViewById(R.id.emailUsuario);
        senhaUsuario = (EditText) findViewById(R.id.senhaUsuario);
        campoSenha = (TextView) findViewById(R.id.campoSenha);
        campoOu= (TextView) findViewById(R.id.campoOu);


        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, principal.class);
                startActivity(it);
            }
        });
    }
}
