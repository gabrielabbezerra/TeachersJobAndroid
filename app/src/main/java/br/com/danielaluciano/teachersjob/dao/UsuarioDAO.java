package br.com.danielaluciano.teachersjob.dao;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import br.com.danielaluciano.teachersjob.entidade.Usuario;

public class UsuarioDAO{

    private DatabaseReference ref;
    private Usuario usuario;

    public UsuarioDAO(){
        ref = FirebaseDatabase.getInstance().getReference("usuario/");
    }

    public void writeUsuario(Usuario usuario){
        ref.child(usuario.getNome()).setValue(usuario);
    }

    public Usuario getUsuario(Usuario usuario, ValueEventListener listener) {

        this.usuario = usuario;
        this.ref.child(usuario.getNome()).addListenerForSingleValueEvent(listener);
        return usuario;
    }

}
