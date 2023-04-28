package cs665_final_project.proxy;

import java.util.List;

import cs665_final_project.Course;
import cs665_final_project.Student;

/**
 * Filters through provided lists to information that matches input, returns
 * null if not found.
 * 
 * @author Tim Flucker
 *
 */
public class IVerifyImpl implements IVerify {

	private List<Course> courseList;
	private List<Student> students;

	public IVerifyImpl(List<Course> courseList, List<Student> students) {
		this.courseList = courseList;
		this.students = students;
	}

	@Override
	public Course verifyCourseId(String courseId) {
		return courseList.stream().filter(c -> c.getCourseId().equals(courseId)).findFirst().orElse(null);
	}

	@Override
	public Student verifyStudentId(String studentId) {
		return students.stream().filter(s -> s.getStudentId().equals(studentId)).findFirst().orElse(null);
	}

}
