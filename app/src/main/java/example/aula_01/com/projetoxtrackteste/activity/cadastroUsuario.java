package example.aula_01.com.projetoxtrackteste.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import example.aula_01.com.projetoxtrackteste.R;
import example.aula_01.com.projetoxtrackteste.config.ConfiguracaoFirebase;
import example.aula_01.com.projetoxtrackteste.models.Usuario;

public class cadastroUsuario extends AppCompatActivity {

    private EditText email;
    private EditText senha;
    private Button botaoCadastrar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;
    private FirebaseDatabase firebaseReferencia;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_cadastro_usuario);

        email = (EditText) findViewById(R.id.emailCadastroUsuario);
        senha = (EditText) findViewById(R.id.senhaCadastroUsuario);
        botaoCadastrar = (Button) findViewById(R.id.botaoCadastrarUsuario);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = new Usuario();
                usuario.setEmail(email.getText().toString());
                usuario.setSenha(senha.getText().toString());
                cadastrarUsuario();

            }
        });
    }

            private void cadastrarUsuario() {
                autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
                autenticacao.createUserWithEmailAndPassword(
                        usuario.getEmail(),
                        usuario.getSenha()
                ).addOnCompleteListener(cadastroUsuario.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser usuarioFirebase = task.getResult().getUser();
                            usuario.setId( usuarioFirebase.getUid() );
                            usuario.salvar();

                            autenticacao.signOut();
                            finish();

                            Toast.makeText(cadastroUsuario.this, "Sucesso ao cadastrar usuário", Toast.LENGTH_LONG).show();
                        } else {

                            String erroExcecao = "";

                            try{
                                throw task.getException();
                            } catch (FirebaseAuthWeakPasswordException e) {
                                erroExcecao = "Digite uma senha mais forte, contendo mais caracteres e com letras e números!";
                            } catch (FirebaseAuthInvalidCredentialsException e) {
                                erroExcecao = "O e-mail digitado é inválido, digite um novo e-mail!";
                            } catch (FirebaseAuthUserCollisionException e) {
                                erroExcecao = "Esse e-mail já está em uso no App!";
                            } catch (Exception e) {
                                erroExcecao = "Ao cadastrar usuário!";
                                e.printStackTrace();
                            }

                            Toast.makeText(cadastroUsuario.this, "Erro ao cadastrar usuário", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }

        }
