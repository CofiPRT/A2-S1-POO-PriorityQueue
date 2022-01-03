package entities;

import persondata.Person;

public abstract class Entity {
	String id;
	
	public Entity(String id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return	The ID of the entity
	 */
	public String getID() {
		return id;
	}
	
	public abstract void addPerson(Person newPerson);
	
	public abstract void removePerson(String personName);
	
	public abstract int getPriority();
}
