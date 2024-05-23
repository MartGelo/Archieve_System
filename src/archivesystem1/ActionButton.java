package archivesystem1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Vallejos
 */
public class ActionButton extends JButton{
    
    
    private boolean mousePress;

    public ActionButton() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3, 3, 3, 3));
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me) {
                mousePress=true;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                mousePress=false;
            }
            
        });
    }




    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D G2=(Graphics2D) grphcs.create();
        G2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        int width=getWidth();
        int height=getHeight();
        int size=Math.min(width, height);
        int x=(width-size)/2;
        int y=(height-size)/2;
        if(mousePress){
            G2.setColor(new Color(158,158,158));
        }else{
            G2.setColor(new Color(199,199,199));
        }
        G2.fill(new Ellipse2D.Double(x,y,size,size));
        G2.dispose();
        super.paintComponent(grphcs); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
}