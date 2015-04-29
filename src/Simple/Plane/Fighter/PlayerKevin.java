/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple.Plane.Fighter;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Kevin Huang
 */
public class PlayerKevin extends Plane implements GameSetting {
    private int score;
    private int Lives;
    public PlayerKevin(){
        ImageIcon playericon = new ImageIcon(this.getClass().getResource(GameResources.srcplayer));
        PlaneImage = playericon.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList<Bullet>();
        SpeedX = 2;
        SpeedY = 2;
        Visible = true;
        CurrentPosition = new Point(InitialPlayerPosition);
        CurrentBullet = new Bullet();
        HitPoints = 100;
        score = 0;
        Lives = initialLives;
        HitPoints = PlayerInitialHealth;
    }
    
    public void MoveUp(){
        dy = -SpeedY;
    }
    public void MoveDown(){
        dy = SpeedY;
    }
    public void MoveRight(){
        dx = SpeedX;
    }
    public void MoveLeft(){
        dx = -SpeedX;
    }
    public void ResetDeltaMove(){
        dx = 0;
        dy = 0;
    }
    public void run() {
        CurrentPosition.x += dx;
        if (CurrentPosition.x <= 2) 
            CurrentPosition.x = 2;
        if (CurrentPosition.x >= Board_Width - 2*width) 
            CurrentPosition.x = Board_Width - 2*width;
        CurrentPosition.y += dy;
        if (CurrentPosition.y <= 2) 
            CurrentPosition.y = 2;
        if (CurrentPosition.y >= Board_Height - 2*height) 
            CurrentPosition.y = Board_Height - 2*height;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int _score){
        score = _score;
    }
    public int getLives(){
        return Lives;
    }
    public void setLives(int lives){
        Lives = lives;
    }
    
}
