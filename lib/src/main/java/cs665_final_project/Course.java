package cs665_final_project;

import java.util.LinkedList;
import java.util.List;

/**
 * Contains relevant information to a university course. This is a major class
 * that many different methods and design patterns interact with.
 * 
 * @author Tim Flucker
 *
 */
public class Course {

	private String courseId;

	private String name;

	private String description;

	private String syllabusLink;

	private Faculty instructor;

	private Concentration concentration;

	private Integer enrollmentLimit;

	private List<Student> enrolledStudents;

	private LinkedList<Student> waitlistedStudents;

	public Course(String courseId, String name, String description, String syllabusLink, Faculty instructor,
			Concentration concentration, Integer enrollmentLimit, List<Student> enrolledStudents,
			LinkedList<Student> waitlistedStudents) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.description = description;
		this.syllabusLink = syllabusLink;
		this.instructor = instructor;
		this.concentration = concentration;
		this.enrollmentLimit = enrollmentLimit;
		this.enrolledStudents = enrolledStudents;
		this.waitlistedStudents = waitlistedStudents;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSyllabusLink() {
		return syllabusLink;
	}

	public void setSyllabusLink(String syllabusLink) {
		this.syllabusLink = syllabusLink;
	}

	public Faculty getInstructor() {
		return instructor;
	}

	public void setInstructor(Faculty instructor) {
		this.instructor = instructor;
	}

	public Concentration getConcentration() {
		return concentration;
	}

	public void setConcentration(Concentration concentration) {
		this.concentration = concentration;
	}

	public Integer getEnrollmentLimit() {
		return enrollmentLimit;
	}

	public void setEnrollmentLimit(Integer enrollmentLimit) {
		this.enrollmentLimit = enrollmentLimit;
	}

	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public LinkedList<Student> getWaitlistedStudents() {
		return waitlistedStudents;
	}

	public void setWaitlistedStudents(LinkedList<Student> waitlistedStudents) {
		this.waitlistedStudents = waitlistedStudents;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", description=" + description + ", syllabusLink=" + syllabusLink
				+ ", instructor=" + instructor + ", concentration=" + concentration.getName() + ", enrollmentLimit="
				+ enrollmentLimit + "]";
	}
	
	public void format() {
		int currentClassSize = this.getEnrolledStudents().size();
		int maxSize = this.getEnrollmentLimit();
		
		String status = (maxSize == currentClassSize) ? "FULL ENROLLMENT" : "SEATS AVAILABLE - " + String.valueOf(maxSize-currentClassSize);
		
		System.out.println("\n-------------- Course Information --------------");
		System.out.println("Course ID: " + this.getCourseId());
		System.out.println("Course Name: " + this.getName());
		System.out.println("Course Description: " + this.getDescription());
		System.out.println("Course syllabusLink: " + this.getSyllabusLink());
		System.out.println("Course Status: " + status);
		
		if(status == "FULL ENROLLMENT") {
			System.out.println("Waitlisted Students: ");
			// prints line for every element in the list
			this.getWaitlistedStudents().stream().forEach(student -> System.out.println("\t" + student.getStudentId()
			+ "\t\t" + student.getName() + "\t\t" + student.getPhoneNumber() + "\t\t" + student.getEmail()));
		}
		System.out.println("-------------------------------------------------------");
	}

}
