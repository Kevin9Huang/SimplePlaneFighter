package Simple.Plane.Fighter;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Huang
 */
public class GUI extends javax.swing.JFrame implements GameSetting{
    private Object icon;
    private Board3 board;

    /**
     * Creates new form GUI
     */
    public GUI() {
        board = new Board3();
        board.setBounds(0, 0, Board_Width, Board_Height);
        getContentPane().add(board);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jTextField1 = new javax.swing.JTextField();
        ButtonUp = new javax.swing.JButton();
        ButtonLeft = new javax.swing.JButton();
        ButtonRight = new javax.swing.JButton();
        ButtonDown = new javax.swing.JButton();
        ButtonShoot = new javax.swing.JButton();
        ButtonBerserk = new javax.swing.JButton();
        ButtonUltimate = new javax.swing.JButton();
        ButtonExit = new javax.swing.JButton();
        LabelHeart1 = new javax.swing.JLabel();
        LabelHeart2 = new javax.swing.JLabel();
        LabelHeart3 = new javax.swing.JLabel();
        BarHealthBar = new javax.swing.JProgressBar();
        LabelDescription = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(null);

        ButtonUp.setText("Up");
        ButtonUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUpActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonUp);
        ButtonUp.setBounds(120, 430, 70, 30);

        ButtonLeft.setText("Left");
        getContentPane().add(ButtonLeft);
        ButtonLeft.setBounds(40, 460, 80, 30);

        ButtonRight.setText("Right");
        ButtonRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRightActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonRight);
        ButtonRight.setBounds(190, 460, 90, 30);

        ButtonDown.setText("Down");
        getContentPane().add(ButtonDown);
        ButtonDown.setBounds(120, 490, 70, 30);

        ButtonShoot.setText("Shoot");
        getContentPane().add(ButtonShoot);
        ButtonShoot.setBounds(110, 460, 90, 30);

        ButtonBerserk.setText("BerserkOn()");
        ButtonBerserk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBerserkActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonBerserk);
        ButtonBerserk.setBounds(30, 520, 120, 30);

        ButtonUltimate.setText("Use Ultimate");
        getContentPane().add(ButtonUltimate);
        ButtonUltimate.setBounds(160, 520, 130, 30);

        ButtonExit.setText("Exit");
        ButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExitActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonExit);
        ButtonExit.setBounds(410, 410, 51, 23);

        LabelHeart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srcimage/heart.png"))); // NOI18N
        LabelHeart1.setToolTipText("");
        LabelHeart1.setMaximumSize(new java.awt.Dimension(2555, 2391));
        LabelHeart1.setMinimumSize(new java.awt.Dimension(2555, 2391));
        getContentPane().add(LabelHeart1);
        LabelHeart1.setBounds(860, 380, 20, 20);

        LabelHeart2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srcimage/heart.png"))); // NOI18N
        LabelHeart2.setToolTipText("");
        LabelHeart2.setMaximumSize(new java.awt.Dimension(2555, 2391));
        LabelHeart2.setMinimumSize(new java.awt.Dimension(2555, 2391));
        getContentPane().add(LabelHeart2);
        LabelHeart2.setBounds(880, 380, 20, 20);

        LabelHeart3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/srcimage/heart.png"))); // NOI18N
        LabelHeart3.setToolTipText("");
        LabelHeart3.setMaximumSize(new java.awt.Dimension(2555, 2391));
        LabelHeart3.setMinimumSize(new java.awt.Dimension(2555, 2391));
        getContentPane().add(LabelHeart3);
        LabelHeart3.setBounds(900, 380, 20, 20);

        BarHealthBar.setValue(100);
        getContentPane().add(BarHealthBar);
        BarHealthBar.setBounds(30, 370, 220, 30);

        LabelDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelDescription.setText("Description: ");
        LabelDescription.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(LabelDescription);
        LabelDescription.setBounds(290, 430, 350, 160);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonUpActionPerformed

    private void ButtonRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRightActionPerformed
        
        
    }//GEN-LAST:event_ButtonRightActionPerformed

    private void ButtonBerserkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBerserkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonBerserkActionPerformed

    private void ButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ButtonExitActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BarHealthBar;
    private javax.swing.JButton ButtonBerserk;
    private javax.swing.JButton ButtonDown;
    private javax.swing.JButton ButtonExit;
    private javax.swing.JButton ButtonLeft;
    private javax.swing.JButton ButtonRight;
    private javax.swing.JButton ButtonShoot;
    private javax.swing.JButton ButtonUltimate;
    private javax.swing.JButton ButtonUp;
    private javax.swing.JLabel LabelDescription;
    private javax.swing.JLabel LabelHeart1;
    private javax.swing.JLabel LabelHeart2;
    private javax.swing.JLabel LabelHeart3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}

