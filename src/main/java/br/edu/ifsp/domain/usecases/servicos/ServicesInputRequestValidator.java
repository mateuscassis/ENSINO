package br.edu.ifsp.domain.usecases.servicos;

import br.edu.ifsp.domain.entities.servicos.Services;
import br.edu.ifsp.domain.usecases.utils.Notifications;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class ServicesInputRequestValidator extends Validator<Services> {
    @Override
    public Notifications validate(Services services) {
        Notifications notifications = new Notifications();

        if (services == null){
            notifications.addError("Services is null");
            return notifications;
        }

        if (nullOrEmpty(services.getNome()))
            notifications.addError("Nome is null or empty");

        return notifications;
    }
}
