package br.edu.ifsp.domain.usecases.aluno;

import br.edu.ifsp.domain.entities.aluno.Superior;
import br.edu.ifsp.domain.entities.creditos.Credits;
import br.edu.ifsp.domain.usecases.creditos.FindCreditsUseCases;
import br.edu.ifsp.domain.usecases.utils.EntitieNotFoundException;
;

public class AddCreditosInAluno {
    private AlunoDAO superiorDAO;
    private FindAlunoUseCases findAlunoUseCases;
    private FindCreditsUseCases findCreditsUseCases;


    public AddCreditosInAluno(AlunoDAO alunoDAO, FindAlunoUseCases findAlunoUseCases, FindCreditsUseCases findCreditsUseCases) {
        this.superiorDAO = alunoDAO;
        this.findAlunoUseCases = findAlunoUseCases;
        this.findCreditsUseCases = findCreditsUseCases;
    }

    public boolean addCreditsToAluno(Credits credits, Superior superior) {
        if (findAlunoUseCases.findOne(superior.getId()).isEmpty()) {
            throw new EntitieNotFoundException("Superior not found");
        }

        superior.addCredits(credits);
        return superiorDAO.addCredits(credits, superior);
    }
    }


