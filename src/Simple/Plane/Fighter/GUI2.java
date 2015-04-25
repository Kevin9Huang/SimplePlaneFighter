package Simple.Plane.Fighter;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Huang
 */
public class GUI2 extends JFrame implements ActionListener{

    private final JButton BtnUp = new JButton("UP");
    private final JButton BtnDown = new JButton("Down");
    private final JButton BtnLeft = new JButton("Left");
    private final JButton BtnRight = new JButton("Right");
    private final JButton BtnShot = new JButton("Shot");
    private final String SrcBackgound = "../srcimage/space.png";
    private final JLabel background;
    

    
    public GUI2(){
        JLabel scorelabel = null;
        scorelabel.setForeground(Color.WHITE);
        background = new JLabel(new ImageIcon(getClass().getResource(SrcBackgound)));
        background.setLayout(new BorderLayout());
        setContentPane(background);
        setTitle("Board.java");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel scorepanel = new JPanel();
        scorepanel.setOpaque(false);
        scorepanel.add(scorelabel);
        add(scorepanel,BorderLayout.NORTH);
        JPanel bottom = new JPanel();
        bottom.setOpaque(false);
        bottom.add(BtnUp);
        bottom.add(BtnDown);
        bottom.add(BtnLeft);
        bottom.add(BtnRight);
        bottom.add(BtnShot);
        add(bottom,BorderLayout.SOUTH);
        setSize(400,300);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
