package controller;

import db.BookingDAO;
import db.BookingDB;
import db.DataAccessException;
import model.Booking;

public class BookingCtr {

    private BookingDAO bookingDAO;

    public BookingCtr() {
        bookingDAO = new BookingDB();
    }

    public Booking findByBaneId(int baneId) throws DataAccessException {
        return bookingDAO.findByBaneId(baneId);
    }
} 