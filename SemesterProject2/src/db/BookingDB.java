package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Booking;

public class BookingDB implements BookingDAO {
	//Gemmer query i en Klasse variabler af typen String
	private static final String FIND_ALL_BOOKINGS = "Select * From Bookings";
	private static final String FIND_A_BOOKING = "Select * From bookings WHERE bane_id = ?";
	private static final String UPDATE_BOOKING = "";
	private static final String DELETE_BOOKING = ""; 
	
	//Laver PreparedStatement variabler og kalder dem således (PIL NED)
	private PreparedStatement findAllBookingsPS;
	private PreparedStatement findABookingPS;
	private PreparedStatement updateABookingPS; 
	private PreparedStatement deleteABookingPS;
	
	public BookingDB() {
		initPreparedStatement();
}
 
	public void initPreparedStatement() {
		Connection con = DBConnection.getInstance().getConnection();
		try {
			findAllBookingsPS = con.prepareStatement(FIND_ALL_BOOKINGS);
			findABookingPS = con.prepareStatement(FIND_A_BOOKING);
			updateABookingPS = con.prepareStatement(UPDATE_BOOKING);
			deleteABookingPS = con.prepareStatement(DELETE_BOOKING);
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}
	
		public Booking findByBaneId(int baneId)  throws DataAccessException {
			Booking booking = null;
			try {
				
			
				findABookingPS.setInt(1, baneId);
				ResultSet rs = findABookingPS.executeQuery();
				if (rs.next()) {
					booking = buildObject(rs);
				}
				return booking; 
				
			} catch (SQLException e) {
				throw new DataAccessException (e, "Could not find Booking with input date");
				
			}
		} 

		private Booking buildObject(ResultSet rs) throws SQLException {
			LocalDate date = rs.getDate("booking_date").toLocalDate();
			int baneId = rs.getInt("bane_Id");
			
			return new Booking (date, baneId);
		}
	} 
