/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple.Plane.Fighter;

import java.awt.event.KeyEvent;

/**
 *
 * @author Kevin Huang
 */
public class PlayerKevin extends Plane implements GameSetting {
    
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -SpeedX;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = SpeedX;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -SpeedY;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = SpeedY;
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
