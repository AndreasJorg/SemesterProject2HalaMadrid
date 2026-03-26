package gui;

import java.time.LocalDate;

import controller.BookingCtr;
import db.DataAccessException;
import model.Booking;

public class TestDB {
	
 public static void main(String[] args) throws DataAccessException {
	
     BookingCtr ctr = new BookingCtr();

     Booking booking = ctr.findByBaneId(1);

     System.out.println(booking); 
}
}
 