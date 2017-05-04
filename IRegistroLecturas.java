package ventanas;

import clases.Conexion;
import clases.ModelTablaLecturas;
import clases.Lectura;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.Color; 
//import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
//import javax.swing.border.*;
//import javax.swing.table.TableColumn;
import java.awt.FlowLayout;
import paneles.PnlNuevaLectura;
import paneles.PnlEditLectura;

/**
 * @author skysoftgo
 */
public class IRegistroLecturas extends javax.swing.JInternalFrame 
{

    /**
     * Creates new form IRegistroLecturas
     */
    private ModelTablaLecturas mdlLectura;
    public DefaultTableModel modelo;
    public Object[][] campos=new Object[40][];
    public String columnNames;
    public int ancho;    
    public int alto;
    FondoLogin F;
    public int idpropiedad; 
    public int idpropietario;
    
    public IRegistroLecturas(JDesktopPane mainApp){
        ancho = (int)((this.getToolkit().getScreenSize().getWidth())/3.6);
        alto = (int)((this.getToolkit().getScreenSize().getHeight())-270);
        
        initComponents();
        
        Rectangle visibleRect = mainApp.getVisibleRect(); 
        this.setLocation(5, 0);
        this.setSize(visibleRect.width-10, visibleRect.height);       
        
        mdlLectura = new ModelTablaLecturas();
        this.tblLecturas.setModel(mdlLectura);
        tblLecturas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        txtNombreCliente.getDocument().addDocumentListener(EscuchadorBuscar);
        
        llenardatos(0,0);
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel(); // 1er Panel: grande
        jPanel3 = new javax.swing.JPanel();
        bntNuevo = new javax.swing.JButton("Nueva Lectura");
        bntActualizar = new javax.swing.JButton("Editar Lectura");
        bntEliminar = new javax.swing.JButton("Borrar Lecura");
        jPanel4 = new javax.swing.JPanel(); // Panel Finder
        jLabel1 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        lbNoExiste = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLecturas = new javax.swing.JTable();
        
        jPanelMeses = new javax.swing.JPanel();
        jPanelContainer = new javax.swing.JPanel();
        jPanelbs = new javax.swing.JPanel();
        jPanelContainerp = new javax.swing.JPanel();
        jPanelbsp = new javax.swing.JPanel();
        jPanelContainerpp = new javax.swing.JPanel();
        jPanelmt3pp = new javax.swing.JPanel();
        jPanelbspp = new javax.swing.JPanel();
        jPanelmt3p = new javax.swing.JPanel();
        jPanelmt3 = new javax.swing.JPanel();
        
        datos = new javax.swing.JLabel();
        enero = new javax.swing.JLabel();
        febrero = new javax.swing.JLabel();
        marzo = new javax.swing.JLabel();
        abril = new javax.swing.JLabel();
        mayo = new javax.swing.JLabel();
        junio = new javax.swing.JLabel();
        julio = new javax.swing.JLabel();
        agosto = new javax.swing.JLabel();
        septiembre = new javax.swing.JLabel();
        octubre = new javax.swing.JLabel();
        noviembre = new javax.swing.JLabel();
        diciembre = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        deudatotal = new javax.swing.JLabel();
        
        casa = new javax.swing.JLabel();
        medidor = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        ci = new javax.swing.JLabel();
        direccion = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        celular = new javax.swing.JLabel();
        deuda = new javax.swing.JLabel();
        tipo = new javax.swing.JLabel();
        manzano = new javax.swing.JLabel();
        estado = new javax.swing.JLabel();
        casadato = new javax.swing.JLabel();
        medidordato = new javax.swing.JLabel();
        nombredato = new javax.swing.JLabel();
        cidato = new javax.swing.JLabel();
        direcciondato = new javax.swing.JLabel();
        telefonodato = new javax.swing.JLabel();
        celulardato = new javax.swing.JLabel();
        deudadato = new javax.swing.JLabel();
        tipodato = new javax.swing.JLabel();
        manzanodato = new javax.swing.JLabel();
        estadodato = new javax.swing.JLabel();
        
        ano = new javax.swing.JLabel();
        
        ano1 = new javax.swing.JLabel();
        vacio = new javax.swing.JLabel();
        uno = new javax.swing.JLabel();
        dos = new javax.swing.JLabel();
        tres = new javax.swing.JLabel();
        cuatro = new javax.swing.JLabel();
        cinco = new javax.swing.JLabel();
        seis = new javax.swing.JLabel();
        siete = new javax.swing.JLabel();
        ocho = new javax.swing.JLabel();
        nueve = new javax.swing.JLabel();
        diez = new javax.swing.JLabel();
        once = new javax.swing.JLabel();
        doce = new javax.swing.JLabel();
        totales = new javax.swing.JLabel();
        vacio1 = new javax.swing.JLabel();
        
        ano111 = new javax.swing.JLabel();
        vaciomt3 = new javax.swing.JLabel();
        unomt3 = new javax.swing.JLabel();
        dosmt3 = new javax.swing.JLabel();
        tresmt3 = new javax.swing.JLabel();
        cuatromt3 = new javax.swing.JLabel();
        cincomt3 = new javax.swing.JLabel();
        seismt3 = new javax.swing.JLabel();
        sietemt3 = new javax.swing.JLabel();
        ochomt3 = new javax.swing.JLabel();
        nuevemt3 = new javax.swing.JLabel();
        diezmt3 = new javax.swing.JLabel();
        oncemt3 = new javax.swing.JLabel();
        docemt3 = new javax.swing.JLabel();
        totalesmt3 = new javax.swing.JLabel();
        vacio111 = new javax.swing.JLabel();
        
        ano11 = new javax.swing.JLabel();
        bs = new javax.swing.JLabel();
        unobs = new javax.swing.JLabel();
        dosbs = new javax.swing.JLabel();
        tresbs = new javax.swing.JLabel();
        cuatrobs = new javax.swing.JLabel();
        cincobs = new javax.swing.JLabel();
        seisbs = new javax.swing.JLabel();
        sietebs = new javax.swing.JLabel();
        ochobs = new javax.swing.JLabel();
        nuevebs = new javax.swing.JLabel();
        diezbs = new javax.swing.JLabel();
        oncebs = new javax.swing.JLabel();
        docebs = new javax.swing.JLabel();
        totalesbs = new javax.swing.JLabel();
        deuda1 = new javax.swing.JLabel();
        
        ano2 = new javax.swing.JLabel();
        vaciop = new javax.swing.JLabel();
        unop = new javax.swing.JLabel();
        dosp = new javax.swing.JLabel();
        tresp = new javax.swing.JLabel();
        cuatrop = new javax.swing.JLabel();
        cincop = new javax.swing.JLabel();
        seisp = new javax.swing.JLabel();
        sietep = new javax.swing.JLabel();
        ochop = new javax.swing.JLabel();
        nuevep = new javax.swing.JLabel();
        diezp = new javax.swing.JLabel();
        oncep = new javax.swing.JLabel();
        docep = new javax.swing.JLabel();
        totalesp = new javax.swing.JLabel();
        vacio2 = new javax.swing.JLabel();
        
        
        ano22 = new javax.swing.JLabel();
        bsp = new javax.swing.JLabel();
        unobsp = new javax.swing.JLabel();
        dosbsp = new javax.swing.JLabel();
        tresbsp = new javax.swing.JLabel();
        cuatrobsp = new javax.swing.JLabel();
        cincobsp = new javax.swing.JLabel();
        seisbsp = new javax.swing.JLabel();
        sietebsp = new javax.swing.JLabel();
        ochobsp = new javax.swing.JLabel();
        nuevebsp = new javax.swing.JLabel();
        diezbsp = new javax.swing.JLabel();
        oncebsp = new javax.swing.JLabel();
        docebsp = new javax.swing.JLabel();
        totalesbsp = new javax.swing.JLabel();
        deuda22 = new javax.swing.JLabel();
        
        ano222 = new javax.swing.JLabel();
        vaciomt3p = new javax.swing.JLabel();
        unomt3p = new javax.swing.JLabel();
        dosmt3p = new javax.swing.JLabel();
        tresmt3p = new javax.swing.JLabel();
        cuatromt3p = new javax.swing.JLabel();
        cincomt3p = new javax.swing.JLabel();
        seismt3p = new javax.swing.JLabel();
        sietemt3p = new javax.swing.JLabel();
        ochomt3p = new javax.swing.JLabel();
        nuevemt3p = new javax.swing.JLabel();
        diezmt3p = new javax.swing.JLabel();
        oncemt3p = new javax.swing.JLabel();
        docemt3p = new javax.swing.JLabel();
        totalesmt3p = new javax.swing.JLabel();
        vacio222 = new javax.swing.JLabel();
        
        ano3 = new javax.swing.JLabel();
        vaciopp = new javax.swing.JLabel();
        unopp = new javax.swing.JLabel();
        dospp = new javax.swing.JLabel();
        trespp = new javax.swing.JLabel();
        cuatropp = new javax.swing.JLabel();
        cincopp = new javax.swing.JLabel();
        seispp = new javax.swing.JLabel();
        sietepp = new javax.swing.JLabel();
        ochopp = new javax.swing.JLabel();
        nuevepp = new javax.swing.JLabel();
        diezpp = new javax.swing.JLabel();
        oncepp = new javax.swing.JLabel();
        docepp = new javax.swing.JLabel();
        totalespp = new javax.swing.JLabel();
        vacio3 = new javax.swing.JLabel();
        
        ano333 = new javax.swing.JLabel();
        vaciomt3pp = new javax.swing.JLabel();
        unomt3pp = new javax.swing.JLabel();
        dosmt3pp = new javax.swing.JLabel();
        tresmt3pp = new javax.swing.JLabel();
        cuatromt3pp = new javax.swing.JLabel();
        cincomt3pp = new javax.swing.JLabel();
        seismt3pp = new javax.swing.JLabel();
        sietemt3pp = new javax.swing.JLabel();
        ochomt3pp = new javax.swing.JLabel();
        nuevemt3pp = new javax.swing.JLabel();
        diezmt3pp = new javax.swing.JLabel();
        oncemt3pp = new javax.swing.JLabel();
        docemt3pp = new javax.swing.JLabel();
        totalesmt3pp = new javax.swing.JLabel();
        vacio333 = new javax.swing.JLabel();
        
        ano33 = new javax.swing.JLabel();
        bspp = new javax.swing.JLabel();
        unobspp = new javax.swing.JLabel();
        dosbspp = new javax.swing.JLabel();
        tresbspp = new javax.swing.JLabel();
        cuatrobspp = new javax.swing.JLabel();
        cincobspp = new javax.swing.JLabel();
        seisbspp = new javax.swing.JLabel();
        sietebspp = new javax.swing.JLabel();
        ochobspp = new javax.swing.JLabel();
        nuevebspp = new javax.swing.JLabel();
        diezbspp = new javax.swing.JLabel();
        oncebspp = new javax.swing.JLabel();
        docebspp = new javax.swing.JLabel();
        totalesbspp = new javax.swing.JLabel();
        deuda33 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lecturas de medidores");
        //setLayout(null);
        
        
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));//BAR

        bntNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/medidor+1.png")));
        bntNuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bntNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(bntNuevo);

        bntActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/medidoredit.png"))); 
        bntActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bntActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntActualizarActionPerformed(evt);
            }
        });
        jPanel3.add(bntActualizar);

        bntEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/medidor-1.png"))); // NOI18N
        bntEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bntEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(bntEliminar);
        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);
        
        
        /* Find */
        jPanel4.setLayout(new java.awt.GridBagLayout());
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel1.setText("Buscar por Número de Casa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 9, 10, 10);
        jPanel4.add(jLabel1, gridBagConstraints);
        
        txtNombreCliente.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtNombreCliente.setPreferredSize(new java.awt.Dimension(120, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        jPanel4.add(txtNombreCliente, gridBagConstraints);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_find.png"))); 
        jButton4.setPreferredSize(new java.awt.Dimension(33, 30));
        jButton4.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jButton4, gridBagConstraints);
        
        lbNoExiste.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        lbNoExiste.setForeground(new java.awt.Color(255, 51, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 6);
        jPanel4.add(lbNoExiste, gridBagConstraints);
        
        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);
        /* end find */
        
        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);
                
        jPanelDatos = new javax.swing.JPanel();
        jPanelDatos.setLayout(new FlowLayout());
        jPanelDatos.setLocation(0, 94);
        //jPanelDatos.setPreferredSize(new Dimension(500,800));
        //jPanelDatos.setBounds(new Rectangle( 100,100,500,800));
        //jPanelDatos.setBorder(BorderFactory.createLineBorder(Color.red));
        
        jPanelTabla = new javax.swing.JPanel();
        jPanelTabla.setLayout(null);        
        jPanelTabla.setLocation(0, 94);
        jPanelTabla.setPreferredSize(new Dimension(ancho-100,alto));
        jPanelTabla.setBorder(BorderFactory.createLineBorder(Color.green));
        jPanelDatos.add(jPanelTabla);
        
        jPanelInfo = new javax.swing.JPanel();
        jPanelInfo.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanelInfo.setLocation(0, 94);
        jPanelInfo.setPreferredSize(new Dimension(ancho+160,alto));
        jPanelInfo.setBorder(BorderFactory.createLineBorder(Color.green));
        jPanelDatos.add(jPanelInfo);
        
        jPanelImage = new javax.swing.JPanel();
        jPanelImage.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanelImage.setLocation(0, 94);
        jPanelImage.setPreferredSize(new Dimension(ancho+50,alto));
        jPanelImage.setBorder(BorderFactory.createLineBorder(Color.green));
        F=new FondoLogin("croquis");
        jPanelImage.add(F);
        jPanelDatos.add(jPanelImage);
        
        
        
        getContentPane().add(jPanelDatos, java.awt.BorderLayout.CENTER);
        
        ID.setFont(new java.awt.Font("ARIAL", Font.BOLD, 16)); 
        ID.setBounds(new Rectangle( 50,0,200,80));
        ID.setText("DATOS PERSONALES");
        ID.setAlignmentX(CENTER_ALIGNMENT);
        jPanelTabla.add(ID);
        
        casa.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        casa.setBounds(new Rectangle( 0,30,150,80));
        casa.setText("CASA # :");
        jPanelTabla.add(casa);
        
        medidor.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        medidor.setBounds(new Rectangle( 0,50,150,80));
        medidor.setText("MEDIDOR:");
        jPanelTabla.add(medidor);
        
        nombre.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        nombre.setBounds(new Rectangle( 0,70,150,80));
        nombre.setText("NOMBRE:");
        jPanelTabla.add(nombre);
        
        ci.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        ci.setBounds(new Rectangle( 0,90,150,80));
        ci.setText("CI:");
        jPanelTabla.add(ci);
        
        direccion.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        direccion.setBounds(new Rectangle(0,110,150,80));
        direccion.setText("DIR.:");
        jPanelTabla.add(direccion);
        
        telefono.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        telefono.setBounds(new Rectangle( 0,130,150,80));
        telefono.setText("TELF.:");
        jPanelTabla.add(telefono);
        
        celular.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        celular.setBounds(new Rectangle( 0,150,150,80));
        celular.setText("CELULAR:");
        jPanelTabla.add(celular);
                
        tipo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        tipo.setBounds(new Rectangle( 0,170,150,80));
        tipo.setText("TIPO CASA:");
        jPanelTabla.add(tipo);
        
        manzano.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        manzano.setBounds(new Rectangle( 0,190,150,80));
        manzano.setText("MANZANO:");
        jPanelTabla.add(manzano);
        
        estado.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        estado.setBounds(new Rectangle( 0,210,150,80));
        estado.setText("ESTADO:");
        jPanelTabla.add(estado);
        
        deuda.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        deuda.setBounds(new Rectangle( 0,230,150,80));
        deuda.setText("DEUDA:");
        jPanelTabla.add(deuda);
        
        
        casadato.setFont(new java.awt.Font("Arial", 4, 12)); 
        casadato.setBounds(new Rectangle( 75,30,150,80));
        casadato.setText("- - - - -");
        jPanelTabla.add(casadato);
        
        medidordato.setFont(new java.awt.Font("Tahoma", 0, 12));
        medidordato.setBounds(new Rectangle( 75,50,150,80));
        medidordato.setText("00000");
        jPanelTabla.add(medidordato);
        
        nombredato.setFont(new java.awt.Font("Tahoma", 0, 12));
        nombredato.setBounds(new Rectangle( 75,70,300,80));
        nombredato.setText("- - - - -");
        jPanelTabla.add(nombredato);
        
        cidato.setFont(new java.awt.Font("Tahoma", 0, 12));
        cidato.setBounds(new Rectangle( 75,90,300,80));
        cidato.setText("00000000");
        jPanelTabla.add(cidato);
        
        direcciondato.setFont(new java.awt.Font("Tahoma", 0, 12));
        direcciondato.setBounds(new Rectangle(75,110,300,80));
        direcciondato.setText("- - - - -");
        jPanelTabla.add(direcciondato);
        
        telefonodato.setFont(new java.awt.Font("Tahoma", 0, 12));
        telefonodato.setBounds(new Rectangle(75,130,150,80));
        telefonodato.setText("0000000");
        jPanelTabla.add(telefonodato);
        
        celulardato.setFont(new java.awt.Font("Tahoma", 0, 12));
        celulardato.setBounds(new Rectangle(75,150,150,80));
        celulardato.setText("00000000");
        jPanelTabla.add(celulardato);
        
        tipodato.setFont(new java.awt.Font("Tahoma", 0, 12));
        tipodato.setBounds(new Rectangle( 75,170,150,80));
        tipodato.setText("- - - - -");
        jPanelTabla.add(tipodato);
        
        manzanodato.setFont(new java.awt.Font("Tahoma", 0, 12));
        manzanodato.setBounds(new Rectangle( 75,190,150,80));
        manzanodato.setText("00000000");
        jPanelTabla.add(manzanodato);
        
        estadodato.setFont(new java.awt.Font("Tahoma", 0, 12));
        estadodato.setBounds(new Rectangle( 75,210,150,80));
        estadodato.setText("- - - - -");
        jPanelTabla.add(estadodato);
        
        deudadato.setFont(new java.awt.Font("Tahoma", 0, 12));
        deudadato.setBounds(new Rectangle(75,230,150,80));
        deudadato.setText("000.00");
        jPanelTabla.add(deudadato);
        
        
        jPanelMeses.setLayout(new GridLayout(16,1,10,10));
        ano.setFont(new java.awt.Font("Arial", Font.BOLD, 16)); 
        ano.setText("AÑO");
        ano.setAlignmentX(CENTER_ALIGNMENT);
        jPanelMeses.add(ano);
        
        datos.setFont(new java.awt.Font("Arial", Font.BOLD, 14)); 
        datos.setText("Meses");
        datos.setAlignmentX(CENTER_ALIGNMENT);
        jPanelMeses.add(datos);
        
        enero.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        enero.setText("ENERO");
        jPanelMeses.add(enero);
        
        febrero.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        febrero.setText("FEBRERO");
        jPanelMeses.add(febrero);
        
        marzo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        marzo.setText("MARZO");        
        jPanelMeses.add(marzo);
        
        abril.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        abril.setText("ABRIL");
        jPanelMeses.add(abril);
        
        mayo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        mayo.setText("MAYO");
        jPanelMeses.add(mayo);
        
        junio.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12));
        junio.setText("JUNIO");
        jPanelMeses.add(junio);
        
        julio.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        julio.setText("JULIO");
        jPanelMeses.add(julio);
        
        agosto.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        agosto.setText("AGOSTO");
        jPanelMeses.add(agosto);
        
        septiembre.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        septiembre.setText("SEPTIEMBRE");
        jPanelMeses.add(septiembre);
        
        octubre.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        octubre.setText("OCTUBRE");
        jPanelMeses.add(octubre);
        
        noviembre.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        noviembre.setText("NOVIEMBRE");
        jPanelMeses.add(noviembre);
        
        diciembre.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        diciembre.setText("DICIEMBRE");
        jPanelMeses.add(diciembre);
        
        total.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        total.setText("TOTAL");
        jPanelMeses.add(total);
        
        deudatotal.setFont(new java.awt.Font("Tahoma", Font.BOLD, 10)); 
        deudatotal.setText("TOTAL DEUDA");
        jPanelMeses.add(deudatotal);
        jPanelInfo.add(jPanelMeses);
        
        jPanelContainer.setLayout(new GridLayout(16,1,10,10));
        ano1.setFont(new java.awt.Font("Arial", Font.BOLD, 16)); 
        ano1.setText("2015");
        ano1.setAlignmentX(CENTER_ALIGNMENT);
        jPanelContainer.add(ano1);
        
        vacio.setFont(new java.awt.Font("Arial", Font.BOLD, 13)); 
        vacio.setText("Medida");
        jPanelContainer.add(vacio);
        
        uno.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        uno.setText("00000");
        uno.setAlignmentX(RIGHT_ALIGNMENT);
        jPanelContainer.add(uno);
        
        dos.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        dos.setText("00000");
        dos.setAlignmentX(RIGHT_ALIGNMENT);
        jPanelContainer.add(dos);
        
        tres.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        tres.setText("00000");
        tres.setAlignmentX(RIGHT_ALIGNMENT);        
        jPanelContainer.add(tres);
        
        cuatro.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cuatro.setText("00000");
        jPanelContainer.add(cuatro);
        
        cinco.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cinco.setText("00000");
        jPanelContainer.add(cinco);
        
        seis.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        seis.setText("00000");
        jPanelContainer.add(seis);
        
        siete.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        siete.setText("00000");
        jPanelContainer.add(siete);
        
        ocho.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        ocho.setText("00000");
        jPanelContainer.add(ocho);
        
        nueve.setFont(new java.awt.Font("Tahoma", 0, 12));
        nueve.setText("00000");
        jPanelContainer.add(nueve);
        
        diez.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        diez.setText("00000");
        jPanelContainer.add(diez);
        
        once.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        once.setText("00000");
        jPanelContainer.add(once);
        
        doce.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        doce.setText("00000");
        jPanelContainer.add(doce);
        
        totales.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        totales.setText("");
        jPanelContainer.add(totales);
        
        vacio1.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        vacio1.setText(" ");
        jPanelContainer.add(vacio1);
        jPanelInfo.add(jPanelContainer);
        
        jPanelmt3.setLayout(new GridLayout(16,1,10,10));
        ano111.setFont(new java.awt.Font("Arial", Font.BOLD, 16)); 
        ano111.setText(" ");
        jPanelmt3.add(ano111);
        
        vaciomt3.setFont(new java.awt.Font("Arial", Font.BOLD, 14)); 
        vaciomt3.setText("MT3");
        jPanelmt3.add(vaciomt3);
        
        unomt3.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        unomt3.setText("00.00");
        jPanelmt3.add(unomt3);
        
        dosmt3.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        dosmt3.setText("00.00");
        jPanelmt3.add(dosmt3);
        
        tresmt3.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        tresmt3.setText("00.00");        
        jPanelmt3.add(tresmt3);
        
        cuatromt3.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cuatromt3.setText("00.00");
        jPanelmt3.add(cuatromt3);
        
        cincomt3.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cincomt3.setText("00.00");
        jPanelmt3.add(cincomt3);
        
        seismt3.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        seismt3.setText("00.00");
        jPanelmt3.add(seismt3);
        
        sietemt3.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        sietemt3.setText("00.00");
        jPanelmt3.add(sietemt3);
        
        ochomt3.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        ochomt3.setText("00.00");
        jPanelmt3.add(ochomt3);
        
        nuevemt3.setFont(new java.awt.Font("Tahoma", 0, 12));
        nuevemt3.setText("00.00");
        jPanelmt3.add(nuevemt3);
        
        diezmt3.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        diezmt3.setText("00.00");
        jPanelmt3.add(diezmt3);
        
        oncemt3.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        oncemt3.setText("00.00");
        jPanelmt3.add(oncemt3);
        
        docemt3.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        docemt3.setText("00.00");
        jPanelmt3.add(docemt3);
        
        totalesmt3.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        totalesmt3.setText("00.00");
        jPanelmt3.add(totalesmt3);
        
        vacio111.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        vacio111.setText(" ");
        jPanelmt3.add(vacio111);
        jPanelInfo.add(jPanelmt3);
        
        
        jPanelbs.setLayout(new GridLayout(16,1,10,10));
        ano11.setFont(new java.awt.Font("Arial", Font.BOLD, 16)); 
        ano11.setText(" ");
        jPanelbs.add(ano11);
        
        bs.setFont(new java.awt.Font("Arial", Font.BOLD, 14)); 
        bs.setText("  Bs:   ");
        jPanelbs.add(bs);
        
        unobs.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        unobs.setText("00.00");
        jPanelbs.add(unobs);
        
        dosbs.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        dosbs.setText("00.00");
        jPanelbs.add(dosbs);
        
        tresbs.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        tresbs.setText("00.00");        
        jPanelbs.add(tresbs);
        
        cuatrobs.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cuatrobs.setText("00.00");
        jPanelbs.add(cuatrobs);
        
        cincobs.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cincobs.setText("00.00");
        jPanelbs.add(cincobs);
        
        seisbs.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        seisbs.setText("00.00");
        jPanelbs.add(seisbs);
        
        sietebs.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        sietebs.setText("00.00");
        jPanelbs.add(sietebs);
        
        ochobs.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        ochobs.setText("00.00");
        jPanelbs.add(ochobs);
        
        nuevebs.setFont(new java.awt.Font("Tahoma", 0, 12));
        nuevebs.setText("00.00");
        jPanelbs.add(nuevebs);
        
        diezbs.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        diezbs.setText("00.00");
        jPanelbs.add(diezbs);
        
        oncebs.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        oncebs.setText("00.00");
        jPanelbs.add(oncebs);
        
        docebs.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        docebs.setText("00.00");
        jPanelbs.add(docebs);
        
        totalesbs.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        totalesbs.setText("00.00");
        jPanelbs.add(totalesbs);
        
        deuda1.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        deuda1.setText("00.00");
        jPanelbs.add(deuda1);
        jPanelInfo.add(jPanelbs);
        
        jPanelContainerp.setLayout(new GridLayout(16,1,10,10));
        ano2.setFont(new java.awt.Font("Arial", Font.BOLD, 16)); 
        ano2.setText("2016");
        ano2.setAlignmentX(CENTER_ALIGNMENT);
        jPanelContainerp.add(ano2);
        
        vaciop.setFont(new java.awt.Font("Arial", Font.BOLD, 13)); 
        vaciop.setText("Medida");
        jPanelContainerp.add(vaciop);
        
        unop.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        unop.setText("00000");
        jPanelContainerp.add(unop);
        
        dosp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        dosp.setText("00000");
        jPanelContainerp.add(dosp);
        
        tresp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        tresp.setText("00000");        
        jPanelContainerp.add(tresp);
        
        cuatrop.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cuatrop.setText("00000");
        jPanelContainerp.add(cuatrop);
        
        cincop.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cincop.setText("00000");
        jPanelContainerp.add(cincop);
        
        seisp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        seisp.setText("00000");
        jPanelContainerp.add(seisp);
        
        sietep.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        sietep.setText("00000");
        jPanelContainerp.add(sietep);
        
        ochop.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        ochop.setText("00000");
        jPanelContainerp.add(ochop);
        
        nuevep.setFont(new java.awt.Font("Tahoma", 0, 12));
        nuevep.setText("00000");
        jPanelContainerp.add(nuevep);
        
        diezp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        diezp.setText("00000");
        jPanelContainerp.add(diezp);
        
        oncep.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        oncep.setText("00000");
        jPanelContainerp.add(oncep);
        
        docep.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        docep.setText("00000");
        jPanelContainerp.add(docep);
        
        totalesp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        totalesp.setText("");
        jPanelContainerp.add(totalesp);
        
        vacio2.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        vacio2.setText("  ");
        jPanelContainerp.add(vacio2);
        jPanelInfo.add(jPanelContainerp);
        
        jPanelmt3p.setLayout(new GridLayout(16,1,10,10));
        ano222.setFont(new java.awt.Font("Arial", Font.BOLD, 16)); 
        ano222.setText(" ");
        jPanelmt3p.add(ano222);
        
        vaciomt3p.setFont(new java.awt.Font("Arial", Font.BOLD, 14)); 
        vaciomt3p.setText("MT3");
        jPanelmt3p.add(vaciomt3p);
        
        unomt3p.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        unomt3p.setText("00.00");
        jPanelmt3p.add(unomt3p);
        
        dosmt3p.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        dosmt3p.setText("00.00");
        jPanelmt3p.add(dosmt3p);
        
        tresmt3p.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        tresmt3p.setText("00.00");        
        jPanelmt3p.add(tresmt3p);
        
        cuatromt3p.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cuatromt3p.setText("00.00");
        jPanelmt3p.add(cuatromt3p);
        
        cincomt3p.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cincomt3p.setText("00.00");
        jPanelmt3p.add(cincomt3p);
        
        seismt3p.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        seismt3p.setText("00.00");
        jPanelmt3p.add(seismt3p);
        
        sietemt3p.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        sietemt3p.setText("00.00");
        jPanelmt3p.add(sietemt3p);
        
        ochomt3p.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        ochomt3p.setText("00.00");
        jPanelmt3p.add(ochomt3p);
        
        nuevemt3p.setFont(new java.awt.Font("Tahoma", 0, 12));
        nuevemt3p.setText("00.00");
        jPanelmt3p.add(nuevemt3p);
        
        diezmt3p.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        diezmt3p.setText("00.00");
        jPanelmt3p.add(diezmt3p);
        
        oncemt3p.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        oncemt3p.setText("00.00");
        jPanelmt3p.add(oncemt3p);
        
        docemt3p.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        docemt3p.setText("00.00");
        jPanelmt3p.add(docemt3p);
        
        totalesmt3p.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        totalesmt3p.setText("00.00");
        jPanelmt3p.add(totalesmt3p);
        
        vacio222.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        vacio222.setText("  ");
        jPanelmt3p.add(vacio222);
        jPanelInfo.add(jPanelmt3p);
        
        
        jPanelbsp.setLayout(new GridLayout(16,1,10,10));
        ano22.setFont(new java.awt.Font("Arial", Font.BOLD, 16)); 
        ano22.setText(" ");
        jPanelbsp.add(ano22);
                
        bsp.setFont(new java.awt.Font("Arial", Font.BOLD, 14)); 
        bsp.setText("  Bs:   ");
        bsp.setAlignmentX(CENTER_ALIGNMENT);
        jPanelbsp.add(bsp);
        
        unobsp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        unobsp.setText("00.00");
        jPanelbsp.add(unobsp);
        
        dosbsp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        dosbsp.setText("00.00");
        jPanelbsp.add(dosbsp);
        
        tresbsp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        tresbsp.setText("00.00");        
        jPanelbsp.add(tresbsp);
        
        cuatrobsp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cuatrobsp.setText("00.00");
        jPanelbsp.add(cuatrobsp);
        
        cincobsp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cincobsp.setText("00.00");
        jPanelbsp.add(cincobsp);
        
        seisbsp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        seisbsp.setText("00.00");
        jPanelbsp.add(seisbsp);
        
        sietebsp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        sietebsp.setText("00.00");
        jPanelbsp.add(sietebsp);
        
        ochobsp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        ochobsp.setText("00.00");
        jPanelbsp.add(ochobsp);
        
        nuevebsp.setFont(new java.awt.Font("Tahoma", 0, 12));
        nuevebsp.setText("00.00");
        jPanelbsp.add(nuevebsp);
        
        diezbsp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        diezbsp.setText("00.00");
        jPanelbsp.add(diezbsp);
        
        oncebsp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        oncebsp.setText("00.00");
        jPanelbsp.add(oncebsp);
        
        docebsp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        docebsp.setText("00.00");
        jPanelbsp.add(docebsp);
        
        totalesbsp.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        totalesbsp.setText("00.00");
        jPanelbsp.add(totalesbsp);
        
        deuda22.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        deuda22.setText("00.00");
        jPanelbsp.add(deuda22);
        jPanelInfo.add(jPanelbsp);
        
        jPanelContainerpp.setLayout(new GridLayout(16,1,10,10));
        jPanelContainerpp.setAlignmentX(RIGHT_ALIGNMENT);
        ano3.setFont(new java.awt.Font("Arial", Font.BOLD, 16)); 
        ano3.setText("2017");
        jPanelContainerpp.add(ano3);
        
        vaciopp.setFont(new java.awt.Font("Arial", Font.BOLD, 13)); 
        vaciopp.setText("Medida");
        jPanelContainerpp.add(vaciopp);
        
        unopp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        unopp.setText("00000");
        unopp.setAlignmentX(RIGHT_ALIGNMENT);
        jPanelContainerpp.add(unopp);
        
        dospp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        dospp.setText("00000");
        dospp.setAlignmentX(RIGHT_ALIGNMENT);
        jPanelContainerpp.add(dospp);
        
        trespp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        trespp.setText("00000");
        trespp.setAlignmentX(RIGHT_ALIGNMENT);        
        jPanelContainerpp.add(trespp);
        
        cuatropp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cuatropp.setText("00000");
        cuatropp.setAlignmentX(RIGHT_ALIGNMENT);
        jPanelContainerpp.add(cuatropp);
        
        cincopp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cincopp.setText("00000");
        cincopp.setAlignmentX(RIGHT_ALIGNMENT);
        jPanelContainerpp.add(cincopp);
        
        seispp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        seispp.setText("00000");
        seispp.setAlignmentX(RIGHT_ALIGNMENT);
        jPanelContainerpp.add(seispp);
        
        sietepp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        sietepp.setText("00000");
        sietepp.setAlignmentX(RIGHT_ALIGNMENT);
        jPanelContainerpp.add(sietepp);
        
        ochopp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        ochopp.setText("00000");
        ochopp.setAlignmentX(RIGHT_ALIGNMENT);
        jPanelContainerpp.add(ochopp);
        
        nuevepp.setFont(new java.awt.Font("Tahoma", 0, 12));
        nuevepp.setText("00000");
        nuevepp.setAlignmentX(RIGHT_ALIGNMENT);
        jPanelContainerpp.add(nuevepp);
        
        diezpp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        diezpp.setText("00000");
        diezpp.setAlignmentX(RIGHT_ALIGNMENT);
        jPanelContainerpp.add(diezpp);
        
        oncepp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        oncepp.setText("00000");
        oncepp.setAlignmentX(RIGHT_ALIGNMENT);
        jPanelContainerpp.add(oncepp);
        
        docepp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        docepp.setText("00000");
        docepp.setAlignmentX(RIGHT_ALIGNMENT);
        jPanelContainerpp.add(docepp);
        
        totalespp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        totalespp.setText("");
        totalespp.setAlignmentX(RIGHT_ALIGNMENT);
        jPanelContainerpp.add(totalespp);
        
        vacio3.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        vacio3.setText("  ");
        jPanelContainerpp.add(vacio3);
        jPanelInfo.add(jPanelContainerpp);
        
        
        jPanelmt3pp.setLayout(new GridLayout(16,1,10,10));
        ano333.setFont(new java.awt.Font("Arial", Font.BOLD, 16)); 
        ano333.setText(" ");
        jPanelmt3pp.add(ano333);
        
        vaciomt3pp.setFont(new java.awt.Font("Arial", Font.BOLD, 14)); 
        vaciomt3pp.setText("MT3");
        jPanelmt3pp.add(vaciomt3pp);
        
        unomt3pp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        unomt3pp.setText("00.00");
        jPanelmt3pp.add(unomt3pp);
        
        dosmt3pp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        dosmt3pp.setText("00.00");
        jPanelmt3pp.add(dosmt3pp);
        
        tresmt3pp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        tresmt3pp.setText("00.00");        
        jPanelmt3pp.add(tresmt3pp);
        
        cuatromt3pp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cuatromt3pp.setText("00.00");
        jPanelmt3pp.add(cuatromt3pp);
        
        cincomt3pp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cincomt3pp.setText("00.00");
        jPanelmt3pp.add(cincomt3pp);
        
        seismt3pp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        seismt3pp.setText("00.00");
        jPanelmt3pp.add(seismt3pp);
        
        sietemt3pp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        sietemt3pp.setText("00.00");
        jPanelmt3pp.add(sietemt3pp);
        
        ochomt3pp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        ochomt3pp.setText("00.00");
        jPanelmt3pp.add(ochomt3pp);
        
        nuevemt3pp.setFont(new java.awt.Font("Tahoma", 0, 12));
        nuevemt3pp.setText("00.00");
        jPanelmt3pp.add(nuevemt3pp);
        
        diezmt3pp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        diezmt3pp.setText("00.00");
        jPanelmt3pp.add(diezmt3pp);
        
        oncemt3pp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        oncemt3pp.setText("00.00");
        jPanelmt3pp.add(oncemt3pp);
        
        docemt3pp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        docemt3pp.setText("00.00");
        jPanelmt3pp.add(docemt3pp);
        
        totalesmt3pp.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        totalesmt3pp.setText("00.00");
        jPanelmt3pp.add(totalesmt3pp);
        
        vacio333.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        vacio333.setText("  ");
        jPanelmt3pp.add(vacio333);
        jPanelInfo.add(jPanelmt3pp);
         
        
        jPanelbspp.setLayout(new GridLayout(16,1,10,10));
        ano33.setFont(new java.awt.Font("Arial", Font.BOLD, 16)); 
        ano33.setText(" ");
        jPanelbspp.add(ano33);
        
        bspp.setFont(new java.awt.Font("Arial", Font.BOLD, 14)); 
        bspp.setText("  Bs:   ");
        
        jPanelbspp.add(bspp);
        
        unobspp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        unobspp.setText("00.00");
        jPanelbspp.add(unobspp);
        
        dosbspp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        dosbspp.setText("00.00");
        jPanelbspp.add(dosbspp);
        
        tresbspp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        tresbspp.setText("00.00");        
        jPanelbspp.add(tresbspp);
        
        cuatrobspp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cuatrobspp.setText("00.00");
        jPanelbspp.add(cuatrobspp);
        
        cincobspp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        cincobspp.setText("00.00");
        jPanelbspp.add(cincobspp);
        
        seisbspp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        seisbspp.setText("00.00");
        jPanelbspp.add(seisbspp);
        
        sietebspp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        sietebspp.setText("00.00");
        jPanelbspp.add(sietebspp);
        
        ochobspp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        ochobspp.setText("00.00");
        jPanelbspp.add(ochobspp);
        
        nuevebspp.setFont(new java.awt.Font("Tahoma", 0, 12));
        nuevebspp.setText("00.00");
        jPanelbspp.add(nuevebspp);
        
        diezbspp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        diezbspp.setText("00.00");
        jPanelbspp.add(diezbspp);
        
        oncebspp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        oncebspp.setText("00.00");
        jPanelbspp.add(oncebspp);
        
        docebspp.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        docebspp.setText("00.00");
        jPanelbspp.add(docebspp);
        
        totalesbspp.setFont(new java.awt.Font("Tahoma", Font.BOLD, 12)); 
        totalesbspp.setText("00.00");
        jPanelbspp.add(totalesbspp);
        
        deuda33.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        deuda33.setText("00.00");
        jPanelbspp.add(deuda33);
        jPanelInfo.add(jPanelbspp);
          
        jPanel2.setLayout(new java.awt.BorderLayout());
        
        tblLecturas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblLecturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblLecturas.setBounds(0, 0, 200, 200);
        tblLecturas.setPreferredSize(new Dimension(400,200));
         
        jScrollPane1.setViewportView(tblLecturas);
        jPanel2.add(tblLecturas, java.awt.BorderLayout.CENTER);       
        pack();
    }
    
    
    
    private void llenardatos(int a, int numero){
        int MT31=0; int MT32=0; int MT33=0;
        double BS1=0.0; double BS2=0.0; double BS3=0.0;
        double D1=0.0; double D2=0.0; double D3=0.0;
        int u=0;
        if(a==0)
        {
            ResultSet propiedad = Conexion.getRegistros("select * from propiedad ORDER BY ID_PROPIEDAD ASC LIMIT 1");
             try{
                while(propiedad.next())
                {
                    int idpropiedad=propiedad.getInt(1);
                    int idpropietario=propiedad.getInt(3);
                    casadato.setText(String.valueOf(propiedad.getInt(4)));
                    medidordato.setText(String.valueOf(propiedad.getInt(5)));
                    tipodato.setText(propiedad.getString(6));
                    manzanodato.setText(String.valueOf(propiedad.getInt(7)));
                    estadodato.setText(propiedad.getString(8));
                    deudadato.setText(String.valueOf(propiedad.getDouble(9)));
                    F.setImagen(propiedad.getString(11));
                    ResultSet propietariodatos = Conexion.getRegistros("SELECT * FROM tblcliente WHERE NoCuenta="+idpropietario+""); 
                    try{
                        while(propietariodatos.next()){
                            cidato.setText(String.valueOf(propietariodatos.getInt(2)));
                            nombredato.setText(propietariodatos.getString(3));
                            direcciondato.setText(propietariodatos.getString(4));
                            telefonodato.setText(String.valueOf(propietariodatos.getInt(5)));
                            celulardato.setText(String.valueOf(propietariodatos.getInt(6)));
                        }
                    }catch(SQLException e){e.printStackTrace();}
                    
                    ResultSet propietariomedidas = Conexion.getRegistros("SELECT * FROM tblmedida WHERE ID_PROPIEDAD="+idpropiedad+"");
                    if(propietariomedidas.next())
                    {
                        try{
                            while(propietariomedidas.next()){
                                String c = String.valueOf(propietariomedidas.getDate(6));
                                String cc = c.substring(0,4);
                                String d = String.valueOf(propietariomedidas.getString(6));
                                String dd = d.substring(5,7);
                                Boolean b= propietariomedidas.getBoolean(9);
                                //setear();
                                if("2015".equals(cc)){
                                    switch(dd){
                                        case "01":
                                            uno.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            unomt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            unobs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){unobs.setForeground(Color.green);}else{unobs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                            MT31=MT31+propietariomedidas.getInt(4);
                                            BS1=BS1+propietariomedidas.getDouble(5);
                                            break;
                                        case "02":
                                            dos.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            dosmt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            dosbs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){dosbs.setForeground(Color.green);}else{dosbs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                            MT31=MT31+propietariomedidas.getInt(4);
                                            BS1=BS1+propietariomedidas.getDouble(5);
                                            break;
                                        case "03":
                                            tres.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            tresmt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            tresbs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){tresbs.setForeground(Color.green);}else{tresbs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                            MT31=MT31+propietariomedidas.getInt(4);
                                            BS1=BS1+propietariomedidas.getDouble(5);
                                            break;
                                        case "04":
                                            cuatro.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            cuatromt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            cuatrobs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){cuatrobs.setForeground(Color.green);}else{cuatrobs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                            MT31=MT31+propietariomedidas.getInt(4);
                                            BS1=BS1+propietariomedidas.getDouble(5);
                                            break;
                                        case "05":
                                            cinco.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            cincomt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            cincobs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){cincobs.setForeground(Color.green);}else{cincobs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                            MT31=MT31+propietariomedidas.getInt(4);
                                            BS1=BS1+propietariomedidas.getDouble(5);
                                            break;
                                        case "06":
                                            seis.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            seismt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            seisbs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){seisbs.setForeground(Color.green);}else{seisbs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                            MT31=MT31+propietariomedidas.getInt(4);
                                            BS1=BS1+propietariomedidas.getDouble(5);
                                            break;
                                        case "07":
                                            siete.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            sietemt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            sietebs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){sietebs.setForeground(Color.green);}else{sietebs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                            MT31=MT31+propietariomedidas.getInt(4);
                                            BS1=BS1+propietariomedidas.getDouble(5);
                                            break;
                                        case "08":
                                            ocho.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            ochomt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            ochobs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){ochobs.setForeground(Color.green);}else{ochobs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                            MT31=MT31+propietariomedidas.getInt(4);
                                            BS1=BS1+propietariomedidas.getDouble(5);
                                            break;
                                        case "09":
                                            nueve.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            nuevemt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            nuevebs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){nuevebs.setForeground(Color.green);}else{nuevebs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                            MT31=MT31+propietariomedidas.getInt(4);
                                            BS1=BS1+propietariomedidas.getDouble(5);
                                        break;
                                        case "10":
                                            diez.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            diezmt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            diezbs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){diezbs.setForeground(Color.green);}else{diezbs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                            MT31=MT31+propietariomedidas.getInt(4);
                                            BS1=BS1+propietariomedidas.getDouble(5);
                                        break;
                                        case "11":
                                            once.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            oncemt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            oncebs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){oncebs.setForeground(Color.green);}else{oncebs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                            MT31=MT31+propietariomedidas.getInt(4);
                                            BS1=BS1+propietariomedidas.getDouble(5);
                                        break;
                                        case "12":
                                            doce.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            docemt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            docebs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){docebs.setForeground(Color.green);}else{docebs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                            MT31=MT31+propietariomedidas.getInt(4);
                                            BS1=BS1+propietariomedidas.getDouble(5);
                                        break;
                                        default:
                                            //System.out.print("Por defecto");
                                        break;
                                    }
                                    totalesmt3.setText(String.valueOf(MT31));
                                    totalesbs.setText(String.valueOf(BS1));
                                    deuda1.setText(String.valueOf(D1));
                                }
                                if("2016".equals(cc)){
                                        switch(dd){
                                        case "01":
                                            unop.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            unomt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            unobsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){unobsp.setForeground(Color.green);}else{unobsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                            MT32=MT32+propietariomedidas.getInt(4);
                                            BS2=BS2+propietariomedidas.getDouble(5);
                                            break;
                                        case "02":
                                            dosp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            dosmt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            dosbsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){dosbsp.setForeground(Color.green);}else{dosbsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                            MT32=MT32+propietariomedidas.getInt(4);
                                            BS2=BS2+propietariomedidas.getDouble(5);
                                            
                                            break;
                                        case "03":
                                            tresp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            tresmt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            tresbsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){tresbsp.setForeground(Color.green);}else{tresbsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                            MT32=MT32+propietariomedidas.getInt(4);
                                            BS2=BS2+propietariomedidas.getDouble(5);
                                            break;
                                        case "04":
                                            cuatrop.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            cuatromt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            cuatrobsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){cuatrobsp.setForeground(Color.green);}else{cuatrobsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                            MT32=MT32+propietariomedidas.getInt(4);
                                            BS2=BS2+propietariomedidas.getDouble(5);
                                            break;
                                        case "05":
                                            cincop.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            cincomt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            cincobsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){cincobsp.setForeground(Color.green);}else{cincobsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                            MT32=MT32+propietariomedidas.getInt(4);
                                            BS2=BS2+propietariomedidas.getDouble(5);
                                            break;
                                        case "06":
                                            seisp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            seismt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            seisbsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){seisbsp.setForeground(Color.green);}else{seisbsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                            MT32=MT32+propietariomedidas.getInt(4);
                                            BS2=BS2+propietariomedidas.getDouble(5);
                                            break;
                                        case "07":
                                            sietep.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            sietemt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            sietebsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){sietebsp.setForeground(Color.green);}else{sietebsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                            MT32=MT32+propietariomedidas.getInt(4);
                                            BS2=BS2+propietariomedidas.getDouble(5);
                                            break;
                                        case "08":
                                            ochop.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            ochomt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            ochobsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){ochobsp.setForeground(Color.green);}else{ochobsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                            MT32=MT32+propietariomedidas.getInt(4);
                                            BS2=BS2+propietariomedidas.getDouble(5);
                                            break;
                                        case "09":
                                            nuevep.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            nuevemt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            nuevebsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){nuevebsp.setForeground(Color.green);}else{nuevebsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                            MT32=MT32+propietariomedidas.getInt(4);
                                            BS2=BS2+propietariomedidas.getDouble(5);
                                        break;
                                        case "10":
                                            diezp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            diezmt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            diezbsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){diezbsp.setForeground(Color.green);}else{diezbsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                            MT32=MT32+propietariomedidas.getInt(4);
                                            BS2=BS2+propietariomedidas.getDouble(5);
                                        break;
                                        case "11":
                                            oncep.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            oncemt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            oncebsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){oncebsp.setForeground(Color.green);}else{oncebsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                            MT32=MT32+propietariomedidas.getInt(4);
                                            BS2=BS2+propietariomedidas.getDouble(5);
                                        break;
                                        case "12":
                                            docep.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            docemt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            docebsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){docebsp.setForeground(Color.green);}else{docebsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                            MT32=MT32+propietariomedidas.getInt(4);
                                            BS2=BS2+propietariomedidas.getDouble(5);
                                        break;
                                        default:
                                            //System.out.print("Por defecto");
                                        break;
                                        }
                                    totalesmt3p.setText(String.valueOf(MT32));
                                    totalesbsp.setText(String.valueOf(BS2));
                                    deuda22.setText(String.valueOf(D2));
                                }
                                if("2017".equals(cc)){
                                    switch(dd){
                                        case "01":
                                            unopp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            unomt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            unobspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){unobspp.setForeground(Color.green);}else{unobspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                            MT33=MT33+propietariomedidas.getInt(4);
                                            BS3=BS3+propietariomedidas.getDouble(5);
                                            break;
                                        case "02":
                                            dospp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            dosmt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            dosbspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){dosbspp.setForeground(Color.green);}else{dosbspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                            MT33=MT33+propietariomedidas.getInt(4);
                                            BS3=BS3+propietariomedidas.getDouble(5);
                                            break;
                                        case "03":
                                            trespp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            tresmt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            tresbspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){tresbspp.setForeground(Color.green);}else{tresbspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                            MT33=MT33+propietariomedidas.getInt(4);
                                            BS3=BS3+propietariomedidas.getDouble(5);;
                                            break;
                                        case "04":
                                            cuatropp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            cuatromt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            cuatrobspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){cuatrobspp.setForeground(Color.green);}else{cuatrobspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                            MT33=MT33+propietariomedidas.getInt(4);
                                            BS3=BS3+propietariomedidas.getDouble(5);;
                                            break;
                                        case "05":
                                            cincopp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            cincomt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            cincobspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){cincobspp.setForeground(Color.green);}else{cincobspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                            MT33=MT33+propietariomedidas.getInt(4);
                                            BS3=BS3+propietariomedidas.getDouble(5);
                                            break;
                                        case "06":
                                            seispp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            seismt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            seisbspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){seisbspp.setForeground(Color.green);}else{seisbspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                            MT33=MT33+propietariomedidas.getInt(4);
                                            BS3=BS3+propietariomedidas.getDouble(5);
                                            break;
                                        case "07":
                                            sietepp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            sietemt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            sietebspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){sietebspp.setForeground(Color.green);}else{sietebspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                            MT33=MT33+propietariomedidas.getInt(4);
                                            BS3=BS3+propietariomedidas.getDouble(5);
                                            break;
                                        case "08":
                                            ochopp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            ochomt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            ochobspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){ochobspp.setForeground(Color.green);}else{ochobspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                            MT33=MT33+propietariomedidas.getInt(4);
                                            BS3=BS3+propietariomedidas.getDouble(5);
                                            break;
                                        case "09":
                                            nuevepp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            nuevemt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            nuevebspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){nuevebspp.setForeground(Color.green);}else{nuevebspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                            MT33=MT33+propietariomedidas.getInt(4);
                                            BS3=BS3+propietariomedidas.getDouble(5);
                                        break;
                                        case "10":
                                            diezpp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            diezmt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            diezbspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){diezbspp.setForeground(Color.green);}else{diezbspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                            MT33=MT33+propietariomedidas.getInt(4);
                                            BS3=BS3+propietariomedidas.getDouble(5);
                                        break;
                                        case "11":
                                            oncepp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            oncemt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            oncebspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){oncebspp.setForeground(Color.green);}else{oncebspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                            MT33=MT33+propietariomedidas.getInt(4);
                                            BS3=BS3+propietariomedidas.getDouble(5);
                                        break;
                                        case "12":
                                            docepp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                            docemt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                            docebspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                            if(b){docebspp.setForeground(Color.green);}else{docebspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                            MT33=MT33+propietariomedidas.getInt(4);
                                            BS3=BS3+propietariomedidas.getDouble(5);
                                        break;
                                        default:
                                            //System.out.print("Por defecto");
                                        break;
                                    }
                                    totalesmt3pp.setText(String.valueOf(MT33));
                                    totalesbspp.setText(String.valueOf(BS3));
                                    deuda33.setText(String.valueOf(D3));
                                }    
                            }
                        }catch(SQLException e){e.printStackTrace();}
                    }else{
                       System.out.print("No se encontro resultados en la BD");
                    }
                }
                Conexion.con.close();
            }catch(SQLException ex){ex.printStackTrace();}
        }else{
            ResultSet propiedad = Conexion.getRegistros("select * from propiedad WHERE numero="+numero+"");
            try{
                while(propiedad.next())
                {
                    idpropiedad=propiedad.getInt(1);
                    idpropietario=propiedad.getInt(3);
                    casadato.setText(String.valueOf(propiedad.getInt(4)));
                    medidordato.setText(String.valueOf(propiedad.getInt(5)));
                    tipodato.setText(propiedad.getString(6));
                    manzanodato.setText(String.valueOf(propiedad.getInt(7)));
                    estadodato.setText(propiedad.getString(8));
                    deudadato.setText(String.valueOf(propiedad.getInt(9)));
                    F.setImagen(propiedad.getString(11));
                    repaint();
                }    
                    Conexion.con.close();
            }catch(SQLException ex){ex.printStackTrace();}
            
            
            ResultSet propietariodatos = Conexion.getRegistros("SELECT * FROM tblcliente WHERE NoCuenta="+idpropietario+""); 
            try{
                while(propietariodatos.next())
                {
                    cidato.setText(String.valueOf(propietariodatos.getInt(2)));
                    nombredato.setText(propietariodatos.getString(3));
                    direcciondato.setText(propietariodatos.getString(4));
                    telefonodato.setText(String.valueOf(propietariodatos.getInt(5)));
                    celulardato.setText(String.valueOf(propietariodatos.getInt(6)));
                }
                    Conexion.con.close();
            }catch(SQLException e){e.printStackTrace();}
                    
            //System.out.print("ID PROPIEDAD:"+idpropiedad+"\n");
            ResultSet propietariomedidas = Conexion.getRegistros("SELECT * FROM tblmedida WHERE ID_PROPIEDAD="+idpropiedad+"");
            
            try{  
                //System.out.print(propietariomedidas.getRow()+"---- \n");
                if(propietariomedidas.getRow() < 0)
                {
                    System.out.print("No encontro resultados en BD MEDIDA \n");
                    setear();
                }else{
                    
                    while(propietariomedidas.next())
                    {
                        u=1;
                        String c = String.valueOf(propietariomedidas.getDate(6));
                        String cc = c.substring(0,4);
                        //System.out.print("Año:"+cc+"\n");
                        String d = String.valueOf(propietariomedidas.getString(6));
                        String dd = d.substring(5,7);
                        Boolean b= propietariomedidas.getBoolean(9);                        
                        //setear();                        
                        if("2015".equals(cc))
                        {
                            switch(dd){
                                case "01":
                                    uno.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    unomt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    unobs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){unobspp.setForeground(Color.green);}else{unobspp.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                    MT31=MT31+propietariomedidas.getInt(4);
                                    BS1=BS1+propietariomedidas.getDouble(5);
                                    break;
                                case "02":
                                    dos.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    dosmt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    dosbs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){dosbs.setForeground(Color.green);}else{dosbs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                    MT31=MT31+propietariomedidas.getInt(4);
                                    BS1=BS1+propietariomedidas.getDouble(5);
                                    break;
                                case "03":
                                    tres.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    tresmt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    tresbs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){tresbs.setForeground(Color.green);}else{tresbs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                    MT31=MT31+propietariomedidas.getInt(4);
                                    BS1=BS1+propietariomedidas.getDouble(5);
                                    break;
                                case "04":
                                    cuatro.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    cuatromt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    cuatrobs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){cuatrobs.setForeground(Color.green);}else{cuatrobs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                    MT31=MT31+propietariomedidas.getInt(4);
                                    BS1=BS1+propietariomedidas.getDouble(5);
                                    break;
                                case "05":
                                    cinco.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    cincomt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    cincobs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){cincobs.setForeground(Color.green);}else{cincobs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                    MT31=MT31+propietariomedidas.getInt(4);
                                    BS1=BS1+propietariomedidas.getDouble(5);
                                    break;
                                case "06":
                                    seis.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    seismt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    seisbs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){seisbs.setForeground(Color.green);}else{seisbs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                    MT31=MT31+propietariomedidas.getInt(4);
                                    BS1=BS1+propietariomedidas.getDouble(5);
                                    break;
                                case "07":
                                    siete.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    sietemt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    sietebs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){sietebs.setForeground(Color.green);}else{sietebs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                    MT31=MT31+propietariomedidas.getInt(4);
                                    BS1=BS1+propietariomedidas.getDouble(5);
                                    break;
                                case "08":
                                    ocho.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    ochomt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    ochobs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){ochobs.setForeground(Color.green);}else{ochobs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                    MT31=MT31+propietariomedidas.getInt(4);
                                    BS1=BS1+propietariomedidas.getDouble(5);
                                    break;
                                case "09":
                                    nueve.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    nuevemt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    nuevebs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){nuevebs.setForeground(Color.green);}else{nuevebs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                    MT31=MT31+propietariomedidas.getInt(4);
                                    BS1=BS1+propietariomedidas.getDouble(5);
                                    break;
                                case "10":
                                    diez.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    diezmt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    diezbs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){diezbs.setForeground(Color.green);}else{diezbs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                    MT31=MT31+propietariomedidas.getInt(4);
                                    BS1=BS1+propietariomedidas.getDouble(5);
                                    break;
                                case "11":
                                    once.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    oncemt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    oncebs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){oncebs.setForeground(Color.green);}else{oncebs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                    MT31=MT31+propietariomedidas.getInt(4);
                                    BS1=BS1+propietariomedidas.getDouble(5);
                                    break;
                                case "12":
                                    doce.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    docemt3.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    docebs.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){docebs.setForeground(Color.green);}else{docebs.setForeground(Color.red);D1=D1+propietariomedidas.getDouble(5);}
                                    MT31=MT31+propietariomedidas.getInt(4);
                                    BS1=BS1+propietariomedidas.getDouble(5);
                                    break;
                                default:
                                    //System.out.print("Por defecto");
                                    break;
                            }
                            totalesmt3.setText(String.valueOf(MT31));
                            totalesbs.setText(String.valueOf(BS1));
                            deuda1.setText(String.valueOf(D1));
                        }
                        if("2016".equals(cc)){
                            switch(dd){
                                case "01":
                                    unop.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    unomt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    unobsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){unobsp.setForeground(Color.green);}else{unobsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                    MT32=MT32+propietariomedidas.getInt(4);
                                    BS2=BS2+propietariomedidas.getDouble(5);
                                    break;
                                case "02":
                                    dosp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    dosmt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    dosbsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){dosbsp.setForeground(Color.green);}else{dosbsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                    MT32=MT32+propietariomedidas.getInt(4);
                                    BS2=BS2+propietariomedidas.getDouble(5);
                                    break;
                                case "03":
                                    tresp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    tresmt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    tresbsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){tresbsp.setForeground(Color.green);}else{tresbsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                    MT32=MT32+propietariomedidas.getInt(4);
                                    BS2=BS2+propietariomedidas.getDouble(5);
                                    break;
                                case "04":
                                    cuatrop.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    cuatromt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    cuatrobsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){cuatrobsp.setForeground(Color.green);}else{cuatrobsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                    MT32=MT32+propietariomedidas.getInt(4);
                                    BS2=BS2+propietariomedidas.getDouble(5);
                                    break;
                                case "05":
                                    cincop.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    cincomt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    cincobsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){cincobsp.setForeground(Color.green);}else{cincobsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                    MT32=MT32+propietariomedidas.getInt(4);
                                    BS2=BS2+propietariomedidas.getDouble(5);
                                    break;
                                case "06":
                                    seisp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    seismt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    seisbsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){seisbsp.setForeground(Color.green);}else{seisbsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                    MT32=MT32+propietariomedidas.getInt(4);
                                    BS2=BS2+propietariomedidas.getDouble(5);
                                    break;
                                case "07":
                                    sietep.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    sietemt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    sietebsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){sietebsp.setForeground(Color.green);}else{sietebsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                    MT32=MT32+propietariomedidas.getInt(4);
                                    BS2=BS2+propietariomedidas.getDouble(5);
                                    break;
                                case "08":
                                    ochop.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    ochomt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    ochobsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){ochobsp.setForeground(Color.green);}else{ochobsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                    MT32=MT32+propietariomedidas.getInt(4);
                                    BS2=BS2+propietariomedidas.getDouble(5);
                                    break;
                                case "09":
                                    nuevep.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    nuevemt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    nuevebsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){nuevebsp.setForeground(Color.green);}else{nuevebsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                    MT32=MT32+propietariomedidas.getInt(4);
                                    BS2=BS2+propietariomedidas.getDouble(5);
                                    break;
                                case "10":
                                    diezp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    diezmt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    diezbsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){diezbsp.setForeground(Color.green);}else{diezbsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                    MT32=MT32+propietariomedidas.getInt(4);
                                    BS2=BS2+propietariomedidas.getDouble(5);
                                    break;
                                case "11":
                                    oncep.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    oncemt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    oncebsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){oncebsp.setForeground(Color.green);}else{oncebsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                    MT32=MT32+propietariomedidas.getInt(4);
                                    BS2=BS2+propietariomedidas.getDouble(5);
                                    break;
                                case "12":
                                    docep.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    docemt3p.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    docebsp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){docebsp.setForeground(Color.green);}else{docebsp.setForeground(Color.red);D2=D2+propietariomedidas.getDouble(5);}
                                    MT32=MT32+propietariomedidas.getInt(4);
                                    BS2=BS2+propietariomedidas.getDouble(5);
                                    break;
                                default:
                                    //System.out.print("Por defecto");
                                    break;   
                            }
                            //System.out.print(MT32);
                            //System.out.print(BS2);
                            totalesmt3p.setText(String.valueOf(MT32));
                            totalesbsp.setText(String.valueOf(BS2));
                            deuda22.setText(String.valueOf(D2));
                        }
                        if("2017".equals(cc)){
                            //System.out.print("entro año 2017 \n");
                            switch(dd){
                                case "01":
                                    unopp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    unomt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));        
                                    unobspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){unobspp.setForeground(Color.green);}else{unobspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                    MT33=MT33+propietariomedidas.getInt(4);
                                    BS3=BS3+propietariomedidas.getDouble(5);
                                    //System.out.print(propietariomedidas.getInt(3)+"\n");
                                    break;
                                case "02":
                                    dospp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    dosmt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    dosbspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){dosbspp.setForeground(Color.green);}else{dosbspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                    MT33=MT33+propietariomedidas.getInt(4);
                                    BS3=BS3+propietariomedidas.getDouble(5);
                                    //System.out.print(propietariomedidas.getInt(3)+"\n");
                                    break;
                                case "03":
                                    trespp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    tresmt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    tresbspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){tresbspp.setForeground(Color.green);}else{tresbspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                    MT33=MT33+propietariomedidas.getInt(4);
                                    BS3=BS3+propietariomedidas.getDouble(5);
                                    //System.out.print(propietariomedidas.getInt(3)+"\n");
                                    break;
                                case "04":
                                    cuatropp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    cuatromt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    cuatrobspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){cuatrobspp.setForeground(Color.green);}else{cuatrobspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                    MT33=MT33+propietariomedidas.getInt(4);
                                    BS3=BS3+propietariomedidas.getDouble(5);
                                    break;
                                case "05":
                                    cincopp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    cincomt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    cincobspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){cincobspp.setForeground(Color.green);}else{cincobspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                    MT33=MT33+propietariomedidas.getInt(4);
                                    BS3=BS3+propietariomedidas.getDouble(5);
                                    break;
                                case "06":
                                    seispp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    seismt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    seisbspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){seisbspp.setForeground(Color.green);}else{seisbspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                    MT33=MT33+propietariomedidas.getInt(4);
                                    BS3=BS3+propietariomedidas.getDouble(5);
                                    break;
                                case "07":
                                    sietepp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    sietemt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    sietebspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){sietebspp.setForeground(Color.green);}else{sietebspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                    MT33=MT33+propietariomedidas.getInt(4);
                                    BS3=BS3+propietariomedidas.getDouble(5);
                                    break;
                                case "08":
                                    ochopp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    ochomt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    ochobspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){ochobspp.setForeground(Color.green);}else{ochobspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                    MT33=MT33+propietariomedidas.getInt(4);
                                    BS3=BS3+propietariomedidas.getDouble(5);
                                    break;
                                case "09":
                                    nuevepp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    nuevemt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    nuevebspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){nuevebspp.setForeground(Color.green);}else{nuevebspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                    MT33=MT33+propietariomedidas.getInt(4);
                                    BS3=BS3+propietariomedidas.getDouble(5);
                                    break;
                                case "10":
                                    diezpp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    diezmt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    diezbspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){diezbspp.setForeground(Color.green);}else{diezbspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                    MT33=MT33+propietariomedidas.getInt(4);
                                    BS3=BS3+propietariomedidas.getDouble(5);
                                    break;
                                case "11":
                                    oncepp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    oncemt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    oncebspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){oncebspp.setForeground(Color.green);}else{oncebspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                    MT33=MT33+propietariomedidas.getInt(4);
                                    BS3=BS3+propietariomedidas.getDouble(5);
                                    break;
                                case "12":
                                    docepp.setText(String.valueOf(propietariomedidas.getInt(3)));
                                    docemt3pp.setText(String.valueOf(propietariomedidas.getInt(4)));
                                    docebspp.setText(String.valueOf(propietariomedidas.getDouble(5)));
                                    if(b){docebspp.setForeground(Color.green);}else{docebspp.setForeground(Color.red);D3=D3+propietariomedidas.getDouble(5);}
                                    MT33=MT33+propietariomedidas.getInt(4);
                                    BS3=BS3+propietariomedidas.getDouble(5);
                                    break;
                                default:
                                    //System.out.print("Por defecto");
                                    break;
                            }
                            totalesmt3pp.setText(String.valueOf(MT33));
                            totalesbspp.setText(String.valueOf(BS3));
                            deuda33.setText(String.valueOf(D3));
                        }
                    }
                    if(u == 0){ setear(); }
                }        
            Conexion.con.close();
            }catch(SQLException e){e.printStackTrace();}           
        }
    }
    
    @SuppressWarnings("empty-statement")
    public void setear(){
        
        uno.setText("0000");
        dos.setText("0000");
        tres.setText("0000");
        cuatro.setText("0000");
        cinco.setText("0000");
        seis.setText("0000");
        siete.setText("0000");
        ocho.setText("0000");
        nueve.setText("0000");
        diez.setText("0000");
        once.setText("0000");
        doce.setText("0000");
        totales.setText(" ");

        unomt3.setText("00.00");
        dosmt3.setText("00.00");
        tresmt3.setText("00.00");
        cuatromt3.setText("00.00");
        cincomt3.setText("00.00");
        seismt3.setText("00.00");
        sietemt3.setText("00.00");
        ochomt3.setText("00.00");
        nuevemt3.setText("00.00");
        diezmt3.setText("00.00");
        oncemt3.setText("00.00");
        docemt3.setText("00.00");
        totalesmt3.setText("00.00");

        unobs.setText("00.00");
        dosbs.setText("00.00");
        tresbs.setText("00.00");
        cuatrobs.setText("00.00");
        cincobs.setText("00.00");
        seisbs.setText("00.00");
        sietebs.setText("00.00");
        ochobs.setText("00.00");
        nuevebs.setText("00.00");
        diezbs.setText("00.00");
        oncebs.setText("00.00");
        docebs.setText("00.00");
        totalesbs.setText("00.00");
        deuda1.setText("00.00");
        
        unop.setText("0000");
        dosp.setText("0000");
        tresp.setText("0000");
        cuatrop.setText("0000");
        cincop.setText("0000");
        seisp.setText("0000");
        sietep.setText("0000");
        ochop.setText("0000");
        nuevep.setText("0000");
        diezp.setText("0000");
        oncep.setText("0000");
        docep.setText("0000");
        totalesp.setText(" ");

        unomt3p.setText("00.00");
        dosmt3p.setText("00.00");
        tresmt3p.setText("00.00");
        cuatromt3p.setText("00.00");
        cincomt3p.setText("00.00");
        seismt3p.setText("00.00");
        sietemt3p.setText("00.00");
        ochomt3p.setText("00.00");
        nuevemt3p.setText("00.00");
        diezmt3p.setText("00.00");
        oncemt3p.setText("00.00");
        docemt3p.setText("00.00");
        totalesmt3p.setText("00.00");

        unobsp.setText("00.00");
        dosbsp.setText("00.00");
        tresbsp.setText("00.00");
        cuatrobsp.setText("00.00");
        cincobsp.setText("00.00");
        seisbsp.setText("00.00");
        sietebsp.setText("00.00");
        ochobsp.setText("00.00");
        nuevebsp.setText("00.00");
        diezbsp.setText("00.00");
        oncebsp.setText("00.00");
        docebsp.setText("00.00");
        totalesbsp.setText("00.00");
        deuda22.setText("00.00");
        
        unopp.setText("0000");
        dospp.setText("0000");
        trespp.setText("0000");
        cuatropp.setText("0000");
        cincopp.setText("0000");
        seispp.setText("0000");
        sietepp.setText("0000");
        ochopp.setText("0000");
        nuevepp.setText("0000");
        diezpp.setText("0000");
        oncepp.setText("0000");
        docepp.setText("0000");
        totalespp.setText(" ");

        unomt3pp.setText("00.00");
        dosmt3pp.setText("00.00");
        tresmt3pp.setText("00.00");
        cuatromt3pp.setText("00.00");
        cincomt3pp.setText("00.00");
        seismt3pp.setText("00.00");
        sietemt3pp.setText("00.00");
        ochomt3pp.setText("00.00");
        nuevemt3pp.setText("00.00");
        diezmt3pp.setText("00.00");
        oncemt3pp.setText("00.00");
        docemt3pp.setText("00.00");
        totalesmt3pp.setText("00.00");

        unobspp.setText("00.00");
        dosbspp.setText("00.00");
        tresbspp.setText("00.00");
        cuatrobspp.setText("00.00");
        cincobspp.setText("00.00");
        seisbspp.setText("00.00");
        sietebspp.setText("00.00");
        ochobspp.setText("00.00");
        nuevebspp.setText("00.00");
        diezbspp.setText("00.00");
        oncebspp.setText("00.00");
        docebspp.setText("00.00");
        totalesbspp.setText("00.00");
        deuda33.setText("00.00");
    }
    
    private void bntNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNuevoActionPerformed
        PnlNuevaLectura pnl = new PnlNuevaLectura();
        JLabel aviso = pnl.getLabelEscondido();
        JOptionPane.showInternalOptionDialog(this, pnl, "Registrar Nueva Lectura",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{aviso},null);
        if(pnl.IsProcesoOk())
        {
            llenardatos(0,0);
        }
    }//GEN-LAST:event_bntNuevoActionPerformed

    private void bntActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActualizarActionPerformed
        
        PnlEditLectura pel = new PnlEditLectura(0);
        JLabel aviso = pel.getLabelEscondido();
        JOptionPane.showInternalOptionDialog(this, pel, "Editar Lectura",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{aviso},null);
        if(pel.IsProcesoOk())
        {
            //llenardatos(0,0);
        }
    }//GEN-LAST:event_bntActualizarActionPerformed

    private void bntEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEliminarActionPerformed
        PnlEditLectura pel = new PnlEditLectura(1);
        JLabel aviso = pel.getLabelEscondido();
        JOptionPane.showInternalOptionDialog(this, pel, "Eliminar Lectura",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{aviso},null);
        if(pel.IsProcesoOk())
        {
            //llenardatos(0,0);
        }
    }//GEN-LAST:event_bntEliminarActionPerformed

    
    private void reiniciarTabla()
    {
         mdlLectura = new ModelTablaLecturas(); 
         this.tblLecturas.setModel(mdlLectura);   
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
        if(e.getDocument().getLength() > 2){
            try 
            {
                
                String busqueda = e.getDocument().getText(0, e.getDocument().getLength());
                int busquedaint;
                busquedaint = Integer.valueOf(busqueda);
                    if(e.getDocument().getLength() > 0)
                    {
                       llenardatos(1,busquedaint);
                    }
                    /*
                    ModelTablaLecturas mtu = new ModelTablaLecturas(busquedaint);
                    if(e.getDocument().getLength() > 0)
                    {
                        if(mtu.estVacio())
                        {
                            this.lbNoExiste.setText("La Lectura "+busquedaint+" no existe");
                            mdlLectura = new ModelTablaLecturas();                
                        }else{
                            mdlLectura = mtu;       
                            this.lbNoExiste.setText("");
                        }               
                    }else{
                        mdlLectura = new ModelTablaLecturas();
                    }
                        this.tblLecturas.setModel(mdlLectura);
                    */
                    if(e.getDocument().getLength() == 0 )
                    {
                        this.lbNoExiste.setText("");
                    }
                
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }else{System.out.print("no entro en el buscador\n");}
    }

    
    private javax.swing.JButton bntActualizar;
    private javax.swing.JButton bntEliminar;
    private javax.swing.JButton bntNuevo;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNoExiste;
    private javax.swing.JTable tblLecturas;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JPanel jPanelContainer;
    
    private javax.swing.JPanel jPanelMeses;
    private javax.swing.JLabel datos;
    private javax.swing.JLabel enero;
    private javax.swing.JLabel febrero;
    private javax.swing.JLabel marzo;
    private javax.swing.JLabel abril;
    private javax.swing.JLabel mayo;
    private javax.swing.JLabel junio;
    private javax.swing.JLabel julio;
    private javax.swing.JLabel agosto;
    private javax.swing.JLabel septiembre;
    private javax.swing.JLabel octubre;
    private javax.swing.JLabel noviembre;
    private javax.swing.JLabel diciembre;
    private javax.swing.JLabel total;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel deudatotal;
    
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPanel jPanelImage;
    private javax.swing.JPanel jPanelbs;
    private javax.swing.JPanel jPanelContainerp;
    private javax.swing.JPanel jPanelbsp;
    private javax.swing.JPanel jPanelContainerpp;
    private javax.swing.JPanel jPanelmt3pp;
    private javax.swing.JPanel jPanelbspp;
    private javax.swing.JPanel jPanelmt3p;
    private javax.swing.JPanel jPanelmt3;
            
    public javax.swing.JLabel casa;
    public javax.swing.JLabel medidor;
    public javax.swing.JLabel nombre;
    public javax.swing.JLabel ci;
    public javax.swing.JLabel direccion;
    public javax.swing.JLabel telefono;
    public javax.swing.JLabel celular;
    public javax.swing.JLabel deuda;
    public javax.swing.JLabel tipo;
    public javax.swing.JLabel manzano;
    public javax.swing.JLabel estado;
    
    
    public javax.swing.JLabel casadato;
    public javax.swing.JLabel medidordato;
    public javax.swing.JLabel nombredato;
    public javax.swing.JLabel cidato;
    public javax.swing.JLabel direcciondato;
    public javax.swing.JLabel telefonodato;
    public javax.swing.JLabel celulardato;
    public javax.swing.JLabel deudadato;
    public javax.swing.JLabel tipodato;
    public javax.swing.JLabel manzanodato;
    public javax.swing.JLabel estadodato;
    
    private javax.swing.JLabel ano;
    
    private javax.swing.JLabel ano1;
    private javax.swing.JLabel vacio;
    private javax.swing.JLabel uno;
    private javax.swing.JLabel dos;
    private javax.swing.JLabel tres;
    private javax.swing.JLabel cuatro;
    private javax.swing.JLabel cinco;
    private javax.swing.JLabel seis;
    private javax.swing.JLabel siete;
    private javax.swing.JLabel ocho;
    private javax.swing.JLabel nueve;
    private javax.swing.JLabel diez;
    private javax.swing.JLabel once;
    private javax.swing.JLabel doce;
    private javax.swing.JLabel totales;
    private javax.swing.JLabel vacio1;
    
    private javax.swing.JLabel ano111;
    private javax.swing.JLabel vaciomt3;
    private javax.swing.JLabel unomt3;
    private javax.swing.JLabel dosmt3;
    private javax.swing.JLabel tresmt3;
    private javax.swing.JLabel cuatromt3;
    private javax.swing.JLabel cincomt3;
    private javax.swing.JLabel seismt3;
    private javax.swing.JLabel sietemt3;
    private javax.swing.JLabel ochomt3;
    private javax.swing.JLabel nuevemt3;
    private javax.swing.JLabel diezmt3;
    private javax.swing.JLabel oncemt3;
    private javax.swing.JLabel docemt3;
    private javax.swing.JLabel totalesmt3;
    private javax.swing.JLabel vacio111;
    
    private javax.swing.JLabel ano11;
    private javax.swing.JLabel bs;
    private javax.swing.JLabel unobs;
    private javax.swing.JLabel dosbs;
    private javax.swing.JLabel tresbs;
    private javax.swing.JLabel cuatrobs;
    private javax.swing.JLabel cincobs;
    private javax.swing.JLabel seisbs;
    private javax.swing.JLabel sietebs;
    private javax.swing.JLabel ochobs;
    private javax.swing.JLabel nuevebs;
    private javax.swing.JLabel diezbs;
    private javax.swing.JLabel oncebs;
    private javax.swing.JLabel docebs;
    private javax.swing.JLabel totalesbs;
    private javax.swing.JLabel deuda1;
    
    private javax.swing.JLabel ano2;
    private javax.swing.JLabel vaciop;
    private javax.swing.JLabel unop;
    private javax.swing.JLabel dosp;
    private javax.swing.JLabel tresp;
    private javax.swing.JLabel cuatrop;
    private javax.swing.JLabel cincop;
    private javax.swing.JLabel seisp;
    private javax.swing.JLabel sietep;
    private javax.swing.JLabel ochop;
    private javax.swing.JLabel nuevep;
    private javax.swing.JLabel diezp;
    private javax.swing.JLabel oncep;
    private javax.swing.JLabel docep;
    private javax.swing.JLabel totalesp;
    private javax.swing.JLabel vacio2;
    
    private javax.swing.JLabel ano222;
    private javax.swing.JLabel vaciomt3p;
    private javax.swing.JLabel unomt3p;
    private javax.swing.JLabel dosmt3p;
    private javax.swing.JLabel tresmt3p;
    private javax.swing.JLabel cuatromt3p;
    private javax.swing.JLabel cincomt3p;
    private javax.swing.JLabel seismt3p;
    private javax.swing.JLabel sietemt3p;
    private javax.swing.JLabel ochomt3p;
    private javax.swing.JLabel nuevemt3p;
    private javax.swing.JLabel diezmt3p;
    private javax.swing.JLabel oncemt3p;
    private javax.swing.JLabel docemt3p;
    private javax.swing.JLabel totalesmt3p;
    private javax.swing.JLabel vacio222;
    
    private javax.swing.JLabel ano22;
    private javax.swing.JLabel bsp;
    private javax.swing.JLabel unobsp;
    private javax.swing.JLabel dosbsp;
    private javax.swing.JLabel tresbsp;
    private javax.swing.JLabel cuatrobsp;
    private javax.swing.JLabel cincobsp;
    private javax.swing.JLabel seisbsp;
    private javax.swing.JLabel sietebsp;
    private javax.swing.JLabel ochobsp;
    private javax.swing.JLabel nuevebsp;
    private javax.swing.JLabel diezbsp;
    private javax.swing.JLabel oncebsp;
    private javax.swing.JLabel docebsp;
    private javax.swing.JLabel totalesbsp;
    private javax.swing.JLabel deuda22;
    
    private javax.swing.JLabel ano3;
    private javax.swing.JLabel vaciopp;
    private javax.swing.JLabel unopp;
    private javax.swing.JLabel dospp;
    private javax.swing.JLabel trespp;
    private javax.swing.JLabel cuatropp;
    private javax.swing.JLabel cincopp;
    private javax.swing.JLabel seispp;
    private javax.swing.JLabel sietepp;
    private javax.swing.JLabel ochopp;
    private javax.swing.JLabel nuevepp;
    private javax.swing.JLabel diezpp;
    private javax.swing.JLabel oncepp;
    private javax.swing.JLabel docepp;
    private javax.swing.JLabel totalespp;
    private javax.swing.JLabel vacio3;
    
    private javax.swing.JLabel ano333;
    private javax.swing.JLabel vaciomt3pp;
    private javax.swing.JLabel unomt3pp;
    private javax.swing.JLabel dosmt3pp;
    private javax.swing.JLabel tresmt3pp;
    private javax.swing.JLabel cuatromt3pp;
    private javax.swing.JLabel cincomt3pp;
    private javax.swing.JLabel seismt3pp;
    private javax.swing.JLabel sietemt3pp;
    private javax.swing.JLabel ochomt3pp;
    private javax.swing.JLabel nuevemt3pp;
    private javax.swing.JLabel diezmt3pp;
    private javax.swing.JLabel oncemt3pp;
    private javax.swing.JLabel docemt3pp;
    private javax.swing.JLabel totalesmt3pp;
    private javax.swing.JLabel vacio333;
    
    private javax.swing.JLabel ano33;
    private javax.swing.JLabel bspp;
    private javax.swing.JLabel unobspp;
    private javax.swing.JLabel dosbspp;
    private javax.swing.JLabel tresbspp;
    private javax.swing.JLabel cuatrobspp;
    private javax.swing.JLabel cincobspp;
    private javax.swing.JLabel seisbspp;
    private javax.swing.JLabel sietebspp;
    private javax.swing.JLabel ochobspp;
    private javax.swing.JLabel nuevebspp;
    private javax.swing.JLabel diezbspp;
    private javax.swing.JLabel oncebspp;
    private javax.swing.JLabel docebspp;
    private javax.swing.JLabel totalesbspp;
    private javax.swing.JLabel deuda33;
}
