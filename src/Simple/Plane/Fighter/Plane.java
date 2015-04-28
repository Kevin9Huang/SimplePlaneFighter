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

    protected Bullet CurrentBullet;
    protected int width;
    protected int height;
    protected int SpeedX;
    protected int SpeedY;
    protected boolean Visible;
    protected Point CurrentPosition;
    protected ArrayList<Bullet> bullet;
    protected int HitPoints;
    protected Image PlaneImage;
    protected int dx;
    protected int dy;

    public Plane() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("plane.png"));
        PlaneImage = ii.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList();
        Visible = true;
        SpeedX = 40;
        SpeedY = 60;               
    }
    
    public int getPlaneWidth() {
        return width;
    }
    
    public int getPlaneHeight() {
        return height;
    }
    
    public int getPlaneSpeedX() {
        return SpeedX;
    }
    
    public int getPlaneSpeedY() {
        return SpeedY;
    }
    
    public boolean isPlaneVisible() {
        return Visible;
    }
    
    public void setPlaneWidth(int _width) {
        width = _width;
    }
    
    public void setPlaneHeight(int _height) {
        height = _height;
    }
    
    public void setPlaneSpeedX(int _speedx) {
        SpeedX = _speedx;
    }
    
    public void setPlaneSpeedY(int _speedy) {
        SpeedY = _speedy;
    }
    
    public void setPlaneVisible(boolean _visible) {
        Visible = _visible;
    }

    public Rectangle getCollisionArea() {
        return new Rectangle(CurrentPosition.x,CurrentPosition.y,width,height);
    }
    
    public Image getPlaneImage(){
        return PlaneImage;
    }
    
    public void Move() {
        CurrentPosition.x += SpeedX;
        CurrentPosition.y += SpeedY;

        if (CurrentPosition.x < 1) {
            CurrentPosition.x = 1;
        }

        if (CurrentPosition.y < 1) {
            CurrentPosition.y = 1;
        }
    }

    public void Shot() {
        bullet.add(new Bullet(CurrentPosition.x + width, CurrentPosition.y + height/2));
    }

    public void ChangeBullet(Bullet x) {
        CurrentBullet = x;
    }
    
    public void PrintDescription() {
        
    }
    public Point getCurrentPosition(){
        return CurrentPosition;
    }
    
    public ArrayList<Bullet> getBullet(){
        return bullet;
    }
}
