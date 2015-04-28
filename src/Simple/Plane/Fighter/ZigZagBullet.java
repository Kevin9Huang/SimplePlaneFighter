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
public class ZigZagBullet extends Bullet implements GameSetting,GameResources{
    private Point CurrentPosition;
    private Image BulletImage;
    boolean visible;
    private int width, height;
    private final int BulletSpeed = 5;
    
    public ZigZagBullet() {
        CurrentPosition = new Point(-99,-99);
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(ZigZagBulletimg));
        BulletImage = bulleticon.getImage();
        visible = true;
        width = BulletImage.getWidth(null);
        height = BulletImage.getHeight(null);
    }

    public ZigZagBullet(int x, int y) {
        CurrentPosition = new Point(x,y);
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(ZigZagBulletimg));
        BulletImage = bulleticon.getImage();
        visible = true;
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

    public void move(boolean toEnemy) {
        if(toEnemy){
            CurrentPosition.x += BulletSpeed;
        }
        else{ //shot to player
            CurrentPosition.x -= BulletSpeed;
        }
        if (CurrentPosition.x > Board_Width)
            visible = false;
    }
}
