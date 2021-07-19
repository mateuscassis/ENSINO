package br.edu.ifsp.domain.entities.aluno;

public class Basic extends Aluno {
    private float mensalidade;
    private static Integer idBasic = 2;

    public Basic(String nome, float mensalidade) {
        super(nome);
        this.mensalidade = mensalidade;
    }


    public float getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
    }

    @Override
    public String toString() {
        return "Basic{" + "Id=" + getId() + " Nome= " + getNome() +
                " mensalidade=" + mensalidade +
                "} " + super.toString();
    }
}
