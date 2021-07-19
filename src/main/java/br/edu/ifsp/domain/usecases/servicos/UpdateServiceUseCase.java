package br.edu.ifsp.domain.usecases.servicos;

import br.edu.ifsp.domain.entities.servicos.Services;
import br.edu.ifsp.domain.usecases.utils.EntitieNotFoundException;
import br.edu.ifsp.domain.usecases.utils.Notifications;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class UpdateServiceUseCase {
    private ServicesDAO servicesDao;

    public UpdateServiceUseCase(ServicesDAO servicesDao) {
        this.servicesDao = servicesDao;
    }

    public boolean update(Services services){
        Validator<Services> validator = new ServicesInputRequestValidator();
        Notifications notifications = validator.validate(services);


        if (notifications.hasErrors())
            throw new IllegalArgumentException(notifications.errorMessage());

        Integer id = services.getId();
        if(servicesDao.findOne(id).isEmpty())
            throw  new EntitieNotFoundException("Services not found.");

        return servicesDao.update(services);
    }
}
