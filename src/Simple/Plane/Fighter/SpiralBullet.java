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
public class SpiralBullet extends Bullet implements GameSetting, GameResources{
    private int BulletSpeedX;
    private int BulletSpeedY;
    private int turnPointx;
    private int turnPointy;
    private boolean initialmove = true;
    private boolean moveUp = false;
    private boolean moveDown = false;
    private boolean moveLeft = false;
    private boolean moveRight = false;
    
    public SpiralBullet() {
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(SpiralBulletimg));
        BulletImage = bulleticon.getImage();
        BulletSpeedX = SpiralBulletDefaultSpeedX;
        BulletSpeedY = SpiralBulletDefaultSpeedY;
        CurrentPosition = new Point(-99,-99);
        visible = true;
        width = BulletImage.getWidth(null);
        height = BulletImage.getHeight(null);
        BulletDamage = ZigZagBulletDamage;
        
    }

    public SpiralBullet(int x, int y) {
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(SpiralBulletimg));
        BulletImage = bulleticon.getImage();
        BulletSpeedX = SpiralBulletDefaultSpeedX;
        BulletSpeedY = SpiralBulletDefaultSpeedY;
        CurrentPosition = new Point(x,y);
        visible = true;
        width = BulletImage.getWidth(null);
        height = BulletImage.getHeight(null);
        BulletDamage = ZigZagBulletDamage;
    }
    
    public SpiralBullet(Bullet x) {
        CurrentPosition = new Point(x.CurrentPosition.x,CurrentPosition.y);
        BulletImage = x.getBulletImage();
        visible = x.visible;
        width = BulletImage.getWidth(null);
        height = BulletImage.getHeight(null);
        BulletSpeedX = SpiralBulletDefaultSpeedX;
        BulletSpeedY = SpiralBulletDefaultSpeedY;

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
        BulletSpeedY = _bulletspeedy;
    }
    public boolean getinitialmove(){
        return initialmove;
    }
    public void setinitialmove(boolean initial){
        initialmove = initial;
    }
    public void move(boolean toEnemy) {
        super.move(toEnemy);
        if(!toEnemy){ //move to player
            BulletSpeedX = -SpiralBulletDefaultSpeedX;
        }
        
        //Arah dilihat dari sudut player
        if(initialmove){
            moveUp = true; 
            moveDown = false;
            moveRight = false;
            moveLeft = false;
            turnPointx = CurrentPosition.x;
            turnPointy = CurrentPosition.y;
            initialmove = false;
        }
        
        if (CurrentPosition.x > Board_Width || CurrentPosition.x < 0 || CurrentPosition.y > Board_Height || CurrentPosition.y < 0)
        {
            visible = false;
        }
        if (moveUp) 
        {
            BulletSpeedY = SpiralBulletDefaultSpeedY;
            BulletSpeedX = 0;
            CurrentPosition.y -= BulletSpeedY;
            CurrentPosition.x = turnPointx;
            if(turnPointy-CurrentPosition.y > RangeUpSpiralBullet){
                moveUp = false;
                moveRight = true;
                turnPointx = CurrentPosition.x;
                turnPointy = CurrentPosition.y;
            }
            
        }
        else if(moveRight){
            BulletSpeedX = SpiralBulletDefaultSpeedX;
            BulletSpeedY = 0;
            CurrentPosition.x += BulletSpeedX;
            CurrentPosition.y = turnPointy;
            if(CurrentPosition.x-turnPointx > RangeLeftSpiralBullet){
                moveRight = false;
                moveDown = true;
                turnPointy = CurrentPosition.y;
                turnPointx = CurrentPosition.x;
                BulletSpeedY = -SpiralBulletDefaultSpeedY;
            }    
            //CurrentPosition.x += BulletSpeedX;
            
        }
        
        else if(moveDown){
            
            BulletSpeedX = 0;
            CurrentPosition.y -= BulletSpeedY;
            CurrentPosition.x = turnPointx;
            if(CurrentPosition.y-turnPointy > RangeUpSpiralBullet){
                moveDown = false;
                moveLeft = true;
                turnPointx = CurrentPosition.x;
                turnPointy = CurrentPosition.y;
                BulletSpeedX = -SpiralBulletDefaultSpeedX;
            }
            
        }
        else if(moveLeft){
            
            BulletSpeedY = 0;
            CurrentPosition.x += BulletSpeedX;
            CurrentPosition.y = turnPointy;
            if(turnPointx-CurrentPosition.x > 0.5*RangeLeftSpiralBullet){
                moveLeft = false;
                moveUp = true;
                turnPointy = CurrentPosition.y;
                initialmove = true;
            }
            CurrentPosition.x += BulletSpeedX;
        }
        
        
    }
}
