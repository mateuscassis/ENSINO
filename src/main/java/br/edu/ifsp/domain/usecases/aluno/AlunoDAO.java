package br.edu.ifsp.domain.usecases.aluno;

import br.edu.ifsp.domain.entities.aluno.Aluno;
import br.edu.ifsp.domain.entities.aluno.Superior;
import br.edu.ifsp.domain.entities.creditos.Credits;
import br.edu.ifsp.domain.usecases.utils.DAO;


public interface AlunoDAO extends DAO<Aluno, Integer> {
    boolean addCredits(Credits credits, Superior aluno );
    boolean removeCreditsFromAluno(Credits credits,Superior superior);
}

