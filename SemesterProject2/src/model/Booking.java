package model;

import java.time.LocalDate;

public class Booking {
	private LocalDate date;
	private int baneId;

	public Booking(LocalDate date, int baneId) {
	this.date = date;
	this.baneId = baneId;
	
}

	public LocalDate getDate() { 
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getBaneId() {
		return baneId;
	}

	public void setBaneId(int baneId) {
		this.baneId = baneId;
	}
	
	@Override
	public String toString() {
	    return "Booking [date=" + date + ", baneId=" + baneId + "]";
	}
}
