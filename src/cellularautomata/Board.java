/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellularautomata;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Liam
 */
public class Board extends JPanel {
    
    private int[][] cellArray;
    private int x;
    private int y;
    
    public Board(int x, int y, int[][] cellArray){
        this.x = x/5;
        this.y = y/5;
        this.cellArray = cellArray;
        
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(null);
        boardPanel.setPreferredSize(new Dimension(x, y));
        
    }
    
    public void paintComponent(Graphics g){
        
        for(int i = 0; i<this.x; i++){
            for(int j =0; j<this.y; j++){
                
                //Fire
                if(cellArray[i][j] == 1){
                    g.setColor(Color.red);
                }
                //
                if(cellArray[i][j] == 2){
                    g.setColor(Color.gray);
                }
                if(cellArray[i][j] == 3){
                    g.setColor(Color.white);
                }
                if(cellArray[i][j] == 4){
                    g.setColor(Color.green);
                }
                if(cellArray[i][j] == 5){
                    g.setColor((Color.green).darker());
                }
                if(cellArray[i][j] == 6){
                    g.setColor(Color.blue);
                }
                if(cellArray[i][j] == 0){
                    g.setColor(Color.orange);
                }
                
;                g.fill3DRect(j*5, i*5, 5, 5, true);
            }
        }
        repaint();
        
    }
}
