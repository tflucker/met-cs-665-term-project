package cs665_final_project.proxy;

import cs665_final_project.Course;
import cs665_final_project.Student;

/**
 * Interface which defines proxy methods. These methods are used to verify if
 * data exists in the Department
 * 
 * @author Tim Flucker
 *
 */
public interface IVerify {

	/**
	 * Attempts to retrieve Course from Department based on provided courseId,
	 * returns null if not found.
	 * 
	 * @param courseId
	 * @return
	 */
	public Course verifyCourseId(String courseId);

	/**
	 * Attempts to retrieve Student from Department based on provided studentId,
	 * returns null if not found.
	 * 
	 * @param studentId
	 * @return
	 */
	public Student verifyStudentId(String studentId);
}
