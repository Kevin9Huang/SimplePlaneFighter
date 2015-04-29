/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple.Plane.Fighter;

/**
 *
 * @author Rosi
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class EnemyShoot implements GameSetting {
    
    private static int cnt;
    public static void main(String args[]) {
        new JFrame().setVisible(true);
        ActionListener actListner = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cnt += 1;
                System.out.println("Counter = "+cnt);
            }
        };
        Timer timer = new Timer(2000, actListner);
        timer.start();
    }
}
