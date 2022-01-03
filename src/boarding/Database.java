package boarding;

import java.util.Vector;

import entities.Entity;
import entities.Family;
import entities.Group;
import entities.Single;
import persondata.Person;

public class Database {
	// entities waiting to be inserted into the priority queue
	private Vector<Entity> entities;
	
	public Database() {
		entities = new Vector<Entity>(1);
	}
	
	/**
	 * Searches for an entity with a specific ID and
	 * registers the person into that entity.
	 * If the entity does not exists, it gets created.
	 * @param newPerson The person to be registered
	 * @param entityID 	The ID of the entity the person should be registered to
	 */
	public void registerPerson(Person newPerson, String entityID) {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.elementAt(i).getID().equals(entityID)) {
				// entity already exists
				entities.elementAt(i).addPerson(newPerson);
				return;
			}
		}
		
		// entityID has not been found, create it
		createEntity(entityID);
		// add this Person to the newly created Entity
		entities.lastElement().addPerson(newPerson);
	}
	
	/**
	 * Searches for an entity in the database with
	 * the given ID and returns it
	 * if it's found
	 * @param entityID 	The ID of the entity to be searched
	 * @return 			The found entity or {@code null} if it hasn't been found
	 */
	public Entity extractEntity(String entityID) {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).getID().equals(entityID)) {
				return entities.remove(i);
			}
		}
		
		// entityID has not been found, should not reach here
		System.out.println("No entity exists "
				+ "for entityID: " + entityID);
		
		return null;
	}
	
	/**
	 * Creates a new entity in the database with the given ID, ready to register
	 * people
	 * @param entityID	The ID of the entity to be created
	 */
	private void createEntity(String entityID) {
		// create corresponding entity type
		if (entityID.charAt(0) == 's') {
			entities.add(new Single(entityID));
			return;
		}
		if (entityID.charAt(0) == 'g') {
			entities.add(new Group(entityID));
			return;
		}
		if (entityID.charAt(0) == 'f') {
			entities.add(new Family(entityID));
			return;
		}
		
		// no entity type has been found, should not happen
		System.out.println("No entity type has been found for"
				+ "entity: " + entityID);
	}
}
