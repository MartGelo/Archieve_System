package archivesystem1;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class List extends javax.swing.JInternalFrame {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/archive_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";
    private Connection con;
    public List() {
        initComponents();
        connectToDatabase();
           populateTable();
        TableActionEvent event=new TableActionEvent() {
            
         @Override
    public void onEdit(int row) {
    
    }



           @Override
    public void onDelete(int row) {
    // Ask for confirmation
    int confirm = JOptionPane.showConfirmDialog(List.this, "Are you sure you want to delete this row?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    
    // If admin confirms deletion
    if (confirm == JOptionPane.YES_OPTION) {
        // Get the data associated with the row to be deleted
        String researchTitle = (String) jTable1.getValueAt(row, 0); // Assuming the first column contains laboratory names

        // Delete the row from the database
        deleteResearchFromDatabase(researchTitle);

        // Remove the corresponding row from the table
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(row);
    }
}

    private void deleteResearchFromDatabase(String title) {
    try {
        String query = "DELETE FROM research_articles WHERE title = ?";
        try (PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.executeUpdate();
            System.out.println("Row deleted from the database.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}



            public void onView(int row) {
               System.err.println("View row: "+row);
            }
        };
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        jTable1.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));

    }
 private void connectToDatabase() {
        try {
            // Establishing a connection to the database
            con = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");
        } catch (SQLException ex) {
            // Handle any SQL exceptions
            ex.printStackTrace();
        }
    }

        private void populateTable() {
            try {
                String query = "SELECT * FROM research_articles"; // Modify this query according to your table structure
                try (Statement stmt = con.createStatement();
                     ResultSet rs = stmt.executeQuery(query)) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0); // Clear existing rows

                    // Iterate over the result set and add rows to the table model
                    while (rs.next()) {
                        Object[] row = {
                            rs.getString("title"),
                            rs.getString("email"),
                            rs.getInt("year_publish"),
                            rs.getString("author"),
                            "Action" // Add more columns as needed
                        };
                        model.addRow(row);
                    }
                }
            } catch (SQLException ex) {
                // Handle any SQL exceptions
                ex.printStackTrace();
            }
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Research Title", "Email", "Year Publish", "Author", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(45);
        jTable1.setSelectionBackground(new java.awt.Color(51, 0, 255));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/add (1).jpg"))); // NOI18N
        jLabel2.setText("ADD LIST");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
      add dialog = new add(null, true);
        dialog.setVisible(true);

        // After the dialog is closed, update the table
        populateTable();
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
