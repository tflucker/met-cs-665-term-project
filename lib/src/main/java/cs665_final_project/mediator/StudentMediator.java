package cs665_final_project.mediator;

import java.util.List;

import cs665_final_project.CompletedCourse;
import cs665_final_project.Course;
import cs665_final_project.Student;

/**
 * Mediator class used for functionality specific to the Student object and
 * fields of that object
 * 
 * @author Tim Flucker
 *
 */
public class StudentMediator {

	static double totalPoints;
	static double totalCredits;

	/**
	 * Computers a student's GPA based on all of their CompletedCourses (part of the
	 * courses Map in Student)
	 * 
	 * @param student
	 */
	public static void getGPA(Student student) {
		totalPoints = 0;
		totalCredits = 0;

		System.out.println("----------------------------------------------");
		for (String semester : student.getCourses().keySet()) {

			// iterates through course map,
			List<Course> semesterCourses = student.getCourses().get(semester);
			semesterCourses.stream().forEach(c -> {
				// finds all instances of CompletedCourse and retrieves the grade value and
				// increments counter
				if (c instanceof CompletedCourse) {
					CompletedCourse compCourse = (CompletedCourse) c;
					// each course's score = unit value (4) * course grade
					totalPoints += compCourse.getGrade() * 4;
					totalCredits += 4;

					System.out.println("Course: " + compCourse.getName() + ",\tGrade: " + compCourse.getGrade());

				}
			});
		}
		double gpa = totalPoints / totalCredits;
		System.out.println("----------------------------------------------");
		System.out.println(
				"Student (" + student.getStudentId() + "): " + student.getName());
		System.out.println("GPA: " + String.valueOf(gpa));
		System.out.println("----------------------------------------------");


	}
}
