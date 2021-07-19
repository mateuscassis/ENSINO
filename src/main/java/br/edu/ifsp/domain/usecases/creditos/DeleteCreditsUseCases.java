package br.edu.ifsp.domain.usecases.creditos;

import br.edu.ifsp.domain.entities.creditos.Credits;
import br.edu.ifsp.domain.usecases.utils.EntitieNotFoundException;

public class DeleteCreditsUseCases {
    private CreditsDAO creditsDAO;

    public DeleteCreditsUseCases(CreditsDAO creditsDAO) {
        this.creditsDAO = creditsDAO;
    }

    public boolean remove(Integer id){
        if (id==null || creditsDAO.findOne(id).isEmpty())
            throw new EntitieNotFoundException("Credits not found");
        return creditsDAO.deleteByKey(id);
    }

    public boolean remove(Credits credits){
        if (credits==null || creditsDAO.findOne(credits.getId()).isEmpty())
            throw new EntitieNotFoundException("Services not found");
        return creditsDAO.delete(credits);
    }
}
