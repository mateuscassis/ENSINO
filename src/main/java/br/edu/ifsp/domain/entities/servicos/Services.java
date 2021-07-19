package br.edu.ifsp.domain.entities.servicos;


public class Services {
    private Integer id;
    private String nome;
    private Integer valor;
    private Integer horas;

    public Services() {
    }

    public Services(String nome, Integer valor, Integer horas) {
        this.nome = nome;
        this.valor = valor;
        this.horas = horas;
    }

    public Services(Integer id, String nome, Integer valor, Integer horas) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.horas = horas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", horas=" + horas +
                '}';
    }
}
