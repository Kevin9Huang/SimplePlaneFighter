/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simple.Plane.Fighter;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Kevin Huang
 */
public class Bullet {
    public int x;
    public int y;
    public boolean visible;
    public int BulletWidth;
    public int BulletHeight;
    public int BoardWidth;
    public int BoardHeight;
    public int BulletSpeed;
    public int DamagePoint;
    public Image BulletImage;
    public final String spritebullet = "../bullet.png";
    public Bullet(){
        x = 0; //inital bullet position x
        y = 0; //inital bullet position y
        visible = false;
        BulletWidth = 10;
        BulletHeight = 10;
        BoardWidth = 800;
        BoardHeight = 600;
        BulletSpeed = 2;
        DamagePoint = 10;
        ImageIcon imgbullet = new ImageIcon(this.getClass().getResource(spritebullet));
        BulletImage = imgbullet.getImage();
    }
    
    // tes konstruktor bullet
    public Bullet(int x, int y) {
        
    }
    
    public int getX(){
        return x;
    }
    public void setX(int _x){
        x = _x;
    }
    public int getY(){
        return y;
    }
    public void setY(int _y){
        y = _y;
    }
    public boolean isVisible(){
        return visible;
    }
    public void setVisible(boolean _visible){
        visible = _visible;
    }
    public int getBulletWidth(){
        return BulletWidth;
    }
    public void setBulletWidth(int _imgwidth){
        BulletWidth = _imgwidth;
    }
    public int getBulletHeight(){
        return BulletHeight;
    }
    public void setBulletHeight(int _imgheight){
        BulletHeight = _imgheight;
    }
    public int getBoardHeight(){
        return BoardHeight;
    }
    public void setBoardHeight(int _brdheight){
        BoardHeight = _brdheight;
    }
    public int getBoardWidth(){
        return BoardWidth;
    }
    public void setBoardWidth(int _brdwidth){
        BoardWidth = _brdwidth;
    }
    public int getDamagePoint(){
        return DamagePoint;
    }
    public void setDamagePoint(int _dmgpoint){
        DamagePoint = _dmgpoint;
    }
    public void Move(){
        this.x += BulletSpeed;
        this.y += BulletSpeed;
    }
    public Rectangle getCollisionArea(){
        return new Rectangle(BulletWidth,BulletHeight);
    }
    public Image getBulletImage(){
        return BulletImage;
    }
}
