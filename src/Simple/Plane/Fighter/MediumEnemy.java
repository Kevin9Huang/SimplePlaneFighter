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

public class MediumEnemy extends Plane implements GameSetting {
    
    public MediumEnemy() {
        ImageIcon weakenemyicon = new ImageIcon(this.getClass().getResource(mediumenemyimage));
        PlaneImage = weakenemyicon.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList();
        Visible = true;
        SpeedX = 2;
        SpeedY = 3;
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
        SpeedX = 4;
        SpeedY = 3;
        HitPoints = 10;
        CurrentBullet = new ZigZagBullet();
        CurrentPosition = new Point(x,y);
        HitPoints = MediumEnemyHealth;
    }
    
    public void run() {
        
        if (CurrentPosition.x < 0) 
        {
            CurrentPosition.x = Board_Width-PlaneImage.getWidth(null);
        }
        CurrentPosition.x -= SpeedX;
    }
}
