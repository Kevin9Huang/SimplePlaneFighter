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

public class Plane {

    private Bullet CurrentBullet;
    private int SpeedX;
    private int SpeedY;
    boolean Visible;
    private Point CurrentPosition;
    private ArrayList bullet;
    private int HitPoints;
    private Image PlaneImage;

    public Plane() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("plane.png"));
        PlaneImage = ii.getImage();
        bullet = new ArrayList();
        Visible = true;
        SpeedX = 40;
        SpeedY = 60;
    }

    Rectangle getCollisionArea() {
        Rectangle r = null;
        return r;
    }
    
    public void Move() {
        
    }

    public void Shot() {
        
    }

    public void ChangeBullet(Bullet x) {
        
    }
    
    public void PrintDescription() {
        
    }
}
