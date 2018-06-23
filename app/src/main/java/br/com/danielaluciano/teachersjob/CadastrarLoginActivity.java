package br.com.danielaluciano.teachersjob;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.danielaluciano.teachersjob.entidade.Usuario;
import br.com.danielaluciano.teachersjob.events.EventCadastrarUsuario;

public class CadastrarLoginActivity extends AppCompatActivity {

    Button btnSalvar;
    TextInputEditText txtNome;
    TextInputEditText txtTelefone;
    TextInputEditText txtCidade;
    TextInputEditText txtEmail;
    TextInputEditText txtSenha;
    TextInputEditText txtConfirmaSenha;

    EventCadastrarUsuario eventCadastrarUsuario;

    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_usuario_page);
        initVariables();
        initEvents();
    }

    private void initVariables() {

        this.btnSalvar = (Button) findViewById(R.id.confirmarButtonCadastrar);
        this.txtNome = (TextInputEditText) findViewById(R.id.nomeTextInputEditTextCadastrar);
        this.txtTelefone = (TextInputEditText) findViewById(R.id.telefoneTextInputEditTextCadastrar);
        this.txtCidade = (TextInputEditText) findViewById(R.id.cidadeTextInputEditTextCadastrar);
        this.txtEmail = (TextInputEditText) findViewById(R.id.emailTextInputEditTextCadastrar);
        this.txtSenha = (TextInputEditText) findViewById(R.id.senhaTextInputEditTextCadastrar);
        this.txtConfirmaSenha = (TextInputEditText) findViewById(R.id.confirmarSenhaTextInputEditTextCadastrar);
        this.usuario = new Usuario();
    }

    private void initEvents() {
        this.btnSalvar.setOnClickListener(eventCadastrar);
    }


    View.OnClickListener eventCadastrar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            preencherObjeto(usuario);

            eventCadastrarUsuario = new EventCadastrarUsuario(usuario,CadastrarLoginActivity.this);

            eventCadastrarUsuario.executarEvento();
        }

    };

    private void preencherObjeto(Usuario usuario) {
        usuario.setEmail(txtEmail.getText().toString());
        usuario.setNome(txtNome.getText().toString());
        usuario.setSenha(txtSenha.getText().toString());
        usuario.setTelefone(txtTelefone.getText().toString());
        usuario.setConfirmarSenha(txtConfirmaSenha.getText().toString());
    }

}
