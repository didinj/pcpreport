/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpreports;

import gnu.io.*;
import java.awt.Component;
import java.beans.Beans;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.RollbackException;

/**
 *
 * @author FADHILAH
 */
public class LocationForm extends javax.swing.JDialog {

    /**
     * Creates new form LocationForm
     */
    public LocationForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (!Beans.isDesignTime()) {
            em.getTransaction().begin();
            locconnect();
            TableColumnAdjuster tca = new TableColumnAdjuster(locationTable);
            tca.adjustColumns();
            disabledForm();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        em = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("PcpreportPU").createEntityManager();
        locquery = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT l FROM Location l");
        loclist = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(locquery.getResultList());
        jScrollPane1 = new javax.swing.JScrollPane();
        locationTable = new javax.swing.JTable();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        subunitPanel = new javax.swing.JPanel();
        unitLabel = new javax.swing.JLabel();
        unitCombo = new javax.swing.JComboBox();
        unitLabel1 = new javax.swing.JLabel();
        subunitCombo = new javax.swing.JComboBox();
        nikLabel = new javax.swing.JLabel();
        loccodeCombo = new javax.swing.JComboBox();
        namaLabel = new javax.swing.JLabel();
        locnameText = new javax.swing.JTextField();
        rfidLabel = new javax.swing.JLabel();
        locrfidField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);

        locationTable.getTableHeader().setDefaultRenderer(new MultisortTableHeaderCellRenderer());
        locationTable.setAutoCreateRowSorter(true);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, loclist, locationTable, "");
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${loccode}"));
        columnBinding.setColumnName("Loc Code");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${locname}"));
        columnBinding.setColumnName("Loc Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${locunit}"));
        columnBinding.setColumnName("Unit");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${locsubunit}"));
        columnBinding.setColumnName("Sub Unit");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${locrfid}"));
        columnBinding.setColumnName("Loc RFID");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        locationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                locationTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(locationTable);
        locationTable.getColumnModel().getColumn(3).setResizable(false);

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        subunitPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        unitLabel.setText("Unit");

        unitCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "001", "002", "003", "004", "005", "006", "007", "008", "009", "010", "011", "012", "013", "014", "015", "016", "017", "018", "019", "020", "021", "022", "023", "024", "025", "026", "027", "028", "029", "030", "031", "032", "033", "034", "035" }));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, locationTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.locunit}"), unitCombo, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        unitLabel1.setText("Subunit");

        subunitCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, locationTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.locsubunit}"), subunitCombo, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        nikLabel.setText("Loc Code");

        loccodeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "L01", "L02", "L03", "L04", "L05", "L06", "L07", "L08", "L09", "L10", "L11", "L12", "L13", "L14", "L15", "L16", "L17", "L18", "L19", "L20" }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, locationTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.loccode}"), loccodeCombo, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        namaLabel.setText("Loc Name");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, locationTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.locname}"), locnameText, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        rfidLabel.setText("RFID");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, locationTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.locrfid}"), locrfidField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout subunitPanelLayout = new javax.swing.GroupLayout(subunitPanel);
        subunitPanel.setLayout(subunitPanelLayout);
        subunitPanelLayout.setHorizontalGroup(
            subunitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subunitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subunitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unitLabel)
                    .addComponent(unitLabel1)
                    .addComponent(nikLabel)
                    .addComponent(namaLabel)
                    .addComponent(rfidLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(subunitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(locnameText)
                    .addComponent(loccodeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subunitCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(unitCombo, 0, 406, Short.MAX_VALUE)
                    .addComponent(locrfidField))
                .addContainerGap())
        );
        subunitPanelLayout.setVerticalGroup(
            subunitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subunitPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subunitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(unitLabel)
                    .addComponent(unitCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(subunitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(unitLabel1)
                    .addComponent(subunitCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(subunitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(nikLabel)
                    .addComponent(loccodeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(subunitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(namaLabel)
                    .addComponent(locnameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(subunitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(rfidLabel)
                    .addComponent(locrfidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(newButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton))
                    .addComponent(subunitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subunitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        pcpreports.Location l = new pcpreports.Location();
        em.persist(l);
        loclist.add(l);
        int row = loclist.size() - 1;
        locationTable.setRowSelectionInterval(row, row);
        locationTable.scrollRectToVisible(locationTable.getCellRect(row, 0, true));
        unitCombo.requestFocusInWindow();
        saveButton.setEnabled(true);
        enabledForm();
    }//GEN-LAST:event_newButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int[] selected = locationTable.getSelectedRows();
        List<pcpreports.Location> toRemove = new ArrayList<pcpreports.Location>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            pcpreports.Location l = loclist.get(locationTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(l);
            em.remove(l);
        }
        loclist.removeAll(toRemove);
        saveData();
        refreshData();
        saveButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        saveData();
        refreshData();
        saveButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void locationTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locationTableMouseClicked
        saveButton.setEnabled(true);
        deleteButton.setEnabled(true);
        enabledForm();
    }//GEN-LAST:event_locationTableMouseClicked

    private void saveData() {
        try {
            em.getTransaction().commit();
            em.getTransaction().begin();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            em.getTransaction().begin();
            List<pcpreports.Location> merged = new ArrayList<pcpreports.Location>(loclist.size());
            for (pcpreports.Location l : loclist) {
                merged.add(em.merge(l));
            }
            loclist.clear();
            loclist.addAll(merged);
        }
    }
    
    private void refreshData() {
        em.getTransaction().rollback();
        em.getTransaction().begin();
        java.util.Collection data = locquery.getResultList();
        for (Object entity : data) {
            em.refresh(entity);
        }
        loclist.clear();
        loclist.addAll(data);
    }
    
    private void disabledForm() {
        Component[] comps = subunitPanel.getComponents();
        for(Component comp:comps) {
            comp.setEnabled(false);
        }
    }
    
    private void enabledForm() {
        Component[] comps = subunitPanel.getComponents();
        for(Component comp:comps) {
            comp.setEnabled(true);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LocationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                LocationForm dialog = new LocationForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    void connect ( String portName ) throws Exception
    {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if ( portIdentifier.isCurrentlyOwned() )
        {
            System.out.println("Error: Port is currently in use");
        }
        else
        {
            CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);
            
            if ( commPort instanceof SerialPort )
            {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
                
                InputStream in = serialPort.getInputStream();
                
                serialPort.addEventListener(new SerialReader(in));
                serialPort.notifyOnDataAvailable(true);

            }
            else
            {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }     
    }
    
    private void locconnect() {
        Query query = em.createNamedQuery("Pcp.findBySetupitem");
        query.setParameter("setupitem", "port");
        Setup s = (Setup)query.getSingleResult();
        try {
            connect(s.getSetupvalue());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static class SerialReader implements SerialPortEventListener 
    {
        private InputStream in;
        private byte[] buffer = new byte[1024];
        
        public SerialReader ( InputStream in )
        {
            this.in = in;
        }
        
        public void serialEvent(SerialPortEvent arg0) {
            int data;
          
            try
            {
                int len = 0;
                while ( ( data = in.read()) > -1 )
                {
                    if ( data == 3 ) {
                        break;
                    }
                    buffer[len++] = (byte) data;
                }
//                System.out.println(new String(buffer,0,len));
                locrfidField.setText(new String(buffer, 0, len).trim());
            }
            catch ( IOException e )
            {
                e.printStackTrace();
                System.exit(-1);
            }             
        }

    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.persistence.EntityManager em;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable locationTable;
    private javax.swing.JComboBox loccodeCombo;
    private java.util.List<pcpreports.Location> loclist;
    private javax.swing.JTextField locnameText;
    private javax.persistence.Query locquery;
    private static javax.swing.JTextField locrfidField;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JButton newButton;
    private javax.swing.JLabel nikLabel;
    private javax.swing.JLabel rfidLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox subunitCombo;
    private javax.swing.JPanel subunitPanel;
    private javax.swing.JComboBox unitCombo;
    private javax.swing.JLabel unitLabel;
    private javax.swing.JLabel unitLabel1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
