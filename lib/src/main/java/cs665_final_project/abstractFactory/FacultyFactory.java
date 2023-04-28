package cs665_final_project.abstractFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cs665_final_project.ChairPerson;
import cs665_final_project.Department;
import cs665_final_project.Faculty;
import cs665_final_project.FullTimeFaculty;
import cs665_final_project.PartTimeFaculty;
import cs665_final_project.util.DataCreationUtil;

/**
 * Class that leverages the AbstractFactory pattern to create new Faculty
 * (FullTimeFaculty and PartTimeFaculty) objects which are associated to the
 * Department.
 * 
 * @author Tim Flucker
 *
 */
public class FacultyFactory implements AbstractFactory {

	@Override
	public void create() {

		// gets singleton instance
		Department department = Department.getInstance();

		// set the ChairPerson for the Department
		department.setChairperson(new ChairPerson("FC001", "John Doe", "123-456-7890", "jdoe@bu.edu", null));

		List<Faculty> facultyList = new ArrayList<>();

		// generate two random ints which will be used to randomly assign the
		// undergraduate and graduate advisors when creating full-time faculty
		boolean advisorsPicked = false;
		int undergradAdvisor = 0;
		int gradAdvisor = 0;

		while (!advisorsPicked) {
			undergradAdvisor = new Random().nextInt(5);
			gradAdvisor = new Random().nextInt(5);

			if (undergradAdvisor != gradAdvisor) {
				advisorsPicked = true;
			}
		}

		// creates 10 full-time faculty members
		for (int i = 0; i < 10; i++) {
			String name = DataCreationUtil.generateRandomName();
			boolean isUndergradAdvisor = (i == undergradAdvisor);
			boolean isGradAdvisor = (i == gradAdvisor);

			Faculty fullTimeFaculty = new FullTimeFaculty("FF00" + String.valueOf(i+1), name, DataCreationUtil.generateRandomPhoneNumber(),
					DataCreationUtil.generateEmail(name), new ArrayList<>(), isUndergradAdvisor, isGradAdvisor, new ArrayList<>());

			facultyList.add(fullTimeFaculty);
		}
		department.setFullTimeFaculty(facultyList);

		// creates 5 part-time faculty members
		facultyList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			String name = DataCreationUtil.generateRandomName();

			Faculty partTimeFaculty = new PartTimeFaculty("FP00" + String.valueOf(i+1), name, DataCreationUtil.generateRandomPhoneNumber(),
					DataCreationUtil.generateEmail(name), null);

			facultyList.add(partTimeFaculty);
		}
		department.setPartTimeFaculty(facultyList);

		System.out.println("\tFaculty created!");
	}

}
