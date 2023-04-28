package cs665_final_project.observer;

import java.util.ArrayList;
import java.util.List;

import cs665_final_project.Course;
import cs665_final_project.Student;

/**
 * Used with the Observer class, set information to be used in the concrete
 * Observer class (CourseObserver).
 * 
 * @author Tim Flucker
 *
 */
public class Subject {

	private List<Observer> observers = new ArrayList<>();
	private Course course;
	private Student student;

	public Subject(Course course) {
		this.course = course;
	}

	/**
	 * Entry point to the Observer functionality and sets Student object
	 * 
	 * @param student
	 * @param action
	 * @param printToConsole 
	 */
	public void takeAction(Student student, String action, boolean printToConsole) {
		this.student = student;
		notifyCourseInstructor(action, printToConsole);
	}

	/**
	 * Loops through all observers and notifies the course instructor of the
	 * relevant course that was affected
	 * 
	 * @param action
	 */
	public void notifyCourseInstructor(String action, boolean printToConsole) {
		// iterate through observers to find relevant courseObserver
		for (Observer o : observers) {
			if (o.subject.getCourse() == course) {

				// call either "enroll" or "drop" observer method based on 'action' parameter
				if (action.equals("ENROLL")) {
					o.enrollStudent(student, printToConsole);
				} else if (action.equals("DROP")) {
					o.dropStudent(student, printToConsole);
				} else {
					System.out.println("Unrecognized action");
				}
			}
		}
	}

	/**
	 * Adds Observer to list
	 * 
	 * @param observer
	 */
	public void attach(Observer observer) {
		observers.add(observer);
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
