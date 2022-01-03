package persondata;

public class Benefits {
	boolean hasPriorityBoarding;
	boolean hasSpecialNeeds;
	
	public Benefits(boolean hasPriorityBoarding, boolean hasSpecialNeeds) {
		this.hasPriorityBoarding = hasPriorityBoarding;
		this.hasSpecialNeeds = hasSpecialNeeds;
	}
	
	/**
	 * Calculates the priority score of the benefits by checking which ones
	 * are offered
	 * @return	The total bonus priority score of the benefits
	 */
	public int getPriority() {
		/* no bonus priority score is given if
		 * the benefit is not offered
		 */
		int result = 0;
		result += hasSpecialNeeds ? 100 : 0;
		result += hasPriorityBoarding ? 30 : 0;
		
		return result;
	}
}
