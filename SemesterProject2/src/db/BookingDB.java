package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Booking;

public class BookingDB implements BookingDAO {
	//Gemmer query i en Klasse variabler af typen String
	private static final String FIND_ALL_BOOKINGS = "Select * From bookings";
	private static final String CREATE_BOOKING = "INSERT INTO bookings (id, baneId, startTid, slutTid, Pris, Status) VALUES (?,?,?,?,?,?)";
	
	//Laver PreparedStatement variabler og kalder dem således (PIL NED)
	private PreparedStatement findAllBookingsPS;
	private PreparedStatement createBookingPS;
	
	public BookingDB() { 
		initPreparedStatement();
} 
 
	public void initPreparedStatement() {
		Connection con = DBConnection.getInstance().getConnection(); 
		try { 
			findAllBookingsPS = con.prepareStatement(FIND_ALL_BOOKINGS);
			createBookingPS = con.prepareStatement(CREATE_BOOKING);
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
	}
	

		
	private Booking buildObject(ResultSet rs) throws SQLException {
	    int id = rs.getInt("Id");
	    int baneId = rs.getInt("BaneId");

	    String startTid = rs.getTime("StartTid").toLocalTime().toString().substring(0, 5);
	    String slutTid = rs.getTime("SlutTid").toLocalTime().toString().substring(0, 5);
	    
	    String pris = rs.getString("Pris");
	    String status = rs.getString("Status");
	    

	    return new Booking(id, baneId, startTid, slutTid, pris, status);

		}
	
		public List<Booking> findAllBookings() throws DataAccessException {
		    List<Booking> bookings = new ArrayList<>();
 
		    try {
		        ResultSet rs = findAllBookingsPS.executeQuery(); 

		        while (rs.next()) { 
		            bookings.add(buildObject(rs)); 
		        }
 
		        return bookings;

		    } catch (SQLException e) {
		        throw new DataAccessException(e, "Could not find all bookings");
		    }
		}
		
		public void createBooking(Booking booking) throws DataAccessException {
			try {
				createBookingPS.setInt(1, booking.getId());
				createBookingPS.setInt(2, booking.getBaneId());
				createBookingPS.setString(3, booking.getStartTid());
				createBookingPS.setString(4, booking.getSlutTid());
				createBookingPS.setString(5, booking.getPris());
				createBookingPS.setString(6, booking.getStatus());
				
				createBookingPS.executeUpdate();
			
		} catch (SQLException e) {
			throw new DataAccessException(e, "Kunne ikke oprette en booking");
		}
	} 
}