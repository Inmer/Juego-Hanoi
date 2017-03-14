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
public class Imagen extends javax.swing.JPanel {
    
        ImageIcon torre = new ImageIcon(getClass().getResource("/img/torre.png"));
        ImageIcon disco1 = new ImageIcon(getClass().getResource("/img/disco 1.png"));
        ImageIcon disco2 = new ImageIcon(getClass().getResource("/img/disco 2.png"));
        ImageIcon disco3 = new ImageIcon(getClass().getResource("/img/disco 3.png"));
        ImageIcon disco4 = new ImageIcon(getClass().getResource("/img/disco 4.png"));
        ImageIcon disco5 = new ImageIcon(getClass().getResource("/img/disco 5.png"));
        ImageIcon disco6 = new ImageIcon(getClass().getResource("/img/disco 6.png"));
    
    public Imagen() {
        this.setSize(600, 400); //se selecciona el tamaño del panel
        
    }

//Se crea un método cuyo parámetro debe ser un objeto Graphics
    public void paint(Graphics grafico) {
        Dimension height = getSize();

//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
        

//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
        grafico.drawImage(torre.getImage(), 0, 0, 200, 400, null);
        grafico.drawImage(torre.getImage(), 200, 0, 200, 400, null);
        grafico.drawImage(torre.getImage(), 400, 0, 200, 400, null);
        
        grafico.drawImage(disco6.getImage(), 0, 332, 200, 34, null);
        grafico.drawImage(disco5.getImage(), 0, 298, 200, 34, null);
        grafico.drawImage(disco4.getImage(), 0, 264, 200, 34, null);
        grafico.drawImage(disco3.getImage(), 0, 230, 200, 34, null);
        grafico.drawImage(disco2.getImage(), 0, 196, 200, 34, null);
        grafico.drawImage(disco1.getImage(), 0, 162, 200, 34, null);
        
        

        setOpaque(false);
        super.paintComponent(grafico);
    }

    
}


