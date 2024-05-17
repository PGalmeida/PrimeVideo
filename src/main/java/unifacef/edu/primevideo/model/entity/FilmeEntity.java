package unifacef.edu.primevideo.model.entity;

import jakarta.persistence.*;

@Entity//entidade de banco de dados
@Table(name = "Filme")// tabela filme do banco de dados
public class FilmeEntity {
    @Id// chave primaria
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "ano_lancamento")
    private int ano_lancamento;
    @Column(name = "nota")
    private float nota;

    public FilmeEntity() {
    }

    public FilmeEntity(Long id, String nome, int ano_lancamento, float nota) {
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
