package gui;

import javax.swing.table.AbstractTableModel;

public class BookingTableModel extends AbstractTableModel {
	
	private String [] columns = {
			"Tid", "Bane1: ", "Bane2: " 
	}; 
	
	private Object[] [] data; 
	
	public BookingTableModel() {
		data = new Object [] [] {
			{"08:00 : 09:00", new BookingCell("Dkk 70", Cellstatus.LEDIG), new BookingCell("Dk 70", Cellstatus.LEDIG)},
			{"09:00 : 10:00", new BookingCell("Optaget", Cellstatus.OPTAGET), new BookingCell("Dk 70", Cellstatus.LEDIG)},
			{"10:00 : 11:00", new BookingCell("Dkk 70", Cellstatus.TURNERING), new BookingCell("Dk 70", Cellstatus.LEDIG)},
			{"11:00 : 12:00", new BookingCell("Dkk 70", Cellstatus.TRÆNING), new BookingCell("Dk 70", Cellstatus.LEDIG)},
			{"12:00 : 13:00", new BookingCell("Dkk 70", Cellstatus.LEDIG), new BookingCell("Dk 70", Cellstatus.LEDIG)},
			{"13:00 : 14:00", new BookingCell("Dkk 70", Cellstatus.LEDIG), new BookingCell("Dk 70", Cellstatus.LEDIG)},
			{"14:00 : 15:00", new BookingCell("Dkk 70", Cellstatus.LEDIG), new BookingCell("Dk 70", Cellstatus.LEDIG)},
			{"15:00 : 16:00", new BookingCell("Dkk 70", Cellstatus.LEDIG), new BookingCell("Dk 70", Cellstatus.LEDIG)},
			{"16:00 : 17:00", new BookingCell("Dkk 70", Cellstatus.LEDIG), new BookingCell("Dk 70", Cellstatus.LEDIG)},
			{"17:00 : 18:00", new BookingCell("Dkk 70", Cellstatus.LEDIG), new BookingCell("Dk 70", Cellstatus.LEDIG)}
		};
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

		

		

	
}
