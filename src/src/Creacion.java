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
    
    private JPanel contenedor;
    //default list model
    private DefaultListModel listModel;
    
    /**Costructor de clase
     * @param jPanel donde se colocan los discos
     * @param DfaultListModel
     */
    
    public Creacion(JPanel jpanel, DefaultListModel listModel) {
        this.contenedor = jpanel;
        this.listModel = listModel;
    }
    
    public void Nuevo_Objeto(int discos)
    {
        
        int aux = discos;
        int ancho = discos;
        int auxY = 335;
        
        for(int i = discos; i > 0; i--)
        {            
        //Crea una nueva instancia de "MiObjeto"
        Disco tmp = new Disco( "Objeto " + this.contador );
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
