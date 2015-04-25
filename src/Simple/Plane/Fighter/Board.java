/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simple.Plane.Fighter;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Kevin Huang
 */
public class Board extends JPanel implements ActionListener{
    private Timer timer;
    private Image player;
    private ArrayList weakenemy;
    private ArrayList mediumenemy;
    private ArrayList strongenemy;
    boolean ingame;
    private int Width_Board;
    private int Height_Board;
    private final String srcplayer = "../spacepix/player.png";
    private final String srcweakenemy = "weakenemy.png";
    private String message = "Game Over";
    
    public Board(int _width,int _height){
        Width_Board = _width;
        Height_Board = _height;
        weakenemy = new ArrayList();
        mediumenemy = new ArrayList();
        strongenemy = new ArrayList();
        ingame = false;
        initenemy();
    }
    private void initenemy(){
        
    }
    public void AddNotify(){
        super.addNotify();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
