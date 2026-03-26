package db;

import model.Booking;

public interface BookingDAO {
    Booking findByBaneId(int baneId) throws DataAccessException;
}