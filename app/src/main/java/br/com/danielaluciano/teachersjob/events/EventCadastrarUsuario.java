package br.com.danielaluciano.teachersjob.events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import br.com.danielaluciano.teachersjob.AreaAtuacaoActivity;
import br.com.danielaluciano.teachersjob.dao.UsuarioDAO;
import br.com.danielaluciano.teachersjob.entidade.Usuario;

public class EventCadastrarUsuario implements EventoApplication {

    private final Usuario usuario;
    private final AppCompatActivity view;
    private UsuarioDAO usuarioDAO;

    public EventCadastrarUsuario(Usuario usuario, AppCompatActivity view){
        this.usuario = usuario;
        this.view = view;
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    public void executarEvento() {
        if(!queriaEstarMorta())
            return;

        usuarioDAO.writeUsuario(usuario);
        this.view.startActivity(new Intent(this.view, AreaAtuacaoActivity.class));
    }

    private boolean queriaEstarMorta() {

        String msg = "";
        boolean valido = true;
        if(!usuario.getSenha().equals(usuario.getConfirmarSenha())){
            msg += "As Senhas NÃO Condizem";
            valido = false;
        }

        if(!valido)
            Toast.makeText(view, msg, Toast.LENGTH_LONG).show();

        return valido;
    }

}
