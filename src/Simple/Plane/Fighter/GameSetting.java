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
    public static final int GROUND = 290;
}
