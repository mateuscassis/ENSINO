package br.edu.ifsp.domain.usecases.creditos;

import br.edu.ifsp.domain.entities.creditos.Credits;
import br.edu.ifsp.domain.usecases.utils.Notifications;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CreditsInputRequestValidator extends Validator<Credits> {

    public Notifications validate(Credits credits) {
        Notifications notifications = new Notifications();

        if (credits == null){
            notifications.addError("Credits is null");
            return notifications;
        }

        if (nullOrEmpty(credits.getNome()))
            notifications.addError("Nome is null or empty");

        return notifications;
    }

}
