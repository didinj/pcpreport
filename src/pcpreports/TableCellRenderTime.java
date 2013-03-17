/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpreports;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author FADHILAH
 */
public class TableCellRenderTime extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;
    private SimpleDateFormat format;

    public TableCellRenderTime() {
        format = new SimpleDateFormat("hh:mm:ss");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
        Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table,
                                         value, isSelected, hasFocus, row, column);

        if (value != null && value instanceof Date) {
            Date date = (Date) value;
            String text = format.format(date);
            label.setText(text);
        }

        return label;
    }
}
