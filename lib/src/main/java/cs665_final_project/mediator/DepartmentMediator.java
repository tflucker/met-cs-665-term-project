package cs665_final_project.mediator;

import java.util.ArrayList;
import java.util.List;

import cs665_final_project.Concentration;
import cs665_final_project.Course;
import cs665_final_project.Department;
import cs665_final_project.Faculty;
import cs665_final_project.FullTimeFaculty;

/**
 * Mediator class used for functionality specific to the Department object and
 * fields of that object
 * 
 * @author Tim Flucker
 *
 */
public class DepartmentMediator {

	private static Department department = Department.getInstance();

	/**
	 * Attempt to retrieve a concentration based on the provided name
	 * 
	 * @param name
	 * @return
	 */
	public static Concentration getConcentrationByName(String name) {
		Concentration concentration = department.getConcentrations().stream().filter(con -> con.getName().equals(name))
				.findFirst().orElse(null);

		// if concentration not found, check all sub-concentrations for value
		if (concentration == null) {
			for (Concentration con : department.getConcentrations()) {
				// if this concentration has sub-concentrations and concentration not found,
				// then check value
				if (con.getSubConcentrations() != null && concentration == null) {
					concentration = con.getSubConcentrations().stream().filter(subCon -> subCon.getName().equals(name))
							.findFirst().orElse(null);
				}
			}

		}
		return concentration;
	}
	
	public static Course getCourse(String courseId, String semester) {
		return getAllCourses(semester).stream().filter(course -> course.getCourseId().equals(courseId)).findFirst().orElse(null);
	}

	/**
	 * Retrieves the concentration supervisor for the provided concentration name
	 * parameter
	 * 
	 * @param concentrationName
	 * @return
	 */
	public FullTimeFaculty getConcentrationSupervisor(String concentrationName) {
		return (FullTimeFaculty) getConcentrationByName(concentrationName).getConcentrationCoordinator();
	}

	/**
	 * Retrieves a list of all courses for the department for all concentrations /
	 * subconcentrations.
	 * 
	 * @param semester
	 * @return
	 */
	public static List<Course> getAllCourses(String semester) {
		List<Course> masterCourseList = new ArrayList<>();
		// iterate through all concentrations and sub-concentrations to compile a
		// 'master' list of all courses for a given semester
		department.getConcentrations().stream().forEach(con -> {
			if (con.getCourses() != null && !con.getCourses().isEmpty() && !con.getCourses().get(semester).isEmpty()) {
				masterCourseList.addAll(con.getCourses().get(semester));
			} else {
				con.getSubConcentrations().stream().forEach(subCon -> {
					masterCourseList.addAll(subCon.getCourses().get(semester));
				});
			}

		});

		return masterCourseList;
	}
	
	
	/**
	 * Retrieves the FullTimeFaculty member who is the graduate student advisor.
	 * 
	 * @return
	 */
	public static Faculty getGraduateAdvisor() {
		return department.getFullTimeFaculty().stream().filter(faculty -> ((FullTimeFaculty) faculty).isGraduateAdvisor())
				.findFirst().orElse(null);
	}

	/**
	 * Retrieves the FullTimeFaculty member who is the undergraduate student
	 * advisor.
	 * 
	 * @return
	 */
	public static Faculty getUndergraduateAdvisor() {
		return department.getFullTimeFaculty().stream()
				.filter(faculty -> ((FullTimeFaculty) faculty).isUndergraduateAdvisor()).findFirst().orElse(null);
	}

}
