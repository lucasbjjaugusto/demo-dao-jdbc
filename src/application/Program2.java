package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("=== Teste 1: Department findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
						
		System.out.println("=== Teste 2: Department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== Teste 3: Department insert ===");
		Department newDepartment = new Department(9, "Commercial");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("=== Teste 4: Department update ===");
		department = departmentDao.findById(5);
		department.setName("IT");
		departmentDao.update(department);
		System.out.println("Update Completed");
		
		System.out.println("=== Teste 5: Department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed");
		
		sc.close();

	}

}
