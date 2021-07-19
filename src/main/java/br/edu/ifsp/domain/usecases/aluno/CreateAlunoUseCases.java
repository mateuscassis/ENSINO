package br.edu.ifsp.domain.usecases.aluno;

import br.edu.ifsp.domain.entities.aluno.Aluno;
import br.edu.ifsp.domain.usecases.utils.Notifications;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CreateAlunoUseCases {
    private AlunoDAO alunoDAO;

    public CreateAlunoUseCases(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public Integer insert(Aluno aluno){
        Validator<Aluno> validator = new AlunoInputRequestValidator();
        Notifications notifications = validator.validate(aluno);


        if (notifications.hasErrors())
            throw new IllegalArgumentException(notifications.errorMessage());


        return alunoDAO.create(aluno);
    }


}
