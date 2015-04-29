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
public class Ultimate implements GameSetting,GameResources{
    protected Point CurrentPosition;
    protected Image UltimateImage;
    protected boolean visible;
    protected int width, height;
    protected int UltimateSpeed;
    public Ultimate() {
        CurrentPosition = new Point(-99,-99);
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(ultimateimg));
        UltimateImage = bulleticon.getImage();
        visible = true;
        width = UltimateImage.getWidth(null);
        height = UltimateImage.getHeight(null);
        UltimateSpeed = DefaultUltimateSpeed;
    }

    public Ultimate(int x, int y) {
        CurrentPosition = new Point(x,y);
        ImageIcon bulleticon = new ImageIcon(this.getClass().getResource(ultimateimg));
        UltimateImage = bulleticon.getImage();
        visible = true;
        width = UltimateImage.getWidth(null);
        height = UltimateImage.getHeight(null);
        UltimateSpeed = DefaultUltimateSpeed;
    }

    public Image getUltimateImage() {
        return UltimateImage;
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
        return new Rectangle(CurrentPosition.x, CurrentPosition.y,UltimateImage.getWidth(null),UltimateImage.getHeight(null));
    }

    public int getUltimateSpeed(){
        return UltimateSpeed;
    }
    
    public void setUltimateSpeed(int _bulletspeed){
        UltimateSpeed = _bulletspeed;
    }
    
    public void move(boolean toEnemy) {
        if(toEnemy){
            CurrentPosition.x += UltimateSpeed;
        }
        else{ //shot to player
            CurrentPosition.x -= UltimateSpeed;
        }
        if (CurrentPosition.x > Board_Width)
            visible = false;
    }
}
