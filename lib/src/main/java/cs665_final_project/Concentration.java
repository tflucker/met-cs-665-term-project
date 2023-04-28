package cs665_final_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A group of courses that can be grouped to together. Each concentration can
 * have sub-concentrations, and many concentrations are part of the Department.
 * A concentration also dictates the courses in a Certificate program.
 * 
 * @author Tim Flucker
 *
 */
public class Concentration {

	private String name;

	private Faculty concentrationCoordinator;

	private Map<String, List<Course>> courses;

	private List<Concentration> subConcentrations;

	public Concentration(String name, Faculty concentrationCoordinator, Map<String, List<Course>> courses,
			List<Concentration> subConcentrations) {
		super();
		this.name = name;
		this.concentrationCoordinator = concentrationCoordinator;
		this.courses = courses;
		this.subConcentrations = subConcentrations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Faculty getConcentrationCoordinator() {
		return concentrationCoordinator;
	}

	public void setConcentrationCoordinator(Faculty concentrationCoordinator) {
		this.concentrationCoordinator = concentrationCoordinator;
	}

	public Map<String, List<Course>> getCourses() {
		return courses;
	}

	public void setCourses(Map<String, List<Course>> courses) {
		this.courses = courses;
	}

	public List<Concentration> getSubConcentrations() {
		return subConcentrations;
	}

	public void setSubConcentrations(List<Concentration> subConcentrations) {
		this.subConcentrations = subConcentrations;
	}

	@Override
	public String toString() {
		return "Concentration [name=" + name + ", concentrationCoordinator=" + concentrationCoordinator + ", courses="
				+ courses + ", subConcentrations=" + subConcentrations + "]";
	}

	public void format(String semester) {
		List<Course> courses = this.getCourses().get(semester);

		System.out.println("\n--------------------- " + this.getName() + " Information ---------------------");

		// if the concentration has no courses, but has sub-concentrations, then get
		// courses associated to each sub-concentration
		if (courses == null || courses.isEmpty()) {
			courses = new ArrayList<>();
			for (Concentration sub : this.getSubConcentrations()) {
				courses.addAll(sub.getCourses().get(semester));
			}
		}

		// for each course, call the format method which prints console output with
		// important information for each course
		courses.stream().forEach(course -> course.format());		
	}

}
