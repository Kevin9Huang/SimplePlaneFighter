package Simple.Plane.Fighter;
/**
 *
 * @author Kevin Huang
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board3 extends JPanel implements ActionListener,GameSetting {

    private Timer timer;
    private PlayerKevin player;
    private ArrayList<WeakEnemy> weakenemies;
    private ArrayList<MediumEnemy> mediumenemies;
    private ArrayList<StrongEnemy> strongenemies;
    private boolean ingame;

    private int[][] pos = { 
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239}, 
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
     };

    public Board3() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        ingame = true;

        setSize(400, 300);

        player = new PlayerKevin();

        initAliens();

        timer = new Timer(5, this);
        timer.start();
    }

    public void addNotify() {
        super.addNotify(); 
    }

    public void initAliens() {
        weakenemies = new ArrayList();
        mediumenemies = new ArrayList();
        strongenemies = new ArrayList();
        
        for (int i=0; i<pos.length; i++ ) {
            weakenemies.add(new WeakEnemy(pos[i][0], pos[i][1]));
        }
    }


    public void paint(Graphics g) {
        super.paint(g);

        if (ingame) {

            Graphics2D g2d = (Graphics2D)g;

            if (player.isPlaneVisible())
                g2d.drawImage(player.getPlaneImage(), player.getCurrentPosition().x, player.getCurrentPosition().y,
                              this);

            for (int i = 0; i < player.getBullet().size(); i++) {
                Bullet m = (Bullet)player.getBullet().get(i);
                g2d.drawImage(m.getBulletImage(), m.getCurrentPosition().x, m.getCurrentPosition().y, this);
            }

            for (int i = 0; i < weakenemies.size(); i++) {
                WeakEnemy weakenemy = (WeakEnemy)weakenemies.get(i);
                if (weakenemy.isPlaneVisible())
                    g2d.drawImage(weakenemy.getPlaneImage(), weakenemy.getCurrentPosition().x, weakenemy.getCurrentPosition().y, this);
                for (int j = 0; j < weakenemy.getBullet().size(); j++) {
                    Bullet m = (Bullet) weakenemy.getBullet().get(j);
                    g2d.drawImage(m.getBulletImage(), m.getCurrentPosition().x, m.getCurrentPosition().y, this);
                }
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("Score " + player.getScore(), 5, 15);


        } else {
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = this.getFontMetrics(small);

            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (Board_Width - metr.stringWidth(msg)) / 2,
                         Board_Height / 2);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {

        if (weakenemies.size()==0 && mediumenemies.size() == 0 && strongenemies.size() == 0) {
            ingame = false;
        }
        for (int i = 0; i < player.getBullet().size(); i++) {
            Bullet playerbullet = (Bullet) player.getBullet().get(i);
            if (playerbullet.isVisible()) 
                playerbullet.move(true);
            else player.getBullet().remove(i);
        }

        for (int i = 0; i < weakenemies.size(); i++) {
            WeakEnemy weakenemy = (WeakEnemy) weakenemies.get(i);
            if (weakenemy.isPlaneVisible()){
                weakenemy.run();
                for (int j = 0; j < weakenemy.getBullet().size(); j++) {
                    Bullet enemybullet = (Bullet) weakenemy.getBullet().get(j);
                    if (enemybullet.isVisible()){
                        enemybullet.move(false);
                    }
                    else weakenemy.getBullet().remove(j);
                }
            } 
            else{
                weakenemies.remove(i);
                player.setScore(player.getScore() + WeakScore);
            }
        }

        player.run();
        checkCollisions();
        repaint();  
    }

    public void checkCollisions() {

        Rectangle playerarea = player.getCollisionArea();

        for (int j = 0; j<weakenemies.size(); j++) {
            WeakEnemy weakenemy = (WeakEnemy) weakenemies.get(j);
            Rectangle weakenemyarea = weakenemy.getCollisionArea();

            if (playerarea.intersects(weakenemyarea)) {
                player.setPlaneVisible(false);
                weakenemy.setPlaneVisible(false);
                ingame = false;
            }
        }

        for (int i = 0; i < player.getBullet().size(); i++) {
            Bullet playerbullet = (Bullet) player.getBullet().get(i);

            Rectangle playerbulletarea = playerbullet.getCollisionArea();

            for (int j = 0; j<weakenemies.size(); j++) {
                WeakEnemy weakenemy = (WeakEnemy) weakenemies.get(j);
                Rectangle weakenemyarea = weakenemy.getCollisionArea();

                if (playerbulletarea.intersects(weakenemyarea)) {
                    playerbullet.setVisible(false);
                    weakenemy.setPlaneVisible(false);
                }
            }
        }
        for (int i = 0; i<weakenemies.size(); i++) {
            for (int j = 0; j < weakenemies.get(i).getBullet().size(); j++) {
                Bullet enemybullet = (Bullet) weakenemies.get(i).getBullet().get(j);

                Rectangle enemybulletarea = enemybullet.getCollisionArea();

                    if (enemybulletarea.intersects(playerarea)) {
                        weakenemies.get(i).getBullet().get(j).setVisible(false);
                        player.setPlaneVisible(false);
                        ingame = false;
                    }
            }
        }
    }
    


    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
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
            if (key == KeyEvent.VK_SPACE) {
                player.Shot();
                for(int i=0;i<weakenemies.size();i++){
                    weakenemies.get(i).Shot();
                }
            }
            
            
        }
        public void keyReleased(KeyEvent e){
            player.ResetDeltaMove();
        }
    }
}

