package br.edu.ifsp.application.repository.sqlite;

import br.edu.ifsp.domain.entities.aluno.Aluno;
import br.edu.ifsp.domain.entities.aluno.Superior;
import br.edu.ifsp.domain.entities.creditos.Credits;
import br.edu.ifsp.domain.usecases.aluno.AlunoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SqliteAlunoDAO implements AlunoDAO {

    @Override
    public boolean addCredits(Credits credits, Superior aluno) {
        return false;
    }

    @Override
    public boolean removeCreditsFromAluno(Credits credits, Superior superior) {
        return false;
    }

    @Override
    public Integer create(Aluno type) {
        String sql = "INSERT INTO Alunos(nome) VALUES (?)";
        try(PreparedStatement statement = ConnectionFactory.createPreparedStatement(sql)) {
            statement.setString(1,type.getNome());
            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();
            int generatedKey = resultSet.getInt(1);
            return generatedKey;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Aluno resultSetToEntity(ResultSet rs) throws SQLException {
        return new Superior(rs.getInt("id"), rs.getString("nome"), rs.getLong("creditos"));
    }

    @Override
    public Optional<Aluno> findOne(Integer key) {
        return Optional.empty();
    }

    @Override
    public List<Aluno> findAll() {
        return null;
    }

    @Override
    public boolean update(Aluno type) {
        return false;
    }

    @Override
    public boolean deleteByKey(Integer key) {
        return false;
    }

    @Override
    public boolean delete(Aluno type) {
        return false;
    }
}
