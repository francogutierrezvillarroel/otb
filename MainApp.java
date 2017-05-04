package ventanas;

import clases.AdminIFrame;
import clases.Conexion;
import clases.FiltroArchivo;
import clases.ScriptRunner;
import clases.Usuario;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import sun.java2d.loops.ProcessPath.ProcessHandler;


/**
 *
 * @author skysoftgo
 */
public class MainApp extends javax.swing.JFrame {

    /**
     * Creates new form MainApp
     */
    private static IRegistroUsuarios vntUsuarios = null;
    private static IRegistroLecturas vntRegistroLectura = null;
    private static ILeerLectura vntLeerLectura = null;
    private static IRegistroClientes vntClientes = null;
    private static IHistorialVecino vntHistorialVecino = null;
    private static IRegistroPagos    vntPagos = null;
    private static IRegistroCobros    vntCobros = null;
    private static IRegistroOrdenes  vntOrdenes = null;
    private static IReporteIngresos  vntReporteIngresos = null;
    private static IReporteEgresos  vntReporteEgresos = null;
    private static IReporteGeneral  vntReporteGeneral = null;
    private static IReporteDeOrdenes vntReporteOrdenes = null;
    private static Alerta vntAlerta = null;
    
    public MainApp() {
        initComponents();           
        this.setLocation(20, 10);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width-50,screenSize.height-50);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/imagenes/gota.png")));
        //System.out.println(bounds.height);
        /* links window */
        this.panelBienvenido.addHyperlinkListener(new HyperlinkListener()
            {
                @Override
                public void hyperlinkUpdate(HyperlinkEvent e)
                {
                    if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED))
                        if(Desktop.isDesktopSupported())
                        {
                            try {
                                Desktop.getDesktop().browse(new URI(e.getURL().toString()));
                            } catch (URISyntaxException ex) {
                                Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                            }catch (IOException ex) {
                            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                }
            });
    }
    
    private void initComponents() {

        dp = new javax.swing.JDesktopPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelBienvenido = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        
        jMenu1 = new javax.swing.JMenu();
        mCerrarSesion = new javax.swing.JMenuItem();
        miRegistrarUsuarios = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        
        jLecturas = new javax.swing.JMenu();
        mRegistroLecturas = new javax.swing.JMenuItem();
        mLeerLecturas = new javax.swing.JMenuItem();
        
        
        mClientes = new javax.swing.JMenu();
        mRegistroClientes = new javax.swing.JMenuItem();
        mHistorial = new javax.swing.JMenuItem();
        mEliminarClientes = new javax.swing.JMenuItem();
        
        mCobros = new javax.swing.JMenu();
        mRegistrodeCobros = new javax.swing.JMenuItem();
        
        mPagos = new javax.swing.JMenu();
        mRegistrodePagos = new javax.swing.JMenuItem();
        mEmisiondeOrdenes = new javax.swing.JMenuItem();
        
        Mreportes = new javax.swing.JMenu();
        mReporteDeIngresos = new javax.swing.JMenuItem();
        mReporteDeEgresos = new javax.swing.JMenuItem();
        mReporteFinal = new javax.swing.JMenuItem();
        mReportedeOrdenes = new javax.swing.JMenuItem();
        
        mHerramientas = new javax.swing.JMenu();
        mAlerta = new javax.swing.JMenuItem();
        mCalculadora = new javax.swing.JMenuItem();
        MiResPaldarBD = new javax.swing.JMenuItem();
        MiRestaurarBD = new javax.swing.JMenuItem();
        
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dp.setBackground(new java.awt.Color(50, 150, 255));
        
        /* Internal Bienvenido */
        jInternalFrame1.setClosable(true);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setResizable(true);
        jInternalFrame1.setTitle("Bienvenido");
        jInternalFrame1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jInternalFrame1.setVisible(true);
        
        panelBienvenido.setEditable(false);
        panelBienvenido.setContentType("text/html"); // NOI18N
        panelBienvenido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelBienvenido.setText("<html><body>\n El rendimiento y datos que el software proporsiona esta bajo responsabilidad del usuario administrador que ingrese datos y asi efectuar las transacciones de manera correcta. <br/> \n Skysoftgo les brinda los servicios de soporte, contactos: <br/> \n <br/> \n Facebook: <a href=\"https://www.facebook.com/skysoftgo\">  www.facebook.com/skysoftgo</a><br/>\n Página web:  <a href=\"http:www.skysoftgo.com\">  www.skysoftgo.com</a><br/> \n e-Mail : skysoftgo@gmail.com <br/>\n<p>\n</body></html>\n");
        jScrollPane1.setViewportView(panelBienvenido);

        jInternalFrame1.getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout dpLayout = new javax.swing.GroupLayout(dp);
        dp.setLayout(dpLayout);
        dpLayout.setHorizontalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dpLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        dpLayout.setVerticalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dpLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        dp.setLayer(jInternalFrame1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(dp, java.awt.BorderLayout.CENTER);
        /* end Internal Bienvenido */

        /* CREATE MENU */
        /* FILE */
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/folder.png"))); // NOI18N
        jMenu1.setText("Archivo");
        jMenu1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jMenu1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        mCerrarSesion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        mCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/disconnect.png"))); // NOI18N
        mCerrarSesion.setText("Cerrar Sessión");
        mCerrarSesion.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/disconnect.png"))); // NOI18N
        mCerrarSesion.setEnabled(true);
        mCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(mCerrarSesion);

        miRegistrarUsuarios.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        miRegistrarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/group_key.png"))); // NOI18N
        miRegistrarUsuarios.setText("Registro de Usuarios");
        miRegistrarUsuarios.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/group_key.png"))); // NOI18N
        miRegistrarUsuarios.setEnabled(false);
        miRegistrarUsuarios.setCursor(new Cursor(Cursor.HAND_CURSOR));
        miRegistrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(miRegistrarUsuarios);

        jMenuItem4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/door_in.png"))); // NOI18N
        jMenuItem4.setText("Salir");
        jMenuItem4.setEnabled(false);
        jMenuItem4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        /* end FILE */
        jMenuBar1.add(jMenu1);
        
        /* Lecture */
        jLecturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/medidor.png"))); // NOI18N
        jLecturas.setText("Lecturas de Medidores");
        jLecturas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLecturas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        
        mRegistroLecturas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        mRegistroLecturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/medidor1.png"))); // NOI18N
        mRegistroLecturas.setText("Lecturas de Medidores");
        mRegistroLecturas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mRegistroLecturas.setEnabled(false);
        mRegistroLecturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regmedidores(evt);
            }
        });       
        jLecturas.add(mRegistroLecturas);
        
        
        mLeerLecturas.setFont(new java.awt.Font("Arial", 0, 14)); 
        mLeerLecturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/medidorgeneral.png"))); // NOI18N
        mLeerLecturas.setText("Lecturas Generales");
        mLeerLecturas.setEnabled(false);
        mLeerLecturas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mLeerLecturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leermedidores(evt);
            }
        });
        
        jLecturas.add(mLeerLecturas);
        
        /* end Lecture */
        jMenuBar1.add(jLecturas);

        /* Neightbor */
        mClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/group.png"))); // NOI18N
        mClientes.setText("Vecinos");
        mClientes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mClientes.setFont(new java.awt.Font("Arial", 0, 18)); 

        mRegistroClientes.setFont(new java.awt.Font("Arial", 0, 14)); 
        mRegistroClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/group_add.png"))); // NOI18N
        mRegistroClientes.setText("Registrar Vecino");
        mRegistroClientes.setEnabled(false);
        mRegistroClientes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mRegistroClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRegistroClientesActionPerformed(evt);
            }
        });
        mClientes.add(mRegistroClientes);
        
        mHistorial.setFont(new java.awt.Font("Arial", 0, 14)); 
        mHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/group.png"))); // NOI18N
        mHistorial.setText("Historial de Deudas de Vecinos");
        mHistorial.setEnabled(false);
        mHistorial.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mHistorialVecinoActionPerformed(evt);
            }
        });
        mClientes.add(mHistorial);
        
        mEliminarClientes.setFont(new java.awt.Font("Arial", 0, 14));
        mEliminarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/groupdel.png"))); // NOI18N
        mEliminarClientes.setText("Borrar a un Vecino");
        mEliminarClientes.setEnabled(false);
        mEliminarClientes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mEliminarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRegistroClientesActionPerformed(evt);
            }
        });
        //mClientes.add(mEliminarClientes);
        
        /* end Neightbor */
        jMenuBar1.add(mClientes);

        /* Charger */
        mCobros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/money_dollar_down.png"))); // NOI18N
        mCobros.setText("Cobros");
        mCobros.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mCobros.setFont(new java.awt.Font("Arial", 0, 18)); 

        mRegistrodeCobros.setFont(new java.awt.Font("Arial", 0, 14)); 
        mRegistrodeCobros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/coins_add.png"))); // NOI18N
        mRegistrodeCobros.setText("Registro de cobros");
        mRegistrodeCobros.setEnabled(false);
        mRegistrodeCobros.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mRegistrodeCobros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRegistrodePagosActionPerformed(evt);
            }
        });
        mCobros.add(mRegistrodeCobros);
        /* end charger */
        jMenuBar1.add(mCobros);
        
        /* payment */
        mPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/money_dollar_up.png"))); // NOI18N
        mPagos.setText("Pagos");
        mPagos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mPagos.setFont(new java.awt.Font("Arial", 0, 18)); 

        mRegistrodePagos.setFont(new java.awt.Font("Arial", 0, 14)); 
        mRegistrodePagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/coins.png"))); // NOI18N
        mRegistrodePagos.setText("Registro de pago efectuado");
        mRegistrodePagos.setEnabled(false);
        mRegistrodePagos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mRegistrodePagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRegistrodePagosActionPerformed(evt);
            }
        });
        mPagos.add(mRegistrodePagos);

        mEmisiondeOrdenes.setFont(new java.awt.Font("Arial", 0, 14)); 
        mEmisiondeOrdenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report_word.png"))); // NOI18N
        mEmisiondeOrdenes.setText("Emision de Ordenes(Corte/Reconexión)");
        mEmisiondeOrdenes.setEnabled(false);
        mEmisiondeOrdenes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mEmisiondeOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEmisiondeOrdenesActionPerformed(evt);
            }
        });
        mPagos.add(mEmisiondeOrdenes);
        /* end paymaent */
        jMenuBar1.add(mPagos);

        /* Reports */
        Mreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png"))); // NOI18N
        Mreportes.setText("Reportes");
        Mreportes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Mreportes.setFont(new java.awt.Font("Arial", 0, 18)); 

        mReporteDeIngresos.setFont(new java.awt.Font("Arial", 0, 14)); 
        mReporteDeIngresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report_add.png"))); // NOI18N
        mReporteDeIngresos.setText("Reporte de Ingresos");
        mReporteDeIngresos.setEnabled(false);
        mReporteDeIngresos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mReporteDeIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mReporteDeIngresosActionPerformed(evt);
            }
        });
        Mreportes.add(mReporteDeIngresos);
        
        mReporteDeEgresos.setFont(new java.awt.Font("Arial", 0, 14)); 
        mReporteDeEgresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report_magnify.png"))); // NOI18N
        mReporteDeEgresos.setText("Reporte de Egresos");
        mReporteDeEgresos.setEnabled(false);
        mReporteDeEgresos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mReporteDeEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mReporteDeEgresosActionPerformed(evt);
            }
        });
        Mreportes.add(mReporteDeEgresos);
        
        mReporteFinal.setFont(new java.awt.Font("Arial", 0, 14)); 
        mReporteFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png"))); // NOI18N
        mReporteFinal.setText("Reporte General");
        mReporteFinal.setEnabled(false);
        mReporteFinal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mReporteFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mReporteFinalActionPerformed(evt);
            }
        });
        Mreportes.add(mReporteFinal);
        
        mReportedeOrdenes.setFont(new java.awt.Font("Arial", 0, 14)); 
        mReportedeOrdenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/book_addresses.png"))); // NOI18N
        mReportedeOrdenes.setText("Reporte de Ordenes Enviadas");
        mReportedeOrdenes.setEnabled(false);
        mReportedeOrdenes.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mReportedeOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mReportedeOrdenesActionPerformed(evt);
            }
        });
        Mreportes.add(mReportedeOrdenes);
        /* end Reports */
        jMenuBar1.add(Mreportes);

        /* Tools */
        mHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/cog.png"))); // NOI18N
        mHerramientas.setText("Herramientas");
        mHerramientas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mHerramientas.setFont(new java.awt.Font("Arial", 0, 18)); 

        mAlerta.setFont(new java.awt.Font("Arial", 0, 14)); 
        mAlerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/error.png"))); // NOI18N
        mAlerta.setText("Alerta");
        mAlerta.setEnabled(false);
        mAlerta.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mAlerta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alerta(evt);
            }
        });
        mHerramientas.add(mAlerta);
        
        mCalculadora.setFont(new java.awt.Font("Arial", 0, 14)); 
        mCalculadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/calculator.png"))); // NOI18N
        mCalculadora.setText("Calculadora");
        mCalculadora.setEnabled(false);
        mCalculadora.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCalculadoraActionPerformed(evt);
            }
        });
        mHerramientas.add(mCalculadora);

        MiResPaldarBD.setFont(new java.awt.Font("Arial", 0, 14)); 
        MiResPaldarBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/database_save.png"))); // NOI18N
        MiResPaldarBD.setText("Respaldar Base de Datos");
        MiResPaldarBD.setEnabled(false);
        MiResPaldarBD.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MiResPaldarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiResPaldarBDActionPerformed(evt);
            }
        });
        mHerramientas.add(MiResPaldarBD);

        MiRestaurarBD.setFont(new java.awt.Font("Arial", 0, 14)); 
        MiRestaurarBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/database_refresh.png"))); // NOI18N
        MiRestaurarBD.setText("Restaurar Base de Datos");
        MiRestaurarBD.setEnabled(false);
        MiRestaurarBD.setCursor(new Cursor(Cursor.HAND_CURSOR));
        MiRestaurarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiRestaurarBDActionPerformed(evt);
            }
        });
        mHerramientas.add(MiRestaurarBD);
        /* end Tools */
        jMenuBar1.add(mHerramientas);

        /* About */
        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/help.png"))); // NOI18N
        jMenu6.setText("Ayuda");
        jMenu6.setFont(new java.awt.Font("Arial", 0, 18)); 

        jMenuItem8.setFont(new java.awt.Font("Arial", 0, 18)); 
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/comment.png"))); // NOI18N
        jMenuItem8.setText("Acerca de");
        jMenuItem8.setEnabled(false);
        jMenuItem8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);
        /* end About */
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }
    
    /* Function Events */        
    private void miRegistrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarUsuariosActionPerformed
       if(vntUsuarios== null)
       {
           vntUsuarios = new IRegistroUsuarios(dp); 
       }
       AdminIFrame.mostrarVentanaFactura(dp, vntUsuarios); 
    }//GEN-LAST:event_miRegistrarUsuariosActionPerformed

    private void regmedidores(java.awt.event.ActionEvent evt){
        vntRegistroLectura =new IRegistroLecturas(dp);
        AdminIFrame.mostrarVentanaFactura(dp, vntRegistroLectura);
    }
    
    private void leermedidores(java.awt.event.ActionEvent evt){
        vntLeerLectura =new ILeerLectura(dp);
        AdminIFrame.mostrarVentanaFactura(dp, vntLeerLectura);
    }
    
    private void mRegistroClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRegistroClientesActionPerformed
       if(vntClientes == null)
       {
           vntClientes = new IRegistroClientes(dp); 
       }
       AdminIFrame.mostrarVentanaFactura(dp, vntClientes); 
    }//GEN-LAST:event_mRegistroClientesActionPerformed
    
    
    private void mHistorialVecinoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
       if(vntHistorialVecino == null)
       {
           vntHistorialVecino = new IHistorialVecino(dp); 
       }
       AdminIFrame.mostrarVentanaFactura(dp, vntHistorialVecino); 
    }
    private void mRegistrodeCobrosActionPerformed(java.awt.event.ActionEvent evt){
       if(vntCobros== null)
       {
           vntCobros = new IRegistroCobros(dp); 
       }
       AdminIFrame.mostrarVentanaFactura(dp, vntCobros); 
    }
    private void mRegistrodePagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRegistrodePagosActionPerformed
       if(vntPagos== null)
       {
           vntPagos = new IRegistroPagos(dp); 
       }
       AdminIFrame.mostrarVentanaFactura(dp, vntPagos); 
    }//GEN-LAST:event_mRegistrodePagosActionPerformed

    private void mEmisiondeOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEmisiondeOrdenesActionPerformed
       if(vntOrdenes== null)
       {
           vntOrdenes = new IRegistroOrdenes(dp); 
       }
       AdminIFrame.mostrarVentanaFactura(dp, vntOrdenes); 
    }//GEN-LAST:event_mEmisiondeOrdenesActionPerformed

    private void mReporteDeIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mReporteDeIngresosActionPerformed
      if(vntReporteIngresos== null)
       {
           vntReporteIngresos = new IReporteIngresos(dp); 
       }
       AdminIFrame.mostrarVentanaFactura(dp, vntReporteIngresos); 
           
    }//GEN-LAST:event_mReporteDeIngresosActionPerformed

     private void mReporteDeEgresosActionPerformed(java.awt.event.ActionEvent evt) {                                                   
      if(vntReporteIngresos== null)
       {
           vntReporteEgresos = new IReporteEgresos(dp); 
       }
       AdminIFrame.mostrarVentanaFactura(dp, vntReporteEgresos);     
    }       
             
     private void mReporteFinalActionPerformed(java.awt.event.ActionEvent evt) {                                                   
      if(vntReporteIngresos== null)
       {
           vntReporteGeneral = new IReporteGeneral(dp); 
       }
       AdminIFrame.mostrarVentanaFactura(dp, vntReporteGeneral);     
    }
             
    private void mReportedeOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mReportedeOrdenesActionPerformed
       if(vntReporteOrdenes== null)
       {
           vntReporteOrdenes = new IReporteDeOrdenes(dp); 
       }
       AdminIFrame.mostrarVentanaFactura(dp, vntReporteOrdenes); 
    }//GEN-LAST:event_mReportedeOrdenesActionPerformed

    private void alerta(java.awt.event.ActionEvent evt){
        vntAlerta =new Alerta(dp);
        AdminIFrame.mostrarVentanaFactura(dp, vntAlerta);
    }
    
    private void MiResPaldarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiResPaldarBDActionPerformed
        JFileChooser selectorDeArchivos = new JFileChooser();        
        int showSaveDialog = selectorDeArchivos.showSaveDialog(this);
        if(showSaveDialog == JFileChooser.APPROVE_OPTION)
        {
            File archivo = selectorDeArchivos.getSelectedFile();
            
            /*NOTE: Used to create a cmd command*/
            String pasword = (Conexion.password == null || Conexion.password.isEmpty())?"":" -p " + Conexion.password;
            String datosComando = Conexion.login + pasword + " --database " + Conexion.bd + " -r " + archivo.getAbsoluteFile()+".sql";
            String executeCmd = "mysqldump -u "+datosComando;
             /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
              
            int processComplete = respaldarBd(executeCmd);
            if (processComplete == 0) {
                    System.out.println("Backup Complete");
                } else {
                    JFileChooser seleccionarExe = new JFileChooser();  
                    seleccionarExe.setFileFilter(new FiltroArchivo());
                    int showOpenDialog = seleccionarExe.showOpenDialog(this);
                    if(showOpenDialog == JFileChooser.APPROVE_OPTION)
                    {                        
                       executeCmd = seleccionarExe.getSelectedFile().getAbsolutePath()+" -u "+datosComando;
                       System.out.println(executeCmd);
                        int respaldarBd = respaldarBd(executeCmd);
                        if(processComplete == 0)
                        {
                           JOptionPane.showMessageDialog(this, "Respaldo de base de datos se realizo correctamente.\n"
                                   + "en "+seleccionarExe.getSelectedFile().getAbsolutePath(), "El Proceso se realizo correctammente", JOptionPane.PLAIN_MESSAGE);                 
                        }
                    }
                }
        
        }        
        
        
    }//GEN-LAST:event_MiResPaldarBDActionPerformed

    private void MiRestaurarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiRestaurarBDActionPerformed
        
        JFileChooser selectorDeArchivos = new JFileChooser();        
        int showSaveDialog = selectorDeArchivos.showOpenDialog(this);
        if(showSaveDialog == JFileChooser.APPROVE_OPTION)
        {
            try {
                FileReader archivo = new FileReader(selectorDeArchivos.getSelectedFile());
                Conexion.Conectar();
                ScriptRunner sr = new ScriptRunner(Conexion.con,false,true);
                sr.runScript(archivo);                
                Conexion.con.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Archivo no soportado");                
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(this, "Archivo no soportado");
            }
            catch(SQLException ex){JOptionPane.showMessageDialog(this, "Archivo no soportado");}
            JOptionPane.showMessageDialog(this, "Base de datos Importado correctamente");
        }
    }//GEN-LAST:event_MiRestaurarBDActionPerformed

    private void mCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCalculadoraActionPerformed
         Process runtimeProcess;
            try {
               
                System.out.println(System.getProperty("os.name"));
                String comandoCalculadora = System.getProperty("os.name").startsWith("Windows")?"calc":"gcalctool";
                runtimeProcess = Runtime.getRuntime().exec(comandoCalculadora);
                               
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);                
            }
           
    }//GEN-LAST:event_mCalculadoraActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
       
        JEditorPane ep = new JEditorPane("text/html", "<html><body>"  + "El rendimiento y datos que el software proporsiona esta bajo responsabilidad del usuario administrador que ingrese datos y asi efectuar las transacciones de manera correcta. <br/> \n Skysoftgo les brinda los servicios de soporte, contactos: <br/> \n <br/> \n Facebook: <a href=\"https://www.facebook.com/skysoftgo\">  www.facebook.com/skysoftgo</a><br/>\n Página web:  <a href=\"http:www.skysoftgo.com\">  www.skysoftgo.com</a><br/> \n e-Mail : skysoftgo@gmail.com <br/>\n<p>" + "</body></html>");

    // handle link events
    ep.addHyperlinkListener(new HyperlinkListener()
    {
        @Override
        public void hyperlinkUpdate(HyperlinkEvent e)
        {
            if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED))
                if(Desktop.isDesktopSupported())
                {
                
                    try {
                        Desktop.getDesktop().browse(new URI(e.getURL().toString()));
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                    }catch (IOException ex) {
                    Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 
                }
        }
    });
    ep.setEditable(false);        
     JOptionPane.showMessageDialog(this, ep, "Enlaces", JOptionPane.PLAIN_MESSAGE);                
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void mCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCerrarSesionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mCerrarSesionActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    
    
    public int respaldarBd(String executeCmd){
           int processComplete = -1;
            /*NOTE: Executing the command here*/
            Process runtimeProcess;
            try {
                runtimeProcess = Runtime.getRuntime().exec(executeCmd);
                processComplete = runtimeProcess.waitFor();               
                return processComplete;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "error", JOptionPane.ERROR_MESSAGE);                
            }
            catch(InterruptedException ex){ex.printStackTrace();}
            return processComplete;
    }
    
    public MainApp getMainApp()
    {
        return this;
    }
    
    public void setPermisos(Usuario user)
    {
        this.mCerrarSesion.setEnabled(user.isCerrarSesion());
        this.miRegistrarUsuarios.setEnabled(user.isRegistroDeUsuario());
        this.jMenuItem4.setEnabled(user.isSalirDeAplicacion());
        
        this.jLecturas.setEnabled(user.isLectura());
        this.mRegistroLecturas.setEnabled(user.isReglectura());
        this.mLeerLecturas.setEnabled(user.isReglectura());
        
        
        this.mClientes.setEnabled(user.isClientes());
        this.mRegistroClientes.setEnabled(user.isRegistroDeClientes());
        //this.mEliminarClientes.setEnabled(user.isRegistroDeClientes());
        this.mHistorial.setEnabled(user.isHistorialCliente());
        
        this.mCobros.setEnabled(user.isCobros());
        this.mRegistrodeCobros.setEnabled(user.isCobrar());
        
        this.mPagos.setEnabled(user.isPagos());
        this.mRegistrodePagos.setEnabled(user.isRegistrosDePagos());
        this.mEmisiondeOrdenes.setEnabled(user.isEmisionesDeOrdenes());
        
        this.Mreportes.setEnabled(user.isReportes());
        this.mReporteDeIngresos.setEnabled(user.isReporteDeIngresos());
        this.mReporteDeEgresos.setEnabled(user.isReporteDePagos());
        this.mReporteFinal.setEnabled(user.isReportegeneral());
        this.mReportedeOrdenes.setEnabled(user.isReporteDeOrdenes());
        
        this.mHerramientas.setEnabled(user.isHerramientas());
        this.mAlerta.setEnabled(user.isAlerta());
        this.mCalculadora.setEnabled(user.isCalculadora());
        this.MiResPaldarBD.setEnabled(user.isRespladarBd());
        this.MiRestaurarBD.setEnabled(user.isRestaurarBd());
        
        this.jMenu6.setEnabled(user.isAyuda());
        this.jMenuItem8.setEnabled(user.isMostrarAyuda());
        
    }
   
    
    private javax.swing.JDesktopPane dp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane panelBienvenido;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenuBar jMenuBar1;
    
    private javax.swing.JMenu jMenu1;
        private javax.swing.JMenuItem miRegistrarUsuarios;
        private javax.swing.JMenuItem mCerrarSesion;
        private javax.swing.JMenuItem jMenuItem4;
    
    private javax.swing.JMenu jLecturas;
        private javax.swing.JMenuItem mRegistroLecturas;
        private javax.swing.JMenuItem mLeerLecturas;
        
        
    private javax.swing.JMenu mClientes;
        private javax.swing.JMenuItem mRegistroClientes;
        private javax.swing.JMenuItem mEliminarClientes;
        private javax.swing.JMenuItem mHistorial;
        
    private javax.swing.JMenu mCobros;
        private javax.swing.JMenuItem mRegistrodeCobros;
        
    private javax.swing.JMenu mPagos;
        private javax.swing.JMenuItem mRegistrodePagos;
        private javax.swing.JMenuItem mEmisiondeOrdenes;
        
    private javax.swing.JMenu Mreportes;
        private javax.swing.JMenuItem mReporteDeIngresos;
        private javax.swing.JMenuItem mReporteDeEgresos;
        private javax.swing.JMenuItem mReporteFinal;
        private javax.swing.JMenuItem mReportedeOrdenes;
        
    private javax.swing.JMenu mHerramientas;
        private javax.swing.JMenuItem mAlerta;
        private javax.swing.JMenuItem mCalculadora;
        private javax.swing.JMenuItem MiResPaldarBD;
        private javax.swing.JMenuItem MiRestaurarBD;
        
    private javax.swing.JMenu jMenu6;
        private javax.swing.JMenuItem jMenuItem8;
    
   
}