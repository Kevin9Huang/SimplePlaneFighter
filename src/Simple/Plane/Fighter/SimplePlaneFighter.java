/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simple.Plane.Fighter;

import javax.swing.SwingUtilities;

/**
 *
 * @author Kevin Huang
 */
public class SimplePlaneFighter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI2();
            }
        });
    }
    
}
