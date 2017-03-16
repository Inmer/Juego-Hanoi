/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dieez
 */


public class Creacion {
    
    //contador interno de dsicos
    private int contador = 0;
    //los discos se almacenan en un map
    private Map map = new HashMap();
    private JLabel texto = new JLabel();
    private JLabel solucion = new JLabel();
    
    private JPanel contenedor;
    /**Costructor de clase
     * @param jPanel donde se colocan los discos
     * @param DfaultListModel
     */
    
    public Creacion(JPanel jpanel,JLabel texto, JLabel solucion) {
        this.contenedor = jpanel;
        this.texto = texto;
        this.solucion = solucion;
    }
    
    public void ponerDiscos(int discos)
    {
        
        
        int ancho = discos;
        int auxY = 335;
        
        
        String nombre;
        
        for(int i = discos; i != 0; i--)
        {            
         
        nombre  = String.valueOf(ancho);    
            
        
        
        //Crea una nueva instancia de Disco
        Disco tmp = new Disco(nombre, contenedor, texto, discos, solucion);
        //ingresa la imagen correcta
        tmp.setIcon(new ImageIcon(getClass().getResource("/img/disco "+ ancho +".png")));
        //pone el disco donde corresponde para iniciar
        tmp.setLocation(0,auxY);        
         //agrega el objeto en el MAP
        map.put("Objeto " + this.contador, tmp );
         //agrega el objeto en el JPanel
         this.contenedor.add(tmp);
         //actualiza graficos
         this.contenedor.repaint();
         auxY -=34;
         ancho-=1;
        }
        
        
     }
    
    
    
}
