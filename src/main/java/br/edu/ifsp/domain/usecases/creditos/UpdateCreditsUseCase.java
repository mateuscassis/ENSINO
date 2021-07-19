package br.edu.ifsp.domain.usecases.creditos;

import br.edu.ifsp.domain.entities.creditos.Credits;
import br.edu.ifsp.domain.usecases.utils.EntitieNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Notifications;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class UpdateCreditsUseCase {
    private CreditsDAO creditsDAO;

    public UpdateCreditsUseCase(CreditsDAO creditsDAO) {
        this.creditsDAO = creditsDAO;
    }

    public boolean update(Credits credits){
        Validator<Credits> validator = new CreditsInputRequestValidator();
        Notifications notifications = validator.validate(credits);

        if (notifications.hasErrors())
            throw new IllegalArgumentException(notifications.errorMessage());

        Integer id = credits.getId();
        if(creditsDAO.findOne(id).isEmpty())
            throw  new EntitieNotFoundException("Credits not found.");

        return creditsDAO.update(credits);
    }
}
