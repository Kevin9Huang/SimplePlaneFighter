/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple.Plane.Fighter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author Kevin Huang
 */
public class Board2 extends JPanel implements Runnable,GameSetting,GameResources{
    private PlayerKevin player;
    private boolean ingame;
    public Board2(){
        ingame = true;
        addKeyListener(new TAdapter() {});
    }
    @Override
    public void run() {
        
    }
    
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                player.MoveLeft();
            }

            if (key == KeyEvent.VK_RIGHT) {
                player.MoveRight();
            }

            if (key == KeyEvent.VK_UP) {
                player.MoveUp();
            }

            if (key == KeyEvent.VK_DOWN) {
                player.MoveDown();
            }
            
        }

        /*public void keyPressed(KeyEvent e) {
          int key = e.getKeyCode();
          player.keyPressed(e);

          int x = player.getX();
          int y = player.getY();

          if (ingame)
          {
            if (key == KeyEvent.VK_SPACE){
                if (!shot.isVisible())
                    shot = new Shot(x, y);
            }
          }
        }*/
    }
    
}
