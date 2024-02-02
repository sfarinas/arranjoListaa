package arranjoListaa;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employes> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered ? ");
		int N = sc.nextInt();
		
		
		for (int i = 0; i < N; i++) {
			System.out.println();
			System.out.println("Employee #" + (i + 1) + " : ");
			System.out.print("Id: ");Integer id = sc.nextInt();sc.nextLine();
			System.out.print("Name: ");String name = sc.nextLine();
			System.out.print("Salary: ");Double salary = sc.nextDouble();
			
			Employes emp = new Employes(id, name, salary);
			
			list.add(emp);
		}
		
		System.out.println();
		System.out.print("Enter the employee ID that will have salary increase : ");
		int idSalary = sc.nextInt();sc.nextLine();
		
		Integer pos = position(list, idSalary);
		
		//Employes emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		
		if (pos == null) {
			System.out.println("This ID does not exist!");
		}else {
			System.out.println("Enter the percentage: ");
			double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
		}
		
		System.out.println();
		System.out.print("List of Employees");

		for (Employes emp : list) {
			System.out.println(emp);
		}
		
		
		sc.close();

	}
	
	public static Integer position(List<Employes> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

}
