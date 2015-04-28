package Simple.Plane.Fighter;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Huang
 */
interface GameResources {
    public final String srcplayer = "/srcimage/player.png";
    public final String weakenemyimage = "/srcimage/alien.png";
    public final String mediumenemyimage = "/srcimage/headufo.gif";
    public final String strongenemyimage = "/srcimage/MediumEnemy.jpg";
    public final String bulletimg = "/srcimage/explosion.png";
    public final String ZigZagBulletimg = "/srcimage/ZigZagBullet.gif";
    public final String [] ClassBulletName = new String[]{"Bullet","ZigZagBullet"};
    public final ArrayList<String> ArrayClassBulletName = new ArrayList<String>(Arrays.asList(ClassBulletName));
    
}
