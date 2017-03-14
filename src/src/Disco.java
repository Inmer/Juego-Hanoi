/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dieez
 */
public class Disco extends JLabel implements MouseListener, MouseMotionListener {

    
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
    
    public Disco(String key){
    
        this.key = key;
        this.setToolTipText(key);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setSize (d);
        this.setPreferredSize(d);
        this.setIcon(new ImageIcon(getClass().getResource("/img/disco 6.png")));
        this.setText("");
        this.setVisible(true);
        this.setLocation(posicion);
        //
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
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

    @Override
    public void mouseReleased(MouseEvent e) {
        nuevo_X = (this.getLocation().x);
        nuevo_Y = (this.getLocation().y);
        this.setLocation(nuevo_X, nuevo_Y);
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

    
    
}
