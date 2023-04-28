package cs665_final_project;

import java.util.LinkedList;
import java.util.List;

/**
 * Child class of the Course class. Used to distinguish between classes that
 * have been previously completed and courses that are in-progress.
 * 
 * @author Tim Flucker
 *
 */
public class CompletedCourse extends Course {

	private String semesterCompleted;

	private Integer grade;

	public CompletedCourse(String courseId, String name, String description, String syllabusLink, Faculty instructor,
			Concentration concentration, Integer enrollmentLimit, List<Student> enrolledStudents,
			LinkedList<Student> waitlistedStudents, String semesterCompleted, Integer grade) {
		super(courseId, name, description, syllabusLink, instructor, concentration, enrollmentLimit, enrolledStudents,
				waitlistedStudents);
		this.semesterCompleted = semesterCompleted;
		this.grade = grade;
	}

	public CompletedCourse(Course course, String semesterCompleted, Integer grade) {
		super(course.getCourseId(), course.getName(), course.getDescription(), course.getSyllabusLink(),
				course.getInstructor(), course.getConcentration(), course.getEnrollmentLimit(),
				course.getEnrolledStudents(), course.getWaitlistedStudents());
		this.semesterCompleted = semesterCompleted;
		this.grade = grade;
	}

	public String getSemesterCompleted() {
		return semesterCompleted;
	}

	public void setSemesterCompleted(String semesterCompleted) {
		this.semesterCompleted = semesterCompleted;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

}
