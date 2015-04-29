/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simple.Plane.Fighter;

/**
 *
 * @author Kevin Huang
 */
public class EnemyFactory{
    
    public Enemy createEnemy(String enemyclass,int x,int y){
        if(enemyclass == null){
            return null;
        }
        if(enemyclass.equalsIgnoreCase("WeakEnemy")){
            return (Enemy) new WeakEnemy(x,y);
        }
        if(enemyclass.equalsIgnoreCase("MediumEnemy")){
            return (Enemy) new MediumEnemy(x,y);
        }
        if(enemyclass.equalsIgnoreCase("StrongEnemy")){
            return (Enemy) new StrongEnemy(x,y);
        }
        return null;
    }
}
