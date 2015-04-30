/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple.Plane.Fighter;

import static Simple.Plane.Fighter.GameSetting.InitialEnemySpawnPosition;
import static Simple.Plane.Fighter.GameSetting.InitialPlayerPosition;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 *
 * @author Rosi
 */

public class MediumEnemy extends Plane implements GameSetting,Enemy {
    
    public MediumEnemy() {
        ImageIcon weakenemyicon = new ImageIcon(this.getClass().getResource(mediumenemyimage));
        PlaneImage = weakenemyicon.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList();
        Visible = true;
        SpeedX = MediumEnemySpeed;
        SpeedY = MediumEnemySpeed;
        HitPoints = 10;
        CurrentBullet = new ZigZagBullet();
        CurrentPosition = new Point(InitialEnemySpawnPosition);
        HitPoints = MediumEnemyHealth;
    }
    
    public MediumEnemy(int x,int y) {
        ImageIcon weakenemyicon = new ImageIcon(this.getClass().getResource(mediumenemyimage));
        PlaneImage = weakenemyicon.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList();
        Visible = true;
        SpeedX = MediumEnemySpeed;
        SpeedY = MediumEnemySpeed;
        HitPoints = 10;
        CurrentBullet = new ZigZagBullet();
        CurrentPosition = new Point(x,y);
        HitPoints = MediumEnemyHealth;
    }
    
    public void run() {
        
        if (CurrentPosition.x < 0) 
        {
            CurrentPosition.x = Board_Width-PlaneImage.getWidth(null);
            if(IncreaseHealthifPassed){
                HitPoints = HitPoints + MediumEnemyHealth;
            }
            if(IncreaseSpeedifPassed){
                SpeedX += PenaltySpeed;
                SpeedY += PenaltySpeed;
            }
        }
        CurrentPosition.x -= SpeedX;
    }
    public String PrintDescription() {
        return MediumEnemyDescription;
    }
}
