package br.edu.ifsp.domain.entities.creditos;

public class Credits {
    public String nome;
    public Integer id;
    public Integer valor;

    public Credits() {
    }

    public Credits(String nome, Integer valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Credits(String nome, Integer id, Integer valor) {
        this.nome = nome;
        this.id = id;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Creditos{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", valor=" + valor +
                '}';
    }
}
