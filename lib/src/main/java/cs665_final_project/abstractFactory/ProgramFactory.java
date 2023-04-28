package cs665_final_project.abstractFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cs665_final_project.CertificateProgram;
import cs665_final_project.Course;
import cs665_final_project.DegreeProgram;
import cs665_final_project.Department;
import cs665_final_project.Program;

/**
 * Class that leverages the AbstractFactory pattern to create new Program
 * objects which are associated to the Department.
 * 
 * @author Tim Flucker
 *
 */
public class ProgramFactory implements AbstractFactory {

	@Override
	public void create() {
		Department department = Department.getInstance();

		// use static methods to create the DegreeProgram and Certificate Program
		// objects and associate them to the Department
		createDegreePrograms(department);
		createCertificatePrograms(department);
		System.out.println("\tPrograms created!");
	}

	/**
	 * Creates the DegreeProgram objects and adds them to the Department
	 * 
	 * @param department
	 */
	private static void createDegreePrograms(Department department) {
		List<Program> degreePrograms = new ArrayList<>();
		// create undergraduate programs
		Program csUndergrad = new DegreeProgram("Computer Science", "B.S.", 8, null, null, true);
		Program cisUndergrad = new DegreeProgram("Computer & Information Systems", "B.S.", 8, null, null, true);

		// create graduate programs
		Program csGrad = new DegreeProgram("Computer Science", "M.S.", 4, null, null, true);
		Program cisGrad = new DegreeProgram("Computer & Information Systems", "M.S.", 4, null, null, true);
		Program daGrad = new DegreeProgram("Database Administration", "M.S.", 4, null, null, true);

		// add all programs to list
		degreePrograms.add(csUndergrad);
		degreePrograms.add(cisUndergrad);
		degreePrograms.add(csGrad);
		degreePrograms.add(cisGrad);
		degreePrograms.add(daGrad);

		department.setDegreePrograms(degreePrograms);
	}

	/**
	 * Creates the CertificateProgram objects and adds them to the Department
	 * 
	 * @param department
	 */
	private static void createCertificatePrograms(Department department) {
		List<Program> certificatePrograms = new ArrayList<>();

		Program securityCert = new CertificateProgram("Security Certificate",
				getListOfCoursesForProgram(department, Arrays.asList("CS101", "CS104", "CS152", "CS153")),
				Department.getConcentrationByName("Systems"));
		Program webTechCert = new CertificateProgram("Web Technology Certificate",
				getListOfCoursesForProgram(department, Arrays.asList("CS101", "CS132", "CS123", "CS152")),
				Department.getConcentrationByName("Programming Languages"));
		Program analyticsCert = new CertificateProgram("Analytics Certificate",
				getListOfCoursesForProgram(department, Arrays.asList("CS101", "CS151", "CS104", "CS131")),
				Department.getConcentrationByName("Databases"));
		Program machineLearningCert = new CertificateProgram("Machine Learning Certificate",
				getListOfCoursesForProgram(department, Arrays.asList("CS101", "CS124", "CS104", "CS122")),
				Department.getConcentrationByName("Software Engineering"));

		// add all programs to list, add list to department
		certificatePrograms.add(securityCert);
		certificatePrograms.add(webTechCert);
		certificatePrograms.add(analyticsCert);
		certificatePrograms.add(machineLearningCert);

		department.setCertificatePrograms(certificatePrograms);
	}

	/**
	 * Given a list of string 'courseId' values, retrieve all the course objects
	 * from a course master list.
	 * 
	 * @param program
	 * @param courseIds
	 * @return
	 */
	private static List<Course> getListOfCoursesForProgram(Department department, List<String> courseIds) {
		List<Course> masterCourseList = Department.getAllCourses("Fall 2022");
		return masterCourseList.stream().filter(c -> courseIds.contains(c.getCourseId())).collect(Collectors.toList());

	}

}
