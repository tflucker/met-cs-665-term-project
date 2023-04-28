package cs665_final_project;

import java.util.List;

import cs665_final_project.mediator.DepartmentMediator;

/**
 * The main container object used in this application. Uses a singleton pattern
 * to maintain a signle instance during runtime execution.
 * 
 * @author Tim Flucker
 *
 */
public class Department {

	// static instance used for singleton pattern
	private static Department department;

	/**
	 * Used to enforce the singleton pattern for the Department class.
	 * 
	 * @return
	 */
	public static Department getInstance() {

		if (department == null) {
			department = new Department();
		}
		return department;
	}

	private String name;

	private ChairPerson chairperson;

	private List<Concentration> concentrations;

	private List<Faculty> fullTimeFaculty;

	private List<Faculty> partTimeFaculty;

	private List<Program> degreePrograms;

	private List<Program> certificatePrograms;

	private Department() {
		System.out.println("** IMPORTANT ** Use Singleton pattern to maintain one instance of the Department object!");
	};

	public Department(String name, List<Concentration> concentrations, ChairPerson chairperson,
			List<Faculty> fullTimeFaculty, List<Faculty> partTimeFaculty, List<Program> degreePrograms,
			List<Program> certificatePrograms) {
		super();
		this.name = name;
		this.concentrations = concentrations;
		this.chairperson = chairperson;
		this.fullTimeFaculty = fullTimeFaculty;
		this.partTimeFaculty = partTimeFaculty;
		this.degreePrograms = degreePrograms;
		this.certificatePrograms = certificatePrograms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Concentration> getConcentrations() {
		return concentrations;
	}

	public void setConcentrations(List<Concentration> concentrations) {
		this.concentrations = concentrations;
	}

	public ChairPerson getChairperson() {
		return chairperson;
	}

	public void setChairperson(ChairPerson chairperson) {
		this.chairperson = chairperson;
	}

	public List<Faculty> getFullTimeFaculty() {
		return fullTimeFaculty;
	}

	public void setFullTimeFaculty(List<Faculty> fullTimeFaculty) {
		this.fullTimeFaculty = fullTimeFaculty;
	}

	public List<Faculty> getPartTimeFaculty() {
		return partTimeFaculty;
	}

	public void setPartTimeFaculty(List<Faculty> partTimeFaculty) {
		this.partTimeFaculty = partTimeFaculty;
	}

	public List<Program> getDegreePrograms() {
		return degreePrograms;
	}

	public void setDegreePrograms(List<Program> degreePrograms) {
		this.degreePrograms = degreePrograms;
	}

	public List<Program> getCertificatePrograms() {
		return certificatePrograms;
	}

	public void setCertificatePrograms(List<Program> certificatePrograms) {
		this.certificatePrograms = certificatePrograms;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", chairperson=" + chairperson + ", concentrations=" + concentrations
				+ ", fullTimeFaculty=" + fullTimeFaculty + ", partTimeFaculty=" + partTimeFaculty + ", degreePrograms="
				+ degreePrograms + ", certificatePrograms=" + certificatePrograms + "]";
	}

	/**
	 * Mediator method that retrieves a concentration object based on the 'name'
	 * method parameter
	 * 
	 * @param name
	 * @return
	 */
	public static Concentration getConcentrationByName(String name) {
		return DepartmentMediator.getConcentrationByName(name);
	}

	/**
	 * Mediator method that retrieves all courses for the department for a
	 * particular semester
	 * 
	 * @param name
	 * @return
	 */
	public static List<Course> getAllCourses(String semester) {
		return DepartmentMediator.getAllCourses(semester);
	}

	/**
	 * Retrieves the FullTimeFaculty member who is the graduate student advisor.
	 * 
	 * @return
	 */
	public Faculty getGraduateAdvisor() {
		return DepartmentMediator.getGraduateAdvisor();
	}

	/**
	 * Retrieves the FullTimeFaculty member who is the undergraduate student
	 * advisor.
	 * 
	 * @return
	 */
	public Faculty getUndergraduateAdvisor() {
		return DepartmentMediator.getUndergraduateAdvisor();
	}

}
