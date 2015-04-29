package Simple.Plane.Fighter;

import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Huang
 */
interface GameSetting {
    public final int Board_Width = 930;
    public final int Board_Height = 400;
    public final Point InitialPlayerPosition = new Point(40,160);
    public final Point InitialEnemySpawnPosition = new Point(40,160);
    public final int GROUND = 290;
    public final int WeakScore = 10;
    public final int MediumScore = 30;
    public final int StrongScore = 50;
    public final int initialLives = 3;
    public final int PlayerInitialHealth = 300;
    public final int WeakEnemyHealth = 40;
    public final int MediumEnemyHealth = 80;
    public final int StrongEnemyHealth = 200;
    public final int NormalBulletDamage = 10; 
    public final int ZigZagBulletDamage = 30;
    public final int SpiralBulletDamage = 50;
    
    
}
