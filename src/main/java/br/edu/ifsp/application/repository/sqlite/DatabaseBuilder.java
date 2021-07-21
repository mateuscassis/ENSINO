package br.edu.ifsp.application.repository.sqlite;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBuilder {

    public void buildDatabaseIfMissing(){
        if (isDatabaseMissing()){
            System.out.println("database is missing. Building database:\n");
            buildTables();
        }
    }

    private boolean isDatabaseMissing() {
       return  !Files.exists(Paths.get("database.db"));
    }

    private void buildTables(){
        try (Statement statement = ConnectionFactory.createStatement()){
            statement.addBatch(createServicosTable());
            statement.addBatch(CreateCreditosTable());
            statement.addBatch(createAlunoTable());
            statement.executeBatch();
            System.out.println("Database successfully created.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private String createAlunoTable(){
       StringBuilder builder = new StringBuilder();

       builder.append("CREATE TABLE Aluno\n" +
               "(\n" +
               "id INT AUTO_INCREMENT,\n" +
               "Nome VARCHAR (60) NOT NULL,\n" +
               "mensalidade INT,\n" +
               "creditos varchar (80),\n" +
               "PRIMARY KEY (id) );");

        System.out.println(builder.toString());
        return builder.toString();
    }

    private String CreateCreditosTable(){
        StringBuilder builder = new StringBuilder();

        builder.append("CREATE TABLE Creditos\n" +
                "(\n" +
                "id INT AUTO_INCREMENT,\n" +
                "Nome VARCHAR (60) NOT NULL,\n" +
                "Valor INT,\n" +
                "PRIMARY KEY (id) );");

        System.out.println(builder.toString());
        return builder.toString();
    }

    private String createServicosTable(){
        StringBuilder builder = new StringBuilder();

        builder.append("CREATE TABLE Servicos\n" +
                "(\n" +
                "id INT AUTO_INCREMENT,\n" +
                "Nome VARCHAR (60) NOT NULL,\n" +
                "Valor INT,\n" +
                "Horas INT (80),\n" +
                "PRIMARY KEY (id) );");

        System.out.println(builder.toString());
        return builder.toString();

    }
}
