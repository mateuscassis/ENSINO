package br.edu.ifsp.application.repository.inmemmory;

import br.edu.ifsp.domain.entities.servicos.Services;
import br.edu.ifsp.domain.usecases.servicos.ServicesDAO;
import java.util.*;

public class InMemoryServicesDAO implements ServicesDAO {
    private static final Map<Integer, Services> db = new LinkedHashMap<>();
    private static int idCounter;

    @Override
    public Integer create(Services services) {
        idCounter++;
        services.setId(idCounter);
        db.put(idCounter, services);
        return idCounter;
    }

    @Override
    public Optional<Services> findOne(Integer key) {
        if (db.containsKey(key))
            return Optional.of(db.get(key));
        return Optional.empty();
    }

    @Override
    public List<Services> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Services services) {
        Integer id = services.getId();
        if (db.containsKey(id)) {
            db.replace(id, services);
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
    public boolean delete(Services services) {
        return deleteByKey(services.getId());
    }
}
