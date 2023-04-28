package cs665_final_project.abstractFactory;

/**
 * Interface used to define methods that each Factory class will use to create
 * application data.
 * 
 * @author Tim Flucker
 *
 */
public interface AbstractFactory {

	/**
	 * Creates data based on the factory implementing the AbstractFactory. Method is
	 * void because all data is set in the singleton instance of Department.
	 * 
	 * @return
	 */
	public void create();
}
