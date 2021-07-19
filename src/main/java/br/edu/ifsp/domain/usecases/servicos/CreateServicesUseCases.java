package br.edu.ifsp.domain.usecases.servicos;

import br.edu.ifsp.domain.usecases.utils.Notifications;
import br.edu.ifsp.domain.usecases.utils.Validator;
import br.edu.ifsp.domain.entities.servicos.Services;

public class CreateServicesUseCases {
    private ServicesDAO servicesDao;

    public CreateServicesUseCases(ServicesDAO servicesDao) {
        this.servicesDao = servicesDao;
    }

    public Integer insert(Services services){
        Validator<Services> validator = new ServicesInputRequestValidator();
        Notifications notifications = validator.validate(services);


        if (notifications.hasErrors())
            throw new IllegalArgumentException(notifications.errorMessage());


        return servicesDao.create(services);
    }


}
