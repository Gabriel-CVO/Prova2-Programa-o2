package orm.actions;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import orm.model.Aluno;

public class ListarPorInicial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe a inicial: ");
        String inicial = scanner.nextLine().toUpperCase() + "%"; 
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();
        
        String sql = "select a from Aluno as a where upper(a.nome) like :inicial";
        
        Query query = manager.createQuery(sql);
        query.setParameter("inicial", inicial);
        
        List<Aluno> listaAluno = query.getResultList();
        
        for (Aluno aluno : listaAluno) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Email: " + aluno.getEmail());
            System.out.println("CPF: " + aluno.getCpf());
            System.out.println("Nascimento: " + aluno.getNascimento());
            System.out.println("Naturalidade: " + aluno.getNaturalidade());
            System.out.println("Endereço: " + aluno.getEndereco());
            System.out.println(); 
        }
        
      
        manager.close();
        factory.close();
        scanner.close();
    }
}

