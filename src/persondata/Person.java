package persondata;

public class Person {
	private String personName;
	private int age;
	private Ticket ticket;
	private Benefits personBenefits;
	
	public Person(String personName, int age, String ticketType,
			boolean hasPriorityBoarding, boolean hasSpecialNeeds) {
		this.personName = personName;
		this.age = age;
		ticket = new Ticket(ticketType);
		personBenefits = new Benefits(hasPriorityBoarding, hasSpecialNeeds);
	}
	
	public Person(String personName) {
		this.personName = personName;
		age = 0;
		ticket = null;
		personBenefits = null;
	}
	
	/**
	 * 
	 * @return	The bonus priority score based on the age category
	 */
	private int agePriority() {
		if (age < 2) return 20;
		if (age < 5) return 10;
		if (age < 10) return 5;
		if (age < 60) return 0;
		// over 60
		return 15;
	}
	
	/**
	 * Getter for {@code personName}
	 * @return	The name of the person
	 */
	public String getName() {
		return personName;
	}
	
	/**
	 * Calculates the total priority score of the person by adding priorities
	 * from age category, ticket type and offered benefits.
	 * @return	Total priority score of the person
	 */
	public int getPriority() {
		// total priority score of the person
		return agePriority() + ticket.getPriority()
				+ personBenefits.getPriority();
	}
}
