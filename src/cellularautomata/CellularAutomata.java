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
    
    private static int x = 400;
    private static int y = 500;
    private static int time = 100;

    public static void main(String[] args) {
        
        GUI gui = new GUI(x, y);
        gui.setVisible(true);
        gui.gameTimer(time);
    }
    
}
