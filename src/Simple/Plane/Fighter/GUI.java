package Simple.Plane.Fighter;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private Board board;

    /**
     * Creates new form GUI
     */
    public GUI() {
        board = new Board();
        board.setBounds(0, 0, Board_Width, Board_Height);
        getContentPane().add(board);
        System.out.println(board.getFocusTraversalKeysEnabled());
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
        ButtonUltimate = new javax.swing.JButton();
        ButtonExit = new javax.swing.JButton();
        LabelDescription = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(null);

        ButtonUp.setText("Up");
        ButtonUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonUpMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonUpMouseReleased(evt);
            }
        });
        getContentPane().add(ButtonUp);
        ButtonUp.setBounds(120, 430, 70, 30);

        ButtonLeft.setText("Left");
        ButtonLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonLeftMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonLeftMouseReleased(evt);
            }
        });
        getContentPane().add(ButtonLeft);
        ButtonLeft.setBounds(40, 460, 80, 30);

        ButtonRight.setText("Right");
        ButtonRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonRightMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonRightMouseReleased(evt);
            }
        });
        getContentPane().add(ButtonRight);
        ButtonRight.setBounds(190, 460, 90, 30);

        ButtonDown.setText("Down");
        ButtonDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonDownMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonDownMouseReleased(evt);
            }
        });
        getContentPane().add(ButtonDown);
        ButtonDown.setBounds(120, 490, 70, 30);

        ButtonShoot.setText("Shoot");
        ButtonShoot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ButtonShootMousePressed(evt);
            }
        });
        getContentPane().add(ButtonShoot);
        ButtonShoot.setBounds(110, 460, 90, 30);

        ButtonUltimate.setText("Use Ultimate");
        ButtonUltimate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ButtonUltimateMouseReleased(evt);
            }
        });
        getContentPane().add(ButtonUltimate);
        ButtonUltimate.setBounds(90, 530, 130, 30);

        ButtonExit.setText("Exit");
        ButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExitActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonExit);
        ButtonExit.setBounds(90, 570, 150, 30);

        LabelDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelDescription.setText("Description: ");
        LabelDescription.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(LabelDescription);
        LabelDescription.setBounds(490, 500, 350, 160);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ButtonExitActionPerformed

    private void ButtonUpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonUpMousePressed
        board.player.MoveUp();
        board.requestFocus(true);
    }//GEN-LAST:event_ButtonUpMousePressed

    private void ButtonLeftMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLeftMousePressed
        board.player.MoveLeft();
        board.requestFocus(true);
    }//GEN-LAST:event_ButtonLeftMousePressed

    private void ButtonRightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRightMousePressed
        board.player.MoveRight();
        board.requestFocus(true);
    }//GEN-LAST:event_ButtonRightMousePressed

    private void ButtonDownMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDownMousePressed
        board.player.MoveDown();
        board.requestFocus(true);
    }//GEN-LAST:event_ButtonDownMousePressed

    private void ButtonUpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonUpMouseReleased
        board.player.ResetDeltaMove();
        board.requestFocus(true);
    }//GEN-LAST:event_ButtonUpMouseReleased

    private void ButtonLeftMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLeftMouseReleased
        board.player.ResetDeltaMove();
        board.requestFocus(true);
    }//GEN-LAST:event_ButtonLeftMouseReleased

    private void ButtonRightMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRightMouseReleased
        board.player.ResetDeltaMove();
        board.requestFocus(true);
    }//GEN-LAST:event_ButtonRightMouseReleased

    private void ButtonDownMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDownMouseReleased
        board.player.ResetDeltaMove();
        board.requestFocus(true);
    }//GEN-LAST:event_ButtonDownMouseReleased

    private void ButtonShootMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonShootMousePressed
        board.player.Shot();
        board.requestFocus(true);
    }//GEN-LAST:event_ButtonShootMousePressed

    private void ButtonUltimateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonUltimateMouseReleased
        if(board.player.getCounterUltimate() > 0 && !board.player.getUltimate().isVisible()){
                        board.player.UseUltimate();
        }
        board.requestFocus(true);
    }//GEN-LAST:event_ButtonUltimateMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDown;
    private javax.swing.JButton ButtonExit;
    private javax.swing.JButton ButtonLeft;
    private javax.swing.JButton ButtonRight;
    private javax.swing.JButton ButtonShoot;
    private javax.swing.JButton ButtonUltimate;
    private javax.swing.JButton ButtonUp;
    private javax.swing.JLabel LabelDescription;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                board.player.MoveLeft();
            }

            if (key == KeyEvent.VK_RIGHT) {
                board.player.MoveRight();
            }

            if (key == KeyEvent.VK_UP) {
                board.player.MoveUp();
            }

            if (key == KeyEvent.VK_DOWN) {
                board.player.MoveDown();
            }
            if (key == KeyEvent.VK_SPACE) {
                board.player.Shot();
                /*for(int i=0;i<weakenemies.size();i++){
                    weakenemies.get(i).Shot();
                }*/
                for(int i=0;i<board.mediumenemies.size();i++){
                    board.mediumenemies.get(i).Shot();
                }
                /*
                for(int i=0;i<strongenemies.size();i++){
                    strongenemies.get(i).Shot();
                }*/
            }
            if(key == KeyEvent.VK_ENTER){
                board.ingame = true;
                board.ResetGame();
            }
            
            
        }
    }
}

