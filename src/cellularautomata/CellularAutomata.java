/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellularautomata;

/**
 *
 * @author Liam
 */
public class CellularAutomata {
    
    private static int x = 30;
    private static int y = 30;
    private static int time = 2000;

    public static void main(String[] args) {
        
        GUI gui = new GUI(x, y);
        gui.setVisible(true);
        gui.gameTimer(time);
    }
    
}
