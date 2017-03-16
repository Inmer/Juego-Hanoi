/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author dieez
 */
public class Torre extends javax.swing.JPanel {
    
        ImageIcon torre = new ImageIcon(getClass().getResource("/img/torre.png"));
        ImageIcon fondo = new ImageIcon(getClass().getResource("/img/fondo.png"));
    
    public Torre() {
        this.setSize(600, 400); //se selecciona el tamaño del panel
        
    }

//Se crea un método cuyo parámetro debe ser un objeto Graphics
    public void paint(Graphics grafico) {
        Dimension height = getSize();

//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        

//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
        grafico.drawImage(fondo.getImage(), 0, 0, 600, 400, null);
        grafico.drawImage(torre.getImage(), 0, 0, 200, 400, null);
        grafico.drawImage(torre.getImage(), 200, 0, 200, 400, null);
        grafico.drawImage(torre.getImage(), 400, 0, 200, 400, null);
        
        
        

        setOpaque(false);
        super.paintComponent(grafico);
    }

    
    
    
}


