package br.com.danielaluciano.teachersjob.entidade;

public class Usuario {

    private long idUsuario;
    private String nome;
    private String telefone;
    private String email;
    private String foto;
    private String senha;

    public Usuario(){
        this.idUsuario = 0;
        this.nome = new String();
        this.telefone = new String();
        this.email = new String();
        this.foto = new String();
    }

    public Usuario(long idUsuario, String nome, String telefone, String email, String foto) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.foto = foto;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", foto='" + foto + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
