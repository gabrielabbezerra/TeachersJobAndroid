package br.com.danielaluciano.teachersjob.events;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import br.com.danielaluciano.teachersjob.dao.UsuarioDAO;
import br.com.danielaluciano.teachersjob.entidade.Usuario;

public class EventUsuarioEntrar implements EventoApplication{

    private final View view;
    private Usuario usuarioLogin;
    private Usuario usuarioBanco;
    private UsuarioDAO usuarioDAO;

    public EventUsuarioEntrar(View view, Usuario usuario){
        this.view = view;
        this.usuarioLogin = usuario;
        this.usuarioBanco = new Usuario();
        this.usuarioBanco.setEmail(usuario.getEmail());
        this.usuarioBanco.setSenha(usuario.getSenha());
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    public void executarEvento() {

        usuarioDAO.getUsuario(usuarioLogin,callBack);

    }

    private void postExecutarEvento() {
        if(usuarioBanco.getSenha().equals(usuarioLogin.getSenha()) && usuarioBanco.getEmail().equals(usuarioLogin.getEmail())){
            Toast.makeText(this.view.getContext(), "Executou o evento de Entrar", Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(this.view.getContext(), "Usuario ou senha incorretos", Toast.LENGTH_SHORT).show();
    }

    private ValueEventListener callBack = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            Usuario u = dataSnapshot.getValue(Usuario.class);
            usuarioLogin.setNome(u.getNome());
            usuarioLogin.setSenha(u.getSenha());
            usuarioLogin.setTelefone(u.getTelefone());
            usuarioLogin.setSenha(u.getSenha());
            usuarioLogin.setEmail(u.getEmail());
            Toast.makeText(view.getContext(), usuarioLogin.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            Log.d("ERRO", databaseError.getMessage());
        }
    };

}
