/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import juego.hanoi.Juego;

/**
 *
 * @author dieez
 */
public class Disco extends JLabel implements MouseListener, MouseMotionListener, ActionListener{

    
    //identifica el disco
    private String key;
    //posicion de la imagen
    private Point posicion = new Point(0,0); 
    //tamaño de la imagen
    private Dimension d = new Dimension(200,34);
    //sirve para calcular el movimiento del objeto
    private Point start_lock;
    //sirve para calcular el movimiento del objeto
    private Point start_drag;
    //sirve para calcular el movimiento del objeto
    private Point offset;
    //auxiliares para el movimiento del objeto
    private int nuevo_X = -1;
    private int nuevo_Y = -1;
    private int torre = 1;
    JPanel jpanel = new JPanel();
    JLabel texto = new JLabel();
    
    public Disco(String key, JPanel jpanel, JLabel texto){
    
        this.key = key;
        this.setToolTipText(key);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setSize (d);
        this.setPreferredSize(d);
        this.setIcon(new ImageIcon(getClass().getResource("/img/disco 6.png")));
        this.setText("");
        this.setVisible(true);
        this.setLocation(posicion);
        this.setName(key);
        this.jpanel = jpanel;
        this.texto = texto;
        //
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.torre = 1;
        
        
        
    }
    
   

   
    
    
    public String getKey(){return key;}
    public void setKey(String key){this.key = key;}
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {    
        this.start_drag = getScreenLocation(e);
        this.start_lock = this.getLocation();
    }
//cuando se suelta el mouse
    @Override
    public void mouseReleased(MouseEvent e) {      
       
       
        nuevo_X = (this.getLocation().x);
        nuevo_Y = (this.getLocation().y);
        this.setLocation(nuevo_X, nuevo_Y);
        
        //cambia los movimietnos
        Juego panel = new Juego();
        panel.getContentPane();
        String txt = this.texto.getText();
        int conteo = Integer.valueOf(txt);
        conteo +=1;
        this.texto.setText(String.valueOf(conteo));
        
        
        //hace caer los discos en su lugar
        int aux = 355;
        Dimension fondo = new Dimension(200,34);
        
        
        if (this.getLocation().x > -100 && this.getLocation().x < 175){         
    
            
            this.setLocation(0,335);
        }
        
        
         if (this.getLocation().x > 175 && this.getLocation().x < 275){
            
             if(this.jpanel.getComponentAt(200, 335).size() != fondo)
             {
                this.setLocation(200,335); 
                
             }else if(this.jpanel.getComponentAt(200, 335).size() == fondo)
             {
                this.setLocation(200,301);   
             } 
             
             
            System.out.println(this.jpanel.getComponentAt(0, 335).size());
            System.out.println(this.jpanel.getComponentAt(200, 335).size());
        }
         
         if (this.getLocation().x > 275 && this.getLocation().x < 500){
            
            
            this.setLocation(400,335);
        }
        
        
        
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(200,0,51),1));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBorder(null);
       
            
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point current = this.getScreenLocation(e);
        offset = new Point((int) current.getX() - (int) start_drag.getX(), (int) current.getY() - (int) start_drag.getY());
        Point new_Location = new Point((int) (this.start_lock.getX() + offset.getX()), (int) (this.start_lock.getY() + offset.getY()));
        this.setLocation(new_Location);
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    private Point getScreenLocation(MouseEvent evt) {

        Point cursor = evt.getPoint();
        Point target_location = this.getLocationOnScreen();
        return new Point((int) (target_location.getX() + cursor.getX()),
                (int) (target_location.getY() + cursor.getY()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
