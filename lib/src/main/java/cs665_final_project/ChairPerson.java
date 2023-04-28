package cs665_final_project;

/**
 * Child class of the abstract Faculty class. Specific to the person leading the
 * Department.
 * 
 * @author Tim Flucker
 *
 */
public class ChairPerson extends Faculty {

	private String courseId;

	public ChairPerson(String facultyId, String name, String phoneNumber, String email, String courseId) {
		super(facultyId, name, phoneNumber, email);
		this.courseId = courseId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "ChairPerson [course=" + courseId + ", getName()=" + getName() + ", getPhoneNumber()=" + getPhoneNumber()
				+ ", getEmail()=" + getEmail() + "]";
	}

	@Override
	public void printResponsibilities() {

		System.out.println("\n************** " + getClass().getSimpleName() + " **************");
		System.out.println("FacultyID: " + this.getFacultyId());
		System.out.println("Name: " + this.getName());
		System.out.println("Phone Number: " + this.getPhoneNumber());
		System.out.println("Email: " + this.getEmail());
		System.out.println("Instructor for Course ID: " + this.courseId);
		System.out.println("**************************************************************");

	}

}
