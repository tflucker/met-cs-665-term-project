package cs665_final_project;

import java.util.List;

/**
 * Child class of the abstract Program class. Specific to 2-year certificate
 * programs offered by the Department
 * 
 * @author Tim Flucker
 *
 */
public class CertificateProgram extends Program {

	private Concentration concentration;

	public CertificateProgram(String name, List<Course> requiredCourses, Concentration concentration) {
		super(name, requiredCourses);
		this.concentration = concentration;
	}

	public Concentration getConcentration() {
		return concentration;
	}

	public void setConcentration(Concentration concentration) {
		this.concentration = concentration;
	}

	@Override
	public String toString() {
		return "CertificateProgram [concentration=" + concentration + ", getName()=" + getName()
				+ ", getRequiredCourses()=" + getRequiredCourses() + "]";
	}

}
