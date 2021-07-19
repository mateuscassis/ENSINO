package br.edu.ifsp.domain.usecases.creditos;

import br.edu.ifsp.domain.entities.creditos.Credits;
import br.edu.ifsp.domain.usecases.utils.Notifications;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CreateCreditsUseCases {
    private CreditsDAO creditsDAO;

    public CreateCreditsUseCases(CreditsDAO creditsDAO) {
        this.creditsDAO = creditsDAO;
    }

    public Integer insert(Credits credits){
        Validator<Credits> validator = new CreditsInputRequestValidator();
        Notifications notifications = validator.validate(credits);


        if (notifications.hasErrors())
            throw new IllegalArgumentException(notifications.errorMessage());


        return creditsDAO.create(credits);
    }


}
