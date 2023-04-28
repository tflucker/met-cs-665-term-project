package cs665_final_project.abstractFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import cs665_final_project.Concentration;
import cs665_final_project.Course;
import cs665_final_project.Department;
import cs665_final_project.FullTimeFaculty;

/**
 * Class that leverages the AbstractFactory pattern to create new Course objects
 * which are associated to the Department.
 * 
 * @author Tim Flucker
 *
 */
public class CourseFactory implements AbstractFactory {

	private static final String[] concentrationNames = { "Systems", "Programming Languages", "Databases",
			"Software Engineering" };

	// sub-cons of 'programming languages'
	private static final String[] subConcentrationNames = { "Procedural Languages", "Object Oriented Languages",
			"Functional Languages" };

	private static HashMap<String, List<Course>> semesterCourses;

	@Override
	public void create() {
		Department department = Department.getInstance();

		String semester = "Fall 2022";
		List<Course> courseList = new ArrayList<>();
		semesterCourses = new HashMap<>();

		// CONCENTRATION --- Systems ---
		Concentration systemsCon = Department.getConcentrationByName(concentrationNames[0]);
		FullTimeFaculty systemsCoordinator = ((FullTimeFaculty) systemsCon.getConcentrationCoordinator());

		Course course1 = new Course("CS101", "Introduction to Computer Science",
				"Learn fundamentals of the field of computer science and its various applications.",
				"/docs/systems/intro-compsci/syllabus.pdf", department.getChairperson(), systemsCon, 2,
				new ArrayList<>(), new LinkedList<>());
		Course course2 = new Course("CS102", "Computer Networks",
				"Discover the complexity of computer networks and how computers communicate with one another.",
				"/docs/systems/comp-networks/syllabus.pdf", systemsCoordinator, systemsCon, 3, new ArrayList<>(),
				new LinkedList<>());
		Course course3 = new Course("CS103", "Intro to Cloud Computing",
				"Explore the future of computer systems, cloud computing! Covers content related to AWS, Azure, and GCP.",
				"/docs/systems/os-design-impl/syllabus.pdf", systemsCoordinator, systemsCon, 2, new ArrayList<>(),
				new LinkedList<>());
		Course course4 = new Course("CS104", "Operating System Design and Implementation",
				"Learn the basics of operations systems and how they are designed and created.",
				"/docs/systems/os-design-impl/syllabus.pdf", systemsCoordinator, systemsCon, 2, new ArrayList<>(),
				new LinkedList<>());

		// adds courses to a list
		courseList = Arrays.asList(course1, course2, course3, course4);

		// add course for ChairPerson
		department.getChairperson().setCourseId("CS101");
		
		// add courses to faculty member, (introCompSci assigned to ChairPerson)
		systemsCoordinator.setCourseIds(Arrays.asList("CS102", "CS103", "CS104"));

		// add courses to the Map, then add map to Concentration
		semesterCourses.put(semester, courseList);
		systemsCon.setCourses(semesterCourses);

		// CONCENTRATION --- Programming Languages ---

		// SUB-CONCENTRATION --- Procedural languages ---
		Concentration proceduralLangCon = Department.getConcentrationByName(subConcentrationNames[0]);
		FullTimeFaculty progLangCoordinator = ((FullTimeFaculty) proceduralLangCon.getConcentrationCoordinator());

		semesterCourses = new HashMap<>();
		course1 = new Course("CS111", "Introduction to FORTRAN",
				"Learn the procedural language of space satellites! Its from the 1960s!",
				"/docs/prog-lang/intro-fortran/syllabus.pdf", progLangCoordinator, proceduralLangCon, 2,
				new ArrayList<>(), new LinkedList<>());
		course2 = new Course("CS112", "Introduction to COBOL",
				"Learn the procedural language of the business, administrative, and finance world.",
				"/docs/prog-lang/intro-cobol/syllabus.pdf", progLangCoordinator, proceduralLangCon, 2,
				new ArrayList<>(), new LinkedList<>());
		course3 = new Course("CS113", "Introduction to C",
				"Learn one the languages behind creating operating systems and is the gateway to many other more specialized programming lanaguages.",
				"/docs/prog-lang//syllabus.pdf", progLangCoordinator, proceduralLangCon, 2, new ArrayList<>(),
				new LinkedList<>());

		// adds courses to a list
		courseList = Arrays.asList(course1, course2, course3);

		// add courses to faculty member, (introCompSci assigned to ChairPerson)
		progLangCoordinator.setCourseIds(Arrays.asList("CS111", "CS112", "CS113"));

		// add courses to the Map, then add map to Concentration
		semesterCourses.put(semester, courseList);
		proceduralLangCon.setCourses(semesterCourses);

		// SUB-CONCENTRATION --- Object Oriented languages ---
		Concentration objOrientedLangCon = Department.getConcentrationByName(subConcentrationNames[1]);
		FullTimeFaculty objLangCoordinator = ((FullTimeFaculty) objOrientedLangCon.getConcentrationCoordinator());

		semesterCourses = new HashMap<>();
		course1 = new Course("CS121", "Intro to Python",
				"Learn about the high-level object oriented language which everyone loves!",
				"/docs/prog-lang/intro-python/syllabus.pdf", objLangCoordinator, objOrientedLangCon, 2,
				new ArrayList<>(), new LinkedList<>());
		course2 = new Course("CS122", "Intro to Java",
				"Learn the basics of one of the most common programming language that powers billions of devices!",
				"/docs/prog-lang/intro-java/syllabus.pdf", objLangCoordinator, objOrientedLangCon, 2, new ArrayList<>(),
				new LinkedList<>());
		course3 = new Course("CS123", "Intro to PHP",
				"Learn the fundamentals of one of the languages behind web development and how servers communicate with one another.",
				"/docs/prog-lang/intro-php/syllabus.pdf", objLangCoordinator, objOrientedLangCon, 2, new ArrayList<>(),
				new LinkedList<>());

		// adds courses to a list
		courseList = Arrays.asList(course1, course2, course3);

		// add courses to faculty member, (introCompSci assigned to ChairPerson)
		objLangCoordinator.setCourseIds(Arrays.asList("CS121", "CS122", "CS123"));

		// add courses to the Map, then add map to Concentration
		semesterCourses.put(semester, courseList);
		objOrientedLangCon.setCourses(semesterCourses);

		// SUB-CONCENTRATION --- Functional languages ---
		Concentration functionalLangCon = Department.getConcentrationByName(subConcentrationNames[2]);
		FullTimeFaculty functionalLangCoordinator = ((FullTimeFaculty) functionalLangCon.getConcentrationCoordinator());

		semesterCourses = new HashMap<>();
		course1 = new Course("CS131", "Intro to C++",
				"Learn about a language that is built on top of the C programming language.",
				"/docs/prog-lang/intro-c-plus-plus/syllabus.pdf", functionalLangCoordinator, functionalLangCon, 2,
				new ArrayList<>(), new LinkedList<>());
		course2 = new Course("CS132", "Intro to JavaScript",
				"Learn about one of the most important and widely used languages for web development",
				"/docs/prog-lang/into-js/syllabus.pdf", functionalLangCoordinator, functionalLangCon, 2,
				new ArrayList<>(), new LinkedList<>());
		course3 = new Course("CS133", "Intro Swift", "Learn the fundamentals of the language used by Apple devices.",
				"/docs/prog-lang/intro-swift/syllabus.pdf", functionalLangCoordinator, functionalLangCon, 2,
				new ArrayList<>(), new LinkedList<>());

		// adds courses to a list
		courseList = Arrays.asList(course1, course2, course3);

		// add courses to faculty member, (introCompSci assigned to ChairPerson)
		functionalLangCoordinator.setCourseIds(Arrays.asList("CS131", "CS132", "CS133"));

		// add courses to the Map, then add map to Concentration
		semesterCourses.put(semester, courseList);
		functionalLangCon.setCourses(semesterCourses);

		// CONCENTRATION --- Databases ---
		Concentration databaseCon = Department.getConcentrationByName(concentrationNames[2]);
		FullTimeFaculty databaseCoordinator = ((FullTimeFaculty) databaseCon.getConcentrationCoordinator());

		semesterCourses = new HashMap<>();
		course1 = new Course("CS141", "SQL Basics for Data Science",
				"Learn the syntax of SQL and its varied applications for data science and data management.",
				"/docs/database/sql-basics/syllabus.pdf", databaseCoordinator, databaseCon, 5, new ArrayList<>(),
				new LinkedList<>());
		course2 = new Course("CS141", "Database Management",
				"Focused on the learning the skills and best practices for the data management field.",
				"/docs/database/db-management/syllabus.pdf", databaseCoordinator, databaseCon, 5, new ArrayList<>(),
				new LinkedList<>());
		course3 = new Course("CS141", "Relational Database Design",
				"Learn standards and best practices when creating relational databases.",
				"/docs/database/relational-db-design/syllabus.pdf", databaseCoordinator, databaseCon, 5,
				new ArrayList<>(), new LinkedList<>());

		// adds courses to a list
		courseList = Arrays.asList(course1, course2, course3);

		// add courses to faculty member, (introCompSci assigned to ChairPerson)
		databaseCoordinator.setCourseIds(Arrays.asList("CS141", "CS142", "CS143"));

		// add courses to the Map, then add map to Concentration
		semesterCourses.put(semester, courseList);
		databaseCon.setCourses(semesterCourses);

		// CONCENTRATION --- Software Engineering ---
		Concentration softwareEngCon = Department.getConcentrationByName(concentrationNames[3]);
		FullTimeFaculty softwareEngCoordinator = ((FullTimeFaculty) softwareEngCon.getConcentrationCoordinator());

		semesterCourses = new HashMap<>();
		course1 = new Course("CS151", "Requirements Analysis and Modeling",
				"Learn how to gather requirements from a client and how to create a project materials for planning and execution.",
				"/docs/database/req-analysis/syllabus.pdf", softwareEngCoordinator, softwareEngCon, 5,
				new ArrayList<>(), new LinkedList<>());
		course2 = new Course("CS152", "Software Quality Assurance and Testing",
				"Learn the different ways an application can be tested and how requirements can be verified.",
				"/docs/database/software-qa-testing/syllabus.pdf", softwareEngCoordinator, softwareEngCon, 5,
				new ArrayList<>(), new LinkedList<>());
		course3 = new Course("CS153", "Intro to Cybersecurity",
				"Learn the fundamentals of securing your application and the types of attacks that can occur.",
				"/docs/database/intro-cybersec/syllabus.pdf", softwareEngCoordinator, softwareEngCon, 5,
				new ArrayList<>(), new LinkedList<>());

		// adds courses to a list
		courseList = Arrays.asList(course1, course2, course3);

		// add courses to faculty member, (introCompSci assigned to ChairPerson)
		softwareEngCoordinator.setCourseIds(Arrays.asList("CS151", "CS152", "CS153"));

		// add courses to the Map, then add map to Concentration
		semesterCourses.put(semester, courseList);
		softwareEngCon.setCourses(semesterCourses);

		System.out.println("\tCourses created!");
	}

}
