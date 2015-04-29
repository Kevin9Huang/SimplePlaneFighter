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
public class Player extends Plane implements GameSetting {
    private int score;
    private int Lives;
    private int CounterUltimate;
    private Ultimate UltimateAtck;
    public Player(){
        super();
        ImageIcon playericon = new ImageIcon(this.getClass().getResource(GameResources.srcplayer));
        PlaneImage = playericon.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList<Bullet>();
        SpeedX = 2;
        SpeedY = 2;
        Visible = true;
        CurrentPosition = new Point(InitialPlayerPosition);
        CurrentBullet = new SpiralBullet();
        HitPoints = 100;
        score = 0;
        Lives = initialLives;
        HitPoints = initialPlayerHealth;
        CounterUltimate = initialPlayerUltimate;
        UltimateAtck = new Ultimate();
        UltimateAtck.setVisible(false);
    }
    
    public void ResetDeltaMove(){
        dx = 0;
        dy = 0;
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
    public int getCounterUltimate(){
        return CounterUltimate;
    }
    public void setCounterUltimate(int counter){
        CounterUltimate = counter;
    }
    public void UseUltimate(){
        if(CounterUltimate > 0){
            CounterUltimate--;
            UltimateAtck = new Ultimate(CurrentPosition.x, CurrentPosition.y);
            UltimateAtck.setVisible(true);
        }
    }
    public Ultimate getUltimate(){
        return UltimateAtck;
    }
    public void setUltimate(Ultimate _ultimate){
        UltimateAtck = _ultimate;
    }
    
}
