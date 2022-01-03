package entities;

import java.util.Vector;

import persondata.Person;

public class GroupedEntity extends Entity {
	Vector<Person> members;
	
	public GroupedEntity(String id) {
		super(id);
		members = new Vector<Person>(1);
	}
	
	/**
	 * Adds a new person among the members of the entity
	 * @param newPerson	The {@code Person} to be added
	 */
	@Override
	public void addPerson(Person newPerson) {
		members.add(newPerson);
	}
	
	/**
	 * Searches for a person with the given name and removes them from
	 * this entity
	 * @param personName	The {@code name} of the person to be removed
	 */
	@Override
	public void removePerson(String personName) {
		for (int i = 0; i < members.size(); i++) {
			// find the index
			if (members.get(i).getName().equals(personName)) {
				members.remove(i);
			}
		}
	}
	
	/**
	 * Calculates the total priority score by calculating
	 * the individual priority scores of every {@code member}
	 * @return	The total priority score of this entity
	 */
	@Override
	public int getPriority() {
		/* add the priorities of all the members
		 * of this Entity
		 */
		int result = 0;
		for (int i = 0; i < members.size(); i++) {
			result += members.get(i).getPriority();
		}
		
		return result;
	}
}
