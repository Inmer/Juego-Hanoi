/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.hanoi;

/**
 *
 * @author USUARIO
 */
public class HanoiCodigo {
    
    public void hanoi(int num, int inicio, int enmedio, int fin)
    {
    
        if(num == 1)
         {        
             
        System.out.println("Moviendo de la torre de inicio " + inicio + " a la torre destino " + fin);
        
         }
        else
         {
             hanoi(num-1, inicio, fin, enmedio);
             
             System.out.println("Moviendo de la torre de inicio " + inicio + " a la torre destino " + fin);
             
             hanoi(num-1, enmedio, inicio, fin);
             
         }
        
    }
    
}
