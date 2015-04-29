/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple.Plane.Fighter;

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

public class StrongEnemy extends Plane implements GameSetting,Enemy {
    
    public StrongEnemy() {
        ImageIcon weakenemyicon = new ImageIcon(this.getClass().getResource(strongenemyimage));
        PlaneImage = weakenemyicon.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList();
        Visible = true;
        SpeedX = 2;
        SpeedY = 3;
        HitPoints = 10;
        CurrentBullet = new SpiralBullet();
        CurrentPosition = new Point(InitialEnemySpawnPosition);
        HitPoints = StrongEnemyHealth;
        Description = StrongEnemyDescription;
    }
    
    public StrongEnemy(int x,int y) {
        ImageIcon weakenemyicon = new ImageIcon(this.getClass().getResource(strongenemyimage));
        PlaneImage = weakenemyicon.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList();
        Visible = true;
        SpeedX = 2;
        SpeedY = 3;
        HitPoints = 10;
        CurrentBullet = new SpiralBullet();
        CurrentPosition = new Point(x,y);
        HitPoints = StrongEnemyHealth;
        Description = StrongEnemyDescription;
    }    
    public void run() {
        if (CurrentPosition.x < 0) 
        {
            CurrentPosition.x = Board_Width-PlaneImage.getWidth(null);
            HitPoints = HitPoints + StrongEnemyHealth;
            //SpeedX += PenaltySpeed;
            //SpeedY += PenaltySpeed;
        }
        CurrentPosition.x -= SpeedX;
        if (CurrentPosition.y < 0) 
        {
            CurrentPosition.y = PlaneImage.getHeight(null);
            SpeedY = -SpeedY;
        }
        if(CurrentPosition.y > Board_Height)
        {
            CurrentPosition.y = Board_Height-PlaneImage.getHeight(null);
            SpeedY = -SpeedY;
        }
        CurrentPosition.x -= SpeedX;
        CurrentPosition.y -= SpeedY;
    }
}
