package orm.actions;



import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Aluno;

public class InserirAluno {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
	
		Aluno aluno = new Aluno();
		System.out.print("Informe o nome: ");
        String nome = scanner.nextLine();
        aluno.setNome(nome);
        System.out.print("Informe o email: ");
        String email = scanner.nextLine();
        aluno.setEmail(email);
        System.out.println("Informe o CPF:");
        String cpf = scanner.nextLine();
        aluno.setCpf(cpf);
        System.out.println("Informe a data de nascimento:");
        String nascimento = scanner.nextLine();
        aluno.setNascimento(nascimento);
        System.out.println("Informe a naturalidade:");
        String naturalidade = scanner.nextLine();
        aluno.setNaturalidade(naturalidade);
        System.out.println("Informe o endereco:");
        String endereco = scanner.nextLine();
        aluno.setEndereco(endereco);
        
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		
		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();
		
		System.out.println("Aluno inserido, ID: "+aluno.getId());
		
		manager.close();
		factory.close();
		scanner.close();
	}
}
