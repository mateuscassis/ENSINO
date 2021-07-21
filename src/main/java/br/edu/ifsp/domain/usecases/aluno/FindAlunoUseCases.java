package br.edu.ifsp.domain.usecases.aluno;

import br.edu.ifsp.domain.entities.aluno.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindAlunoUseCases<T> {
    private AlunoDAO alunoDAO;
    private List<T> alunos;

    public FindAlunoUseCases(){
        alunos = new ArrayList<T>();
    }

    public FindAlunoUseCases(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public Optional<Aluno> findOne(Integer id){
        if (id == null)
            throw new IllegalArgumentException("Id can not be null ");
        return alunoDAO.findOne(id);
    }

    public List<T> findAll(){
        return (List<T>) alunoDAO.findAll();
    }




}