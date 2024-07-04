package orm.actions;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.model.Aluno;

public class ListarAlunos {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		String sql = "select a from Aluno as a";
		
		Query query = manager.createQuery(sql);
		
		List<Aluno> listaAluno = query.getResultList();
		
		for (Aluno aluno : listaAluno) {
			System.out.println(aluno.getNome());
			System.out.println(aluno.getEmail());
			System.out.println(aluno.getCpf());
			System.out.println(aluno.getNascimento());
			System.out.println(aluno.getNaturalidade());
			System.out.println(aluno.getEndereco());
			System.out.println(); 
		}
	}
}
