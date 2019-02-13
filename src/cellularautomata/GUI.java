package cellularautomata;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class GUI extends JFrame implements MouseMotionListener, MouseListener{
    
    private boolean dragging;
    private int[][] cellArray;
    private int xNew;
    private int yNew;
    private int[] tempCells = new int[9];
    private int[] newCells = new int[9];

    public GUI(int xSize, int ySize) {
        super("Java Fire Simulation");
        super.frameInit();
        
        makeCells(xSize, ySize);
        printCells(cellArray);
        
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        pack();
        setDefaultLookAndFeelDecorated(true);
        setSize(ySize, xSize+22);
        addMouseListener(this);
        addMouseMotionListener(this);
        
        xNew = xSize/5;
        yNew = ySize/5;
    }
    
    public void drawCells(){
        for(int i = 0; i < xNew; i++ ){
            for(int j = 0; j < yNew; j++){
                
                int tempNumPlus = 0;
                
                //Loops to grab surrounding the surrounding cells
                for(int iX = -1; iX<=1; iX++){
                    for(int jX = -1; jX <= 1; jX++){
                         int xValue = i+iX;
                         int yValue = j+jX;
                         
                         //This is the wraparound for the cells on edges
                         if(xValue == -1){
                             xValue = xNew-1;
                         }else if(xValue == xNew){
                             xValue = 0;
                         }
                         
                         if(yValue == -1){
                             yValue = yNew-1;
                         }else if(yValue == yNew){
                             yValue = 0;
                         }
                        
                        tempCells[tempNumPlus] = cellArray[xValue][yValue];  
                        tempNumPlus++;//from 0-9 for surrounding cells 
                    }
                }
                Cells myCells = new Cells(tempCells);
                newCells = myCells.returnCells();
                
                for(int iY = -1; iY<1; iY++){
                    for(int jY = -1; jY<1; jY++){
                        
                        int xValue = i+iY;
                        int yValue = j+jY;

                        if(xValue == -1){
                            xValue = xNew-1;
                        }else if(xValue == xNew){
                            xValue = 0;
                        }

                        if(yValue == -1){
                            yValue = yNew-1;
                        }else if(yValue == yNew){
                            yValue = 0;
                        }
                        cellArray[xValue][yValue] = newCells[(iY+1)*3+(jY+1)];
                    }
                }
            }//End 2nd For
        }//End Outer For
        System.out.println();
    }//End Method
    
    public void gameTimer(int timeTime){
        TimerTask task = new TimerTask() {
            public void run(){
                printCells(cellArray);
                drawCells();
                printCells(cellArray);
            }
        };
        
        Timer timer = new Timer();
        timer.schedule(task, 0, timeTime);
    }
    
    private void makeCells(int arrayX, int arrayY){
        Random rand = new Random();
        
        int tempX = arrayX/5;
        int tempY = arrayY/5;
        cellArray = new int[tempX][tempY];
        
        //Fill array with cell types
        for(int i =0; i<tempX; i++){
            for(int j =0; j<tempY; j++){
                cellArray[i][j] = rand.nextInt(2)+4;
            }
        }
        cellArray[2][2] = 1;
    }
    
    public void printCells(int[][] cellsArray){
        for(int[] array1D: cellsArray){
            System.out.println();
            for(int i: array1D){
                System.out.print(i + " ");
            }
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if(dragging){
            System.out.println("Dragging left");
        }else if(!dragging){
            System.out.println("Dragging right");
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            System.out.println("X: " + e.getX() + " Y:" + e.getY());
            dragging = true;
        }else if(e.getButton() == MouseEvent.BUTTON3){
            System.out.println("right Click");
            dragging = false;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    public void processWindowEvent(WindowEvent e){
        if(e.getID() == WindowEvent.WINDOW_CLOSING){
            this.dispose();
            System.out.println("\n\nQuit App");
            System.exit(0);
        }
    }
    
}
