/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simple.Plane.Fighter;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Kevin Huang
 */
public class Bullet implements GameSetting,GameResources{
    protected Point CurrentPosition;
    protected Image BulletImage;
    protected boolean visible;
    protected int width, height;
    protected int BulletSpeed = NormalSpeedBullet;
    protected int BulletDamage;
    public Bullet() {
        CurrentPosition = new Point(-99,-99);
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(bulletimg));
        BulletImage = bulleticon.getImage();
        visible = true;
        width = BulletImage.getWidth(null);
        height = BulletImage.getHeight(null);
        BulletDamage = NormalBulletDamage;

    }

    public Bullet(int x, int y) {
        CurrentPosition = new Point(x,y);
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(bulletimg));
        BulletImage = bulleticon.getImage();
        visible = true;
        width = BulletImage.getWidth(null);
        height = BulletImage.getHeight(null);
        BulletDamage = NormalBulletDamage;
    }

    public Bullet(Bullet x) {
        CurrentPosition = new Point(x.CurrentPosition.x,CurrentPosition.y);
        BulletImage = x.getBulletImage();
        visible = x.visible;
        width = BulletImage.getWidth(null);
        height = BulletImage.getHeight(null);

    }

    public Image getBulletImage() {
        return BulletImage;
    }

    public Point getCurrentPosition(){
        return CurrentPosition;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Rectangle getCollisionArea() {
        return new Rectangle(CurrentPosition.x, CurrentPosition.y,BulletImage.getWidth(null),BulletImage.getHeight(null));
    }

    public int getBulletSpeed(){
        return BulletSpeed;
    }
    
    public void setBulletSpeed(int _bulletspeed){
        BulletSpeed = _bulletspeed;
    }
    
    public void move(boolean toEnemy) {
        if(toEnemy){
            CurrentPosition.x += BulletSpeed;
        }
        else{ //shot to player
            CurrentPosition.x -= BulletSpeed;
        }
        if (CurrentPosition.x > Board_Width || CurrentPosition.x < 0)
            visible = false;
    }
    public int getBulletDamage(){
        return BulletDamage;
    }
    public void setBulletDamage(int bulletdamage){
        BulletDamage = bulletdamage;
    }
}
