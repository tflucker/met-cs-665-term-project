package cs665_final_project.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import cs665_final_project.CertificateProgram;
import cs665_final_project.CompletedCourse;
import cs665_final_project.Concentration;
import cs665_final_project.Course;
import cs665_final_project.DegreeProgram;
import cs665_final_project.Department;
import cs665_final_project.Faculty;
import cs665_final_project.FullTimeFaculty;
import cs665_final_project.Program;
import cs665_final_project.Student;
import cs665_final_project.abstractFactory.AbstractFactory;
import cs665_final_project.abstractFactory.FactoryProvider;
import cs665_final_project.mediator.DepartmentMediator;
import cs665_final_project.observer.CourseObserver;
import cs665_final_project.observer.Subject;
import cs665_final_project.proxy.IVerify;
import cs665_final_project.proxy.IVerifyProxy;
import cs665_final_project.util.DataCreationUtil;
import cs665_final_project.util.FactoryType;

/**
 * Facade class which acts as an intermediary layer between the Main class and
 * the various methods to interact with the design patterns.
 * 
 * @author Tim Flucker
 *
 */
public class DepartmentFacade {

	private List<Student> students;

	/**
	 * On instantiation create all data for the application
	 */
	public DepartmentFacade() {
		initializeApplicationData();
	}

	/**
	 * Uses the AbstractFactory pattern to create all of the hard-coded application
	 * data.
	 * 
	 * @return
	 */
	private Department initializeApplicationData() {

		System.out.println(
				"TEST - Use AbstractFactory pattern to generate differnt objects and associate them to Singleton instance of Department");
		System.out.println("Initializing application data ...");
		AbstractFactory abstractFactory;

		// creates a new Department object using singleton pattern
		abstractFactory = FactoryProvider.getFactory(FactoryType.DEPARTMENT);
		abstractFactory.create();

		// uses singleton department and creates list of full-time and part-time faculty
		// and adds them to the department
		abstractFactory = FactoryProvider.getFactory(FactoryType.FACULTY);
		abstractFactory.create();

		// uses singleton department and creates list of full-time and part-time faculty
		// and adds them to the department
		abstractFactory = FactoryProvider.getFactory(FactoryType.CONCENTRATION);
		abstractFactory.create();

		// uses singleton department and creates list of Courses and adds them to the
		// department
		abstractFactory = FactoryProvider.getFactory(FactoryType.COURSE);
		abstractFactory.create();

		// uses singleton department and creates list of Programs (Degree and
		// Certificate) and adds them to the department
		abstractFactory = FactoryProvider.getFactory(FactoryType.PROGRAM);
		abstractFactory.create();

		// creates list of Students
		createStudents();

		return Department.getInstance();
	}

	/**
	 * Creates initial dataset of the students for this department.
	 */
	private void createStudents() {
		System.out.println("Creating students ...");
		Department department = Department.getInstance();
		List<Program> degreePrograms = department.getDegreePrograms();
		List<Program> certificatePrograms = department.getCertificatePrograms();

		students = new ArrayList<>();
		for (int i = 0; i < degreePrograms.size() * 3; i++) {
			String name = DataCreationUtil.generateRandomName();
			DegreeProgram dProgram = (DegreeProgram) degreePrograms.get(i % 3);

			// creates new student with random name, phone number, an email address based on
			// the name, a program, and a random thesis advisor and topic
			Student student = new Student("SD00" + String.valueOf(i + 1), name,
					DataCreationUtil.generateRandomPhoneNumber(), DataCreationUtil.generateEmail(name), new HashMap<>(),
					dProgram, DataCreationUtil.selectRandomThesisAdvisor(department),
					DataCreationUtil.selectThesisTopic());

			students.add(student);
		}

		// create students for certificate programs
		for (int i = 0; i < certificatePrograms.size() * 3; i++) {
			String name = DataCreationUtil.generateRandomName();
			CertificateProgram certProgram = (CertificateProgram) certificatePrograms.get(i % 3);
			// creates new student with random name, phone number, an email address based on
			// the name, a program
			Student student = new Student("SC00" + String.valueOf(i + 1), name,
					DataCreationUtil.generateRandomPhoneNumber(), DataCreationUtil.generateEmail(name), new HashMap<>(),
					certProgram, null, null);

			students.add(student);
		}

		// give all students a few previously completed classes
		for (int i = 0; i < students.size(); i++) {
			int facultyIndex = i;
			Student s = students.get(i);
			// gives every student 2 completed courses for the 'Spring 2022'
			assignRandomCompletedCourses(s, "Spring 2022", 2);

			// if the student has a thesis topic, assign them a random thesis advisor from
			// the full-time faculty list
			if (s.getThesisTopic() != null) {

				if (i >= department.getFullTimeFaculty().size())
					facultyIndex = 0;

				// associate student to thesis advisor
				FullTimeFaculty advisor = (FullTimeFaculty) department.getFullTimeFaculty().get(facultyIndex);
				advisor.getThesisAdvisees().add(s);
				// associate advisor to student
				s.setThesisAdvisor(advisor);

			}
		}

		System.out.println("Successfully created " + String.valueOf(students.size()) + " students!");

	}


	/**
	 * Assigns random completed courses to the the provided student parameter.
	 * 
	 * @param student
	 * @param semester
	 * @param numCourses
	 * @return
	 */
	public static List<Course> assignRandomCompletedCourses(Student student, String semester, int numCourses) {
		// get list of courses to choose from at random
//		List<Course> courses = semesterCourses.get("Fall 2022");
		List<Course> completedCourses = new ArrayList<>();

		LinkedList<Course> courses = new LinkedList<>(Department.getAllCourses("Fall 2022"));

		for (int i = 0; i < numCourses; i++) {

			// generate random index to choose a random course
			int courseIndex = new Random().nextInt(courses.size());

			// generate a random grade value for the completed course
			// remove randomly selected course from list of all courses to prevent duplicate
			// selections
			int randomGrade = new Random().nextInt(5);
			Course course = courses.remove(courseIndex);

			// add completed course to list
			CompletedCourse completedCourse = new CompletedCourse(course, semester, randomGrade);
			completedCourses.add(completedCourse);
		}

		// sets completed courses for student
		student.getCourses().put(semester, completedCourses);
		return completedCourses;
	}
	
	/**
	 * Enrolls student in specified course for a certain semester. Verifies that the
	 * studentId and courseId are valid and their objects exist within the
	 * department
	 * 
	 * @param studentId
	 * @param courseId
	 * @param semester
	 */
	public void enrollStudentInCourse(String studentId, String courseId, String semester, boolean printToConsole) {
		IVerify verificationService = new IVerifyProxy(semester, students);
		Course course = verificationService.verifyCourseId(courseId);
		Student student = verificationService.verifyStudentId(studentId);

		// verify that student and course are not null
		if (student != null) {
			if (course != null) {

				// instantiate new observer pattern for this course
				Subject subject = new Subject(course);
				new CourseObserver(subject);

				// this is the subject's "update" method, which notifies the observer and
				// enrolls the student
				subject.takeAction(student, "ENROLL", printToConsole);

			} else {
				System.out.println("Course ID: " + courseId + " not found.");
			}
		} else {
			System.out.println("Student ID: " + studentId + " not found.");
		}
	}

	/**
	 * Drops student from specified course for a certain semester. Verifies that the
	 * studentId and courseId are valid and their objects exist within the
	 * department
	 * 
	 * @param studentId
	 * @param courseId
	 * @param semester
	 */
	public void dropStudentFromCourse(String studentId, String courseId, String semester, boolean printToConsole) {
		IVerify verificationService = new IVerifyProxy(semester, students);
		Course course = verificationService.verifyCourseId(courseId);
		Student student = verificationService.verifyStudentId(studentId);
		if (student != null) {

			if (course != null) {
				Subject subject = new Subject(course);
				new CourseObserver(subject);
				subject.takeAction(student, "DROP", printToConsole);

			} else {
				System.out.println("Course ID: " + courseId + " not found.");
			}
		} else {
			System.out.println("Student ID: " + studentId + " not found.");
		}
	}

	/**
	 * Uses the Mediator pattern to get the student's GPA based on their completed
	 * courses
	 * 
	 * @param studentId
	 */
	public void getStudentGPA(String studentId) {
		IVerify verificationService = new IVerifyProxy("Fall 2022", students);
		Student student = verificationService.verifyStudentId(studentId);
		student.getGPA();

	}

	public void getDepartmentAdvisors() {
		Faculty underGradAdvisor = Department.getInstance().getUndergraduateAdvisor();
		Faculty graduateAdvisor = Department.getInstance().getGraduateAdvisor();

		System.out.println("Undergraduate Advisor:\t" + underGradAdvisor.getName() + "\t"
				+ underGradAdvisor.getPhoneNumber() + "\t" + underGradAdvisor.getEmail());
		System.out.println("Graduate Advisor:\t" + graduateAdvisor.getName() + "\t" + graduateAdvisor.getPhoneNumber()
				+ "\t" + graduateAdvisor.getEmail());

	}

	/**
	 * Retrieves the course with the provided courseId in a particular semester and
	 * prints to the console the relevant information about the class.
	 * 
	 * @param courseId
	 * @param semester
	 */
	public void printCourseInformation(String courseId, String semester) {
		Course course = DepartmentMediator.getCourse(courseId, semester);

		// prints information about the course to the console (id, name, description,
		// syllabus, a status (based on number of enrolled students), and a list of
		// waitlisted students if applicable
		course.format();

	}

	/**
	 * Retrieves the
	 * 
	 * @param concentrationName
	 * @param semester
	 */
	public void printConcentrationCoursesInformation(String concentrationName, String semester) {

		// get class associated to a concentration for the provided semester
		Concentration concentration = DepartmentMediator.getConcentrationByName(concentrationName);

		// prints information about the all courses in this concentration to the console
		// (id, name, description, syllabus, a status (based on number of enrolled
		// students), and a list of waitlisted students if applicable
		concentration.format(semester);

	}

	public void printFacultyResponsibilities(String facultyId, String semester) {
		Department department = Department.getInstance();
		Faculty faculty = null;
		if (facultyId.contains("FC")) {
			faculty = department.getChairperson();
		} else if (facultyId.contains("FF")) {
			faculty = department.getFullTimeFaculty().stream().filter(f -> f.getFacultyId().equals(facultyId))
					.findFirst().orElse(null);
		} else {
			faculty = department.getPartTimeFaculty().stream().filter(f -> f.getFacultyId().equals(facultyId))
					.findFirst().orElse(null);
		}

		faculty.printResponsibilities();
	}

}
