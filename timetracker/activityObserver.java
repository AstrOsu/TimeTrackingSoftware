/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetracker;

import java.awt.event.KeyListener;
import java.awt.event.*; 

/**
 *
 * @author GG46195x
 */
public class activityObserver extends MouseAdapter implements  KeyListener{
   
    long timeSinceLastAction; 
    int interval; 
    
    public activityObserver(){
        timeSinceLastAction = System.currentTimeMillis(); 
    }
    
    public void setInterval(int interval)
    {
        
    }
    
    public long sinceMoved(){
        return System.currentTimeMillis() - timeSinceLastAction; 
    }
    
    public void mouseClicked(MouseEvent e)
    {       
        timeSinceLastAction = System.currentTimeMillis(); 
    }
    
    public void mouseMoved(MouseEvent e)
    {
        timeSinceLastAction = System.currentTimeMillis(); 
    }
    
    public void keyReleased(KeyEvent e)
    {
        timeSinceLastAction = System.currentTimeMillis(); 
    }
    
    public void keyPressed(KeyEvent e)
    {
        timeSinceLastAction = System.currentTimeMillis(); 
    }
    
    public void keyTyped(KeyEvent e)
    {
        timeSinceLastAction = System.currentTimeMillis(); 
    }
    
    
}

