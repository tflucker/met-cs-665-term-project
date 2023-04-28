package cs665_final_project.abstractFactory;

import cs665_final_project.Department;

/**
 * Class that leverages the AbstractFactory pattern to create a new Department
 * object.
 * 
 * @author Tim Flucker
 *
 */
public class DepartmentFactory implements AbstractFactory {

	@Override
	public void create() {

		Department department = Department.getInstance();

		department.setName("Computer Science");

		System.out.println("\tDepartment created!");
	}

}
