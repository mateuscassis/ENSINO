package br.edu.ifsp.application.repository.sqlite;

public class DatabaseBuilder {
    private void buildTables(){

    }

    private String createAlunoTable(){
       StringBuilder builder = new StringBuilder();
       builder.append("CREATE TABLE ALUNO (\n");
       builder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
       builder.append("nome TEXT NOT NULL, \n");

        return null;
    }

    private String creditosTable(){
        return null;
    }

    private String createServiços(){
        return null;
    }
}
