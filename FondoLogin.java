
package ventanas;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class FondoLogin extends javax.swing.JPanel {

     String ruta;
     ImageIcon ImagenFondo;
     Graphics g;
    public FondoLogin(String ruta) {
        initComponents();
        this.ruta = ruta;        
    }
    
    public void setImagen(String ruta){
        this.ruta= ruta;
        
    }
    
  
    
    public void paintComponent(Graphics g)
    {
        Dimension tam = getSize();
        //ImageIcon ImagenFondo = new ImageIcon(new ImageIcon(getClass().getResource("/resources/imagenes/croquis.jpg")).getImage());
        ImagenFondo = new ImageIcon(new ImageIcon(getClass().getResource("/resources/imagenes/"+ruta+".jpg")).getImage());
        g.drawImage(ImagenFondo.getImage(), 0, 0, tam.width,tam.height,null);
        setOpaque(false);
        super.paintComponent(g);
    }
    
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 450, Short.MAX_VALUE)
        );
    }
}
