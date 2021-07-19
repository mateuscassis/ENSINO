package br.edu.ifsp.domain.usecases.aluno;

import br.edu.ifsp.domain.entities.aluno.Aluno;
import br.edu.ifsp.domain.usecases.utils.Notifications;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class AlunoInputRequestValidator extends Validator<Aluno>{

    public Notifications validate(Aluno aluno) {
        Notifications notifications = new Notifications();

        if (aluno == null){
            notifications.addError("Aluno is null");
            return notifications;
        }

        if (nullOrEmpty(aluno.getNome()))
            notifications.addError("Nome is null or empty");

        return notifications;
    }

}
