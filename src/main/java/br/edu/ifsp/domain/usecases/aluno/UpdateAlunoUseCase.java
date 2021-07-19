package br.edu.ifsp.domain.usecases.aluno;

import br.edu.ifsp.domain.entities.aluno.Aluno;
import br.edu.ifsp.domain.entities.creditos.Credits;
import br.edu.ifsp.domain.usecases.utils.EntitieNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Notifications;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class UpdateAlunoUseCase {
    private AlunoDAO alunoDAO;

    public UpdateAlunoUseCase(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public boolean update(Aluno aluno, Credits credits){
        Validator<Aluno> validator = new AlunoInputRequestValidator();
        Notifications notifications = validator.validate(aluno);

        if (notifications.hasErrors())
            throw new IllegalArgumentException(notifications.errorMessage());

        Integer id = aluno.getId();
        if(alunoDAO.findOne(id).isEmpty())
            throw  new EntitieNotFoundException("Aluno not found.");

        return alunoDAO.update(aluno);
    }
}
