/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.hanoi;

import java.util.*;

/**
 *
 * @author inmer
 */
public class JuegoHanoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner h = new Scanner(System.in);
        HanoiCodigo hc = new HanoiCodigo ();
        
        System.out.println("**Para salir ingrese " + "0**");        
        System.out.print("Ingrese el numero de aros: ");
        int n;
        n= h.nextInt();        
        
        if(n!=0){        
        
        hc.hanoi(n, 1, 2, 3);        
    }   else if (n==0){
        
        System.out.print("Gracias por jugar " + "Hanoi \n");
        
    }
        
    }
        
        
    }
    

