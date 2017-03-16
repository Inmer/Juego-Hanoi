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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import juego.hanoi.Juego;

/**
 *
 * @author dieez
 */
public class Disco extends JLabel implements MouseListener, MouseMotionListener, ActionListener{

    private Point inicio;
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
    private JPanel jpanel = new JPanel();
    private JLabel texto = new JLabel();
    private JLabel solucion = new JLabel();
    private int discos;
    private int abajo;
    private int arriba;
    
    public Disco(String key, JPanel jpanel, JLabel texto, int discos, JLabel solucion){
    
        this.key = key;
        this.setToolTipText(key);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setSize (d);
        this.setPreferredSize(d);
        this.setIcon(new ImageIcon(getClass().getResource("/img/disco 6.png")));
        this.setText("");
        this.setVisible(true);
        this.setLocation(posicion);
        this.inicio = posicion;
        this.setName(key);
        this.jpanel = jpanel;
        this.texto = texto;
        this.solucion = solucion;
        this.discos = discos;
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
        //si no hay nada arriba deja mover el 
        Point aux = this.getLocation();
        
        if(this.jpanel.getComponentAt(aux.x, aux.y-34).size().height != 34){
        
        this.start_drag = getScreenLocation(e);
        this.start_lock = this.getLocation();
        this.inicio = this.getLocation();
        }
        
    }
//cuando se suelta el mouse
    public void caer(){
    
        //hace caer los discos en su lugar
        int aux = 355;
        Dimension fondo = new Dimension(600,400);
        Dimension p = new Dimension(200,34);
        //existe una variable inicio que servira para regresar el dico cuando el de abajo sea mayor
        
        //cae en torre 1
        if (this.getLocation().x > -100 && this.getLocation().x < 175){         
    
             if (this.jpanel.getComponentAt(0, 199).size().height == 34) {
                 
                 //revisa si el de abajo es menor para poder decidir si lo regrea o lo coloca
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(0, 199).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(0, 165);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                 

             } else if (this.jpanel.getComponentAt(0, 233).size().height == 34) {
                 
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(0, 233).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(0, 199);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                 

             }else if (this.jpanel.getComponentAt(0, 267).size().height == 34) {
                 
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(0, 267).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(0, 233);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                 

             }else if (this.jpanel.getComponentAt(0, 301).size().height == 34) {
                 
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(0, 301).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(0, 267);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                 

             }else if (this.jpanel.getComponentAt(0, 335).size().height == 34) {
                 
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(0, 335).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(0, 301);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                
             }
             
             if (this.jpanel.getComponentAt(0, 335).size().height == 400) {
                 this.setLocation(0, 335);

             }
            
        }
        
        //cae en torre2
         if (this.getLocation().x > 175 && this.getLocation().x < 275){             
          
           
             if (this.jpanel.getComponentAt(200, 199).size().height == 34) {
                 
                 //revisa si el de abajo es menor para poder decidir si lo regrea o lo coloca
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(200, 199).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(200, 165);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                 

             } else if (this.jpanel.getComponentAt(200, 233).size().height == 34) {
                 
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(200, 233).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(200, 199);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                 

             }else if (this.jpanel.getComponentAt(200, 267).size().height == 34) {
                 
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(200, 267).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(200, 233);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                 

             }else if (this.jpanel.getComponentAt(200, 301).size().height == 34) {
                 
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(200, 301).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(200, 267);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                 

             }else if (this.jpanel.getComponentAt(200, 335).size().height == 34) {
                 
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(200, 335).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(200, 301);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                
             }
             
             if (this.jpanel.getComponentAt(200, 335).size().height == 400) {
                 this.setLocation(200, 335);

             }

             System.out.println(this.jpanel.getComponentAt(200, 335).size());
             
             
             
             
           // System.out.println(this.jpanel.getComponentAt(0, 335).size());
            //System.out.println(this.jpanel.getComponentAt(200, 335).size());
        }
         
         //cae en torre 3
         if (this.getLocation().x > 275 && this.getLocation().x < 500){
            
            
            if (this.jpanel.getComponentAt(400, 199).size().height == 34) {
                 
                 //revisa si el de abajo es menor para poder decidir si lo regrea o lo coloca
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(400, 199).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(400, 165);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                 

             } else if (this.jpanel.getComponentAt(400, 233).size().height == 34) {
                 
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(400, 233).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(400, 199);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                 

             }else if (this.jpanel.getComponentAt(400, 267).size().height == 34) {
                 
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(400, 267).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(400, 233);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                 

             }else if (this.jpanel.getComponentAt(400, 301).size().height == 34) {
                 
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(400, 301).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(400, 267);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                 

             }else if (this.jpanel.getComponentAt(400, 335).size().height == 34) {
                 
                 this.abajo = Integer.valueOf(this.jpanel.getComponentAt(400, 335).toString().charAt(10))- 48;
                 this.arriba = Integer.valueOf(this.getToolTipText());
                 
                 if(this.abajo > this.arriba ){
                        this.setLocation(400, 301);
                    }
                 if(this.abajo < this.arriba){
                         this.setLocation(inicio);
                    }
                 
                
             }
             
             if (this.jpanel.getComponentAt(400, 335).size().height == 400) {
                 this.setLocation(400, 335);

             }

        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {      
       
       
        nuevo_X = (this.getLocation().x);
        nuevo_Y = (this.getLocation().y);
        
        
        //cambia los movimietnos
        Juego panel = new Juego();
        panel.getContentPane();
        String txt = this.texto.getText();
        int conteo = Integer.valueOf(txt);
        conteo +=1;
        this.texto.setText(String.valueOf(conteo));
        
        
        caer();
        
        //gana si hay algo en el tope de la torre 3 dependiendo de la cantidad de discos
        
        ganar();
        
        
    }
    
    public void ganar(){
    
        String txt = this.texto.getText();
        int movidas = Integer.valueOf(txt);
        
        String txt2 = this.solucion.getText();
        int solucion = Integer.valueOf(txt);
        
        //gana si hay algo en el tope de la torre 3 dependiendo de la cantidad de discos
        
        switch (this.discos) {
            case 6:
                if (this.jpanel.getComponentAt(400, 165).size().height == 34) {
                    JOptionPane.showMessageDialog(null, "Ganaste ");
                    
                    if (movidas == solucion){
                     JOptionPane.showMessageDialog(null, "Juego perfecto");
                    }
                    
                }
                break;
            case 5:
                if (this.jpanel.getComponentAt(400, 199).size().height == 34) {
                    JOptionPane.showMessageDialog(null, "Ganaste ");
                    if (movidas == solucion){
                     JOptionPane.showMessageDialog(null, "Juego perfecto");
                    }
                }
                break;
            case 4:
                if (this.jpanel.getComponentAt(400, 233).size().height == 34) {
                    JOptionPane.showMessageDialog(null, "Ganaste ");
                    if (movidas == solucion){
                     JOptionPane.showMessageDialog(null, "Juego perfecto");
                    }
                }
                break;
            case 3:
                if (this.jpanel.getComponentAt(400, 267).size().height == 34) {
                    JOptionPane.showMessageDialog(null, "Ganaste ");
                    if (movidas == solucion){
                     JOptionPane.showMessageDialog(null, "Juego perfecto");
                    }
                }
                break;

        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
         
        Point aux = this.getLocation();
        
        if(this.jpanel.getComponentAt(aux.x, aux.y-34).size().height != 34){
        this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(200,0,51),1));
        }
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
