package controller;

import java.util.List;

import db.BookingDAO;
import db.BookingDB;
import db.DataAccessException;
import model.Booking;

public class BookingCtr {

    private BookingDAO bookingDAO;

    public BookingCtr() {
        bookingDAO = new BookingDB();
    }
    
    public void createBooking(Booking booking) throws DataAccessException {
    	bookingDAO.createBooking(booking);
    	
    }
    
    public List<Booking> findAllBookings() throws DataAccessException {
    	return bookingDAO.findAllBookings();
    }
} 