package adaztecnologia.gigsuite.Entity;

/**
 * Classe criada para representar o Bean de todos os clientes que irão se cadastrar no aplicativo
 */

public class Cliente{
    private Long id;
    private String nome;
    private String apelido;
    private String cpf;
    private String telefone;
    private String email;
    private String descricao;
    private String categoria;
    private int avaliacaoPositiva;
    private int avaliacaoNegativa;
    private boolean termos;
    private Usuario usuario;


    //CONSTRUTOR
    public Cliente(Long id, String nome, String apelido, String cpf, String telefone, String email, String descricao, String categoria, int avaliacaoPositiva, int avaliacaoNegativa, boolean termos, Usuario usuario){
        this.setId(id);
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setAtividade(descricao);
        this.setCategoria(categoria);
        this.setAvaliacaoPositiva(avaliacaoPositiva);
        this.setAvaliacaoNegativa(avaliacaoNegativa);
        this.setApelido(apelido);
        this.setEmail(email);
        this.setTermos(termos);
        this.setCpf(cpf);
        this.setUsuario(usuario);
    }


    //GETTERS E SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescricao() {
        return descricao;
    }

    public void setAtividade(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getAvaliacaoPositiva() {
        return avaliacaoPositiva;
    }

    public void setAvaliacaoPositiva(int avaliacaoPositiva) {
        this.avaliacaoPositiva = avaliacaoPositiva;
    }

    public int getAvaliacaoNegativa() {
        return avaliacaoNegativa;
    }

    public void setAvaliacaoNegativa(int avaliacaoNegativa) {
        this.avaliacaoNegativa = avaliacaoNegativa;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTermos() {
        return termos;
    }

    public void setTermos(boolean termos) {
        this.termos = termos;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
