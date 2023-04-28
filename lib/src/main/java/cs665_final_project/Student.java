package cs665_final_project;

import java.util.List;
import java.util.Map;

import cs665_final_project.mediator.StudentMediator;

/**
 * Represents a student who attends a university and takes classes offered by
 * the Department.
 * 
 * @author Tim Flucker
 *
 */
public class Student {

	private String studentId;

	private String name;

	private String phoneNumber;

	private String email;

	private Map<String, List<Course>> courses;

	private Program enrolledProgram;

	private FullTimeFaculty thesisAdvisor;

	private String thesisTopic;

	public Student(String studentId, String name, String phoneNumber, String email, Map<String, List<Course>> courses,
			Program enrolledProgram, FullTimeFaculty thesisAdvisor, String thesisTopic) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.courses = courses;
		this.enrolledProgram = enrolledProgram;
		this.thesisAdvisor = thesisAdvisor;
		this.thesisTopic = thesisTopic;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, List<Course>> getCourses() {
		return courses;
	}

	public void setCourses(Map<String, List<Course>> courses) {
		this.courses = courses;
	}

	public Program getEnrolledProgram() {
		return enrolledProgram;
	}

	public void setEnrolledProgram(Program enrolledProgram) {
		this.enrolledProgram = enrolledProgram;
	}

	public FullTimeFaculty getThesisAdvisor() {
		return thesisAdvisor;
	}

	public void setThesisAdvisor(FullTimeFaculty thesisAdvisor) {
		this.thesisAdvisor = thesisAdvisor;
	}

	public String getThesisTopic() {
		return thesisTopic;
	}

	public void setThesisTopic(String thesisTopic) {
		this.thesisTopic = thesisTopic;
	}

	@Override
	public String toString() {
		return "Student [studentId = " + studentId + " name=" + name + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", courses=" + courses + ", enrolledProgram=" + enrolledProgram.getName() + ", thesisAdvisor="
				+ thesisAdvisor.getName() + ", thesisTopic=" + thesisTopic + "]";
	}

	public void getGPA() {
		StudentMediator.getGPA(this);
	}

}
