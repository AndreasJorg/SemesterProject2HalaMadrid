package db;

import java.util.List;

import model.Booking;

public interface BookingDAO {


	List<Booking> findAllBookings() throws DataAccessException;

	void createBooking(Booking booking) throws DataAccessException;
}