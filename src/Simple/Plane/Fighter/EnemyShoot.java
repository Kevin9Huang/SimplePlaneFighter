/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple.Plane.Fighter;

/**
 *
 * @author Rosi
 */

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Simple demo that uses java.util.Timer to schedule a task to execute once 5
 * seconds have passed.
 */

public class EnemyShoot {
    Toolkit toolkit;
    Timer timer;

  public EnemyShoot() {
    toolkit = Toolkit.getDefaultToolkit();
    timer = new Timer();
    timer.schedule(new Shoot(), 0, 2 * 1000); //subsequent rate
  }

  class Shoot extends TimerTask {
    int berapaKaliTembak = 10;

    public void run() {
      if (berapaKaliTembak > 0) {
        toolkit.beep();
        System.out.println("Dor!");
        berapaKaliTembak--;
      } else {
        toolkit.beep();
        System.out.println("Peluru habis!");
        //timer.cancel(); //Not necessary because we call System.exit
        System.exit(0); //Stops the AWT thread (and everything else)
      }
    }
  }

  public static void main(String args[]) {
    new EnemyShoot();
  }
}
