/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellularautomata;

import java.util.Random;

/**
 *
 * @author Liam
 */
public class Cells {
    
    private int[] surroundingCells = new int[9];
    private int cellState;
    
    public Cells(int[] surroundingCells){
        this.surroundingCells = surroundingCells;
        this.cellState = surroundingCells[4];
        
        Random rand = new Random();
        
        //Wall = 0
        //Fire = 1
        //Ash = 2
        //Ground = 3
        //Tree = 4
        //Pine = 5
        //Water = 6
        
        switch(cellState){
            //wall
            case 0: {
                cellState = 0;
                break;
            }
            
            //fire
            case 1: {
                for(int i : surroundingCells){
                    if(i == 6){ //---------------   //If cell is water
                        i = 3; //----------------   //turns to ground
                        cellState = 3;
                    }
                    if(i != 6){
                        if(rand.nextInt(3) == 0){   //33% chance of turning to Ash
                            cellState = 2; 
                        }else{
                            cellState = 1;
                        }
                    }
                }
                break;
            }
            
            //Ash
            case 2: {
                if(rand.nextInt(100) == 0){
                    cellState = 2;
                }else{
                    cellState = 3;
                }
                break;
            }
            
            //Ground
            case 3: {
                if(rand.nextInt(200) == 0){
                    if(rand.nextInt(5) == 0){
                        cellState = 5;
                    }else{
                        cellState = 4;
                    }
                }else{
                    cellState = 3;
                }
                break;
            }
            
            //tree
            case 4: {
                for(int i: surroundingCells) {
                    if(i == 1){
                        if(rand.nextInt(3) == 0){
                            cellState = 1;
                        }else{
                            cellState = 4;
                        }
                    }
                }
                if(rand.nextInt(10000) == 0){
                    cellState = 1;
                }
                break;
            }
            
             //Pine
            case 5: {
                for(int i: surroundingCells) {
                    if(i == 1){
                        if(rand.nextInt(10) == 0){
                            cellState = 1;
                        }else{
                            cellState = 5;
                        }
                    }
                }
                if(rand.nextInt(10000) == 0){
                    cellState = 1;
                }
                break;
            }
            
            //Water
            case 6: {
                for(int i : surroundingCells){
                    if(i == 1){
                        cellState = 3;
                    }else{
                        cellState = 6;
                    }
                }
                break;
            }
        }
        this.surroundingCells[4] = cellState;
    }
    
    public int[] returnCells(){
        return this.surroundingCells;
    }
    
}
