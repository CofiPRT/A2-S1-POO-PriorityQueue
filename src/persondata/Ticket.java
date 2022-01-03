package persondata;

public class Ticket {
	private String ticketType;
	
	public Ticket (String ticketType) {
		this.ticketType = ticketType;
	}
	
	/**
	 * 
	 * @return	The bonus priority score based on the ticket type
	 */
	public int getPriority() {
		if (ticketType.equals("e")) {
			// Economy Ticket
			return 0;
		}
		if (ticketType.equals("p")) {
			// Premium Ticket
			return 20;
		}
		if (ticketType.equals("b")) {
			// Business Ticket
			return 35;
		}
		
		// should not reach here
		System.out.println("No ticket found for type: "	+ ticketType);
		return 0;
	}
}
