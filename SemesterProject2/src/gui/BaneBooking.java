package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.JTable;
import javax.swing.JLabel;

public class BaneBooking extends JFrame {
	
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JDatePickerImpl dp;
    private JTable BookingTableJTable;
    

    public static void main(String[] args) { 
    	java.awt.EventQueue.invokeLater(() -> {
    		try {
    			BaneBooking frame = new BaneBooking(); 
    			frame.setVisible(true);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	});
    }
    public BaneBooking() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 1200, 850);

        contentPane = new JPanel();
        setContentPane(contentPane);

        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        contentPane.setLayout(null);
        dp = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        dp.setBounds(0, 0, 486, 21);

        contentPane.add(dp);
        
        BookingTableJTable = new JTable();
        
        BookingTableJTable.setModel(new BookingTableModel());
        
        BookingTableJTable.setRowHeight(40);
        refreshTable();
        
        BookingCellRenderer renderer = new BookingCellRenderer();
        for (int i = 1; i < BookingTableJTable.getColumnCount(); i++) {
        	BookingTableJTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
        	
        }
        
        BookingTableJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = BookingTableJTable.getSelectedRow();
                int col = BookingTableJTable.getSelectedColumn();

                if (col == 0) return;

                Object value = BookingTableJTable.getValueAt(row, col);

                if (value == null) {
                    String tid = BookingTableJTable.getValueAt(row, 0).toString();
                    String[] tider = tid.split(" : ");

                    String startTid = tider[0];
                    String slutTid = tider[1];

                    int baneId = col;
                    String pris = "Dkk 70";

                    int svar = javax.swing.JOptionPane.showConfirmDialog(
                            BaneBooking.this,
                            "Vil du booke bane " + baneId +
                            "\nTid: " + startTid + " - " + slutTid +
                            "\nPris: " + pris,
                            "Opret booking",
                            javax.swing.JOptionPane.YES_NO_OPTION
                    );

                    if (svar == javax.swing.JOptionPane.YES_OPTION) {
                        try {
                            controller.BookingCtr bookingCtr = new controller.BookingCtr();

                            model.Booking booking = new model.Booking(
                            		//Opretter booking med id 5
                                    2,
                                    baneId,
                                    startTid,
                                    slutTid,
                                    pris,
                                    "OPTAGET"
                            );

                            bookingCtr.createBooking(booking);

                            refreshTable();

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        
        BookingTableJTable.setBounds(50, 50, 1100, 800);
        contentPane.add(BookingTableJTable);
        
        JLabel Bane2BTN = new JLabel("Bane 2");
        Bane2BTN.setBounds(936, 28, 44, 12);
        contentPane.add(Bane2BTN);
        
        JLabel Bane1BTN = new JLabel("Bane 1");
        Bane1BTN.setBounds(554, 28, 44, 12);
        contentPane.add(Bane1BTN);
        
    } 

    private void refreshTable() {
    	    BookingTableJTable.setModel(new BookingTableModel());

    	    BookingCellRenderer renderer = new BookingCellRenderer();
    	    for (int i = 1; i < BookingTableJTable.getColumnCount(); i++) {
    	        BookingTableJTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
    	    }
    	}
	
	public LocalDate getValue() {
        Date selectedDate = (Date) dp.getModel().getValue();
        if (selectedDate != null) {
            return selectedDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }
        return null;
    }

    private class DateLabelFormatter extends AbstractFormatter {
        private static final long serialVersionUID = 1L;

        private final String datePattern = "yyyy-MM-dd";
        private final SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parse(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }
            return "";
        }
    }
}