package cs665_final_project.abstractFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import cs665_final_project.Concentration;
import cs665_final_project.Department;
import cs665_final_project.Faculty;

/**
 * Class that leverages the AbstractFactory pattern to create new Concentration
 * objects which are associated to the Department.
 * 
 * @author Tim Flucker
 *
 */
public class ConcentrationFactory implements AbstractFactory {

	private static final String[] concentrationNames = { "Systems", "Programming Languages", "Databases",
			"Software Engineering" };
	private static final String[] subConcentrationNames = { "Procedural Languages", "Object Oriented Languages",
			"Functional Languages" };

	@Override
	public void create() {
		Department department = Department.getInstance();
		List<Faculty> fullTime = department.getFullTimeFaculty();
		List<Concentration> concentrationList = new ArrayList<>();

		// sorts list of full time faculty by facultyId in ascending order
		fullTime.sort(Comparator.comparing(Faculty::getFacultyId));

		for (int i = 0; i < concentrationNames.length; i++) {
			Concentration concentration = null;

			// create sub-concentrations for 'Programming Languages' concentration
			if (concentrationNames[i].equals("Programming Languages")) {
				List<Concentration> subConcentrations = new ArrayList<>();

				// creates list of subconcentrations based on array of SubConcentration names
				for (int j = 0; j < subConcentrationNames.length; j++) {
					subConcentrations.add(new Concentration(subConcentrationNames[j],
							fullTime.get(concentrationNames.length + j), new HashMap<>(), null));
				}
				concentration = new Concentration(concentrationNames[i], fullTime.get(i), new HashMap<>(),
						subConcentrations);

			} else {
				// create normal concentration, which does not have any sub-concentrations
				concentration = new Concentration(concentrationNames[i], fullTime.get(i), new HashMap<>(), null);

			}
			concentrationList.add(concentration);
		}
		department.setConcentrations(concentrationList);
		System.out.println("\tConcentrations created!");
	}
}
