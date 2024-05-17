package unifacef.edu.primevideo.model.dto;

public class FilmeDTO {
    private Long id;
    private String nome;
    private int ano_lancamento;
    private float nota;

    public FilmeDTO(){

    }

    public FilmeDTO(Long id, String nome, int ano_lancamento, float nota) {
        this.id = id;
        this.nome = nome;
        this.ano_lancamento = ano_lancamento;
        this.nota = nota;
    }

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

    public int getAno_lancamento() {
        return ano_lancamento;
    }

    public void setAno_lancamento(int ano_lancamento) {
        this.ano_lancamento = ano_lancamento;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
