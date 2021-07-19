package br.edu.ifsp.domain.usecases.aluno;

import br.edu.ifsp.domain.entities.aluno.Aluno;

import java.util.List;
import java.util.Optional;

public class FindAlunoUseCases {
    private AlunoDAO alunoDAO;

    public FindAlunoUseCases(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public Optional<Aluno> findOne(Integer id){
        if (id == null)
            throw new IllegalArgumentException("Id can not be null ");
        return alunoDAO.findOne(id);
    }

    public List<Aluno> findAll(){
        return alunoDAO.findAll();
    }


}