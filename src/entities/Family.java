package entities;

public class Family extends GroupedEntity {
	public Family(String id) {
		super(id);
	}
	
	/**
	 * Families have their priority score increased by {@code 10}
	 */
	@Override
	public int getPriority() {
		// Family bonus is added to the total priority score
		return 10 + super.getPriority();
	}	
}
