package adaztecnologia.gigsuite.Entity;

/**
 * Classe criada para representar o Bean de Login do aplicativo
 */

public class Usuario {

    private Long id;
    private String usuario;
    private String senha;

    //CONSTRUTOR
    public Usuario(Long id, String usuario, String senha){
        this.setId(id);
        this.setUsuario(usuario);
        this.setSenha(senha);
    }

    //GETTERS E SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
