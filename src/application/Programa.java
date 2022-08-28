package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import entidade.Funcionario;
public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> list = new ArrayList<>();
		
		System.out.print("Quantos funcionários serão cadastrados? ");
		int N = sc.nextInt();
		
		for (int i=0; i<N; i++) {
			
			System.out.println();
			System.out.println("Funcionario #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.println("Id já usado! Tente novamente: ");
				id = sc.nextInt();
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			Double salario = sc.nextDouble();
			
			Funcionario emp = new Funcionario (id, nome, salario);
			
			list.add(emp);
		}
		
		System.out.println();
		System.out.print("Digite o id do funcionário que terá aumento salarial : ");
		int idsalario = sc.nextInt();

		
		
		Funcionario emp = list.stream().filter(x -> x.getId() == idsalario).findFirst().orElse(null);
		
		
		if (emp == null) {
			System.out.println("Este id não existe!");
		}
		else {
			System.out.print("Digite a porcentagem: ");
			double percent = sc.nextDouble();
			
			emp.aumentoSalario(percent);
		}
		
		System.out.println();
		System.out.println("lista de funcionario:");
		for (Funcionario e : list) {
			System.out.println(e);
		}		
		
		sc.close();
	}

	public static Integer position(List<Funcionario> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean hasId(List<Funcionario> list, int id) {
		Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;	

	}

}
