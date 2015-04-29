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
public class SpiralBullet extends Bullet implements GameSetting,GameResources{
    
    public SpiralBullet() {
        super();
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(ZigZagBulletimg));
        BulletImage = bulleticon.getImage();
        
    }

    public SpiralBullet(int x, int y) {
        super(x,y);
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(ZigZagBulletimg));
        BulletImage = bulleticon.getImage();
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
