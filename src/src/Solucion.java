/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;

/**
 *
 * @author dieez
 */
public class Solucion {
    
    

    public static void main(String[] args) {
        // para la solucion
        ArrayList<String> lista = new ArrayList<String>();
        Solucion objHanoi = new Solucion();
        objHanoi.torresHanoi(3, 1, 2, 3, lista);
        System.out.println(lista.size());
    }
    
    public static void torresHanoi(int discos, int torre1, int torre2, int torre3,  ArrayList<String> lista){
        
        
        //algoritmo recursivo para la solucion
        if(discos==1){
            System.out.println("mover disco de torre " + torre1 + " a Torre " + torre3 );
            lista.add("");
        }else{
            
            torresHanoi(discos-1, torre1, torre3, torre2, lista);
            System.out.println("mover disco de torre " + torre1 + " a Torre " + torre3); 
            lista.add("");
            torresHanoi(discos-1, torre2, torre1, torre3, lista);
            
        }
        
    }
        
    }
    

