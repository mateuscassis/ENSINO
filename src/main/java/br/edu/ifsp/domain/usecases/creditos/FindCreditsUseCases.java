package br.edu.ifsp.domain.usecases.creditos;

import br.edu.ifsp.domain.entities.creditos.Credits;


import java.util.List;
import java.util.Optional;

public class FindCreditsUseCases {
    private CreditsDAO creditsDAO;

    public FindCreditsUseCases(CreditsDAO creditsDAO) {
        this.creditsDAO = creditsDAO;
    }


    public Optional<Credits> findOne(Integer id){
        if (id == null)
            throw new IllegalArgumentException("Id can not be null ");
        return creditsDAO.findOne(id);
    }

    public List<Credits> findAll(){
        return creditsDAO.findAll();
    }

}