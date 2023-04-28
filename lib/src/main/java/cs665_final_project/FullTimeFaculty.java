package cs665_final_project;

import java.util.List;

/**
 * Child class of the abstract Faculty class. Specific to full time faculty
 * members who can lead course concentrations, be undergrad / graduate advisors,
 * and thesis advisors
 * 
 * @author Tim Flucker
 *
 */
public class FullTimeFaculty extends Faculty {

	public FullTimeFaculty(String facultyId, String name, String phoneNumber, String email, List<String> courseIds,
			boolean isGraduateAdvisor, boolean isUndergraduateAdvisor, List<Student> thesisAdvisees) {
		super(facultyId, name, phoneNumber, email);
		this.courseIds = courseIds;
		this.isGraduateAdvisor = isGraduateAdvisor;
		this.isUndergraduateAdvisor = isUndergraduateAdvisor;
		this.thesisAdvisees = thesisAdvisees;
	}

	private List<String> courseIds;

	private boolean isGraduateAdvisor;

	private boolean isUndergraduateAdvisor;

	private List<Student> thesisAdvisees;

	public List<String> getCourseIds() {
		return courseIds;
	}

	public void setCourseIds(List<String> courseIds) {
		this.courseIds = courseIds;
	}

	public boolean isGraduateAdvisor() {
		return isGraduateAdvisor;
	}

	public void setGraduateAdvisor(boolean isGraduateAdvisor) {
		this.isGraduateAdvisor = isGraduateAdvisor;
	}

	public boolean isUndergraduateAdvisor() {
		return isUndergraduateAdvisor;
	}

	public void setUndergraduateAdvisor(boolean isUndergraduateAdvisor) {
		this.isUndergraduateAdvisor = isUndergraduateAdvisor;
	}

	public List<Student> getThesisAdvisees() {
		return thesisAdvisees;
	}

	public void setThesisAdvisees(List<Student> thesisAdvisees) {
		this.thesisAdvisees = thesisAdvisees;
	}

	@Override
	public String toString() {
		return "FullTimeFaculty [courseIds=" + courseIds.toString() + ", isGraduateAdvisor=" + isGraduateAdvisor
				+ ", isUndergraduateAdvisor=" + isUndergraduateAdvisor + ", thesisAdvisees=" + thesisAdvisees
				+ ", getName()=" + getName() + ", getPhoneNumber()=" + getPhoneNumber() + ", getEmail()=" + getEmail()
				+ "]";
	}

	@Override
	public void printResponsibilities() {
		System.out.println("\n************** " + getClass().getSimpleName() + " **************");
		System.out.println("FacultyID: " + this.getFacultyId());
		System.out.println("Name: " + this.getName());
		System.out.println("Phone Number: " + this.getPhoneNumber());
		System.out.println("Email: " + this.getEmail());
		// prints courseIds this faculty member is teaching
		if (this.courseIds != null && !this.courseIds.isEmpty()) {
			System.out.println("Instructor for Course IDs:");
			this.courseIds.stream().forEach(c -> System.out.println("\t" + c));
		}

		// prints student information this faculty member is advising for their thesis
		if (this.thesisAdvisees != null && !this.thesisAdvisees.isEmpty()) {
			System.out.println("Thesis Advisees:");
			this.thesisAdvisees.stream().forEach(student -> System.out
					.println("\t" + student.getStudentId() + "\t" + student.getName() + "\t" + student.getEmail()));
		}
		System.out.println("**************************************************************");

	}

}
