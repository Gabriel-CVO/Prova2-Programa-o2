package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Aluno;

public class RemoverAluno {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		Aluno aluno = new Aluno();
		System.out.print("Informe o Id a ser removido: ");
        Long Id = scanner.nextLong();
		aluno.setId(Id);
		aluno = manager.find(Aluno.class, aluno.getId());
		
		manager.getTransaction().begin();
		manager.remove(aluno);
		manager.getTransaction().commit();
		
		System.out.println("Aluno excluído!");
		
		manager.close();
		factory.close();
		scanner.close();
	}
}
