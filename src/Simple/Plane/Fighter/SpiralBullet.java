/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simple.Plane.Fighter;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import static java.lang.Math.abs;
import javax.swing.ImageIcon;

/**
 *
 * @author Kevin Huang
 */
public class SpiralBullet extends Bullet implements GameSetting,GameResources{
    private int BulletSpeedX;
    private int BulletSpeedY;
    public SpiralBullet() {
        super();
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(SpiralBulletimg));
        BulletImage = bulleticon.getImage();
        BulletSpeedX = 3;
        BulletSpeedY = 3;
        CurrentPosition = new Point(-99,-99);
        visible = true;
        width = BulletImage.getWidth(null);
        height = BulletImage.getHeight(null);
        BulletDamage = SpiralBulletDamage;
        
    }

    public SpiralBullet(int x, int y) {
        super(x,y);
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(SpiralBulletimg));
        BulletImage = bulleticon.getImage();
        BulletSpeedX = 3;
        BulletSpeedY = 3;
        CurrentPosition = new Point(x,y);
        visible = true;
        width = BulletImage.getWidth(null);
        height = BulletImage.getHeight(null);
        BulletDamage = SpiralBulletDamage;
    }
    
    public SpiralBullet(Bullet x) {
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
        System.out.println("Tes");
        CurrentPosition.x += BulletSpeedX;
        CurrentPosition.y -= BulletSpeedY;
    }

}
