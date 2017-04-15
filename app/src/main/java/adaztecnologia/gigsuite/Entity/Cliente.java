package adaztecnologia.gigsuite.Entity;

/**
 * Classe criada para representar o Bean de todos os clientes que irão se cadastrar no aplicativo
 */

public class Cliente{
    private Long id;
    private String nome;
    private String telefone;
    private String descricao;
    private String categoria;
    private int avaliacaoPositiva;
    private int avaliacaoNegativa;


    //CONSTRUTOR
    public Cliente(Long id, String nome, String telefone, String descricao, String categoria, int avaliacaoPositiva, int avaliacaoNegativa){
        this.setId(id);
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setAtividade(descricao);
        this.setCategoria(categoria);
        this.setAvaliacaoPositiva(avaliacaoPositiva);
        this.setAvaliacaoNegativa(avaliacaoNegativa);
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
}
