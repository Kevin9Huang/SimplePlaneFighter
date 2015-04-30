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
    public final String srcplayer = "/srcimage/player2.png";
    public final String weakenemyimage = "/srcimage/alien.png";
    public final String mediumenemyimage = "/srcimage/headufo.gif";
    public final String strongenemyimage = "/srcimage/009_ufo0000_trans.gif";
    public final String bulletimg = "/srcimage/explosion.png";
    public final String heartimg = "/srcimage/heart.png";
    public final String ultimateicon = "/srcimage/nuke.png";
    public final String ultimateimg = "/srcimage/pjpa4449.gif";
    public final String ZigZagBulletimg = "/srcimage/ZigZagBullet.gif";
    public final String SpiralBulletimg = "/srcimage/SpiralBullet.gif";
    public final String [] ClassBulletName = new String[]{"Bullet","ZigZagBullet","SpiralBullet"};
    public final String backgroundmusic = "/srcmusic/backgroundmusic.mp3";
    public final ArrayList<String> ArrayClassBulletName = new ArrayList<String>(Arrays.asList(ClassBulletName));
   
}
