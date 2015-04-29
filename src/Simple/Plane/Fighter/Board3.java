package Simple.Plane.Fighter;
/**
 *
 * @author Kevin Huang
 */

import static Simple.Plane.Fighter.GameResources.bulletimg;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Board3 extends JPanel implements ActionListener,GameSetting,GameResources {

    private Timer timer;
    private PlayerKevin player;
    private ArrayList<WeakEnemy> weakenemies;
    private ArrayList<MediumEnemy> mediumenemies;
    private ArrayList<StrongEnemy> strongenemies;
    private boolean ingame;
    private boolean EnableWeakEnemy = false;
    private boolean EnableMediumEnemy = true;
    private boolean EnableStrongEnemy = false;

    private final int[][] weakenemypos = { 
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239}
     };
    
    private final int[][] mediumenemypos = { 
        {2180, 59}, {2300, 89}, {1380, 119},
        {780, 139}, {580, 169}, {680, 269}
     };
    private final int[][] strongenemypos = { 
        {2380, 89}, {2500, 119}, {1380, 149},
        {780, 169}, {580, 199}, {680, 299}
     };

    public Board3() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        ingame = true;

        setSize(400, 300);

        player = new PlayerKevin();

        initEnemies();

        timer = new Timer(5, this);
        timer.start();
    }

    public void addNotify() {
        super.addNotify(); 
    }

    public void initEnemies() {
        weakenemies = new ArrayList();
        mediumenemies = new ArrayList();
        strongenemies = new ArrayList();
        if(EnableWeakEnemy)
        {
            for (int i=0; i<weakenemypos.length; i++ ) {
                weakenemies.add(new WeakEnemy(weakenemypos[i][0], weakenemypos[i][1]));
            }
        }
        if(EnableMediumEnemy){
            for (int i=0; i<mediumenemypos.length; i++ ) {
                mediumenemies.add(new MediumEnemy(mediumenemypos[i][0], mediumenemypos[i][1]));
            }
        }
        if(EnableStrongEnemy)
        {
            for (int i=0; i<strongenemypos.length; i++ ) {
                strongenemies.add(new StrongEnemy(strongenemypos[i][0], strongenemypos[i][1]));
            }
        }
    }


    public void paint(Graphics g) {
        super.paint(g);

        if (ingame) {

            Graphics2D g2d = (Graphics2D)g;
            if (player.isPlaneVisible())
            {
                g2d.drawImage(player.getPlaneImage(), player.getCurrentPosition().x, player.getCurrentPosition().y,
                              this);
            }
            for (int i = 0; i < player.getBullet().size(); i++) {
                Bullet m;
                if(player.getBullet().get(i).getClass().getSimpleName().equals("ZigZagBullet")){
                    m = (ZigZagBullet) player.getBullet().get(i);
                }
                else{
                    m = (Bullet) player.getBullet().get(i);
                }
                 g2d.drawImage(m.getBulletImage(), m.getCurrentPosition().x, m.getCurrentPosition().y, this);
            }
            if(EnableWeakEnemy){
                for (int i = 0; i < weakenemies.size(); i++) {
                    WeakEnemy weakenemy = (WeakEnemy)weakenemies.get(i);
                    if (weakenemy.isPlaneVisible())
                        g2d.drawImage(weakenemy.getPlaneImage(), weakenemy.getCurrentPosition().x, weakenemy.getCurrentPosition().y, this);
                    for (int j = 0; j < weakenemy.getBullet().size(); j++) {
                        Bullet m;
                        if(weakenemy.getBullet().get(j).getClass().getSimpleName().equals("ZigZagBullet")){
                            m = (ZigZagBullet) weakenemy.getBullet().get(j);
                        }
                        else{
                            m = (Bullet) weakenemy.getBullet().get(j);
                        }
                        g2d.drawImage(m.getBulletImage(), m.getCurrentPosition().x, m.getCurrentPosition().y, this);
                    }
                }
            }
            if(EnableMediumEnemy){
                for (int i = 0; i < mediumenemies.size(); i++) {
                    MediumEnemy mediumenemy = (MediumEnemy)mediumenemies.get(i);
                    if (mediumenemy.isPlaneVisible())
                        g2d.drawImage(mediumenemy.getPlaneImage(), mediumenemy.getCurrentPosition().x, mediumenemy.getCurrentPosition().y, this);
                    for (int j = 0; j < mediumenemy.getBullet().size(); j++) {
                        Bullet m;
                        if(mediumenemy.getBullet().get(j).getClass().getSimpleName().equals("ZigZagBullet")){
                            m = (ZigZagBullet) mediumenemy.getBullet().get(j);
                        }
                        else{
                            m = (Bullet) mediumenemy.getBullet().get(j);
                        }
                        g2d.drawImage(m.getBulletImage(), m.getCurrentPosition().x, m.getCurrentPosition().y, this);
                    }
                }
            }
            if(EnableStrongEnemy){
                for (int i = 0; i < strongenemies.size(); i++) {
                    StrongEnemy strongenemy = (StrongEnemy)strongenemies.get(i);
                    if (strongenemy.isPlaneVisible())
                        g2d.drawImage(strongenemy.getPlaneImage(), strongenemy.getCurrentPosition().x,strongenemy.getCurrentPosition().y, this);
                    for (int j = 0; j < strongenemy.getBullet().size(); j++) {
                        Bullet m;
                        if(strongenemy.getBullet().get(j).getClass().getSimpleName().equals("ZigZagBullet")){
                            m = (ZigZagBullet) strongenemy.getBullet().get(j);
                        }
                        else{
                            m = (Bullet) strongenemy.getBullet().get(j);
                        }
                        g2d.drawImage(m.getBulletImage(), m.getCurrentPosition().x, m.getCurrentPosition().y, this);
                    }
                }
             }
             g2d.setColor(Color.WHITE);
            if(player.getScore() > 60){
                player.ChangeBullet(new ZigZagBullet());
            }
            g2d.drawString("Score : " + player.getScore(), 5, 15);
            Rectangle HealthBar = new Rectangle(5, Board_Height-30,200,20);
            g.fillRect(5, Board_Height-30,player.getHitPoints(),20);
            ImageIcon Liveicon = new ImageIcon(this.getClass().getResource(heartimg));
            Image LiveImage = Liveicon.getImage();
            g.drawImage(LiveImage, Board_Width-30, 20, 20, 20, this);
            //g2d.draw(HealthBar);

        }else {
            String msg = "Game Over....Press Enter to try again";
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
            Bullet playerbullet;
            if(player.getBullet().get(i).getClass().getSimpleName().equals("ZigZagBullet")){
                playerbullet= (ZigZagBullet) player.getBullet().get(i);
            }
            else{
                playerbullet = (Bullet) player.getBullet().get(i);
            }
            if (playerbullet.isVisible()) 
                playerbullet.move(true);
            else player.getBullet().remove(i);
        }
        if(EnableWeakEnemy){
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
        }
        if(EnableMediumEnemy){
            for (int i = 0; i < mediumenemies.size(); i++) {
                MediumEnemy mediumenemy = (MediumEnemy) mediumenemies.get(i);
                if (mediumenemy.isPlaneVisible()){
                    mediumenemy.run();
                    for (int j = 0; j < mediumenemy.getBullet().size(); j++) {
                        Bullet enemybullet = (Bullet) mediumenemy.getBullet().get(j);
                        if (enemybullet.isVisible()){
                            enemybullet.move(false);
                        }
                        else mediumenemy.getBullet().remove(j);
                    }
                } 
                else{
                    mediumenemies.remove(i);
                    player.setScore(player.getScore() + MediumScore);
                }
            }
        }
        if(EnableStrongEnemy){
            for (int i = 0; i < strongenemies.size(); i++) {
                StrongEnemy strongenemy = (StrongEnemy) strongenemies.get(i);
                if (strongenemy.isPlaneVisible()){
                    strongenemy.run();
                    for (int j = 0; j < strongenemy.getBullet().size(); j++) {
                        Bullet enemybullet = (Bullet) strongenemy.getBullet().get(j);
                        if (enemybullet.isVisible()){
                            enemybullet.move(false);
                        }
                        else strongenemy.getBullet().remove(j);
                    }
                } 
                else{
                    strongenemies.remove(i);
                    player.setScore(player.getScore() + StrongScore);
                }
            }
        }
        

        player.run();
        checkCollisions();
        repaint();  
    }

    public void checkCollisions() {

        Rectangle playerarea = player.getCollisionArea();
        if(EnableWeakEnemy){
            for (int i = 0; i<weakenemies.size(); i++) {
                WeakEnemy weakenemy = (WeakEnemy) weakenemies.get(i);
                Rectangle weakenemyarea = weakenemy.getCollisionArea();

                if (playerarea.intersects(weakenemyarea)) {
                    player.setPlaneVisible(false);
                    weakenemy.setPlaneVisible(false);
                    ingame = false;
                }
                for (int j = 0; j < weakenemies.get(i).getBullet().size(); j++) {
                    Bullet enemybullet = (Bullet) weakenemies.get(i).getBullet().get(j);

                    Rectangle enemybulletarea = enemybullet.getCollisionArea();

                        if (enemybulletarea.intersects(playerarea)) {
                            weakenemies.get(i).getBullet().get(j).setVisible(false);
                            player.setHitPoints(player.getHitPoints()-enemybullet.getBulletDamage());
                            if(player.getHitPoints() < 0){
                               player.setLives(player.getLives()-1);
                               if(player.getLives() < 0){
                                   ingame = false;
                               }
                            }
                        }
                }
            }
        }
        if(EnableMediumEnemy){
            for (int i = 0; i<mediumenemies.size(); i++) {
                MediumEnemy mediumenemy = (MediumEnemy) mediumenemies.get(i);
                Rectangle mediumenemyarea = mediumenemy.getCollisionArea();

                if (playerarea.intersects(mediumenemyarea)) {
                    player.setPlaneVisible(false);
                    mediumenemy.setPlaneVisible(false);
                    ingame = false;
                }
                for (int j = 0; j < mediumenemy.getBullet().size(); j++) {
                    Bullet enemybullet = (Bullet) mediumenemy.getBullet().get(j);

                    Rectangle enemybulletarea = enemybullet.getCollisionArea();

                        if (enemybulletarea.intersects(playerarea)) {
                            mediumenemy.getBullet().get(j).setVisible(false);
                            player.setHitPoints(player.getHitPoints()-enemybullet.getBulletDamage());
                            if(player.getHitPoints() < 0){
                               player.setLives(player.getLives()-1);
                               if(player.getLives() < 0){
                                   ingame = false;
                               }
                            }
                        }
                }
            }
        }
        if(EnableStrongEnemy){
            for (int i = 0; i<strongenemies.size(); i++) {
                StrongEnemy strongenemy = (StrongEnemy) strongenemies.get(i);
                Rectangle strongenemyarea = strongenemy.getCollisionArea();

                if (playerarea.intersects(strongenemyarea)) {
                    player.setPlaneVisible(false);
                    strongenemy.setPlaneVisible(false);
                    ingame = false;
                }
                for (int j = 0; j < strongenemy.getBullet().size(); j++) {
                    Bullet enemybullet = (Bullet) strongenemy.getBullet().get(j);

                    Rectangle enemybulletarea = enemybullet.getCollisionArea();

                        if (enemybulletarea.intersects(playerarea)) {
                            strongenemy.getBullet().get(j).setVisible(false);
                            player.setHitPoints(player.getHitPoints()-enemybullet.getBulletDamage());
                            if(player.getHitPoints() < 0){
                               player.setLives(player.getLives()-1);
                               if(player.getLives() < 0){
                                   ingame = false;
                               }
                            }
                        }
                }
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
            for (int j = 0; j<mediumenemies.size(); j++) {
                MediumEnemy mediumenemy = (MediumEnemy) mediumenemies.get(j);
                Rectangle mediumenemyarea = mediumenemy.getCollisionArea();

                if (playerbulletarea.intersects(mediumenemyarea)) {
                    playerbullet.setVisible(false);
                    mediumenemy.setPlaneVisible(false);
                }
            }
            for (int j = 0; j<strongenemies.size(); j++) {
                StrongEnemy strongenemy = (StrongEnemy) strongenemies.get(j);
                Rectangle weakenemyarea = strongenemy.getCollisionArea();

                if (playerbulletarea.intersects(weakenemyarea)) {
                    playerbullet.setVisible(false);
                    strongenemy.setPlaneVisible(false);
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
                /*for(int i=0;i<weakenemies.size();i++){
                    weakenemies.get(i).Shot();
                }*/
                for(int i=0;i<mediumenemies.size();i++){
                    mediumenemies.get(i).Shot();
                }
                /*
                for(int i=0;i<strongenemies.size();i++){
                    strongenemies.get(i).Shot();
                }*/
            }
            if(key == KeyEvent.VK_0){
                player.ChangeBullet(new Bullet());
            }
            if(key == KeyEvent.VK_1){
                player.ChangeBullet(new ZigZagBullet());
            }
            if(key == KeyEvent.VK_ENTER){
                ingame = true;
                ResetGame();
            }
            
            
        }
        public void keyReleased(KeyEvent e){
            player.ResetDeltaMove();
        }
    }
    private void ResetGame(){
        player = new PlayerKevin();
        initEnemies();
    }
}

