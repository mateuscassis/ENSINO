package br.edu.ifsp.domain.usecases.aluno;

import br.edu.ifsp.domain.usecases.creditos.FindCreditsUseCases;
import br.edu.ifsp.domain.entities.aluno.Aluno;
import br.edu.ifsp.domain.entities.aluno.Superior;
import br.edu.ifsp.domain.entities.creditos.Credits;
import br.edu.ifsp.domain.usecases.utils.EntitieNotFoundException;

import java.util.Optional;

public class RemoveCreditsForAluno {
    private FindAlunoUseCases findAlunoUseCases;
    private FindCreditsUseCases findCreditsUseCases;
    private AlunoDAO alunoDAO;

    public RemoveCreditsForAluno(FindAlunoUseCases findAlunoUseCases, FindCreditsUseCases findCreditsUseCases, AlunoDAO alunoDAO) {
        this.findAlunoUseCases = findAlunoUseCases;
        this.findCreditsUseCases = findCreditsUseCases;
        this.alunoDAO = alunoDAO;
    }

    public boolean removeCreditsFromAluno(Credits credits, Superior aluno){

        Optional<Aluno> alunosup = findAlunoUseCases.findOne(credits.getId());

        if(alunosup.isEmpty()){
            throw new EntitieNotFoundException("Aluno not found");
        }
        aluno.deleteCredits(credits);
        return alunoDAO.removeCreditsFromAluno(credits, aluno);
    }
}
