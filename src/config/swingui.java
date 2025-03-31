
package config;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import testapptaskm.loginForm;
import user.userDashboard;

public class swingui {
 




    
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException {
        try {
            UIManager.setLookAndFeel("de.javasoft.synthetica.simple2d.SyntheticaSimple2DLookAndFeel");
        } catch (IllegalAccessException ex) {
            Logger.getLogger(swingui.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new loginForm().setVisible(true);
            new userDashboard().setVisible(true);
        });
    }
}


