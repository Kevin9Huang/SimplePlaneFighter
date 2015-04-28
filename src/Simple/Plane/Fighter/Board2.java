/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple.Plane.Fighter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Kevin Huang
 */
public class Board2 extends JPanel implements Runnable,GameSetting,GameResources{
    private Timer timer;
    private PlayerKevin player;
    private ArrayList<WeakEnemy> weakenemies;
    private ArrayList<StrongEnemy> strongenemies;
    private ArrayList<MediumEnemy> mediumenemies;
    private boolean ingame;
    private Thread animator;
    public Board2(){
        ingame = true;
        addKeyListener(new TAdapter() {});
        Dimension d = new Dimension(Board_Width,Board_Height);
        setBackground(Color.black);
        gameInit();
        setDoubleBuffered(true);
    }
    
    public void addNotify(){
        super.addNotify();
        gameInit();
    }
    
    public void gameInit(){
        weakenemies = new ArrayList();
        mediumenemies = new ArrayList();
        strongenemies = new ArrayList();
        for (int i=0; i < 4; i++) {
            for (int j=0; j < 6; j++) {
                WeakEnemy weakenemy = new WeakEnemy(InitialEnemySpawnPosition.x, InitialEnemySpawnPosition.y);
                weakenemies.add(weakenemy);
            }
        }
        player = new PlayerKevin();
        if (animator == null || !ingame) {
            animator = new Thread(this);
            animator.start();
        }
    }
    
    public void drawEnemy(Graphics g){
        for(int i = 0;i<weakenemies.size();i++){
            WeakEnemy weakenemy = weakenemies.get(i);
            if(weakenemy.isPlaneVisible()){
                g.drawImage(weakenemy.getPlaneImage(),weakenemy.getCurrentPosition().x,weakenemy.getCurrentPosition().y, this);
            }
        }
    }
    
    public void drawPlayer(Graphics g){
        if(player.isPlaneVisible()){
            g.drawImage(player.getPlaneImage(),player.getCurrentPosition().x,player.getCurrentPosition().y, this);
        }
        else{
            ingame = false;
        }
    }
    
    public void drawBullet(Graphics g){
        for(int i = 0;i<player.getBullet().size();i++){
            Bullet bullet = player.getBullet().get(i);
            if(bullet.isVisible()){
                g.drawImage(bullet.getBulletImage(),bullet.getX(),bullet.getY(), this);
            }
        }
        for(int i = 0;i<weakenemies.size();i++){
            WeakEnemy weakenemy = weakenemies.get(i);
            for(int j = 0;j<weakenemy.getBullet().size();j++){
                Bullet bullet = player.getBullet().get(j);
                if(bullet.isVisible()){
                    g.drawImage(bullet.getBulletImage(),bullet.getX(),bullet.getY(), this);
                }
            }
        }
        for(int i = 0;i<mediumenemies.size();i++){
            MediumEnemy mediumenemy = mediumenemies.get(i);
            for(int j = 0;j<mediumenemy.getBullet().size();j++){
                Bullet bullet = player.getBullet().get(j);
                if(bullet.isVisible()){
                    g.drawImage(bullet.getBulletImage(),bullet.getX(),bullet.getY(), this);
                }
            }
        }
        for(int i = 0;i<strongenemies.size();i++){
            StrongEnemy strongenemy = strongenemies.get(i);
            for(int j = 0;j<strongenemy.getBullet().size();j++){
                Bullet bullet = player.getBullet().get(j);
                if(bullet.isVisible()){
                    g.drawImage(bullet.getBulletImage(),bullet.getX(),bullet.getY(), this);
                }
            }
        }
    }
    
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0,Board_Width,Board_Height);
        g.setColor(Color.green);   

        if (ingame) {
          drawEnemy(g);
          drawPlayer(g);
          drawBullet(g);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        
    }
    
    public void animationCycle()  {

        /*if (deaths == NUMBER_OF_ALIENS_TO_DESTROY) {
            ingame = false;
            message = "Game won!";
        }*/

        // player

        player.run();
        
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (ingame) {
            repaint();
            animationCycle();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) 
                sleep = 2;
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
            beforeTime = System.currentTimeMillis();
        }
        gameOver();
    }*/
    
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
