package tetris;

import java.util.ArrayList;
import java.util.Random;

public class Figure {
    int[][] map = new int[10][15];
    ArrayList<Point> fig = new ArrayList();
    int tupe;
    public void new_fig(int tupe){
        this.tupe = tupe;
        fig.removeAll(fig);
        if(tupe == 0){fig.add(new Point(0,1));fig.add(new Point(1,1));fig.add(new Point(0,0));fig.add(new Point(1,0));}
        if(tupe == 1){fig.add(new Point(0,3));fig.add(new Point(0,2));fig.add(new Point(0,1));fig.add(new Point(0,0));}
    }
    public void left(){
        int min = 444;
        ArrayList<Point> temp_point = new ArrayList();
        for(int i = 0; i < fig.size();i++){
            temp_point.add(new Point(fig.get(i).x - 1,fig.get(i).y));
            if(min > fig.get(i).x - 1) min = fig.get(i).x - 1;
        }
        if(min >= 0){
            boolean log = true;
            for(int i = 0; i < temp_point.size(); i++)
            if(map[temp_point.get(i).x][temp_point.get(i).y] == 1)
                log = false;
            if(log)
            fig = temp_point;
        }
    }
    public void right(){
        int max = 0;
        ArrayList<Point> temp_point = new ArrayList();
        for(int i = 0; i < fig.size();i++){
            temp_point.add(new Point(fig.get(i).x + 1,fig.get(i).y));
            if(max < fig.get(i).x + 1) max = fig.get(i).x + 1;
        }
        if(max <= 9){
            boolean log = true;
            for(int i = 0; i < temp_point.size(); i++)
            if(map[temp_point.get(i).x][temp_point.get(i).y] == 1)
                log = false;
            if(log)
            fig = temp_point;
        }
        
    }
    public boolean down(int[][] map){
        Random rnd = new Random();
        boolean log = true;
        this.map = map;
        ArrayList<Point> temp_point = new ArrayList();
        for(int i = 0; i < fig.size();i++){
            temp_point.add(new Point(fig.get(i).x ,fig.get(i).y + 1));
            if( (fig.get(i).y + 1) >= 14) log = false;
        }
        for(int i = 0; i < temp_point.size(); i++)
            if(map[temp_point.get(i).x][temp_point.get(i).y] == 1)
                log = false;
        if(log) fig = temp_point; else {
            for(int i = 0; i < fig.size(); i++)
                this.map[fig.get(i).x][fig.get(i).y] = 1;
            new_fig(rnd.nextInt(2));update(); return false;}
        return true;
        
    }
    public void full_down(){
        while(down(map)){}
    }
   
    public void rotate(){
        boolean log = true;
        ArrayList<Point> temp_point = new ArrayList();
        for(int i = 0; i < fig.size();i++)
            temp_point.add(new Point(fig.get(i).y-fig.get(0).x,fig.get(i).x-fig.get(0).y));
        
        for(int i = 0; i < temp_point.size(); i++)
        if(map[temp_point.get(i).x][temp_point.get(i).y] == 1)
                log = false;
            if(log)
            fig = temp_point;
        
        
    }
    public void update(){
        for(int j = 0; j < 15; j++){
        boolean log = true;
        for(int i = 0; i < 10; i++)
            if(map[i][j] == 0)
                log = false;
        if(log){
            for(int i_1 = 0; i_1 < 10; i_1++)
                map[i_1][j] = 0;
            for(int j_1 = j; j_1 > 0; j_1--)
                for(int i_1 = 0; i_1 < 10; i_1++)
                    map[i_1][j_1] = map[i_1][j_1 - 1];
        }
        }
    }
    public int[][] get_map(){
        
        int[][] map = new int[10][15];
        for(int i = 0; i < 10; i++)
            for(int j = 0; j < 15; j++)
                map[i][j] = this.map[i][j];
        for(int i = 0; i < fig.size(); i++)
            map[fig.get(i).x][fig.get(i).y] = 1;
        return map;
    }
    
}
