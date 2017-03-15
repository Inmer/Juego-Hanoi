/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author dieez
 */
public class MatrizTorres {
    
    private int[] torres;
    
    public MatrizTorres(int discos){
    
        this.torres = new int[3];
        this.setTorres(torres);
        
    }

    public MatrizTorres(){
    
        
        
    }
    
    
    

    public int[] getTorres() {
        return torres;
    }

    public void setTorres(int[] torres) {
        this.torres = torres;
    }
    
    
    
}
