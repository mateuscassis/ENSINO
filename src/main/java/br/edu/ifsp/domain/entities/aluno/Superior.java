package br.edu.ifsp.domain.entities.aluno;

import br.edu.ifsp.domain.entities.creditos.Credits;

import java.util.ArrayList;
import java.util.List;

public class Superior extends Aluno{
    private List<Credits> credits = new ArrayList<>();
    private static Integer idSuperior = 1;

    public Superior(int id, String nome, long creditos){

    }

    public Superior(String nome) {
        super(nome);
    }

    public Superior(Integer id, String nome, List<Credits> credits) {
        super(id, nome);
        this.credits = credits;
    }


    public void addCredits(Credits creditos) {
        credits.add(creditos);
    }

    public void deleteCredits(Credits creditos){
        credits.remove(creditos);
    }


    public List<Credits> getCredits() {
        return credits;
    }

    public Integer ValorApagar(Superior superior){
        Integer count = 0;
        for (Credits credits : credits){
            count += credits.getValor();
        }
        return  count;
    }



    @Override
    public String toString() {
        return "Superior{" +
                "credits=" + credits +
                "} " + super.toString();
    }
}
