/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simple.Plane.Fighter;

import static Simple.Plane.Fighter.GameResources.spritebullet;
import static Simple.Plane.Fighter.GameSetting.Board_Width;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Kevin Huang
 */
public class Bullet2 extends Bullet implements GameSetting,GameResources{
    private Point CurrentPosition;
    private Image BulletImage;
    boolean visible;
    private int width, height;
    private final int BulletSpeed = 2;
    
    public Bullet2() {
        CurrentPosition = new Point(-99,-99);
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(spritebullet2));
        BulletImage = bulleticon.getImage();
        visible = true;
        width = BulletImage.getWidth(null);
        height = BulletImage.getHeight(null);
    }

    public Bullet2(int x, int y) {
        CurrentPosition = new Point(x,y);
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(spritebullet));
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
