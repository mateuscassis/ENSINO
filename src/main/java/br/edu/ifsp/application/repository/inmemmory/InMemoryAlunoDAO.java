package br.edu.ifsp.application.repository.inmemmory;

import br.edu.ifsp.domain.entities.creditos.Credits;
import br.edu.ifsp.domain.entities.aluno.Aluno;
import br.edu.ifsp.domain.entities.aluno.Superior;
import br.edu.ifsp.domain.usecases.aluno.AlunoDAO;

import java.util.*;

public class InMemoryAlunoDAO implements AlunoDAO {
    private static final Map<Integer, Aluno> db = new LinkedHashMap<>();
    private static int idCounter;



    @Override
    public Integer create(Aluno aluno) {
        idCounter++;
        aluno.setId(idCounter);
        db.put(idCounter, aluno);
        return idCounter;
    }

    @Override
    public Optional<Aluno> findOne(Integer key) {
        if (db.containsKey(key))
            return Optional.of(db.get(key));
        return Optional.empty();
    }

    @Override
    public List<Aluno> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Aluno aluno) {
       Integer id = aluno.getId();
       if(db.containsKey(id)){
           db.replace(id, aluno);
           return true;}
        return false;
    }

    @Override
    public boolean deleteByKey(Integer key) {
        if (db.containsKey(key)){
            db.remove(key);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Aluno aluno) {
        return deleteByKey(aluno.getId());
    }

    @Override
    public boolean addCredits(Credits credits , Superior aluno) {
        return false;
    }

    @Override
    public boolean removeCreditsFromAluno(Credits credits, Superior aluno){
        return false;
    }

}
