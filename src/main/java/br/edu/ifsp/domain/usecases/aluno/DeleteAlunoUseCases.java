package br.edu.ifsp.domain.usecases.aluno;
import br.edu.ifsp.domain.entities.aluno.Aluno;
import br.edu.ifsp.domain.usecases.utils.EntitieNotFoundException;

public class DeleteAlunoUseCases {
    private AlunoDAO alunoDAO;

    public DeleteAlunoUseCases(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public boolean remove(Integer id){
        if (id==null || alunoDAO.findOne(id).isEmpty())
            throw new EntitieNotFoundException("Aluno not found");
        return alunoDAO.deleteByKey(id);
    }

    public boolean remove(Aluno aluno){
        if (aluno==null || alunoDAO.findOne(aluno.getId()).isEmpty())
            throw new EntitieNotFoundException("Aluno not found");
        return alunoDAO.delete(aluno);
    }
}
