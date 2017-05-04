package ventanas;

import clases.Lectura;
//import clases.Cliente;
import clases.Conexion;
import clases.LecturaGeneral;
import clases.ModelTablaLecturas;
//import clases.ModelTablaUsuarios;
import javax.swing.*;
import java.awt.Rectangle;
//import java.awt.Color; 
import java.awt.Cursor;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
//import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableColumn;
import java.util.Calendar;
import java.util.Date;
import paneles.PnlNuevaLectura;

/**
 * @author skysoftgo
 */
public class ILeerLectura extends javax.swing.JInternalFrame {

    /**
     * Creates new form ILeerLecturas
     */
    private ModelTablaLecturas mdlLectura;
    DefaultTableModel tblLecturasmes;
    public int ancho;
    public int alto;
    
    public ILeerLectura(JDesktopPane mainApp) {
        Rectangle visibleRect = mainApp.getVisibleRect();
        ancho = visibleRect.width;
        alto = visibleRect.height;
        
        initComponents();
        mdlLectura = new ModelTablaLecturas();
        //this.tblLecturas.setModel(mdlLectura);
         
        this.setLocation(5, 0);
        this.setSize(visibleRect.width-10, visibleRect.height-10);
        this.txtNombreCliente.getDocument().addDocumentListener(EscuchadorBuscar);
        
        
        this.tblLecturas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblLecturas.getColumnModel().getColumn(1).setPreferredWidth(80);
        /*
        tblLecturas.getColumnModel().getColumn(0).setPreferredWidth(130);
        
        for(int i=2;i<38;i++ ){
            tblLecturas.getColumnModel().getColumn(i).setPreferredWidth(45);
        }
        */
    }

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        
        Calendar year = Calendar.getInstance();
        int years = year.get(Calendar.YEAR);
        int lastyear = years-1;
        int lastlastyear = years-2;

        jPanel1 = new javax.swing.JPanel(); // UP Panel
        jPanel3 = new javax.swing.JPanel();
        bntNuevo = new javax.swing.JButton("Este Mes");
        bntActualizar = new javax.swing.JButton("AÑO "+years);
        bntEliminar = new javax.swing.JButton("AÑO "+lastyear);
        
        delete = new javax.swing.JButton("BORRAR");
        edit = new javax.swing.JButton("EDITAR");
        
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbNoExiste = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();

        jButton1 = new javax.swing.JButton("AÑO 2013");
        jButton2 = new javax.swing.JButton("AÑO 2014");
        jButton3 = new javax.swing.JButton("AÑO 2015");
        jButton4 = new javax.swing.JButton("AÑO 2016");
        jButton5 = new javax.swing.JButton("AÑO 2017");
        jButton6 = new javax.swing.JButton("AÑO 2018");
        jButton7 = new javax.swing.JButton("AÑO 2019");
        jButton8 = new javax.swing.JButton("AÑO 2020");
        jButton9 = new javax.swing.JButton("AÑO 2021");
        jButton10 = new javax.swing.JButton("AÑO 2022");
        
        jButton41 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        etiqueta = new javax.swing.JLabel();
               
        jPanel2 = new javax.swing.JPanel(); //Down Panel
        
        jPanel5 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        house = new javax.swing.JLabel();
        january = new javax.swing.JLabel();
        february = new javax.swing.JLabel();
        march = new javax.swing.JLabel();
        april = new javax.swing.JLabel();
        may = new javax.swing.JLabel();
        june = new javax.swing.JLabel();
        july = new javax.swing.JLabel();
        august = new javax.swing.JLabel();
        september = new javax.swing.JLabel();
        october = new javax.swing.JLabel();
        november = new javax.swing.JLabel();
        december = new javax.swing.JLabel();
        
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        //jScrollPane3 = new javax.swing.JScrollPane();
        tblLecturas = new javax.swing.JTable();
        tblLecturasmess = new javax.swing.JTable();
        
        jPanelmes = new javax.swing.JPanel();
        //jPanelano1 = new javax.swing.JPanel();
        //jPanelano2 = new javax.swing.JPanel();
        
        
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lecturas Generales");

        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));//BAR
        
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png")));
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png")));
        jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png")));
        jButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png")));
        jButton4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png")));
        jButton5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png")));
        jButton6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png")));
        jButton7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png")));
        jButton8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png")));
        jButton9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png")));
        jButton10.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });
        for(int i=2013;i<2023;i++)
        {
            
        }
        
        
        
        bntNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png")));
        bntNuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bntNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(bntNuevo);

        bntActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png")));
        bntActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bntActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntActualizarActionPerformed(evt);
            }
        });
        jPanel3.add(bntActualizar);

        bntEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png")));
        bntEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bntEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(bntEliminar);
        
        jButton51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/report.png")));
        jButton51.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt2EliminarActionPerformed(evt);
            }
        });
        jPanel3.add(jButton51);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        
        jPanel4.setLayout(new java.awt.GridBagLayout());
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel1.setText("Número de Casa: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 9, 10, 10);
        jPanel4.add(jLabel1, gridBagConstraints);

        txtNombreCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        txtNombreCliente.setPreferredSize(new java.awt.Dimension(120, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 8);
        jPanel4.add(txtNombreCliente, gridBagConstraints);

        
        jButton41.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_find.png"))); 
        jButton41.setPreferredSize(new java.awt.Dimension(33, 30));
        jButton41.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 12);
        jPanel4.add(jButton41, gridBagConstraints);
       
        lbNoExiste.setFont(new java.awt.Font("Tahoma", 0, 14));
        lbNoExiste.setForeground(new java.awt.Color(255, 51, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 6);
        jPanel4.add(lbNoExiste, gridBagConstraints);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        
        jPanel2.setLayout(new java.awt.BorderLayout());
        
        jPanel5.setLayout(new java.awt.GridLayout(1,14,10,10));
        name.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        name.setText("      ");
        name.setAlignmentX(CENTER_ALIGNMENT);
        jPanel5.add(name);
        
        house.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        house.setText("      ");
        house.setAlignmentX(CENTER_ALIGNMENT);
        //jPanel5.add(house);
        
        january.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        january.setText("ENERO");
        house.setAlignmentX(CENTER_ALIGNMENT);
        jPanel5.add(january);
        february.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        february.setText("FEBRERO");
        february.setAlignmentX(CENTER_ALIGNMENT);
        jPanel5.add(february);
        march.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        march.setText("MARZO");
        house.setAlignmentX(CENTER_ALIGNMENT);
        jPanel5.add(march);
        april.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        april.setText("ABRIL");
        april.setAlignmentX(CENTER_ALIGNMENT);
        jPanel5.add(april);
        may.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        may.setText("MAYO");
        may.setAlignmentX(CENTER_ALIGNMENT);
        jPanel5.add(may);
        june.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        june.setText("JUNIO");
        june.setAlignmentX(CENTER_ALIGNMENT);
        jPanel5.add(june);
        july.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        july.setText("JULIO");
        july.setAlignmentX(CENTER_ALIGNMENT);
        jPanel5.add(july);
        august.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        august.setText("AGOSTO");
        august.setAlignmentX(CENTER_ALIGNMENT);
        jPanel5.add(august);
        september.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        september.setText("SEPTIEMBRE");
        september.setAlignmentX(CENTER_ALIGNMENT);
        jPanel5.add(september);
        october.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        october.setText("OCTUBRE");
        october.setAlignmentX(CENTER_ALIGNMENT);
        jPanel5.add(october);
        november.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        november.setText("NOVIEMBRE");
        november.setAlignmentX(CENTER_ALIGNMENT);
        jPanel5.add(november);
        december.setFont(new java.awt.Font("Arial", Font.BOLD, 12)); 
        december.setText("DICIEMBRE");
        december.setAlignmentX(CENTER_ALIGNMENT);
        jPanel5.add(december);
        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_START);
        
        createtable(0);
        
        
        jPanelmes.setLayout(null); 
        tblLecturasmess.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        tblLecturasmess.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] { {}, {},{},{}  },
                new String [] { }
        ));
        tblLecturasmess.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        //tblLecturasmess.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblLecturasmess.updateUI();
        etiqueta.setBounds(((ancho/2)-100),0,200,20);
        etiqueta.setFont(new java.awt.Font("Tahoma", 0, 24));
        etiqueta.setText("MES o AÑO");
        
        delete.setBounds(((ancho/2)+50),(alto-190),150,40);
        delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        edit.setBounds(((ancho/2)-200),(alto-190),150,40);
        edit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanelmes.add(delete);
        jPanelmes.add(edit);
        jPanelmes.add(etiqueta);
        jScrollPane2.setViewportView(tblLecturasmess);
        jScrollPane2.setBounds(new Rectangle(ancho/4,40,ancho/2,400));
        jPanelmes.add(jScrollPane2);
                   
        tblLecturas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tblLecturas);
        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
        pack();
    }
    
    private void createtable(int ff){
        int nc=0;int x=0;
        if(ff == 0){
            ResultSet count = Conexion.getRegistros("SELECT COUNT(*) AS total FROM propiedad ");
             try{
                 while(count.next()){
                     nc=count.getInt("total");
                 }   
                 count.close();
             }catch(SQLException ex){ex.printStackTrace();}
        }else{
            ResultSet count = Conexion.getRegistros("SELECT COUNT(*) AS total FROM propiedad where numero="+ff);
             try{
                 while(count.next()){
                     nc=count.getInt("total");
                 }   
                 count.close();
            }catch(SQLException ex){ex.printStackTrace();}
        }
        if(nc == 0){this.lbNoExiste.setText("Sin Resultados");}else{this.lbNoExiste.setText("");}
        Object[][] campos=new Object[nc][];
        
        tblLecturas.setFont(new java.awt.Font("Tahoma", 0, 12)); 
        String[] columnNames = {"Nombre","Nº de Casa","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.",
                                "Lectura", "MT3", "Bs.", "Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs.","Lectura", "MT3", "Bs."};
        ResultSet lecturas;
        if(ff == 0){ 
            lecturas = Conexion.getRegistros("SELECT *FROM propiedad ");
        }else{  lecturas = Conexion.getRegistros("SELECT *FROM propiedad where numero="+ff);   }    
             try{
                while(lecturas.next()){

                    Object[] campo=new Object[38]; 
                    int indice = lecturas.getInt(1);
                    int indice1 = lecturas.getInt(3);
                    campo[1]=lecturas.getInt(4);

                    ResultSet lecturaname = Conexion.getRegistros("SELECT * FROM tblcliente where NoCuenta="+indice1+"");
                    try{
                        while(lecturaname.next()){    
                            campo[0]=lecturaname.getString(3);
                        }
                            lecturaname.close();     
                    }catch(SQLException ex){ex.printStackTrace();}

                    ResultSet lectura = Conexion.getRegistros("select * from tblmedida where ID_PROPIEDAD="+indice+"");
                    try{
                        int j=2;
                        while(lectura.next())
                        { 
                            campo[j]=lectura.getInt(3);
                            campo[j+1]=lectura.getInt(4);
                            campo[j+2]=lectura.getDouble(5);
                            j=j+3;
                        }
                            lectura.close();     
                    }catch(SQLException ex){ex.printStackTrace();}



                   campos[x]=campo;
                    x=x+1; 
                }
                Conexion.con.close();
                tblLecturas.updateUI();
            }catch(SQLException ex){ex.printStackTrace();}    
        tblLecturas.setModel(new javax.swing.table.DefaultTableModel(campos,columnNames)); 
    }
    
    private void createtablemes(int caso){      
        int x=0; int y=0; int b=0;
        String fech="";
        String fech1="";
        String fech2="";
        String fech3="";
        String fech4="";
        String mess=""; 
        String ab="";
        
        int casa=0;
        int medidor=0;
        String nombre="";

        String[] columnNamesmes = {"ID","Nº de Casa","Nº medidor","Nombre Propietario","Lectura", "MT3", "Bs.","Estado","Fecha","Observación"};
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        if(mes < 9){ mess="0"+mes; fech1= año+"-"+mess; }else{ fech1= año+"-"+mes;  }
        fech2= String.valueOf((año));
        fech3= String.valueOf((año-1));
        fech4= String.valueOf((año-2));
        //if(dia < 9){ diaa="0"+dia; vernn = fech1+"-"+diaa;}else{vernn = fech1+"-"+dia;}
             
        if(caso == 1){        
            switch(mes){
                case 1:
                    etiqueta.setText("MES DE ENERO");
                break;
                case 2:
                    etiqueta.setText("MES DE FEBRERO");
                break;
                case 3:
                    etiqueta.setText("MES DE MARZO");
                break;
                case 4:
                    etiqueta.setText("MES DE ABRIL");
                break;
                case 5:
                    etiqueta.setText("MES DE MAYO");
                break;
                case 6:
                    etiqueta.setText("MES DE JUNIO");
                break;
                case 7:
                    etiqueta.setText("MES DE JULIO");
                break;
                case 8:
                    etiqueta.setText("MES DE AGOSTO");
                break;
                case 9:
                    etiqueta.setText("MES DE SEPTIEMBRE");
                break;
                case 10:
                    etiqueta.setText("MES DE OCTUBRE");
                break;
                case 11:
                    etiqueta.setText("MES DE NOVIEMBRE");
                break;
                case 12:
                    etiqueta.setText("MES DE DICIEMBRE");
                break;
                default:
                    etiqueta.setText("MES");
                break;
            }
        }else{
            if(caso==2){
                etiqueta.setText("AÑO "+fech2);
                etiqueta.setBounds((ancho/2)-50,0,200,20);
            }else{
                if(caso==3){
                    etiqueta.setText("AÑO "+fech3);
                    etiqueta.setBounds((ancho/2)-50,0,200,20);
                }else{
                    etiqueta.setText("AÑO "+fech4);
                    etiqueta.setBounds((ancho/2)-50,0,200,20);
                }
            }
        }
        
        ResultSet vern = Conexion.getRegistros("select * from tblmedida");
            try{
                while(vern.next())
                {
                    String abc=(String.valueOf(vern.getDate(6)));
                    if(caso == 1){
                            ab = abc.substring(0,7);
                    }else{
                            ab = abc.substring(0,4);
                    }
                    switch(caso){
                        case 1:
                            if(ab.equals(fech1)){
                                y++;
                            }
                        break;
                        case 2:
                            if(ab.equals(fech2)){
                                y++;
                            }
                        break;
                        case 3:
                            if(ab.equals(fech3)){
                                y++;
                            }
                        break;
                        case 4:
                            if(ab.equals(fech4)){
                                y++;
                            }
                        break;
                    }      
                }
                vern.close();

            }catch(SQLException ex){ex.printStackTrace();}
        Object[][] objetos=new Object[y][];
        
        
        
        ResultSet propiedades = Conexion.getRegistros("SELECT * FROM propiedad ");
         try{
            while(propiedades.next()){
                b=1;
                int indice = propiedades.getInt(1);//propiedad
                int indice1 = propiedades.getInt(3);//propietario
                casa=propiedades.getInt(4); //casa
                medidor=propiedades.getInt(5); //medidor
                
                ResultSet lecturaname = Conexion.getRegistros("SELECT Nombre FROM tblcliente where NoCuenta="+indice1+"");
                try{
                while(lecturaname.next()){    
                    nombre=(lecturaname.getString("Nombre"));
                }
                    lecturaname.close();     
                }catch(SQLException ex){ex.printStackTrace();}
                
                ResultSet lectura = Conexion.getRegistros("select * from tblmedida where ID_PROPIEDAD="+indice+"");
                try{
                    while(lectura.next())
                    { 
                        String fec=(String.valueOf(lectura.getDate(6)));
                        
                        if(caso == 1){
                            fech = fec.substring(0,7);
                            if(fech.equals(fech1)){
                                    Object[] datos=new Object[10];
                                    datos[0]= lectura.getInt(1);
                                    datos[1]=casa;
                                    datos[2]=medidor;
                                    datos[3]=nombre;
                                    datos[4]=lectura.getInt(3);
                                    datos[5]=lectura.getInt(4);
                                    datos[6]=lectura.getDouble(5);
                                    if(lectura.getBoolean(9)){datos[7]="pagado";}else{datos[7]="debe";} 
                                    datos[8]= String.valueOf(lectura.getDate(6));
                                    datos[9]= lectura.getString(8);
                                    
                                    objetos[x]=datos;
                                    x++;
                                    
                                }else{
                                 fech = null;
                                }
                        }else{
                            fech = fec.substring(0,4);
                            switch(caso)
                            { 
                                case 2:
                                    if(fech.equals(fech2)){
                                        Object[] datos=new Object[10];
                                        datos[0]= lectura.getInt(1);
                                        datos[1]=casa;
                                        datos[2]=medidor;
                                        datos[3]=nombre;
                                        datos[4]=lectura.getInt(3);
                                        datos[5]=lectura.getInt(4);
                                        datos[6]=lectura.getDouble(5);
                                        if(lectura.getBoolean(9)){datos[7]="pagado";}else{datos[7]="debe";} 
                                        datos[8]= String.valueOf(lectura.getDate(6));
                                        datos[9]= lectura.getString(8);
                                        
                                        objetos[x]=datos;
                                        x=x+1;
                                    }else{
                                     fech = null;
                                    }
                                        break;
                                case 3:
                                    if(fech.equals(fech3)){
                                        Object[] datos=new Object[10];
                                        datos[0]= lectura.getInt(1);
                                        datos[1]=casa;
                                        datos[2]=medidor;
                                        datos[3]=nombre;
                                        datos[4]=lectura.getInt(3);
                                        datos[5]=lectura.getInt(4);
                                        datos[6]=lectura.getDouble(5);
                                        if(lectura.getBoolean(9)){datos[7]="pagado";}else{datos[7]="debe";} 
                                        datos[8]= String.valueOf(lectura.getDate(6));
                                        datos[9]= lectura.getString(8);
                                        
                                        objetos[x]=datos;
                                        x=x+1;
                                    }else{
                                     fech = null;
                                    }
                                    break;
                                case 4:
                                    if(fech.equals(fech4)){
                                        Object[] datos=new Object[10];
                                        datos[0]= lectura.getInt(1);
                                        datos[1]=casa;
                                        datos[2]=medidor;
                                        datos[3]=nombre;
                                        datos[4]=lectura.getInt(3);
                                        datos[5]=lectura.getInt(4);
                                        datos[6]=lectura.getDouble(5);
                                        if(lectura.getBoolean(9)){datos[7]="pagado";}else{datos[7]="debe";} 
                                        datos[7]= String.valueOf(lectura.getDate(6));
                                        datos[8]= lectura.getString(8);
                                        
                                        objetos[x]=datos;
                                        x=x+1;
                                    }else{
                                     fech = null;
                                    }
                                    break;    
                            }
                        }    
                    }
                        lectura.close();     
                }catch(SQLException ex){ex.printStackTrace();}
            }
            Conexion.con.close();
            tblLecturasmess.updateUI();
         }catch(SQLException ex){ex.printStackTrace();}  
         
        tblLecturasmess.setModel(new javax.swing.table.DefaultTableModel(objetos,columnNamesmes));
        if(fech!=null){ jPanelmes.setVisible(false);}
    }
    
    
    private void bntNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNuevoActionPerformed
        jPanel2.setVisible(false);
        tblLecturasmess.setModel(new javax.swing.table.DefaultTableModel());
        createtablemes(1);
        getContentPane().add(jPanelmes, java.awt.BorderLayout.CENTER);
        jPanelmes.setVisible(true);
        txtNombreCliente.setEditable(false);
    }//GEN-LAST:event_bntNuevoActionPerformed

    private void bntActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActualizarActionPerformed
        jPanel2.setVisible(false);
        tblLecturasmess.setModel(new javax.swing.table.DefaultTableModel());
        createtablemes(2);
        getContentPane().add(jPanelmes, java.awt.BorderLayout.CENTER);
        jPanelmes.setVisible(true);
        txtNombreCliente.setEditable(false);
    }//GEN-LAST:event_bntActualizarActionPerformed
    
    private void bnt2EliminarActionPerformed(java.awt.event.ActionEvent evt){
        jPanel2.setVisible(false);        
        tblLecturasmess.setModel(new javax.swing.table.DefaultTableModel());
        createtablemes(4);
        getContentPane().add(jPanelmes, java.awt.BorderLayout.CENTER);
        jPanelmes.setVisible(true);
        txtNombreCliente.setEditable(false);
    }
    
    private void bntEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEliminarActionPerformed
        jPanel2.setVisible(false);
        tblLecturasmess.setModel(new javax.swing.table.DefaultTableModel());
        createtablemes(3);
        getContentPane().add(jPanelmes, java.awt.BorderLayout.CENTER);
        jPanelmes.setVisible(true);
        txtNombreCliente.setEditable(false);
    }//GEN-LAST:event_bntEliminarActionPerformed
    
    
    private void editActionPerformed(java.awt.event.ActionEvent evt){
        int indice  = this.tblLecturasmess.getSelectedRow();
        if(indice != -1)
        {
            Object idd=this.tblLecturasmess.getValueAt(indice, 0);
            Integer id_1= (Integer) idd;
            Object ncasa =     this.tblLecturasmess.getValueAt(indice, 1);
            Object nmedidor =  this.tblLecturasmess.getValueAt(indice, 2);
            Object nombre =    this.tblLecturasmess.getValueAt(indice, 3);
            Object medid =    this.tblLecturasmess.getValueAt(indice, 4);
            Integer medida =(Integer) medid;
            Object mt =       this.tblLecturasmess.getValueAt(indice, 5);
            Integer mt3 =  (Integer) mt;
            Object apaga =    this.tblLecturasmess.getValueAt(indice, 6);
            Double apagar = (Double) apaga;
            Object fech=     this.tblLecturasmess.getValueAt(indice, 7);
            
            int id=0;
            int id2=0;
            Date fecha=null;
            String mes="";
            String obser="";
            int esta=0;
            
            ResultSet xc = Conexion.getRegistros("select * from tblmedida where ID_MEDIDA="+id_1);
                try{
                    while(xc.next())
                    {
                        id = xc.getInt(1);
                        id2= xc.getInt(2);
                        fecha=xc.getDate(6);
                        mes=xc.getString(7);
                        obser=xc.getString(8);
                        esta=xc.getInt(9);
                    } 
                    xc.close();     
                }catch(SQLException ex){ex.printStackTrace();} 
                
            Lectura lect=new Lectura(id,id2,medida,mt3,apagar,fecha,mes,obser,esta);
            PnlNuevaLectura nl = new PnlNuevaLectura(lect);
            JLabel aviso = nl.getLabelEscondido();
            JOptionPane.showInternalOptionDialog(this, nl, "Actualizar Datos de Cliente",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, new Object[]{aviso},null);
            if(nl.IsProcesoOk()){
                reiniciarTabla();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        }
    }
    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt){
        int indice  = this.tblLecturasmess.getSelectedRow();
        if(indice != -1)
        {       
            Object idd=this.tblLecturasmess.getValueAt(indice, 0);
            Integer id_1= (Integer) idd;
            
            int status = JOptionPane.showOptionDialog(this, "¿Esta seguro de Elimnar?","Question", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null);
            System.out.println("Option " + status + " selected!");
            if(status == 1){
                ResultSet delete = Conexion.getRegistros("DELETE  FROM tblmedida WHERE id_medida="+id_1);
                try{
                 if (!delete.isBeforeFirst() ) {    
                        System.out.println("empty"); 
                  }else {
                        System.out.println("OK proceso");                         
                  }
                    delete.close();     
                }catch(SQLException ex){ex.printStackTrace();}
            }
            //JOptionPane.showInternalOptionDialog(this, pvc, "Actualizar Datos de Cliente",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, new Object[]{aviso},null);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        }
    }
    
    private void reiniciarTabla(){
        //tblLecturasmess.updateUI();
        //tblLecturasmess.updateUI();
        //mdlLectura = new ModelTablaLecturas(); 
        //this.tblLecturasmess.setModel(mdlLectura);
        /*jPanel2.setVisible(false);
        tblLecturasmess.setModel(new javax.swing.table.DefaultTableModel());
        createtablemes(1);
        getContentPane().add(jPanelmes, java.awt.BorderLayout.CENTER);
        jPanelmes.setVisible(true);*/
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
            if(e.getDocument().getLength() > 2)
            {
                String Buscar;
                int nBuscar;
                Buscar = e.getDocument().getText(0, e.getDocument().getLength());
                nBuscar = Integer.valueOf(Buscar);
                createtable(nBuscar);
          
            }else{
                if(e.getDocument().getLength() <= 1){this.lbNoExiste.setText("");}else{this.lbNoExiste.setText("Sin resultados");}
                createtable(0);
            }
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    private javax.swing.JButton bntActualizar;
    private javax.swing.JButton bntEliminar;
    private javax.swing.JButton bntNuevo;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton51;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    //private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbNoExiste;
    private javax.swing.JTable tblLecturas;
    private javax.swing.JTextField txtNombreCliente;
    
    private javax.swing.JLabel name;
    private javax.swing.JLabel house;
    private javax.swing.JLabel january;
    private javax.swing.JLabel february;
    private javax.swing.JLabel march;
    private javax.swing.JLabel april;
    private javax.swing.JLabel may;
    private javax.swing.JLabel june;
    private javax.swing.JLabel july;
    private javax.swing.JLabel august;
    private javax.swing.JLabel september;
    private javax.swing.JLabel october;
    private javax.swing.JLabel november;
    private javax.swing.JLabel december;
    
    private javax.swing.JPanel jPanelmes;
    //private javax.swing.JPanel jPanelano1;
    //private javax.swing.JPanel jPanelano2;
    private javax.swing.JTable tblLecturasmess;

    
    private javax.swing.JButton delete;
    private javax.swing.JButton edit; 
    
    private javax.swing.JLabel etiqueta;
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton10;
    
}
