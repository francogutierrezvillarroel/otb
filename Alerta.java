package ventanas;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import paneles.PnlReporteIngresos;

/**
 *
 * @author skysoftgo
 */
public class Alerta extends javax.swing.JInternalFrame {
    /**
     * Creates new form Alerta
     */
    public Alerta(JDesktopPane mainApp) {
        initComponents();
        Rectangle visibleRect = mainApp.getVisibleRect();       
        this.setSize(visibleRect.width-100, visibleRect.height);        
        PnlReporteIngresos pvc = new PnlReporteIngresos();
        this.getContentPane().add(pvc, BorderLayout.CENTER);
    }  
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Alertas");

        pack();
    }
}
