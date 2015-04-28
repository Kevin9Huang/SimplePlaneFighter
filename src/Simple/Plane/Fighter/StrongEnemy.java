/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple.Plane.Fighter;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 *
 * @author Rosi
 */
public class StrongEnemy extends Plane implements GameSetting {
    
    public StrongEnemy() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("strongenemy.png"));
        PlaneImage = ii.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList();
        Visible = true;
        SpeedX = 30;
        SpeedY = 45;
        HitPoints = 30;
    }
    
    public void run() {
        CurrentPosition.x += dx;
        if (CurrentPosition.x <= 2) 
            CurrentPosition.x = 2;
        if (CurrentPosition.x >= Board_Width - 2*width) 
            CurrentPosition.x = Board_Height - 2*width;  
    }
}
