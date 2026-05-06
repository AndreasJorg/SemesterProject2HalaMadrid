package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import db.BookingDB;
import db.DataAccessException;
import model.Booking;

public class BookingTableModel extends AbstractTableModel {
	
	private String [] columns = {
			"Tid", "Bane1: ", "Bane2: " 
	}; 
	
	private Object[] [] data; 
	
	public BookingTableModel() {
		data = new Object [] [] {
			//Creating the visuels to our JTable
			//Not valid data
            {"08:00 : 09:00", null, null},
            {"09:00 : 10:00", null, null},
            {"10:00 : 11:00", null, null},
            {"11:00 : 12:00", null, null},
            {"12:00 : 13:00", null, null},
            {"13:00 : 14:00", null, null},
            {"14:00 : 15:00", null, null},
            {"15:00 : 16:00", null, null},
            {"16:00 : 17:00", null, null},
            {"17:00 : 18:00", null, null}
    };
    
    loadBookingsFromDatabase();
}

private void loadBookingsFromDatabase() {
    BookingDB bookingDB = new BookingDB();

    try {
        List<Booking> bookings = bookingDB.findAllBookings();

        for (Booking b : bookings) {

            int row = findRow(b.getStartTid(), b.getSlutTid());
            int column = b.getBaneId(); // 1 = Bane1, 2 = Bane2

            if (row != -1 && column >= 1 && column <= 2) {
                data[row][column] = new BookingCell(
                        b.getPris(),
                        Cellstatus.valueOf(b.getStatus().toUpperCase())
                );
            }
        }

        fireTableDataChanged();

    } catch (DataAccessException e) {
        e.printStackTrace();
    }
}

private int findRow(String startTid, String slutTid) {
    String tid = (startTid + " : " + slutTid).trim();

    for (int i = 0; i < data.length; i++) {
        String tableTid = data[i][0].toString().trim();

        if (tableTid.equalsIgnoreCase(tid)) {
            return i;
        }
    }

    return -1;
}

	
	    @Override
	    public int getRowCount() {
	        return data.length;
	    }

	    @Override
	    public int getColumnCount() {
	        return columns.length;
	    }

	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        return data[rowIndex][columnIndex];
	    }

	    @Override
	    public String getColumnName(int column) {
	        return columns[column];
	    }
	    
	}

	

