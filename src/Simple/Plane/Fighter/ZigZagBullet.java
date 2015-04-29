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
    private int BulletSpeedX;
    private int BulletSpeedY;
    public ZigZagBullet() {
        super();
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(ZigZagBulletimg));
        BulletImage = bulleticon.getImage();
        BulletSpeedX = 3;
        BulletSpeedY = 3;
        CurrentPosition = new Point(-99,-99);
        visible = true;
        width = BulletImage.getWidth(null);
        height = BulletImage.getHeight(null);
        BulletDamage = ZigZagBulletDamage;
        
    }

    public ZigZagBullet(int x, int y) {
        super(x,y);
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(ZigZagBulletimg));
        BulletImage = bulleticon.getImage();
        BulletSpeedX = 3;
        BulletSpeedY = 3;
        CurrentPosition = new Point(x,y);
        visible = true;
        width = BulletImage.getWidth(null);
        height = BulletImage.getHeight(null);
        BulletDamage = ZigZagBulletDamage;
    }
    
    public ZigZagBullet(Bullet x) {
        super(x);
        CurrentPosition = new Point(x.CurrentPosition.x,CurrentPosition.y);
        BulletImage = x.getBulletImage();
        visible = x.visible;
        width = BulletImage.getWidth(null);
        height = BulletImage.getHeight(null);
        BulletSpeedX = 5;
        BulletSpeedY = 3;

    }
    public int getSpeedX(){
        return BulletSpeedX;
    }
    public int getSpeedY(){
        return BulletSpeedY;
    }
    public void setSpeedX(int _bulletspeedx){
        BulletSpeedX = _bulletspeedx;
    }
    public void setSpeedY(int _bulletspeedy){
        BulletSpeedX = _bulletspeedy;
    }
    public void move(boolean toEnemy) {
        super.move(toEnemy);
        if(!toEnemy){ //move to player
            BulletSpeedX = -BulletSpeedX;
        }
        if (CurrentPosition.y < 0) 
        {
            CurrentPosition.y = BulletImage.getHeight(null);
            BulletSpeedY = -BulletSpeedY;
        }
        if(CurrentPosition.y > Board_Height)
        {
            CurrentPosition.y = Board_Height-BulletImage.getHeight(null);
            BulletSpeedY = -BulletSpeedY;
        }
        CurrentPosition.x += BulletSpeedX;
        CurrentPosition.y -= BulletSpeedY;
    }

}
