/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class GameLogic {

    void start() throws InterruptedException{
        int[][] map = new int[10][15];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                map[i][j] = 0;
            }
        }
        
        Visual sc = new Visual(map);
        Figure fig = new Figure();
        fig.new_fig(0);
        sc.repaint();
        sc.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 37) { fig.left(); sc.set_map(fig.get_map()); sc.repaint();}
                //if(e.getKeyCode() == 38) { fig.rotate(); sc.set_map(fig.get_map()); sc.repaint();}
                if(e.getKeyCode() == 39) { fig.right(); sc.set_map(fig.get_map()); sc.repaint();}
                if(e.getKeyCode() == 40) { fig.full_down(); sc.set_map(fig.get_map()); sc.repaint();}
            }});

  
        while(true){
            fig.down(fig.map); sc.set_map(fig.get_map()); sc.repaint();
            Thread.sleep(700);
        }
    }


    }
    

