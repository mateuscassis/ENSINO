package br.edu.ifsp.application.main;

import br.edu.ifsp.application.repository.inmemmory.InMemoryAlunoDAO;
import br.edu.ifsp.application.repository.inmemmory.InMemoryCreditsDAO;
import br.edu.ifsp.application.repository.inmemmory.InMemoryServicesDAO;
import br.edu.ifsp.application.repository.sqlite.DatabaseBuilder;
import br.edu.ifsp.application.view.App;
import br.edu.ifsp.domain.usecases.aluno.*;
import br.edu.ifsp.domain.usecases.creditos.*;
import br.edu.ifsp.domain.usecases.servicos.*;

public class Main {

    public static CreateAlunoUseCases createAlunoUseCases;
    public static DeleteAlunoUseCases deleteAlunoUseCases;
    public static FindAlunoUseCases findAlunoUseCases;
    public static UpdateAlunoUseCase updateAlunoUseCase;
    public static AddCreditosInAluno addCreditosInAluno;
    public static RemoveCreditsForAluno removeCreditsForAluno;

    public static CreateCreditsUseCases createCreditsUseCases;
    public static DeleteCreditsUseCases deleteCreditsUseCases;
    public static FindCreditsUseCases findCreditsUseCases;
    public static UpdateCreditsUseCase updateCreditsUseCase;

    public static CreateServicesUseCases createServicesUseCases;
    public static DeleteServicesUseCase deleteServicesUseCase;
    public static FindServicesUseCases findServicesUseCases;
    public static UpdateServiceUseCase updateServiceUseCase;

    public static void main(String[] args) {
        configureInjection();
        App.main(args);


    }

    private static void setupDatabase() {
        DatabaseBuilder dbBuilder = new DatabaseBuilder();
        dbBuilder.buildDatabaseIfMissing();
    }

    private static void configureInjection() {
        AlunoDAO alunoDAO = new InMemoryAlunoDAO();
        createAlunoUseCases = new CreateAlunoUseCases(alunoDAO);
        deleteAlunoUseCases = new DeleteAlunoUseCases(alunoDAO);
        findAlunoUseCases = new FindAlunoUseCases(alunoDAO);
        updateAlunoUseCase = new UpdateAlunoUseCase(alunoDAO);
        addCreditosInAluno = new AddCreditosInAluno(alunoDAO, findAlunoUseCases, findCreditsUseCases);
        removeCreditsForAluno = new RemoveCreditsForAluno(findAlunoUseCases, findCreditsUseCases, alunoDAO);

        CreditsDAO creditsDAO = new InMemoryCreditsDAO();
        createCreditsUseCases = new CreateCreditsUseCases(creditsDAO);
        deleteCreditsUseCases = new DeleteCreditsUseCases(creditsDAO);
        findCreditsUseCases = new FindCreditsUseCases(creditsDAO);
        updateCreditsUseCase = new UpdateCreditsUseCase(creditsDAO);

        ServicesDAO servicesDAO = new InMemoryServicesDAO();
        createServicesUseCases = new CreateServicesUseCases(servicesDAO);
        deleteServicesUseCase = new DeleteServicesUseCase(servicesDAO);
        findServicesUseCases = new FindServicesUseCases(servicesDAO);
        updateServiceUseCase = new UpdateServiceUseCase(servicesDAO);
    }
}
