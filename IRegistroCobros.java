package ventanas;

import clases.ModelTablaCobros;
import clases.Cobro;
import java.awt.Cursor;
import java.awt.Rectangle;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import paneles.PnlNuevoCobro;

/**
 *
 * @author skysoftgo
 */
public class IRegistroCobros extends javax.swing.JInternalFrame {

    /**
     * Creates new form IRegistroCobros
     */
    private ModelTablaCobros mtp;
    public IRegistroCobros(JDesktopPane mainApp) {
        initComponents();
        mtp = new  ModelTablaCobros();
        this.tblPago.setModel(mtp);
        Rectangle visibleRect = mainApp.getVisibleRect();       
        //this.setSize(visibleRect.width-999, visibleRect.height);
        this.setBounds(((visibleRect.width)/4), 0,visibleRect.width-600, visibleRect.height);
        this.tblPago.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.txtNombreCliente.getDocument().addDocumentListener(EscuchadorBuscar);
        
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        lbNoExiste = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        bntNuevo = new javax.swing.JButton("Nuevo Cobro");
        bntActualizar = new javax.swing.JButton("Editar un Cobro");
        bntElliminar = new javax.swing.JButton("Eliminar un Cobro");
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPago = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cobros");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre del Vecino:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 6);
        jPanel4.add(jLabel1, gridBagConstraints);

        txtNombreCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombreCliente.setPreferredSize(new java.awt.Dimension(120, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 7);
        jPanel4.add(txtNombreCliente, gridBagConstraints);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_find.png"))); // NOI18N
        jButton4.setPreferredSize(new java.awt.Dimension(30, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel4.add(jButton4, gridBagConstraints);

        lbNoExiste.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNoExiste.setForeground(new java.awt.Color(255, 51, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel4.add(lbNoExiste, gridBagConstraints);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        bntNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bntNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_add.png"))); 
        bntNuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bntNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(bntNuevo);

        bntActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bntActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_edit.png"))); 
        bntActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bntActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntActualizarActionPerformed(evt);
            }
        });
        jPanel5.add(bntActualizar);

        bntElliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bntElliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_delete.png")));
        bntElliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bntElliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntElliminarActionPerformed(evt);
            }
        });
        jPanel5.add(bntElliminar);

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        tblPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPago);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void bntNuevoActionPerformed(java.awt.event.ActionEvent evt) {
        PnlNuevoCobro pvc = new PnlNuevoCobro();
        JLabel aviso = pvc.getLabelEscondido();
        JOptionPane.showInternalOptionDialog(this, pvc, "Registrar Nuevo cobro",JOptionPane.OK_CANCEL_OPTION,
                                            JOptionPane.QUESTION_MESSAGE, null, new Object[]{aviso},null);
        if(pvc.IsProcesoOk())
        {
            this.reiniciarTabla();
        }
    }

    private void bntActualizarActionPerformed(java.awt.event.ActionEvent evt) {
       int indice = this.tblPago.getSelectedRow();
       if(indice != -1)
       {
           Cobro pagoSeleccionado = mtp.getPago(indice);
           PnlNuevoCobro pvc = new PnlNuevoCobro(pagoSeleccionado);
            JLabel aviso = pvc.getLabelEscondido();
             JOptionPane.showInternalOptionDialog(this, pvc, "Actualizar cobro",JOptionPane.OK_CANCEL_OPTION,
                                                 JOptionPane.QUESTION_MESSAGE, null, new Object[]{aviso},null);
             if(pvc.IsProcesoOk())
             {
                 this.reiniciarTabla();
             }
       }else
       {
           JOptionPane.showMessageDialog(this, "Primero debe seleccionar una fila de la tabla", "Seleccione una fila", JOptionPane.ERROR_MESSAGE);
       }
        
    }

    private void bntElliminarActionPerformed(java.awt.event.ActionEvent evt) {
        int indice = this.tblPago.getSelectedRow();
       if(indice != -1)
       {
           Cobro pagoSeleccionado = mtp.getPago(indice);
            int confirmacion = JOptionPane.showInternalConfirmDialog(this, "¿Realmente desea borrar este cobro?", "Eliminar Cobro", JOptionPane.YES_NO_CANCEL_OPTION);
            
            if(confirmacion == JOptionPane.OK_OPTION)
            {
                int borrar = pagoSeleccionado.borrar();
                if(borrar != 0)
                {
                    reiniciarTabla();
                    JOptionPane.showMessageDialog(this, "Cobro eliminado correctamente", "Cobro Borrado", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "No se pudo Pudo borrar el cobro", "Error Interno", JOptionPane.ERROR_MESSAGE);
                }
            }
            
       }else
       {
           JOptionPane.showMessageDialog(this, "Primero debe seleccionar una fila de la tabla", "Seleccione una fila", JOptionPane.ERROR_MESSAGE);
       }
    }

    
    public void reiniciarTabla()
    {
        mtp = new  ModelTablaCobros();
        this.tblPago.setModel(mtp);
    }
    DocumentListener EscuchadorBuscar = new DocumentListener(){
        @Override
        public void insertUpdate(DocumentEvent e) {
            mostrarRegistrosEncontrados(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            mostrarRegistrosEncontrados(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            mostrarRegistrosEncontrados(e);
        }
    };
    
    
    public void mostrarRegistrosEncontrados(DocumentEvent e)
    {
        try {
            String nombreBuscar = e.getDocument().getText(0, e.getDocument().getLength());
            ModelTablaCobros mtu = new ModelTablaCobros(nombreBuscar);
            if(!nombreBuscar.isEmpty())
            {
                if(mtu.estVacio())
                {
                    this.lbNoExiste.setText("El Cliente "+nombreBuscar+" no existe");
                    mtp = new ModelTablaCobros();                
                }else{
                    mtp = mtu;       
                    this.lbNoExiste.setText("");
                }               
            }else
            {
                mtp = new ModelTablaCobros();
            }
             this.tblPago.setModel(mtp);
            if(nombreBuscar.isEmpty())
            {
                this.lbNoExiste.setText("");
            }
            
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

  
    private javax.swing.JButton bntActualizar;
    private javax.swing.JButton bntElliminar;
    private javax.swing.JButton bntNuevo;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNoExiste;
    private javax.swing.JTable tblPago;
    private javax.swing.JTextField txtNombreCliente;

}
