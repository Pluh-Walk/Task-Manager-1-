/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbConnector;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author CHRISTIAN
 */
public class regFormAD extends javax.swing.JFrame {

    /**
     * Creates new form regForm
     */
    public regFormAD() {
        initComponents();
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;

 
    int frameWidth = 785;
    int frameHeight = 468;

 
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
    }
    public String destination = "";
    File selectedfile;
    public String oldpath;
    public String path;
    
    void loadImage(String imagePath) {
    if (imagePath != null && !imagePath.isEmpty()) {
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            Image img = icon.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
            image.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading image: " + e.getMessage());
        }
    } else {
        image.setIcon(null); 
}
    }
    
   public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
 
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
     
    public static String email, usname;
    public boolean duplicateCheck() {
    dbConnector dbc = new dbConnector();
    
    try {
    String query = "SELECT * FROM tbl_user WHERE u_username = '" + un.getText() + "' OR u_email = '" + em.getText() + "'";
    ResultSet resultSet = dbc.getData(query);
    
    if (resultSet.next()) {
        email = resultSet.getString("u_email");
        if(email.equals(em.getText())) {
            JOptionPane.showMessageDialog(null, "Email is Already Used!");
            em.setText("");
        }
        
        usname = resultSet.getString("u_username");
        if(usname.equals(un.getText())) {
            JOptionPane.showMessageDialog(null, "Username is Already Used!");
            un.setText("");
        }
        return true;
    }
} catch (SQLException ex) {
    System.out.println("SQL Exception: " + ex);
}
    
    return false; 
}
    public boolean updateCheck() {
    dbConnector dbc = new dbConnector();
    
    try {
    String query = "SELECT * FROM tbl_user WHERE (u_username = '" + un.getText() + "' OR u_email = '" + em.getText() + "')AND u_id != '"+uid.getText()+"'   ";
    ResultSet resultSet = dbc.getData(query);
    
    if (resultSet.next()) {
        email = resultSet.getString("u_email");
        if(email.equals(em.getText())) {
            JOptionPane.showMessageDialog(null, "Email is Already Used!");
            em.setText("");
        }
        
        usname = resultSet.getString("u_username");
        if(usname.equals(un.getText())) {
            JOptionPane.showMessageDialog(null, "Username is Already Used!");
            un.setText("");
        }
        return true;
    }
} catch (SQLException ex) {
    System.out.println("SQL Exception: " + ex);
}
    
    
    return false; // No duplicates found
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        us = new javax.swing.JComboBox<>();
        ut = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        em = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        un = new javax.swing.JTextField();
        remove = new javax.swing.JButton();
        update = new javax.swing.JButton();
        del = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        refresh1 = new javax.swing.JButton();
        select = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel1.setText("Employee Attribute Manipulator");

        jPanel1.setBackground(new java.awt.Color(204, 102, 255));
        jPanel1.setLayout(null);

        add.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add);
        add.setBounds(100, 80, 90, 30);

        cancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel);
        cancel.setBounds(320, 120, 90, 30);

        us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Active", " ", " " }));
        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        jPanel1.add(us);
        us.setBounds(200, 400, 180, 30);

        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", " " }));
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });
        jPanel1.add(ut);
        ut.setBounds(200, 360, 180, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("User Status");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(110, 400, 80, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Account Type");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(100, 360, 95, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("First Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(110, 200, 90, 30);

        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel1.add(fn);
        fn.setBounds(200, 200, 180, 29);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Last Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(110, 240, 90, 30);

        ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnActionPerformed(evt);
            }
        });
        jPanel1.add(ln);
        ln.setBounds(200, 240, 180, 29);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Email");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 280, 50, 30);

        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        jPanel1.add(em);
        em.setBounds(200, 280, 180, 29);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Username");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(120, 320, 80, 30);

        un.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unActionPerformed(evt);
            }
        });
        jPanel1.add(un);
        un.setBounds(200, 320, 180, 29);

        remove.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        remove.setText("REMOVE");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove);
        remove.setBounds(650, 370, 90, 30);

        update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        update.setText("UPDATE");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update);
        update.setBounds(320, 80, 90, 30);

        del.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        del.setText("DELETE");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });
        jPanel1.add(del);
        del.setBounds(210, 80, 90, 30);

        clear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear);
        clear.setBounds(210, 120, 90, 30);

        jPanel2.setBackground(new java.awt.Color(12, 226, 240));
        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 890, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("User ID");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(130, 160, 52, 30);

        uid.setEnabled(false);
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        jPanel1.add(uid);
        uid.setBounds(200, 160, 180, 29);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(480, 90, 270, 270);

        refresh1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        refresh1.setText("REFRESH");
        refresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh1ActionPerformed(evt);
            }
        });
        jPanel1.add(refresh1);
        refresh1.setBounds(100, 120, 90, 30);

        select.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        select.setText("SELECT");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel1.add(select);
        select.setBounds(490, 370, 90, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(505, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
    if (fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty() 
        || un.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(null, "All fields are required!");
    
    } else if (updateCheck()) {
        
        System.out.println("Duplicate Exist");
    
    } else {
        dbConnector dbc = new dbConnector();
        dbc.updateData("UPDATE tbl_user SET u_name = '" + fn.getText() + "', "
            + "u_lname = '" + ln.getText() + "', "
            + "u_email = '" + em.getText() + "', "
            + "u_username = '" + un.getText() + "', "
            + "u_type = '" + ut.getSelectedItem() + "', "
            + "u_status = '" + us.getSelectedItem() + "' WHERE u_id = '" + uid.getText() + "';");
        

        usersForm uf = new usersForm();
        uf.setVisible(true);
        this.dispose();
    }
    }//GEN-LAST:event_updateActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
  image.setIcon(null);
  selectedfile = null;
  destination = "";
  path = "";
  select.setEnabled(true);
  refresh1.setVisible(true);
    }//GEN-LAST:event_removeActionPerformed

    private void unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unActionPerformed

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed

    }//GEN-LAST:event_emActionPerformed

    private void lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void utActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utActionPerformed

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        new usersForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        dbConnector dbc = new dbConnector();


    if (fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty() || un.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required!");
        return;
    }

    if (duplicateCheck()) {
        return;
    }

 
    String email = em.getText();
    String emailRegex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    if (!email.matches(emailRegex)) {
        JOptionPane.showMessageDialog(null, "Invalid email format!");
        return;
    }

 
    if (selectedfile != null) {
        try {
            
            String destination = "src/userImages/" + selectedfile.getName(); 
            
          
            Files.copy(selectedfile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            
           
            this.destination = destination;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Failed to save image: " + ex.getMessage());
            return;
        }
    } else {
        JOptionPane.showMessageDialog(null, "No image selected!");
        return;
    }

    String query = String.format(
        "INSERT INTO tbl_user " +
        "(u_name, u_lname, u_email, u_username, u_type, u_status, u_image, u_pass) " +
        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '')",
        fn.getText(),
        ln.getText(),
        email,
        un.getText(),
        ut.getSelectedItem(),
        us.getSelectedItem(),
        this.destination 
    );

   
    if (dbc.insertData(query)) {
        JOptionPane.showMessageDialog(null, "Registration Success!");
        new usersForm().setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(null, "Connection Error!");
    }

    }//GEN-LAST:event_addActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void refresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refresh1ActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
       JFileChooser fileChooser = new JFileChooser();
  if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
    selectedfile = fileChooser.getSelectedFile();
    destination = "src/userImages/" + selectedfile.getName();
    path = selectedfile.getAbsolutePath();

    if (!selectedfile.exists()) {
      JOptionPane.showMessageDialog(this,
         "Selected file does not exist.",
         "File Error",
         JOptionPane.ERROR_MESSAGE);
      destination = "";
      path = "";
      return;
    }

    ImageIcon rawIcon = new ImageIcon(path);
    Image scaled = rawIcon.getImage()
                         .getScaledInstance(
                             image.getWidth(),
                             image.getHeight(),
                             Image.SCALE_SMOOTH);
    image.setIcon(new ImageIcon(scaled));

    
    select.setEnabled(false);
    refresh1.setVisible(false);

   
    remove.setEnabled(true);
  }
    }//GEN-LAST:event_selectActionPerformed

    /**SS
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
            java.util.logging.Logger.getLogger(regFormAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(regFormAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(regFormAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(regFormAD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new regFormAD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    public javax.swing.JButton cancel;
    public javax.swing.JButton clear;
    public javax.swing.JButton del;
    public javax.swing.JTextField em;
    public javax.swing.JTextField fn;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JTextField ln;
    public javax.swing.JButton refresh1;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JTextField uid;
    public javax.swing.JTextField un;
    public javax.swing.JButton update;
    public javax.swing.JComboBox<String> us;
    public javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
