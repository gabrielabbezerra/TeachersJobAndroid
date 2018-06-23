package br.com.danielaluciano.teachersjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.danielaluciano.teachersjob.entidade.Usuario;
import br.com.danielaluciano.teachersjob.events.EventUsuarioEntrar;

public class LoginActivity extends AppCompatActivity {

    private Button btnEntrar;
    private Usuario usuario;

    private TextInputEditText txtEmail;
    private TextInputEditText txtSenha;

    private EventUsuarioEntrar entrar;

    private TextView btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        initVariables();
        initEvents();
    }

    private void initEvents() {
        btnEntrar.setOnClickListener(btnEntrarEvent);
        btnCadastrar.setOnClickListener(btnCadastrarEvent);
    }

    private void initVariables() {
        this.btnEntrar = (Button)findViewById(R.id.btnEntrar);
        this.txtEmail = (TextInputEditText) findViewById(R.id.emailTextInputEditText);
        this.txtSenha = (TextInputEditText) findViewById(R.id.senhaTextInputEditText);
        this.btnCadastrar = (TextView) findViewById(R.id.cadastreSeTextView);
        this.usuario = new Usuario();
        this.entrar = new EventUsuarioEntrar(this,usuario);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    View.OnClickListener btnEntrarEvent = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            usuario.setEmail(txtEmail.getText().toString());
            usuario.setSenha(txtSenha.getText().toString());

            entrar.executarEvento();

        }
    };

    View.OnClickListener btnCadastrarEvent = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(LoginActivity.this, TermosCondicoesActivity.class));
        }
    };

}
