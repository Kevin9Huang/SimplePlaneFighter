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
    private int x;
    private int y;
    private boolean visible;
    private int BulletWidth;
    private int BulletHeight;
    private int BoardWidth;
    private int BoardHeight;
    private int BulletSpeed;
    private int DamagePoint;
    private Image BulletImage;
    private final String spritebullet = "../bullet.png";
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
    private int getX(){
        return x;
    }
    private void setX(int _x){
        x = _x;
    }
    private int getY(){
        return y;
    }
    private void setY(int _y){
        y = _y;
    }
    private boolean isVisible(){
        return visible;
    }
    private void setVisible(boolean _visible){
        visible = _visible;
    }
    private int getBulletWidth(){
        return BulletWidth;
    }
    private void setBulletWidth(int _imgwidth){
        BulletWidth = _imgwidth;
    }
    private int getBulletHeight(){
        return BulletHeight;
    }
    private void setBulletHeight(int _imgheight){
        BulletHeight = _imgheight;
    }
    private int getBoardHeight(){
        return BoardHeight;
    }
    private void setBoardHeight(int _brdheight){
        BoardHeight = _brdheight;
    }
    private int getBoardWidth(){
        return BoardWidth;
    }
    private void setBoardWidth(int _brdwidth){
        BoardWidth = _brdwidth;
    }
    private int getDamagePoint(){
        return DamagePoint;
    }
    private void setDamagePoint(int _dmgpoint){
        DamagePoint = _dmgpoint;
    }
    private void Move(){
        this.x += BulletSpeed;
        this.y += BulletSpeed;
    }
    private Rectangle getCollisionArea(){
        return new Rectangle(BulletWidth,BulletHeight);
    }
}
