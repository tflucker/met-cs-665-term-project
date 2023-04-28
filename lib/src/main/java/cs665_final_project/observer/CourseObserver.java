package cs665_final_project.observer;

import java.util.List;

import cs665_final_project.Course;
import cs665_final_project.Student;

/**
 * Concrete implementation of the abstract Observer class. Handles how students
 * enroll / drop courses
 * 
 * @author Tim Flucker
 *
 */
public class CourseObserver extends Observer {

	public CourseObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void enrollStudent(Student student, boolean printToConsole) {
		String action = "Student Enrolled In Course";
		Course course = subject.getCourse();
		List<Student> enrolledStudents = course.getEnrolledStudents();
		if (enrolledStudents.size() < course.getEnrollmentLimit()) {
			enrolledStudents.add(student);
			System.out.println(
					"Student " + student.getStudentId() + " successfully enrolled in course " + course.getCourseId());

			// notify advisor when enrollment limit for the course has been reached
			if (enrolledStudents.size() == course.getEnrollmentLimit()) {
				System.out.println(
						"Enrollment limit reached for Course (" + course.getCourseId() + "): " + course.getName());
				printToConsole = true;
				action += ", Enrollment Limit Reached";
			}

		} else {
			action = "Student Added to Course Waitlist";
			System.out.println("Course " + course.getCourseId() + " has reached enrollment limit. Adding student "
					+ student.getStudentId() + " to waitlist for this class.");
			course.getWaitlistedStudents().add(student);
		}

		// notifies the courseInstructor and provides them with up-to-date information
		// about the course
		notifyCourseInstructor(action, printToConsole);
	}

	@Override
	public void dropStudent(Student student, boolean printToConsole) {
		String action = "Student Droped Course";
		Course course = subject.getCourse();
		List<Student> enrolledStudents = course.getEnrolledStudents();

		// remove student who requested to drop the class
		enrolledStudents.remove(student);
		System.out
				.println("Student " + student.getStudentId() + " successfully dropped course " + course.getCourseId());

		// check to see if the course has any waitlisted students
		if (enrolledStudents.size() < course.getEnrollmentLimit() && !course.getWaitlistedStudents().isEmpty()) {

			// get the first person who was waitlisted and add them to the course's enrolled
			// students
			Student toAdd = course.getWaitlistedStudents().removeFirst();
			System.out.println("Adding waitlisted student " + toAdd.getStudentId() + " to class!");
			enrolledStudents.add(toAdd);
			action += ", Waitlist Student Added";
		} else {
			System.out.println("No waitlisted students found.");
		}
		// notifies the courseInstructor and provides them with up-to-date information
		// about the course
		notifyCourseInstructor(action, printToConsole);

	}

	/**
	 * Prints console output that is some update for the course instructor,
	 * informing them of new students who have enrolled in or dropped from the
	 * course.
	 * 
	 * @param action
	 */
	private void notifyCourseInstructor(String action, boolean printToConsole) {
		if (printToConsole) {
			Course course = subject.getCourse();
			System.out.println(
					"\n------------------------------- Course Update Notification -------------------------------");
			System.out.println("Reason for Notification: " + action);
			System.out.println("Course (" + course.getCourseId() + "): " + course.getName());
			System.out.println("Instructor: " + course.getInstructor().getName());
			System.out.println("Enrollment Limit: " + course.getEnrollmentLimit());
			System.out
					.println("Available Spots: " + (course.getEnrollmentLimit() - course.getEnrolledStudents().size()));

			// prints enrolled students
			System.out.println("\nEnrolled Students: ");
			course.getEnrolledStudents().stream().forEach(student -> System.out.println("\t" + student.getStudentId()
					+ "\t\t" + student.getName() + "\t\t" + student.getPhoneNumber() + "\t\t" + student.getEmail()));

			// prints waitlisted students
			System.out.println("\nWaitlisted Students: ");
			course.getWaitlistedStudents().stream().forEach(student -> System.out.println("\t" + student.getStudentId()
					+ "\t\t" + student.getName() + "\t\t" + student.getPhoneNumber() + "\t\t" + student.getEmail()));
			System.out.println(
					"\n--------------------------------------------------------------------------------------------\n");
		}
	}
}
