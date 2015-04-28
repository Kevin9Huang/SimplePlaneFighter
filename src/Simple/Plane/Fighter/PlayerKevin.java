/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple.Plane.Fighter;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Kevin Huang
 */
public class PlayerKevin extends Plane implements GameSetting {

    public PlayerKevin(){
        ImageIcon playericon = new ImageIcon(this.getClass().getResource(GameResources.srcplayer));
        width = 100;
    }
    public void MoveUp(){
        dy = -SpeedY;
    }
    public void MoveDown(){
        dy = SpeedY;
    }
    public void MoveRight(){
        dx = SpeedX;
    }
    public void MoveLeft(){
        dx = -SpeedX;
    }
    public void ResetDeltaMove(){
        dx = 0;
        dy = 0;
    }
}
