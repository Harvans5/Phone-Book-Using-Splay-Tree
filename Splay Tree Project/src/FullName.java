/**
 * Henry Arvans
 * Stores the full name of a person that is created and implements comaparable for the names 
 * that will compare in a lexicographical order
 * @author henryarvans
 *
 */
public class FullName implements Comparable<FullName> {
	private String firstName;
	private String lastName;
	/**
	 * Constructor for the full name of a person
	 * @param firstName
	 * @param lastName
	 */
	public FullName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	/**
	 * Returns the full name by last name then first
	 */
	public String toString() {
		return this.lastName + ", " + this.firstName;
	}
	/**
	 * Compares to names lexicographically 
	 */
	public int compareTo(FullName f) {
		int retval = this.lastName.compareTo(f.lastName);
		if (retval == 0) {
			return this.firstName.compareTo(f.firstName);
		}
		return retval;
	}
}

