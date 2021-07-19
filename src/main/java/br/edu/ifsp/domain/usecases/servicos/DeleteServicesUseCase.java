package br.edu.ifsp.domain.usecases.servicos;

import br.edu.ifsp.domain.entities.servicos.Services;
import br.edu.ifsp.domain.usecases.utils.EntitieNotFoundException;

public class DeleteServicesUseCase {
    private ServicesDAO servicesDAO;

    public DeleteServicesUseCase(ServicesDAO servicesDAO) {
        this.servicesDAO = servicesDAO;
    }

    public boolean remove(Integer id){
        if (id==null || servicesDAO.findOne(id).isEmpty())
            throw new EntitieNotFoundException("Services not found");
        return servicesDAO.deleteByKey(id);
    }

    public boolean remove(Services services){
        if (services==null || servicesDAO.findOne(services.getId()).isEmpty())
            throw new EntitieNotFoundException("Services not found");
        return servicesDAO.delete(services);
    }
}
