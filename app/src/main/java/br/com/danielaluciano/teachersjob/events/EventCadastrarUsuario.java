package br.com.danielaluciano.teachersjob.events;

import android.view.View;
import android.widget.Toast;

import br.com.danielaluciano.teachersjob.dao.UsuarioDAO;
import br.com.danielaluciano.teachersjob.entidade.Usuario;

public class EventCadastrarUsuario implements EventoApplication {

    private final Usuario usuario;
    private final View view;
    private UsuarioDAO usuarioDAO;

    public EventCadastrarUsuario(Usuario usuario, View view){
        this.usuario = usuario;
        this.view = view;
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    public void executarEvento() {
        usuarioDAO.writeUsuario(usuario);
        Toast.makeText(view.getContext(), "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
    }

}
