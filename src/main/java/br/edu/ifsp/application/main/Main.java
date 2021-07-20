package br.edu.ifsp.application.main;

import br.edu.ifsp.application.repository.inmemmory.InMemoryAlunoDAO;
import br.edu.ifsp.application.repository.inmemmory.InMemoryCreditsDAO;
import br.edu.ifsp.application.repository.inmemmory.InMemoryServicesDAO;
import br.edu.ifsp.domain.entities.aluno.Aluno;
import br.edu.ifsp.domain.entities.aluno.Basic;
import br.edu.ifsp.domain.entities.aluno.Superior;
import br.edu.ifsp.domain.entities.creditos.Credits;
import br.edu.ifsp.domain.entities.servicos.Services;
import br.edu.ifsp.domain.usecases.aluno.*;
import br.edu.ifsp.domain.usecases.creditos.*;
import br.edu.ifsp.domain.usecases.servicos.*;

public class Main {

    public static CreateAlunoUseCases createAlunoUseCases;
    private static DeleteAlunoUseCases deleteAlunoUseCases;
    private static FindAlunoUseCases findAlunoUseCases;
    public static UpdateAlunoUseCase updateAlunoUseCase;
    private static AddCreditosInAluno addCreditosInAluno;
    private static RemoveCreditsForAluno removeCreditsForAluno;

    public static CreateCreditsUseCases createCreditsUseCases;
    public static DeleteCreditsUseCases deleteCreditsUseCases;
    public static FindCreditsUseCases findCreditsUseCases;
    public static UpdateCreditsUseCase updateCreditsUseCase;

    public static CreateServicesUseCases createServicesUseCases;
    private static DeleteServicesUseCase deleteServicesUseCase;
    private static FindServicesUseCases findServicesUseCases;
    public static UpdateServiceUseCase updateServiceUseCase;

    public static void main(String[] args) {
        configureInjection();

        //Criando Alunos
        Superior aluno1 = new Superior("joao");
        Aluno aluno2 = new Basic("joao2", 2000);
        createAlunoUseCases.insert(aluno1);
        createAlunoUseCases.insert(aluno2);

        //Criando Creditos
        Credits credits1 = new Credits("matematica", 100);
        Credits credits2 = new Credits("Portugues", 100);
        createCreditsUseCases.insert(credits1);
        createCreditsUseCases.insert(credits2);

        //Buscando Creditos
        System.out.println(findCreditsUseCases.findOne(2));


        //Adicionando Creditos ao Aluno superior.
        addCreditosInAluno.addCreditsToAluno(credits1,aluno1);
        addCreditosInAluno.addCreditsToAluno(credits2,aluno1);

        //Removendo Creditos do Aluno Superior.
        removeCreditsForAluno.removeCreditsFromAluno(credits1,aluno1);
        removeCreditsForAluno.removeCreditsFromAluno(credits2,aluno1);

       //Buscando aluno
        System.out.println(findAlunoUseCases.findOne(1));
        System.out.println(findAlunoUseCases.findOne(2));

        //Testando Valor a Pagar
        System.out.println("Valor a pagar: " + aluno1.ValorApagar(aluno1));

        //Testando procurar todos os Alunos
        System.out.println(findAlunoUseCases.findAll());

        //Testando criar serviços
        Services services1 = new Services("engenharia", 100, 1);
        createServicesUseCases.insert(services1);
        System.out.println(findServicesUseCases.findOne(1));
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
