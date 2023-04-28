package cs665_final_project.abstractFactory;

import cs665_final_project.util.FactoryType;

/**
 * Helper class for the AbstractFactory pattern, helps choose which factory to
 * instantiate and call the 'create' method. Used by the DepartmentFacade class.
 * 
 * @author Tim Flucker
 *
 */
public class FactoryProvider {

	/**
	 * Based on type determines which factory to initialize
	 * 
	 * @param type
	 * @return
	 */
	public static AbstractFactory getFactory(FactoryType type) {

		AbstractFactory factory = null;
		switch (type) {

		case DEPARTMENT:
			factory = new DepartmentFactory();
			break;
		case FACULTY:
			factory = new FacultyFactory();
			break;
		case PROGRAM:
			factory = new ProgramFactory();
			break;
		case COURSE:
			factory = new CourseFactory();
			break;
		case CONCENTRATION:
			factory = new ConcentrationFactory();
			break;
		default:
			System.err.println("Unrecognized factory type!");
			break;
		}

		return factory;
	}

}
