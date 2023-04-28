package cs665_final_project;

import java.util.List;

/**
 * Child class of the abstract Program class. Specific to traditional 4-year
 * degree programs offered by the Department
 * 
 * @author Tim Flucker
 *
 */
public class DegreeProgram extends Program {

	private String type;

	private Integer programLength;

	private List<Course> electiveCourses;

	private boolean thesisRequired;

	public DegreeProgram(String name, String type, Integer programLength, List<Course> requiredCourses,
			List<Course> electiveCourses, boolean thesisRequired) {
		super(name, requiredCourses);
		this.type = type;
		this.programLength = programLength;
		this.electiveCourses = electiveCourses;
		this.thesisRequired = thesisRequired;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getProgramLength() {
		return programLength;
	}

	public void setProgramLength(Integer programLength) {
		this.programLength = programLength;
	}

	public List<Course> getElectiveCourses() {
		return electiveCourses;
	}

	public void setElectiveCourses(List<Course> electiveCourses) {
		this.electiveCourses = electiveCourses;
	}

	public boolean isThesisRequired() {
		return thesisRequired;
	}

	public void setThesisRequired(boolean thesisRequired) {
		this.thesisRequired = thesisRequired;
	}

	@Override
	public String toString() {
		return "DegreeProgram [type=" + type + ", programLength=" + programLength + ", requiredCourses="
				+ getRequiredCourses() + ", electiveCourses=" + electiveCourses + ", thesisRequired=" + thesisRequired
				+ ", getName()=" + getName() + "]";
	}

}
