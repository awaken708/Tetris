package tetris;

import java.awt.*;
import java.awt.event.*;


public class Visual extends Frame {

    int[][] map_class;

    Visual(int[][] map) {
        map_class = map;

        setSize(400, 600);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });

    }

    public void set_map(int[][] map) {
        map_class = map;
    }
    Image offscreen;
    Graphics g2;

    public void paint(Graphics g) {

        offscreen = createImage(400, 600);
        g2 = offscreen.getGraphics();
        //g2.clearRect(0, 0, map_class[0].length, map_class[0].length);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                if (map_class[i][j] > 0) {
                    g2.setColor(Color.red);
                    g2.fillRect(i*40 , j*40 + 30, 40, 40);
                } else {
                    g2.setColor(Color.black);
                    g2.fillRect(i*40 , j*40 + 30 , 40, 40);
                }
            }
        }
        //if(!offscreen.getGraphics().equals(g))
        g.drawImage(offscreen, 0, 0, null);

    }

    public void update(Graphics g) {
        paint(g);
    }

}
