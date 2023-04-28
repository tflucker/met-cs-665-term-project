package cs665_final_project.observer;

import cs665_final_project.Student;

/**
 * Abstract class which defines methods for concrete implemenations of this
 * Observer. Methods are related to students enrolling in or dropping a course.
 * 
 * @author Tim Flucker
 *
 */
public abstract class Observer {

	public Subject subject;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * Enrolls a student in the subject's course. If enrollment limit has been
	 * reached, the student will be added to a waitlist for the course instead of
	 * being enrolled.
	 * 
	 * @param student
	 */
	public abstract void enrollStudent(Student student, boolean printToConsole);

	/**
	 * Drops the student from the subject's course. If there are any student's on
	 * the waitlist, then the first student in the waitlist will be enrolled in the
	 * course.
	 * 
	 * @param student
	 */
	public abstract void dropStudent(Student student, boolean printToConsole);

}
