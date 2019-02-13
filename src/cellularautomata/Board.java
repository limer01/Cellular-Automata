/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellularautomata;

import java.awt.Dimension;
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
        this.x = x;
        this.y = y;
        this.cellArray = cellArray;
        
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(null);
        boardPanel.setPreferredSize(new Dimension(x, y));
        
    }
}
