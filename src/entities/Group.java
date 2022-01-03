package entities;

public class Group extends GroupedEntity {
	public Group(String id) {
		super(id);
	}
	
	/**
	 * Groups have their priority scores increased by {@code 5}
	 */
	@Override
	public int getPriority() {
		// Group bonus is added to the total priority score
		return 5 + super.getPriority();
	}
}
