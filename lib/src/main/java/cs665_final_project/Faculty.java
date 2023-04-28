package cs665_final_project;

/**
 * Abstract class which is used as a parent class for other types of faculty.
 * 
 * @author Tim Flucker
 *
 */
public abstract class Faculty {

	private String facultyId;

	private String name;

	private String phoneNumber;

	private String email;

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
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

	public Faculty(String facultyId, String name, String phoneNumber, String email) {
		super();
		this.facultyId = facultyId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	/**
	 * Prints important information for a Faculty member, different concrete
	 * implementations for ChairPerson, PartTimeFaculty, and FullTimeFaculty. 
	 */
	public abstract void printResponsibilities();

}
