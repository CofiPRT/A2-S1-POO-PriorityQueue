package entities;

import persondata.Person;

public class Single extends Entity {
	private Person singlePerson;
	
	public Single(String id) {
		super(id);
		singlePerson = null;
	}
	
	/**
	 * Checks beforehand if another person is registered to the entity, for
	 * only one person may exist in this type of entity.
	 * If everything is good, register the person to the entity.
	 * @param newPerson	Person to be added
	 */
	public void addPerson(Person newPerson) {
		if (singlePerson != null) {
			// Single admits only one Person, should not happen
			System.out.println("A Single Entity cannot have more"
					+ "than one member!");
		}
		
		singlePerson = newPerson;
	}
	
	public void removePerson(String personName) {
		if (singlePerson.getName().equals(personName)) {
			singlePerson = null;
		} else {
			// should not happen
			System.out.println("No match for single person "
						+ singlePerson.getName() + " and " + personName);
		}
	}
	
	/**
	 * NO BONUS priority score is given for Single type
	 * @return	Priority score of the person
	 */
	public int getPriority() {
		return singlePerson.getPriority();
	}
	
	public String getName() {
		return singlePerson.getName();
	}
	
}
