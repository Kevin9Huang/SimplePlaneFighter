/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple.Plane.Fighter;

/**
 *
 * @author Rosi
 */

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player extends Plane implements GameSetting {
    
    private int ultimateCounter = 3; 
    private int score;
    public Player() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("/srcimage/player.png"));
        PlaneImage = ii.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList();
        Visible = true;
        SpeedX = 40;
        SpeedY = 60; 
        score = 0;
    }
    
    public int getPlayerWidth() {
        return width;
    }
    
    public int getPlayerHeight() {
        return height;
    }
    
    public int getPlayerSpeedX() {
        return SpeedX;
    }
    
    public int getPlayerSpeedY() {
        return SpeedY;
    }
    
    public boolean getPlayerVisible() {
        return Visible;
    }
    
    public void setPlayerWidth(int _width) {
        width = _width;
    }
    
    public void setPlayerHeight(int _height) {
        height = _height;
    }
    
    public void setPlayerSpeedX(int _speedx) {
        SpeedX = _speedx;
    }
    
    public void setPlayerSpeedY(int _speedy) {
        SpeedY = _speedy;
    }
    
    public void setPlayerVisible(boolean _visible) {
        Visible = _visible;
    }
    
    public void UseUltimate() {
        ultimateCounter -= 1;
    }
    
    public void AddUltimate() {
        ultimateCounter += 1;
    }
    
    public void IncreaseSpeed(int speed) {
        SpeedX += speed;
        SpeedY += speed;
    }
    
    public void ChangeBullet(Bullet x) {
        CurrentBullet = x;
    }
    
    public void PrintDescription() {
        
    }
    
    public void BerserkOn() {
        
    }
    public void run() {
        CurrentPosition.x += dx;
        if (CurrentPosition.x <= 2) 
            CurrentPosition.x = 2;
        if (CurrentPosition.x >= Board_Width - 2*width) 
            CurrentPosition.x = Board_Width - 2*width;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int _score){
        score = _score;
    }
}
