package cs665_final_project.proxy;

import java.util.List;

import cs665_final_project.Course;
import cs665_final_project.Department;
import cs665_final_project.Student;

/**
 * Implements IVerify interface and initializes the IVerifyProxyImpl before
 * calling relevant method in the IVerifyProxyImpl.
 * 
 * @author Tim Flucker
 *
 */
public class IVerifyProxy implements IVerify {

	private static IVerify iVerify;

	private String semester;
	private List<Student> students;

	public IVerifyProxy(String semester, List<Student> students) {
		this.semester = semester;
		this.students = students;
	}

	@Override
	public Course verifyCourseId(String courseId) {
		if (iVerify == null) {
			iVerify = new IVerifyImpl(Department.getAllCourses(semester), students);
		}
		return iVerify.verifyCourseId(courseId);
	}

	@Override
	public Student verifyStudentId(String studentId) {
		if (iVerify == null) {
			iVerify = new IVerifyImpl(Department.getAllCourses(semester), students);
		}
		return iVerify.verifyStudentId(studentId);
	}

}
