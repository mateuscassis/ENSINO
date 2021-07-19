package br.edu.ifsp.domain.usecases.servicos;

import br.edu.ifsp.domain.entities.servicos.Services;

import java.util.List;
import java.util.Optional;

public class FindServicesUseCases {
    private ServicesDAO servicesDAO;

    public FindServicesUseCases(ServicesDAO servicesDAO) {
        this.servicesDAO = servicesDAO;
    }

    public Optional<Services> findOne(Integer id){
        if (id == null)
            throw new IllegalArgumentException("Id can not be null ");
        return servicesDAO.findOne(id);
    }

    public List<Services> findAll(){
        return servicesDAO.findAll();
    }

}
