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
        
    }
    
    public void AddUltimate() {
        
    }
    
    public void ChangeSpeed(int speed) {
        
    }
    
    public void ChangeBullet(Bullet x) {
        
    }
    
    public void PrintDescription() {
        
    }
    
    public void BerserkOn() {
        
    }
}
