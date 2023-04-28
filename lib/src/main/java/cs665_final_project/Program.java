package cs665_final_project;

import java.util.List;

/**
 * Parent class for DegreeProgram and CertificateProgram classes. Container
 * object for a list of courses
 * 
 * @author Tim Flucker
 *
 */
public abstract class Program {

	private String name;

	private List<Course> requiredCourses;

	public Program(String name, List<Course> requiredCourses) {
		super();
		this.name = name;
		this.requiredCourses = requiredCourses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getRequiredCourses() {
		return requiredCourses;
	}

	public void setRequiredCourses(List<Course> requiredCourses) {
		this.requiredCourses = requiredCourses;
	}

}
