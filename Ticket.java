

public final class Ticket {
	private int ticket_number;
	private Integer[][] displayOfNos;
    private Ticket(int ticket_number,Integer[][] displayOfNos){
		this.ticket_number=ticket_number;
		this.displayOfNos=displayOfNos;
	}
	public static Ticket generateTicket(int ticket_number,Integer[][] displayOfNos){
		return new Ticket(ticket_number,displayOfNos);
	}
	public void getTicketNumber(){
		return this.ticket_number;
	} 
	public void getFinalArray(){
		return this.displayOfNos;
	}
}
