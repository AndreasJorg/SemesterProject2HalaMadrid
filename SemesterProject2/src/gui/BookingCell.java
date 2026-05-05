package gui;

public class BookingCell {
	private String text;
	private Cellstatus status;
	
	public BookingCell(String text, Cellstatus status) {
		this.text = text;
		this.status = status;
	}
	
	public String getText() {
		return text; 
	} 
	
	public Cellstatus getStatus() {
		return status;
	}
	@Override
	public String toString() {
	    return text;
	}
}