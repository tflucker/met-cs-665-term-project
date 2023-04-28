package cs665_final_project;

import cs665_final_project.facade.DepartmentFacade;

/**
 * Main application that showcases the functionality of the project. This
 * application tests the following design patterns: - Singleton -
 * AbstractFactory - Facade - Proxy - Mediator - Observer
 * 
 * @author Tim Flucker
 *
 */
public class App {

	public static void main(String[] args) {

		// Facade pattern hides complicated functionality from the user. Uses singleton
		// + abstract factory to initializes all of the data for the application.
		DepartmentFacade facade = new DepartmentFacade();

		// simulate students enrolling in classes (adds to class, may add to waitlist if
		// limit is reached)

		// -- IMPORTANT -- the boolean parameter dictates whether a 'course update' is
		// printed to the console. Right now it will print the first person who enrolls
		// and again when the enrollment limit is reached. This boolean also applies to
		// the ' dropStudentFromCourse' method.
		facade.enrollStudentInCourse("SD001", "CS151", "Fall 2022", true);
		facade.enrollStudentInCourse("SD002", "CS151", "Fall 2022", false);
		facade.enrollStudentInCourse("SD003", "CS151", "Fall 2022", false);
		facade.enrollStudentInCourse("SD004", "CS151", "Fall 2022", false);
		facade.enrollStudentInCourse("SC005", "CS151", "Fall 2022", false);
		facade.enrollStudentInCourse("SD006", "CS151", "Fall 2022", false);
		facade.enrollStudentInCourse("SD007", "CS151", "Fall 2022", false);
		facade.enrollStudentInCourse("SD008", "CS151", "Fall 2022", false);
		facade.enrollStudentInCourse("SD009", "CS151", "Fall 2022", false);

		facade.enrollStudentInCourse("SD004", "CS121", "Fall 2022", false);
		facade.enrollStudentInCourse("SC007", "CS121", "Fall 2022", false);
		facade.enrollStudentInCourse("SC013", "CS121", "Fall 2022", false);
		facade.enrollStudentInCourse("SC015", "CS121", "Fall 2022", false);

		facade.enrollStudentInCourse("SC002", "CS111", "Fall 2022", false);
		facade.enrollStudentInCourse("SD001", "CS122", "Fall 2022", false);
		facade.enrollStudentInCourse("SC003", "CS123", "Fall 2022", false);
		facade.enrollStudentInCourse("SC005", "CS121", "Fall 2022", false);

		facade.enrollStudentInCourse("SD003", "CS133", "Fall 2022", false);
		facade.enrollStudentInCourse("SD001", "CS133", "Fall 2022", false);
		facade.enrollStudentInCourse("SC009", "CS133", "Fall 2022", false);
		facade.enrollStudentInCourse("SD007", "CS133", "Fall 2022", false);
		facade.enrollStudentInCourse("SD011", "CS133", "Fall 2022", false);

		
		// simulate students dropping classes (removes student and then checks waitlist)
		facade.dropStudentFromCourse("SD004", "CS151", "Fall 2022", true);
		facade.dropStudentFromCourse("SC005", "CS151", "Fall 2022", false);

		
		
		// use combination facade + mediator pattern to retrieve a students GPA
		System.out.println("\nUse Mediator pattern to retrieve a student's GPA");
		facade.getStudentGPA("SD001");

		// use combination facade + mediator pattern to retrieve a students GPA
		System.out.println("\nUse Mediator pattern to retrieve the undergraduate and graduate advisors within the Department");
		facade.getDepartmentAdvisors();
		
		// print course information via a 'format' method, returns console output
		facade.printCourseInformation("CS151", "Fall 2022");
		
		// print all of the course information for all courses within this concentration
		facade.printConcentrationCoursesInformation("Programming Languages", "Fall 2022");
		
		facade.printFacultyResponsibilities("FC001", "Fall 2022");
		facade.printFacultyResponsibilities("FF001", "Fall 2022");
		facade.printFacultyResponsibilities("FP001", "Fall 2022");
	}

}
