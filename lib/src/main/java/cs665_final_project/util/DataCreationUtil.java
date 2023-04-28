package cs665_final_project.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import cs665_final_project.Department;
import cs665_final_project.Faculty;
import cs665_final_project.FullTimeFaculty;

/**
 * Utility class used to aid in the creation of random data for Student and
 * Faculty objects
 * 
 * @author Tim Flucker
 *
 */
public class DataCreationUtil {

	/**
	 * Generates a random phone number with the format (ex. 123-456-7890)
	 * 
	 * @return
	 */
	public static String generateRandomPhoneNumber() {

		Random rand = new Random();
		int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
		int num2 = rand.nextInt(743);
		int num3 = rand.nextInt(10000);

		DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
		DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

		return df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
	}

	/**
	 * Generates a random name from a bank of 30 unique first names and 30 unique
	 * last names and returns a String value.
	 * 
	 * @return
	 */
	public static String generateRandomName() {

		// 30 random first names
		String[] firstNames = { "Alex", "George", "David", "Andrew", "Michael", "Steven", "Tim", "Jacob", "Gabriel",
				"Matthew", "Scott", "Zachary", "Tom", "Edward", "Jack", "Garrett", "Jean", "Donald", "James", "Brandon",
				"Joseph", "Isaac", "Ivan", "Igor", "Vlad", "Jonah", "Philip", "Marco", "Troy", "Simon" };
		// 30 random last names
		String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis",
				"Rodriguez", "Martinez", "Hernandez", "Lopez", "Anderson", "Taylor", "Moore", "Jackson", "White",
				"Harris", "Thompson", "Clark", "Lewis", "Allen", "King", "Wright", "Sanchez", "Harris", "Hill", "Baker",
				"Nelson", "Carter" };

		return firstNames[new Random().nextInt(firstNames.length)] + " "
				+ lastNames[new Random().nextInt(lastNames.length)];

	}

	/**
	 * Generates an Boston University email address based on the provided name.
	 * 
	 * @param name
	 * @return
	 */
	public static String generateEmail(String name) {

		// split provided name
		String[] parts = name.split(" ");

		// return string with format (ex. John Doe --> jDoe@bu.edu)
		return String.valueOf(parts[0].charAt(0)).toLowerCase() + parts[1] + "@bu.edu";
	}

	/**
	 * Selects a random FullTimeFaculty element from the department's
	 * fullTimeFaculty list. Used when creating new Student objects.
	 * 
	 * @param department
	 * @return
	 */
	public static FullTimeFaculty selectRandomThesisAdvisor(Department department) {
		Random rand = new Random();
		List<Faculty> thesisAdvisors = department.getFullTimeFaculty();

		// returns random element from list based on the size of the list
		return (FullTimeFaculty) thesisAdvisors.get(rand.nextInt(thesisAdvisors.size()));

	}

	/**
	 * returns a random string element from the thesis topic list. Used when
	 * creating new Student objects.
	 * 
	 * @return
	 */
	public static String selectThesisTopic() {
		Random rand = new Random();
		List<String> thesisTopics = Arrays.asList("Role of human-computer interaction",
				"Artificial Intelligence potential for optimizing renewable energy ",
				"Role of Machine Leanring for Human Prosthetics",
				"Quantum Computing and predicting future stock trends",
				"Using Artificial Intelligence to improve child education and curriculum.",
				"Redefining benchmarks for Artifical Intelligence critical thinking", "Machine Learning in chat-bots");

		return thesisTopics.get(rand.nextInt(thesisTopics.size()));
	}
}
