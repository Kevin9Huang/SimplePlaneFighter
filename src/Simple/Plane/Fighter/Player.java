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

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player extends Plane {
    
    int ultimateCounter = 3; 

    public Player() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("player.png"));
        PlaneImage = ii.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList();
        Visible = true;
        SpeedX = 40;
        SpeedY = 60; 
    }
    
    public void UseUltimate() {
        ultimateCounter -= 1;
    }
    
    public void AddUltimate() {
        ultimateCounter += 1;
    }
    
    public void IncreaseSpeed(int speed) {
        SpeedX += speed;
        SpeedY += speed;
    }
    
    public void ChangeBullet(Bullet x) {
        CurrentBullet = x;
    }
    
    public void PrintDescription() {
        
    }
    
    public void BerserkOn() {
        
    }
}
