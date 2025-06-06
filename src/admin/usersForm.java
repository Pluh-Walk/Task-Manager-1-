
package admin;

import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author CHRISTIAN
 */
public class usersForm extends javax.swing.JFrame {
    
    private static final Logger logger = Logger.getLogger(usersForm.class.getName());
    
    /**
     * Creates new form adminDashboard
     */
    public usersForm() {
        initComponents();
           Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int frameWidth = 690;
        int frameHeight = 442;

        int centerX = (screenWidth - frameWidth) / 2;
        int centerY = (screenHeight - frameHeight) / 2;

        setBounds(centerX, centerY, frameWidth, frameHeight);
        setResizable(false);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                setLocation(centerX, centerY); 
            }
        });
        displayData();
    }
    
    public void displayData(){
        try {
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT u_id, u_name, u_lname, u_email FROM tbl_user");
            usersTable.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            logger.info("Displayed user data successfully.");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error displaying user data: " + ex.getMessage(), ex);
        } 
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        acc_id = new javax.swing.JLabel();
        p_add = new javax.swing.JPanel();
        acc_name = new javax.swing.JLabel();
        p_update = new javax.swing.JPanel();
        acc_name2 = new javax.swing.JLabel();
        p_delete = new javax.swing.JPanel();
        acc_name3 = new javax.swing.JLabel();
        acc_name1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 51, 255));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 153, 255));

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(usersTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 520, 330));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/administrator (2).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, -1));

        acc_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        acc_id.setText("  ID");
        jPanel1.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 30, 30));

        p_add.setBackground(new java.awt.Color(42, 59, 159));
        p_add.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_addMouseExited(evt);
            }
        });
        p_add.setLayout(null);

        acc_name.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        acc_name.setText("ADD");
        acc_name.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        p_add.add(acc_name);
        acc_name.setBounds(50, 10, 40, 20);

        jPanel1.add(p_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 40));

        p_update.setBackground(new java.awt.Color(42, 59, 159));
        p_update.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_updateMouseExited(evt);
            }
        });
        p_update.setLayout(null);

        acc_name2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        acc_name2.setText("EDIT");
        acc_name2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        p_update.add(acc_name2);
        acc_name2.setBounds(50, 10, 40, 20);

        jPanel1.add(p_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 140, 40));

        p_delete.setBackground(new java.awt.Color(42, 59, 159));
        p_delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        p_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_deleteMouseExited(evt);
            }
        });
        p_delete.setLayout(null);

        acc_name3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        acc_name3.setText("DELETE");
        acc_name3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        p_delete.add(acc_name3);
        acc_name3.setBounds(40, 10, 70, 20);

        jPanel1.add(p_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, 40));

        acc_name1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        acc_name1.setText("Current User");
        acc_name1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(acc_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, 30));

        jPanel3.setBackground(new java.awt.Color(12, 226, 240));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel1.setText("USERS FORM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jLabel1)
                .addContainerGap(297, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       
        adminDashboard adb = new adminDashboard();
        adb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session sess = Session.getInstance();
        acc_id.setText(""+sess.getUid());
        
        
    }//GEN-LAST:event_formWindowActivated

    private void p_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseEntered
        
        Color navcolor = new Color(42,59,159);
        Color hovercolor = new Color(51,126,159);
        
        p_add.setBackground(hovercolor);    
    }//GEN-LAST:event_p_addMouseEntered

    private void p_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseExited
        Color navcolor = new Color(42,59,159);
        Color hovercolor = new Color(51,126,159);
        
        p_add.setBackground(navcolor);
    }//GEN-LAST:event_p_addMouseExited

    private void p_updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_updateMouseEntered
        Color navcolor = new Color(42,59,159);
        Color hovercolor = new Color(51,126,159);
        
        p_update.setBackground(hovercolor);    
    }//GEN-LAST:event_p_updateMouseEntered

    private void p_updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_updateMouseExited
        Color navcolor = new Color(42,59,159);
        Color hovercolor = new Color(51,126,159);
        
        p_update.setBackground(navcolor);
    }//GEN-LAST:event_p_updateMouseExited

    private void p_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseClicked
    logger.info("Navigating to add user form.");
    regFormAD rfd = new regFormAD();
    rfd.setVisible(true);
    rfd.remove.setEnabled(false);
    rfd.select.setEnabled(true);
    new dbConnector().logAction(Session.getInstance().getUid(), "Navigated to add user form.");
    
    this.dispose();
    }//GEN-LAST:event_p_addMouseClicked

    private void p_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_updateMouseClicked
         logger.info("Navigating to update user form.");
    int rowindex = usersTable.getSelectedRow();

    if (rowindex < 0) {
        JOptionPane.showMessageDialog(null, "Please select an Item!");
        logger.warning("No item selected for update.");
    } else {
        try {
            dbConnector dbc = new dbConnector();
            TableModel tbl = usersTable.getModel(); 
            ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE u_id = '" + tbl.getValueAt(rowindex, 0) + "'");

            if (rs.next()) {
                regFormAD rfd = new regFormAD();
                rfd.uid.setText(String.valueOf(rs.getInt("u_id")));
                rfd.fn.setText(rs.getString("u_name"));
                rfd.ln.setText(rs.getString("u_lname"));
                rfd.em.setText(rs.getString("u_email"));
                rfd.un.setText(rs.getString("u_username"));
                rfd.ut.setSelectedItem(rs.getString("u_type"));
                rfd.us.setSelectedItem(rs.getString("u_status"));

                // Load and display the image
                String imagePath = rs.getString("u_image"); // Ensure this is the correct column name
                rfd.loadImage(imagePath);
                
                rfd.add.setEnabled(false);
                rfd.update.setEnabled(true);

                rfd.setVisible(true);
                this.dispose();

                
                dbc.logAction(Session.getInstance().getUid(), "Navigated to update user form for user ID: " + rs.getInt("u_id"));
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error fetching data for user update: " + ex.getMessage(), ex);
        }
    }
    }//GEN-LAST:event_p_updateMouseClicked

    private void p_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseEntered
           
        Color hovercolor = new Color(51,126,159);
        
        p_delete.setBackground(hovercolor);
    }//GEN-LAST:event_p_deleteMouseEntered

    private void p_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseClicked
          int rowindex = usersTable.getSelectedRow();
    logger.info("Navigating to delete a user from the form.");
    if (rowindex < 0) {
        JOptionPane.showMessageDialog(null, "Please select a user to delete!");
    } else {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            TableModel tbl = usersTable.getModel(); 
            String id = tbl.getValueAt(rowindex, 0).toString(); 

            dbConnector dbc = new dbConnector();
            try {
                boolean isDeleted = dbc.deleteUserById(id);

                if (isDeleted) {
                    dbc.logAction(Session.getInstance().getUid(), "Deleted user with ID " + id); // Log deletion
                    JOptionPane.showMessageDialog(null, "User deleted successfully.");
                    displayData(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete user.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
    }//GEN-LAST:event_p_deleteMouseClicked

    private void p_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_deleteMouseExited
        Color navcolor = new Color(42,59,159);
        
        p_delete.setBackground(navcolor);
    }//GEN-LAST:event_p_deleteMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(usersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usersForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usersForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_id;
    private javax.swing.JLabel acc_name;
    private javax.swing.JLabel acc_name1;
    private javax.swing.JLabel acc_name2;
    private javax.swing.JLabel acc_name3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel p_add;
    private javax.swing.JPanel p_delete;
    private javax.swing.JPanel p_update;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
