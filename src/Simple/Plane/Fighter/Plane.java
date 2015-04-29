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

public class Plane implements GameSetting,GameResources {
    
    protected Bullet CurrentBullet;
    protected int width;
    protected int height;
    protected int dx;
    protected int dy;
    protected int SpeedX;
    protected int SpeedY;
    protected boolean Visible;
    
    protected Point CurrentPosition;
    protected ArrayList<Bullet> bullet;
    protected int HitPoints;
    protected Image PlaneImage;

    public Plane() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/srcimage/player.png"));
        PlaneImage = ii.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList();
        Visible = true;
        SpeedX = 40;
        SpeedY = 60;
        CurrentPosition = new Point(-99,-99);
        HitPoints = 100;
    }
    
    public Plane(int x,int y) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/srcimage/player.png"));
        PlaneImage = ii.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList();
        Visible = true;
        SpeedX = 40;
        SpeedY = 60;
        CurrentPosition = new Point(x,y);
        HitPoints = 100;
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
        return new Rectangle(CurrentPosition.x,CurrentPosition.y,PlaneImage.getWidth(null),PlaneImage.getHeight(null));
    }
    
    public void MoveUp(){
        dy = -SpeedY;
    }
    
    public void MoveDown(){
        dy = SpeedY;
    }
    
    public void MoveRight(){
        dx = SpeedX;
    }
    
    public void MoveLeft(){
        dx = -SpeedX;
    }
    
    public void ResetDeltaMove(){
        dx = 0;
        dy = 0;
    }

    public void Shot() {
        boolean bulletclassnotfound = true;
        int i = 0;
        while(bulletclassnotfound && i<ArrayClassBulletName.size()){
                if(CurrentBullet.getClass().getSimpleName().equals(ArrayClassBulletName.get(i))){
                    //TODO Recheck bug report about casting parent class to child class and insert it into parent class
                    // Class c = CurrentBullet.getClass(); c Should be class according to (ArrayClassBulletName.get(i)
                    //Bullet m = (c)c.getConstruktor()c.class.getConstructor(int.class, int.class).newInstance(CurrentPosition.x + width, CurrentPosition.y + height/2);
                    if(ArrayClassBulletName.get(i).equals("ZigZagBullet")){
                        bullet.add(new ZigZagBullet(CurrentPosition.x + width, CurrentPosition.y + height/2));
                        bulletclassnotfound = false;
                    }
                    else if(ArrayClassBulletName.get(i).equals("SpiralBullet")){
                        //bullet.add(new ZigZagBullet(CurrentPosition.x + width, CurrentPosition.y + height/2));
                        bulletclassnotfound = false;
                    }
                }
            i++;
        }
        if(bulletclassnotfound){ //Bullet name not found! = Default Bullet
            bullet.add(new Bullet(CurrentPosition.x + width, CurrentPosition.y + height/2));
        }
    }

    public void ChangeBullet(Bullet x) {
        int i = 0;
        boolean bulletclassnotfound = true;
        while(bulletclassnotfound && i<ArrayClassBulletName.size()){
                if(x.getClass().getSimpleName().equals(ArrayClassBulletName.get(i))){
                    //TODO Recheck bug report about casting parent class to child class and insert it into parent class
                    // Class c = CurrentBullet.getClass(); c Should be class according to (ArrayClassBulletName.get(i)
                    //Bullet m = (c)c.getConstruktor()c.class.getConstructor(int.class, int.class).newInstance(CurrentPosition.x + width, CurrentPosition.y + height/2);
                    if(ArrayClassBulletName.get(i).equals("ZigZagBullet")){
                        CurrentBullet = new ZigZagBullet();
                        bulletclassnotfound = false;
                    }
                    else if(ArrayClassBulletName.get(i).equals("SpiralBullet")){
                        //CurrentBullet = new SpiralBullet();
                        bulletclassnotfound = false;
                    }
                }
            i++;
        }
        if(bulletclassnotfound){ //Bullet name not found! = Default Bullet
            bullet.add(new Bullet(CurrentPosition.x + width, CurrentPosition.y + height/2));
        }
    }
    
    public void PrintDescription() {
        
    }
    public Point getCurrentPosition(){
        return CurrentPosition;
    }
    
    public ArrayList<Bullet> getBullet(){
        return bullet;
    }
    public void setPlaneImage(Image planeimage){
        PlaneImage = planeimage;
    }
    public Image getPlaneImage(){
        return PlaneImage;
    }
    public int getHitPoints(){
        return HitPoints;
    }
    public void setHitPoints(int _health){
        HitPoints = _health;
    }
    public void run() {
        CurrentPosition.x += dx;
        if (CurrentPosition.x <= 2) 
            CurrentPosition.x = 2;
        if (CurrentPosition.x >= Board_Width - 2*width) 
            CurrentPosition.x = Board_Width - 2*width;
        CurrentPosition.y += dy;
        if (CurrentPosition.y <= 2) 
            CurrentPosition.y = 2;
        if (CurrentPosition.y >= Board_Height - 2*height) 
            CurrentPosition.y = Board_Height - 2*height;
    }
}