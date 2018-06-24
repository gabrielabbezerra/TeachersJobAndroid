package br.com.danielaluciano.teachersjob;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

import br.com.danielaluciano.teachersjob.entidade.Usuario;
import br.com.danielaluciano.teachersjob.events.EventCadastrarUsuario;
import br.com.danielaluciano.teachersjob.events.EventSelecionarFoto;

public class CadastrarLoginActivity extends AppCompatActivity {

    private Button btnSalvar;
    private TextInputEditText txtNome;
    private TextInputEditText txtTelefone;
    private TextInputEditText txtCidade;
    private TextInputEditText txtEmail;
    private TextInputEditText txtSenha;
    private TextInputEditText txtConfirmaSenha;
    private ImageView btnFotoCadastrar;

    private EventCadastrarUsuario eventCadastrarUsuario;
    private EventSelecionarFoto eventSelecionarFoto;
    private Usuario usuario;

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
        this.btnFotoCadastrar = (ImageView) findViewById(R.id.cameraImageViewCadastrar);
        this.eventSelecionarFoto = new EventSelecionarFoto(this);
        this.usuario = new Usuario();
    }

    private void initEvents() {
        btnFotoCadastrar.setOnClickListener(eventBtnSelecionarFoto);
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
        usuario.setCidade(txtCidade.getText().toString());
        usuario.setFoto(getBytesImageView());
    }

    private String getBytesImageView() {
        Bitmap imagem = ((BitmapDrawable)btnFotoCadastrar.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        imagem.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        return Base64.encodeToString(baos.toByteArray(),Base64.DEFAULT);
    }

    private void getImageViewFromBytes(String imageBase64){
        byte[] data = Base64.decode(imageBase64, Base64.DEFAULT);
        btnFotoCadastrar.setImageBitmap(BitmapFactory.decodeByteArray(data,0,data.length));
    }

    View.OnClickListener eventBtnSelecionarFoto = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            eventSelecionarFoto.executarEvento();
        }
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        eventSelecionarFoto.onRequestPermessionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        eventSelecionarFoto.onActivityResult(requestCode,resultCode,data,btnFotoCadastrar);
    }


}
