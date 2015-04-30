/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple.Plane.Fighter;

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

public class WeakEnemy extends Plane implements GameSetting,Enemy {
    
    public WeakEnemy() {
        super();
        ImageIcon weakenemyicon = new ImageIcon(this.getClass().getResource(weakenemyimage));
        PlaneImage = weakenemyicon.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList();
        Visible = true;
        SpeedX = WeakEnemySpeed;
        SpeedY = WeakEnemySpeed;
        HitPoints = 10;
        CurrentBullet = new SpiralBullet();
        CurrentPosition = new Point(InitialEnemySpawnPosition);
        HitPoints = WeakEnemyHealth;
    }
    
    public WeakEnemy(int x,int y) {
        super(x,y);
        ImageIcon weakenemyicon = new ImageIcon(this.getClass().getResource(weakenemyimage));
        PlaneImage = weakenemyicon.getImage();
        width = PlaneImage.getWidth(null);
        height = PlaneImage.getHeight(null);
        bullet = new ArrayList();
        Visible = true;
        SpeedX = WeakEnemySpeed;
        SpeedY = WeakEnemySpeed;
        HitPoints = 10;
        CurrentBullet = new Bullet();
        CurrentPosition = new Point(x,y);
        HitPoints = WeakEnemyHealth;
    }
    
    public void run() {
        if (CurrentPosition.x < 0) 
        {
            CurrentPosition.x = Board_Width-PlaneImage.getWidth(null);
            HitPoints = HitPoints + WeakEnemyHealth;
            //SpeedX += PenaltySpeed;
            //SpeedY += PenaltySpeed;
        }
        CurrentPosition.x -= SpeedX;
    }
    public String PrintDescription() {
        return WeakEnemyDescription;
    }
}
