package br.edu.ifsp.application.repository.inmemmory;


import br.edu.ifsp.domain.entities.creditos.Credits;
import br.edu.ifsp.domain.usecases.creditos.CreditsDAO;

import java.util.*;

public class InMemoryCreditsDAO implements CreditsDAO {
    private static final Map<Integer, Credits> db = new LinkedHashMap<>();
    private static int idCounter;

    @Override
    public Integer create(Credits credits) {
        idCounter++;
        credits.setId(idCounter);
        db.put(idCounter, credits);
        return idCounter;
    }

    @Override
    public Optional<Credits> findOne(Integer key) {
        if (db.containsKey(key))
            return Optional.of(db.get(key));
        return Optional.empty();
    }

    @Override
    public List<Credits> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Credits credits) {
        Integer id = credits.getId();
        if (db.containsKey(id)) {
            db.replace(id, credits);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer key) {
        if (db.containsKey(key)) {
            db.remove(key);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Credits credits) {
        return deleteByKey(credits.getId());
    }
}
