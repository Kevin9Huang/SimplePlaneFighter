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
    //Board
    public final int Board_Width = 930;
    public final int Board_Height = 400;
    
    //Position
    public final Point InitialPlayerPosition = new Point(40,160);
    public final Point InitialEnemySpawnPosition = new Point(40,160);
    
    //Scoring
    public final int WeakScore = 10;
    public final int MediumScore = 30;
    public final int StrongScore = 50;
    
    //Player
    public final int initialLives = 10;
    public final int initialPlayerHealth = 200;
    public final int initialPlayerUltimate = 10;
    public final int PlayerSpeed = 2;
    
    //Enemy
    public final int WeakEnemyHealth = 40;
    public final int MediumEnemyHealth = 80;
    public final int StrongEnemyHealth = 200;
    public final int PenaltySpeed = 1;
    public final int WeakEnemySpeed = 2;
    public final int MediumEnemySpeed = 4;
    public final int StrongEnemySpeedX = 5;
    public final int StrongEnemySpeedY = 5;

    public final boolean IncreaseHealthifPassed = false;
    public final boolean IncreaseSpeedifPassed = false;

    
    
    //Bullet
    public final int NormalBulletDamage = 10; 
    public final int ZigZagBulletDamage = 30;
    public final int SpiralBulletDamage = 50;
    public final int NormalSpeedBullet = 4;
    public final int NormalSpeedZigZagBullet = 5;
    public final int NormalSpeedSpiralBullet = 6;
    public final int SpiralBulletDefaultSpeedX = 5;
    public final int SpiralBulletDefaultSpeedY = 3;
    public final int RangeUpSpiralBullet = 50;
    public final int RangeLeftSpiralBullet = 50;
    
    //Ultimate
    public final int DefaultUltimateSpeed = 7;
    
    //Description
    public final String DescriptionTxt = "Description: ";
    public final String PlaneDescription = "This is default plane";
    public final String PlayerDescription = "This is your player";
    public final String WeakEnemyDescription = "This is weak enemy unit";
    public final String MediumEnemyDescription = "This is medium enemy unit";
    public final String StrongEnemyDescription = "This is strong enemy unit";
}
