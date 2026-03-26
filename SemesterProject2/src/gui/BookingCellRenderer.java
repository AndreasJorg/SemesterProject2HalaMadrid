package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class BookingCellRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        //Centerere teksten i cellen.
        setHorizontalAlignment(CENTER);

        
        if (value instanceof BookingCell) {
            BookingCell cell = (BookingCell) value;
            setText(cell.getText());

            switch (cell.getStatus()) {
                case LEDIG:
                    setBackground(Color.GREEN);
                    break;
                case OPTAGET:
                    setBackground(Color.RED);
                    break;
                case TRÆNING:
                	setBackground(Color.YELLOW);
                	break;
                case TURNERING:
                    setBackground(Color.YELLOW);
                    break;
            }
        } else {
            setText(value != null ? value.toString() : "");
            setBackground(Color.WHITE);
        }

        return this;
    }
}